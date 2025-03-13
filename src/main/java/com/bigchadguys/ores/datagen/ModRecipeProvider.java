package com.bigchadguys.ores.datagen;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.block.ModBlocks;
import com.bigchadguys.ores.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static void oreSmelting(@NotNull RecipeOutput recipeOutput, List<ItemLike> ingredients, @NotNull RecipeCategory category, @NotNull ItemLike result,
                                      float experience, int cookingTime, @NotNull String group) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, ingredients, category, result,
                experience, cookingTime, group, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull RecipeOutput recipeOutput, List<ItemLike> ingredients, @NotNull RecipeCategory category, @NotNull ItemLike result,
                                      float experience, int cookingTime, @NotNull String group) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, ingredients, category, result,
                experience, cookingTime, group, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(@NotNull RecipeOutput recipeOutput, RecipeSerializer<T> cookingSerializer, AbstractCookingRecipe.@NotNull Factory<T> factory,
                                                                       List<ItemLike> ingredients, @NotNull RecipeCategory category, @NotNull ItemLike result, float experience, int cookingTime, @NotNull String group, String recipeName) {
        for (ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime, cookingSerializer, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, JoesOres.MOD_ID + ":" + getItemName(result) + recipeName + "_" + getItemName(itemlike));
        }
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        List<ItemLike> MORPHITE_SMELTABLES = List.of(ModItems.RAW_MORPHITE, ModBlocks.MORPHITE_ORE, ModBlocks.DEEPSLATE_MORPHITE_ORE);

        oreSmelting(recipeOutput, MORPHITE_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_MORPHITE.get(), 0.25f, 200, "morphite");
        oreBlasting(recipeOutput, MORPHITE_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_MORPHITE.get(), 0.25f, 100, "morphite");
    }
}
