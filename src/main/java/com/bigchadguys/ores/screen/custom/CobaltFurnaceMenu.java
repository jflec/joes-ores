package com.bigchadguys.ores.screen.custom;

import com.bigchadguys.ores.block.entity.custom.CobaltFurnaceBlockEntity;
import com.bigchadguys.ores.screen.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CobaltFurnaceMenu extends AbstractContainerMenu {
    private final Container container;
    private final ContainerData data;
    private final Level level;

    public CobaltFurnaceMenu(int windowId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(ModMenuTypes.COBALT_FURNACE_MENU.get(), windowId, playerInventory,
                (CobaltFurnaceBlockEntity) playerInventory.player.level().getBlockEntity(extraData.readBlockPos()),
                new SimpleContainer(3), new SimpleContainerData(4));
    }

    public CobaltFurnaceMenu(MenuType<?> type, int id, Inventory playerInventory,
                             CobaltFurnaceBlockEntity blockEntity, Container container, ContainerData data) {
        super(type, id);
        this.level = blockEntity.getLevel();
        this.container = container;
        this.data = data;

        checkContainerSize(container, 3);
        checkContainerDataCount(data, 4);
        container.startOpen(playerInventory.player);

        this.addSlot(new Slot(container, 0, 56, 17));
        this.addSlot(new Slot(container, 1, 56, 53));
        this.addSlot(new FurnaceResultSlot(playerInventory.player, container, 2, 116, 35));

        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        for (int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
        }

        this.addDataSlots(data);
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return this.container.stillValid(player);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        ItemStack copy = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack item = slot.getItem();
            copy = item.copy();

            if (index == 2) {
                if (!this.moveItemStackTo(item, 3, 39, true)) return ItemStack.EMPTY;
                slot.onQuickCraft(item, copy);
            } else if (index != 1 && index != 0) {
                if (isSmeltable(item)) {
                    if (!this.moveItemStackTo(item, 0, 1, false)) return ItemStack.EMPTY;
                } else if (isFuel(item)) {
                    if (!this.moveItemStackTo(item, 1, 2, false)) return ItemStack.EMPTY;
                } else if (index >= 3 && index < 30) {
                    if (!this.moveItemStackTo(item, 30, 39, false)) return ItemStack.EMPTY;
                } else if (index >= 30 && index < 39) {
                    if (!this.moveItemStackTo(item, 3, 30, false)) return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(item, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (item.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (item.getCount() == copy.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, item);
        }

        return copy;
    }

    public int getLitProgress() {
        int burnTime = data.get(0);
        int burnTimeTotal = data.get(1);
        return burnTimeTotal != 0 ? burnTime * 14 / burnTimeTotal : 0;
    }

    public int getBurnProgress() {
        int cookTime = data.get(2);
        int cookTimeTotal = data.get(3);
        return cookTimeTotal != 0 ? cookTime * 24 / cookTimeTotal : 0;
    }

    public boolean isLit() {
        return this.data.get(0) > 0;
    }

    private boolean isSmeltable(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return this.level.getRecipeManager()
                .getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(stack), this.level)
                .isPresent();
    }

    private boolean isFuel(ItemStack stack) {
        return CobaltFurnaceBlockEntity.isFuel(stack);
    }
}
