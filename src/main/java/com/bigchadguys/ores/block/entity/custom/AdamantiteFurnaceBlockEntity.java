package com.bigchadguys.ores.block.entity.custom;

import com.bigchadguys.ores.block.ModBlocks;
import com.bigchadguys.ores.block.entity.ModBlockEntities;
import com.bigchadguys.ores.item.ModItems;
import com.bigchadguys.ores.screen.ModMenuTypes;
import com.bigchadguys.ores.screen.custom.AdamantiteFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;

public class AdamantiteFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    private final RecipeManager.CachedCheck<SingleRecipeInput, SmeltingRecipe> recipeCheck =
            RecipeManager.createCheck(RecipeType.SMELTING);

    private static final int DATA_LIT_TIME = 0;
    private static final int DATA_LIT_DURATION = 1;
    private static final int DATA_COOKING_PROGRESS = 2;
    private static final int DATA_COOKING_TOTAL_TIME = 3;

    public AdamantiteFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ADAMANTITE_FURNACE_BLOCK_ENTITY.get(), pos, state, RecipeType.SMELTING);
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.joesores.adamantite_furnace");
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int windowId, @NotNull Inventory playerInventory) {
        return new AdamantiteFurnaceMenu(
                ModMenuTypes.ADAMANTITE_FURNACE_MENU.get(),
                windowId,
                playerInventory,
                this,
                this,
                this.dataAccess
        );
    }

    @Override
    public void setItem(int slot, @NotNull ItemStack stack) {
        super.setItem(slot, stack);
        if (slot == 0) {
            int thirdCookTime = Math.max(1, getRecipeCookTime(getLevel()) / 3);
            dataAccess.set(DATA_COOKING_TOTAL_TIME, thirdCookTime);
            dataAccess.set(DATA_COOKING_PROGRESS, 0);
            setChanged();
        }
    }

    private int getRecipeCookTime(Level world) {
        if (world == null || this.items.getFirst().isEmpty()) {
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
            AdamantiteFurnaceBlockEntity furnace
    ) {
        ItemStack inputStack = furnace.items.get(0);
        ItemStack fuelStack = furnace.items.get(1);
        ItemStack outputStack = furnace.items.get(2);

        boolean isCelestiumInput = !inputStack.isEmpty() && (
                inputStack.getItem() == ModItems.RAW_CELESTIUM.get() ||
                        inputStack.getItem() == ModBlocks.CELESTIUM_ORE.get().asItem() ||
                        inputStack.getItem() == ModBlocks.DEEPSLATE_CELESTIUM_ORE.get().asItem()
        );

        boolean hasVanillaRecipe = furnace.recipeCheck.getRecipeFor(
                new SingleRecipeInput(inputStack), world
        ).isPresent();

        boolean wasLit = furnace.isLit();
        boolean dirty = false;

        if (!furnace.isLit()
                && !fuelStack.isEmpty()
                && AbstractFurnaceBlockEntity.isFuel(fuelStack)
                && !inputStack.isEmpty()
                && (isCelestiumInput || hasVanillaRecipe)
        ) {
            int burnTime = 1600;
            furnace.dataAccess.set(DATA_LIT_TIME, burnTime);
            furnace.dataAccess.set(DATA_LIT_DURATION, burnTime);
            fuelStack.shrink(1);
            dirty = true;
        }

        if (furnace.isLit()) {
            furnace.dataAccess.set(
                    DATA_LIT_TIME,
                    furnace.dataAccess.get(DATA_LIT_TIME) - 1
            );
        }

        if (isCelestiumInput && furnace.isLit()) {
            boolean isDaytime = (world.getDayTime() % 24000L) < 12000L;
            Item outItem = isDaytime
                    ? ModItems.SOLARIUM_INGOT.get()
                    : ModItems.LUNARIUM_INGOT.get();

            if (outputStack.isEmpty()
                    || (outputStack.getItem() == outItem && outputStack.getCount() < outputStack.getMaxStackSize())
            ) {
                int prog = furnace.dataAccess.get(DATA_COOKING_PROGRESS) + 1;
                furnace.dataAccess.set(DATA_COOKING_PROGRESS, prog);
                int total = 66;

                if (prog >= total) {
                    inputStack.shrink(1);
                    if (outputStack.isEmpty()) {
                        furnace.items.set(2, new ItemStack(outItem, 1));
                    } else {
                        outputStack.grow(1);
                    }
                    furnace.dataAccess.set(DATA_COOKING_PROGRESS, 0);
                    dirty = true;
                }
            }
        } else if (!isCelestiumInput) {
            AbstractFurnaceBlockEntity.serverTick(world, pos, state, furnace);
        } else {
            int prog = furnace.dataAccess.get(DATA_COOKING_PROGRESS);
            if (prog > 0) {
                furnace.dataAccess.set(DATA_COOKING_PROGRESS, Math.max(prog - 2, 0));
                dirty = true;
            }
        }

        boolean nowLit = furnace.isLit();
        if (wasLit != nowLit) {
            dirty = true;
            world.setBlock(pos, state.setValue(BlockStateProperties.LIT, nowLit), 3);
        }

        if (dirty) {
            furnace.setChanged();
        }
    }
}
