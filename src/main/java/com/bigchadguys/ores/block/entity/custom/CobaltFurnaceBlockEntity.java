package com.bigchadguys.ores.block.entity.custom;

import com.bigchadguys.ores.block.entity.ModBlockEntities;
import com.bigchadguys.ores.screen.ModMenuTypes;
import com.bigchadguys.ores.screen.custom.CobaltFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CobaltFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    private final RecipeManager.CachedCheck<SingleRecipeInput, SmeltingRecipe> recipeCheck =
            RecipeManager.createCheck(RecipeType.SMELTING);

    public CobaltFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(
                ModBlockEntities.COBALT_FURNACE_BLOCK_ENTITY.get(),
                pos,
                state,
                RecipeType.SMELTING
        );
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.joesores.cobalt_furnace");
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(
            int windowId,
            @NotNull Inventory playerInventory
    ) {
        return new CobaltFurnaceMenu(
                ModMenuTypes.COBALT_FURNACE_MENU.get(),
                windowId,
                playerInventory,
                this,
                this,
                dataAccess
        );
    }

    @Override
    public void setItem(int slot, @NotNull ItemStack stack) {
        super.setItem(slot, stack);
        if (slot == 0) {
            int halfCookTime = Math.max(1, getRecipeCookTime(getLevel()) / 2);
            dataAccess.set(DATA_COOKING_TOTAL_TIME, halfCookTime);
            dataAccess.set(DATA_COOKING_PROGRESS, 0);
            setChanged();
        }
    }

    private int getRecipeCookTime(Level world) {
        if (world == null || items.getFirst().isEmpty()) {
            return AbstractFurnaceBlockEntity.BURN_TIME_STANDARD;
        }
        return recipeCheck.getRecipeFor(new SingleRecipeInput(getItem(0)), world)
                .map(holder -> holder.value().getCookingTime())
                .orElse(AbstractFurnaceBlockEntity.BURN_TIME_STANDARD);
    }

    public static boolean isFuel(ItemStack stack) {
        return AbstractFurnaceBlockEntity.isFuel(stack);
    }

    public boolean isLit() {
        return dataAccess.get(DATA_LIT_TIME) > 0;
    }

    public static void serverTick(
            Level world,
            BlockPos pos,
            BlockState state,
            CobaltFurnaceBlockEntity furnace
    ) {
        AbstractFurnaceBlockEntity.serverTick(world, pos, state, furnace);
        if (furnace.dataAccess.get(DATA_COOKING_PROGRESS) == 0
                && furnace.dataAccess.get(DATA_COOKING_TOTAL_TIME) > 0
        ) {
            int updatedTotal = Math.max(1, furnace.getRecipeCookTime(world) / 2);
            furnace.dataAccess.set(DATA_COOKING_TOTAL_TIME, updatedTotal);
        }
    }
}
