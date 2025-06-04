package com.bigchadguys.ores.block.custom;

import com.bigchadguys.ores.block.entity.custom.AdamantiteFurnaceBlockEntity;
import com.bigchadguys.ores.block.entity.ModBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AdamantiteFurnaceBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final MapCodec<AdamantiteFurnaceBlock> CODEC = simpleCodec(AdamantiteFurnaceBlock::new);

    public AdamantiteFurnaceBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }

    @Override
    public @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(LIT, false);
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new AdamantiteFurnaceBlockEntity(pos, state);
    }

    @Override
    public @NotNull ItemInteractionResult useItemOn(
            @NotNull ItemStack stack,
            @NotNull BlockState state,
            Level world,
            @NotNull BlockPos pos,
            @NotNull Player player,
            @NotNull InteractionHand hand,
            @NotNull net.minecraft.world.phys.BlockHitResult hitResult
    ) {
        if (!world.isClientSide()) {
            BlockEntity entity = world.getBlockEntity(pos);
            if (entity instanceof AdamantiteFurnaceBlockEntity furnaceEntity) {
                player.openMenu(
                        new SimpleMenuProvider(
                                furnaceEntity,
                                Component.translatable("container.joesores.adamantite_furnace")
                        ),
                        pos
                );
            }
        }
        return ItemInteractionResult.sidedSuccess(world.isClientSide());
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level world,
            @NotNull BlockState state,
            @NotNull BlockEntityType<T> type
    ) {
        if (!world.isClientSide()
                && type == ModBlockEntities.ADAMANTITE_FURNACE_BLOCK_ENTITY.get()
        ) {
            return (currentWorld, currentPos, currentState, blockEntity) -> {
                if (!(blockEntity instanceof AdamantiteFurnaceBlockEntity furnaceEntity)) {
                    return;
                }
                boolean wasLit = currentState.getValue(LIT);
                AdamantiteFurnaceBlockEntity.serverTick(currentWorld, currentPos, currentState, furnaceEntity);
                boolean isNowLit = furnaceEntity.isLit();
                if (wasLit != isNowLit) {
                    BlockState updatedState = currentState.setValue(LIT, isNowLit);
                    currentWorld.setBlock(currentPos, updatedState, 3);
                    currentWorld.sendBlockUpdated(currentPos, currentState, updatedState, 3);
                    currentWorld.getChunkSource().getLightEngine().checkBlock(currentPos);
                }
            };
        }
        return null;
    }

    @Override
    public void animateTick(
            @NotNull BlockState state,
            @NotNull Level world,
            @NotNull BlockPos pos,
            @NotNull net.minecraft.util.RandomSource random
    ) {
        if (!state.getValue(LIT)) {
            return;
        }

        double centerX = pos.getX() + 0.5;
        double centerY = pos.getY();
        double centerZ = pos.getZ() + 0.5;

        if (random.nextDouble() < 0.1) {
            world.playLocalSound(
                    centerX, centerY, centerZ,
                    net.minecraft.sounds.SoundEvents.FURNACE_FIRE_CRACKLE,
                    net.minecraft.sounds.SoundSource.BLOCKS,
                    1.0F, 1.0F,
                    false
            );
        }

        Direction facing = state.getValue(FACING);
        Direction.Axis axis = facing.getAxis();
        double randomOffset = random.nextDouble() * 0.6 - 0.3;

        double offsetX = axis == Direction.Axis.X ? facing.getStepX() * 0.52 : randomOffset;
        double offsetZ = axis == Direction.Axis.Z ? facing.getStepZ() * 0.52 : randomOffset;

        double particleX = centerX + offsetX;
        double particleY = centerY + random.nextDouble() * 6.0 / 16.0;
        double particleZ = centerZ + offsetZ;

        world.addParticle(ParticleTypes.SMOKE, particleX, particleY, particleZ, 0.0, 0.0, 0.0);
        world.addParticle(ParticleTypes.FLAME, particleX, particleY, particleZ, 0.0, 0.0, 0.0);
    }

    @Override
    public void onRemove(
            @NotNull BlockState oldState,
            @NotNull Level world,
            @NotNull BlockPos pos,
            @NotNull BlockState newState,
            boolean isMoving
    ) {
        if (oldState.getBlock() != newState.getBlock()) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof AdamantiteFurnaceBlockEntity furnaceEntity) {
                Containers.dropContents(world, pos, furnaceEntity);
            }
        }
        super.onRemove(oldState, world, pos, newState, isMoving);
    }
}
