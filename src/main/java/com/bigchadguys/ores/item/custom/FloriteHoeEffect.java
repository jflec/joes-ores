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

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class FloriteHoeEffect {

    public static void useHoe(Level world, ServerPlayer player) {
        applyHoeEffect(world, player);
    }

    private static void applyHoeEffect(Level world, ServerPlayer player) {
        final BlockPos playerPos = player.blockPosition();
        final int horizontalRange = 4;
        final int verticalRange = 1;
        final Set<Action> actions = Actions.get().getActions();
        for (int dx = -horizontalRange; dx <= horizontalRange; dx++) {
            for (int dz = -horizontalRange; dz <= horizontalRange; dz++) {
                for (int dy = -verticalRange; dy <= verticalRange; dy++) {
                    final BlockPos targetPos = playerPos.offset(dx, dy, dz);
                    final BlockState state = world.getBlockState(targetPos);
                    if (state.isAir() || state.getBlock() instanceof GrassBlock) continue;
                    final ActionContext context = new ActionContext(world, targetPos, state,
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
            final BlockState s = context.state();
            return s.getBlock() instanceof SugarCaneBlock ||
                    s.getBlock() instanceof CactusBlock ||
                    (s.getBlock() instanceof StemBlock && s.getValue(StemBlock.AGE) == 7);
        }
        @Override
        public void execute(ActionContext context) {
            ServerLevel srvWorld = (ServerLevel) context.world();
            final BlockState s = context.state();
            final RandomSource srvRng = srvWorld.getRandom();
            for (int i = 0; i < 4; i++) {
                s.randomTick(srvWorld, context.pos(), srvRng);
            }
        }
    }

    public static class BoneMealAction implements Action {
        @Override
        public boolean canApply(ActionContext context) {
            final BlockState s = context.state();
            if (s.getBlock() instanceof BonemealableBlock && !(s.getBlock() instanceof StemBlock))
                return true;
            if (s.getBlock() instanceof StemBlock)
                return s.getValue(StemBlock.AGE) != 7;
            return false;
        }
        @Override
        public void execute(ActionContext context) {
            final BlockPos pos = context.pos();
            final Vec3 center = new Vec3(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
            final BlockHitResult hit = new BlockHitResult(center, Direction.UP, pos, false);
            final UseOnContext useContext = new UseOnContext(context.player(), InteractionHand.MAIN_HAND, hit);
            BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), context.world(), pos, useContext.getPlayer());
            if (!context.player().isCreative()) {
                context.mainItem().hurtAndBreak(1, context.player(), context.player().getEquipmentSlotForItem(context.mainItem()));
            }
        }
    }

    public enum Actions {
        INSTANCE;
        private ImmutableSet<Action> actions;
        private final Set<Supplier<Action>> suppliers = new HashSet<>();
        Actions() {
            register(RandomTickableAction::new);
            register(BoneMealAction::new);
        }
        public void register(Supplier<Action> s) {
            suppliers.add(s);
        }
        public void setup() {
            Set<Action> set = new HashSet<>();
            for (Supplier<Action> s : suppliers) {
                set.add(s.get());
            }
            actions = ImmutableSet.copyOf(set);
        }
        public static Actions get() {
            return INSTANCE;
        }
        public ImmutableSet<Action> getActions() {
            return actions;
        }
    }
}
