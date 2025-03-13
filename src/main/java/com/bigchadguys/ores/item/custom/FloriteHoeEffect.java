package com.bigchadguys.ores.item.custom;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class FloriteHoeEffect {

    private static final int HORIZONTAL_RANGE = 4;
    private static final int VERTICAL_RANGE = 1;

    public static void useHoe(Level world, ServerPlayer player) {
        applyHoeEffect(world, player);
    }

    private static void applyHoeEffect(Level world, ServerPlayer player) {
        final BlockPos playerPos = player.blockPosition();
        final ImmutableSet<Action> actions = Actions.get().getActions();
        for (int dx = -HORIZONTAL_RANGE; dx <= HORIZONTAL_RANGE; dx++) {
            for (int dz = -HORIZONTAL_RANGE; dz <= HORIZONTAL_RANGE; dz++) {
                for (int dy = -VERTICAL_RANGE; dy <= VERTICAL_RANGE; dy++) {
                    BlockPos targetPos = playerPos.offset(dx, dy, dz);
                    BlockState state = world.getBlockState(targetPos);
                    if (state.isAir() || state.getBlock() instanceof GrassBlock) continue;
                    ActionContext context = new ActionContext(world, targetPos, state,
                            player.getMainHandItem(), player.getOffhandItem(), player);
                    for (Action act : actions) {
                        if (act.canApply(context)) {
                            act.execute(context);
                        }
                    }
                }
            }
        }
    }

    public interface Action {
        boolean canApply(ActionContext context);
        void execute(ActionContext context);
    }

    public record ActionContext(Level world, BlockPos pos, BlockState state, ItemStack mainItem, ItemStack offItem, Player player) {}

    public static class RandomTickableAction implements Action {
        @Override
        public boolean canApply(ActionContext context) {
            BlockState state = context.state();
            Object block = state.getBlock();
            return block instanceof SugarCaneBlock ||
                    block instanceof CactusBlock ||
                    (block instanceof StemBlock && state.getValue(StemBlock.AGE) == 7);
        }

        @Override
        public void execute(ActionContext context) {
            ServerLevel srvWorld = (ServerLevel) context.world();
            BlockState state = context.state();
            RandomSource rng = srvWorld.getRandom();
            for (int i = 0; i < 4; i++) {
                state.randomTick(srvWorld, context.pos(), rng);
            }
        }
    }

    public static class BoneMealAction implements Action {
        @Override
        public boolean canApply(ActionContext context) {
            BlockState state = context.state();
            Object block = state.getBlock();
            if (block instanceof BonemealableBlock && !(block instanceof StemBlock))
                return true;
            if (block instanceof StemBlock)
                return state.getValue(StemBlock.AGE) != 7;
            return false;
        }

        @Override
        public void execute(ActionContext context) {
            BlockPos pos = context.pos();
            Vec3 center = new Vec3(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
            BlockHitResult hit = new BlockHitResult(center, Direction.UP, pos, false);
            UseOnContext useContext = new UseOnContext(context.player(), InteractionHand.MAIN_HAND, hit);
            BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), context.world(), pos, useContext.getPlayer());
            if (!context.player().isCreative()) {
                context.mainItem().hurtAndBreak(1, context.player(), context.player().getEquipmentSlotForItem(context.mainItem()));
            }
        }
    }

    public enum Actions {
        INSTANCE;
        private final ImmutableSet<Action> actions;

        Actions() {
            actions = ImmutableSet.of(new RandomTickableAction(), new BoneMealAction());
        }

        public static Actions get() {
            return INSTANCE;
        }

        public ImmutableSet<Action> getActions() {
            return actions;
        }
    }
}
