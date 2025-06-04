package com.bigchadguys.ores.block.entity.custom;

import com.bigchadguys.ores.block.custom.MorphiteSynthesizerBlock;
import com.bigchadguys.ores.block.entity.ModBlockEntities;
import com.bigchadguys.ores.recipe.ModRecipes;
import com.bigchadguys.ores.recipe.MorphiteSynthesizerRecipe;
import com.bigchadguys.ores.recipe.MorphiteSynthesizerRecipeInput;
import com.bigchadguys.ores.screen.custom.MorphiteSynthesizerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class MorphiteSynthesizerBlockEntity extends BlockEntity implements MenuProvider {
    private static final int CATALYST_SLOT = 0;
    private static final int MORPHITE_INGOT_SLOT = 1;
    private static final int UPGRADE_INGOT_SLOT = 2;
    private static final int OUTPUT_SLOT = 3;

    public final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null && !level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    private final ContainerData data;
    private int progress = 0;
    private final int maxProgress = 72;

    public MorphiteSynthesizerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MORPHITE_SYNTHESIZER_BLOCK_ENTITY.get(), pos, state);
        this.data = createContainerData();
    }

    private ContainerData createContainerData() {
        return new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> progress;
                    case 1 -> maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                if (index == 0) {
                    progress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("blockentity.ores.morphite_synthesizer");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId,
                                            @NotNull Inventory playerInventory,
                                            @NotNull Player player) {
        return new MorphiteSynthesizerMenu(containerId, playerInventory, this, data);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.@NotNull Provider regs) {
        tag.put("inventory", itemHandler.serializeNBT(regs));
        tag.putInt("morphite_synthesizer.progress", progress);
        super.saveAdditional(tag, regs);
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider regs) {
        super.loadAdditional(tag, regs);
        itemHandler.deserializeNBT(regs, tag.getCompound("inventory"));
        progress = tag.getInt("morphite_synthesizer.progress");
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }
        if (level != null) {
            Containers.dropContents(level, worldPosition, inv);
        }
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (hasRecipe() && isOutputSlotEmptyOrReceivable()) {
            increaseCraftingProgress();
            level.setBlockAndUpdate(pos, state.setValue(MorphiteSynthesizerBlock.LIT, true));
            setChanged(level, pos, state);
            if (hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
            level.setBlockAndUpdate(pos, state.setValue(MorphiteSynthesizerBlock.LIT, false));
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        Optional<RecipeHolder<MorphiteSynthesizerRecipe>> recipe = getCurrentRecipe();
        if (recipe.isPresent()) {
            ItemStack output = recipe.get().value().output();
            itemHandler.extractItem(CATALYST_SLOT, 1, false);
            itemHandler.extractItem(MORPHITE_INGOT_SLOT, 1, false);
            itemHandler.extractItem(UPGRADE_INGOT_SLOT, 1, false);
            itemHandler.setStackInSlot(
                    OUTPUT_SLOT,
                    new ItemStack(
                            output.getItem(),
                            itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + output.getCount()
                    )
            );
        }
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        ItemStack outputStack = itemHandler.getStackInSlot(OUTPUT_SLOT);
        return outputStack.isEmpty() || outputStack.getCount() < outputStack.getMaxStackSize();
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<MorphiteSynthesizerRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) {
            return false;
        }
        ItemStack output = recipe.get().value().getResultItem(null);
        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private Optional<RecipeHolder<MorphiteSynthesizerRecipe>> getCurrentRecipe() {
        List<ItemStack> inputs = List.of(
                itemHandler.getStackInSlot(CATALYST_SLOT),
                itemHandler.getStackInSlot(MORPHITE_INGOT_SLOT),
                itemHandler.getStackInSlot(UPGRADE_INGOT_SLOT)
        );
        if (level == null) {
            return Optional.empty();
        }
        return level.getRecipeManager()
                .getRecipeFor(
                        ModRecipes.MORPHITE_SYNTHESIZER_TYPE.get(),
                        new MorphiteSynthesizerRecipeInput(inputs),
                        level
                );
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        ItemStack existing = itemHandler.getStackInSlot(OUTPUT_SLOT);
        return existing.isEmpty() || existing.getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        ItemStack existing = itemHandler.getStackInSlot(OUTPUT_SLOT);
        int maxCount = existing.isEmpty() ? 64 : existing.getMaxStackSize();
        int currentCount = existing.getCount();
        return maxCount >= currentCount + count;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider regs) {
        return saveWithoutMetadata(regs);
    }
}
