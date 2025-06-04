package com.bigchadguys.ores.block.custom;

import com.bigchadguys.ores.block.entity.ModBlockEntities;
import com.bigchadguys.ores.block.entity.custom.MorphiteSynthesizerBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MorphiteSynthesizerBlock extends BaseEntityBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final MapCodec<MorphiteSynthesizerBlock> CODEC = simpleCodec(MorphiteSynthesizerBlock::new);

    public MorphiteSynthesizerBlock(Properties properties) {
        super(properties.lightLevel(state -> state.getValue(LIT) ? 12 : 0));
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return defaultBlockState().setValue(LIT, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        builder.add(LIT);
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new MorphiteSynthesizerBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> @Nullable BlockEntityTicker<T> getTicker(
            @NotNull Level world,
            @NotNull BlockState state,
            @NotNull BlockEntityType<T> type
    ) {
        if (type != ModBlockEntities.MORPHITE_SYNTHESIZER_BLOCK_ENTITY.get()) {
            return null;
        }

        if (world.isClientSide()) {
            return (lvl, pos, st, be) -> {
                if (!(be instanceof MorphiteSynthesizerBlockEntity)) return;
                if (st.getValue(LIT) && lvl.getGameTime() % 40 == 0) {
                    double x = pos.getX() + 0.5;
                    double y = pos.getY() + 1.0;
                    double z = pos.getZ() + 0.5;
                    lvl.playLocalSound(
                            x, y, z,
                            SoundEvents.BEACON_AMBIENT,
                            SoundSource.BLOCKS,
                            1f, 0.4f,
                            false
                    );
                }
            };
        }

        return (lvl, pos, st, be) -> {
            if (!(be instanceof MorphiteSynthesizerBlockEntity synth)) return;

            boolean wasLit = st.getValue(LIT);
            synth.tick(lvl, pos, st);

            boolean isNowLit = lvl.getBlockState(pos).getValue(LIT);
            if (wasLit != isNowLit) {
                BlockState updatedState = st.setValue(LIT, isNowLit);
                lvl.setBlock(pos, updatedState, 3);
                lvl.sendBlockUpdated(pos, st, updatedState, 3);
                lvl.getChunkSource().getLightEngine().checkBlock(pos);

                lvl.playSound(
                        null, pos,
                        isNowLit ? SoundEvents.BEACON_ACTIVATE : SoundEvents.BEACON_DEACTIVATE,
                        SoundSource.BLOCKS,
                        1f, 0.4f
                );
            }
        };
    }

    @Override
    public void onRemove(
            @NotNull BlockState oldState,
            @NotNull Level world,
            @NotNull BlockPos pos,
            BlockState newState,
            boolean isMoving
    ) {
        if (oldState.getBlock() != newState.getBlock()) {
            BlockEntity tileEntity = world.getBlockEntity(pos);
            if (tileEntity instanceof MorphiteSynthesizerBlockEntity synth) {
                synth.drops();
            }
            world.playSound(
                    null, pos,
                    SoundEvents.BEACON_DEACTIVATE,
                    SoundSource.BLOCKS,
                    1f, 1f
            );
        }
        super.onRemove(oldState, world, pos, newState, isMoving);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(
            @NotNull ItemStack stack,
            @NotNull BlockState state,
            Level world,
            @NotNull BlockPos pos,
            @NotNull Player player,
            @NotNull InteractionHand hand,
            @NotNull BlockHitResult hitResult
    ) {
        if (!world.isClientSide()) {
            BlockEntity tileEntity = world.getBlockEntity(pos);
            if (tileEntity instanceof MorphiteSynthesizerBlockEntity synth) {
                player.openMenu(
                        new SimpleMenuProvider(
                                synth,
                                Component.literal("Morphite Synthesizer")
                        ),
                        pos
                );
            }
        }
        return ItemInteractionResult.sidedSuccess(world.isClientSide());
    }
}
