package com.bigchadguys.ores.datagen;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.block.ModBlocks;
import com.bigchadguys.ores.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static void oreSmelting(@NotNull RecipeOutput recipeOutput,
                                      List<ItemLike> ingredients,
                                      @NotNull RecipeCategory category,
                                      @NotNull ItemLike result,
                                      float experience,
                                      int cookingTime,
                                      @NotNull String group) {
        oreCooking(
                recipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new,
                ingredients,
                category,
                result,
                experience,
                cookingTime,
                group,
                "_from_smelting"
        );
    }

    protected static void oreBlasting(@NotNull RecipeOutput recipeOutput,
                                      List<ItemLike> ingredients,
                                      @NotNull RecipeCategory category,
                                      @NotNull ItemLike result,
                                      float experience,
                                      int cookingTime,
                                      @NotNull String group) {
        oreCooking(
                recipeOutput,
                RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new,
                ingredients,
                category,
                result,
                experience,
                cookingTime,
                group,
                "_from_blasting"
        );
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(
            @NotNull RecipeOutput recipeOutput,
            RecipeSerializer<T> cookingSerializer,
            AbstractCookingRecipe.@NotNull Factory<T> factory,
            List<ItemLike> ingredients,
            @NotNull RecipeCategory category,
            @NotNull ItemLike result,
            float experience,
            int cookingTime,
            @NotNull String group,
            String recipeNameSuffix
    ) {
        for (ItemLike input : ingredients) {
            SimpleCookingRecipeBuilder
                    .generic(
                            Ingredient.of(input),
                            category,
                            result,
                            experience,
                            cookingTime,
                            cookingSerializer,
                            factory
                    )
                    .group(group)
                    .unlockedBy(getHasName(input), has(input))
                    .save(
                            recipeOutput,
                            JoesOres.MOD_ID + ":" +
                                    getItemName(result) +
                                    recipeNameSuffix + "_" +
                                    getItemName(input)
                    );
        }
    }

    protected static void registerStandardTools(
            @NotNull RecipeOutput recipeOutput,
            @NotNull ItemLike swordOut,
            @NotNull ItemLike axeOut,
            @NotNull ItemLike pickOut,
            @NotNull ItemLike shovelOut,
            @NotNull ItemLike hoeOut,
            @NotNull ItemLike ingot,
            @NotNull String unlockName
    ) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, swordOut)
                .pattern(" C ")
                .pattern(" C ")
                .pattern(" S ")
                .define('C', ingot)
                .define('S', Items.STICK)
                .unlockedBy("has_" + unlockName, has(ingot))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, axeOut)
                .pattern("CC ")
                .pattern("CS ")
                .pattern(" S ")
                .define('C', ingot)
                .define('S', Items.STICK)
                .unlockedBy("has_" + unlockName, has(ingot))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickOut)
                .pattern("CCC")
                .pattern(" S ")
                .pattern(" S ")
                .define('C', ingot)
                .define('S', Items.STICK)
                .unlockedBy("has_" + unlockName, has(ingot))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovelOut)
                .pattern(" C ")
                .pattern(" S ")
                .pattern(" S ")
                .define('C', ingot)
                .define('S', Items.STICK)
                .unlockedBy("has_" + unlockName, has(ingot))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoeOut)
                .pattern("CC ")
                .pattern(" S ")
                .pattern(" S ")
                .define('C', ingot)
                .define('S', Items.STICK)
                .unlockedBy("has_" + unlockName, has(ingot))
                .save(recipeOutput);
    }

    protected static void registerStandardArmor(
            @NotNull RecipeOutput recipeOutput,
            @NotNull ItemLike helmetOut,
            @NotNull ItemLike chestplateOut,
            @NotNull ItemLike leggingsOut,
            @NotNull ItemLike bootsOut,
            @NotNull ItemLike ingot,
            @NotNull String unlockName
    ) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmetOut)
                .pattern("CCC")
                .pattern("C C")
                .pattern("   ")
                .define('C', ingot)
                .unlockedBy("has_" + unlockName, has(ingot))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, chestplateOut)
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ingot)
                .unlockedBy("has_" + unlockName, has(ingot))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, leggingsOut)
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .define('C', ingot)
                .unlockedBy("has_" + unlockName, has(ingot))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, bootsOut)
                .pattern("   ")
                .pattern("C C")
                .pattern("C C")
                .define('C', ingot)
                .unlockedBy("has_" + unlockName, has(ingot))
                .save(recipeOutput);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        record OreData(List<ItemLike> smeltables, ItemLike ingotItem, String unlockName) { }

        Map<String, OreData> ores = Map.of(
                "cobalt", new OreData(
                        List.of(ModItems.RAW_COBALT, ModBlocks.COBALT_ORE, ModBlocks.DEEPSLATE_COBALT_ORE),
                        ModItems.COBALT_INGOT.get(),
                        "cobalt_ingot"
                ),
                "magnite", new OreData(
                        List.of(ModItems.RAW_MAGNITE, ModBlocks.MAGNITE_ORE, ModBlocks.DEEPSLATE_MAGNITE_ORE),
                        ModItems.MAGNITE_INGOT.get(),
                        "magnite_ingot"
                ),
                "mythril", new OreData(
                        List.of(ModItems.RAW_MYTHRIL, ModBlocks.MYTHRIL_ORE, ModBlocks.DEEPSLATE_MYTHRIL_ORE),
                        ModItems.MYTHRIL_INGOT.get(),
                        "mythril_ingot"
                ),
                "adamantite", new OreData(
                        List.of(ModItems.RAW_ADAMANTITE, ModBlocks.ADAMANTITE_ORE, ModBlocks.DEEPSLATE_ADAMANTITE_ORE),
                        ModItems.ADAMANTITE_INGOT.get(),
                        "adamantite_ingot"
                ),
                "orichalcum", new OreData(
                        List.of(ModItems.RAW_ORICHALCUM, ModBlocks.ORICHALCUM_ORE, ModBlocks.DEEPSLATE_ORICHALCUM_ORE),
                        ModItems.ORICHALCUM_INGOT.get(),
                        "orichalcum_ingot"
                ),
                "viridium", new OreData(
                        List.of(ModItems.RAW_VIRIDIUM, ModBlocks.VIRIDIUM_ORE),
                        ModItems.VIRIDIUM_INGOT.get(),
                        "viridium_ingot"
                )
        );

        record ToolArmorData(
                ItemLike sword, ItemLike axe, ItemLike pickaxe,
                ItemLike shovel, ItemLike hoe,
                ItemLike helmet, ItemLike chestplate,
                ItemLike leggings, ItemLike boots,
                ItemLike ingot, String unlockName
        ) { }

        Map<String, ToolArmorData> toolArmorMap = Map.of(
                "copper", new ToolArmorData(
                        ModItems.COPPER_SWORD.get(),
                        ModItems.COPPER_AXE.get(),
                        ModItems.COPPER_PICKAXE.get(),
                        ModItems.COPPER_SHOVEL.get(),
                        ModItems.COPPER_HOE.get(),
                        ModItems.COPPER_HELMET.get(),
                        ModItems.COPPER_CHESTPLATE.get(),
                        ModItems.COPPER_LEGGINGS.get(),
                        ModItems.COPPER_BOOTS.get(),
                        Items.COPPER_INGOT,
                        "copper_ingot"
                ),
                "magnite", new ToolArmorData(
                        ModItems.MAGNITE_SWORD.get(),
                        ModItems.MAGNITE_AXE.get(),
                        ModItems.MAGNITE_PICKAXE.get(),
                        ModItems.MAGNITE_SHOVEL.get(),
                        ModItems.MAGNITE_HOE.get(),
                        ModItems.MAGNITE_HELMET.get(),
                        ModItems.MAGNITE_CHESTPLATE.get(),
                        ModItems.MAGNITE_LEGGINGS.get(),
                        ModItems.MAGNITE_BOOTS.get(),
                        ModItems.MAGNITE_INGOT,
                        "magnite_ingot"
                ),
                "cobalt", new ToolArmorData(
                        ModItems.COBALT_SWORD.get(),
                        ModItems.COBALT_AXE.get(),
                        ModItems.COBALT_PICKAXE.get(),
                        ModItems.COBALT_SHOVEL.get(),
                        ModItems.COBALT_HOE.get(),
                        ModItems.COBALT_HELMET.get(),
                        ModItems.COBALT_CHESTPLATE.get(),
                        ModItems.COBALT_LEGGINGS.get(),
                        ModItems.COBALT_BOOTS.get(),
                        ModItems.COBALT_INGOT,
                        "cobalt_ingot"
                ),
                "mythril", new ToolArmorData(
                        ModItems.MYTHRIL_SWORD.get(),
                        ModItems.MYTHRIL_AXE.get(),
                        ModItems.MYTHRIL_PICKAXE.get(),
                        ModItems.MYTHRIL_SHOVEL.get(),
                        ModItems.MYTHRIL_HOE.get(),
                        ModItems.MYTHRIL_HELMET.get(),
                        ModItems.MYTHRIL_CHESTPLATE.get(),
                        ModItems.MYTHRIL_LEGGINGS.get(),
                        ModItems.MYTHRIL_BOOTS.get(),
                        ModItems.MYTHRIL_INGOT,
                        "mythril_ingot"
                ),
                "orichalcum", new ToolArmorData(
                        ModItems.ORICHALCUM_SWORD.get(),
                        ModItems.ORICHALCUM_AXE.get(),
                        ModItems.ORICHALCUM_PICKAXE.get(),
                        ModItems.ORICHALCUM_SHOVEL.get(),
                        ModItems.ORICHALCUM_HOE.get(),
                        ModItems.ORICHALCUM_HELMET.get(),
                        ModItems.ORICHALCUM_CHESTPLATE.get(),
                        ModItems.ORICHALCUM_LEGGINGS.get(),
                        ModItems.ORICHALCUM_BOOTS.get(),
                        ModItems.ORICHALCUM_INGOT,
                        "orichalcum_ingot"
                ),
                "adamantite", new ToolArmorData(
                        ModItems.ADAMANTITE_SWORD.get(),
                        ModItems.ADAMANTITE_AXE.get(),
                        ModItems.ADAMANTITE_PICKAXE.get(),
                        ModItems.ADAMANTITE_SHOVEL.get(),
                        ModItems.ADAMANTITE_HOE.get(),
                        ModItems.ADAMANTITE_HELMET.get(),
                        ModItems.ADAMANTITE_CHESTPLATE.get(),
                        ModItems.ADAMANTITE_LEGGINGS.get(),
                        ModItems.ADAMANTITE_BOOTS.get(),
                        ModItems.ADAMANTITE_INGOT,
                        "adamantite_ingot"
                ),
                "viridium", new ToolArmorData(
                        ModItems.VIRIDIUM_SWORD.get(),
                        ModItems.VIRIDIUM_AXE.get(),
                        ModItems.VIRIDIUM_PICKAXE.get(),
                        ModItems.VIRIDIUM_SHOVEL.get(),
                        ModItems.VIRIDIUM_HOE.get(),
                        ModItems.VIRIDIUM_HELMET.get(),
                        ModItems.VIRIDIUM_CHESTPLATE.get(),
                        ModItems.VIRIDIUM_LEGGINGS.get(),
                        ModItems.VIRIDIUM_BOOTS.get(),
                        ModItems.VIRIDIUM_INGOT,
                        "viridium_ingot"
                ),
                "solarium", new ToolArmorData(
                        null, null, null, null, null,
                        ModItems.SOLARIUM_HELMET.get(),
                        ModItems.SOLARIUM_CHESTPLATE.get(),
                        ModItems.SOLARIUM_LEGGINGS.get(),
                        ModItems.SOLARIUM_BOOTS.get(),
                        ModItems.SOLARIUM_INGOT,
                        "solarium_ingot"
                ),
                "lunarium", new ToolArmorData(
                        null, null, null, null, null,
                        ModItems.LUNARIUM_HELMET.get(),
                        ModItems.LUNARIUM_CHESTPLATE.get(),
                        ModItems.LUNARIUM_LEGGINGS.get(),
                        ModItems.LUNARIUM_BOOTS.get(),
                        ModItems.LUNARIUM_INGOT,
                        "lunarium_ingot"
                )
        );

        for (Map.Entry<String, OreData> entry : ores.entrySet()) {
            OreData data = entry.getValue();
            oreSmelting(
                    recipeOutput,
                    data.smeltables(),
                    RecipeCategory.MISC,
                    data.ingotItem(),
                    0.7f,
                    200,
                    data.unlockName()
            );
            oreBlasting(
                    recipeOutput,
                    data.smeltables(),
                    RecipeCategory.MISC,
                    data.ingotItem(),
                    0.7f,
                    100,
                    data.unlockName()
            );
        }

        for (Map.Entry<String, ToolArmorData> entry : toolArmorMap.entrySet()) {
            ToolArmorData t = entry.getValue();

            if (t.sword() != null) {
                registerStandardTools(
                        recipeOutput,
                        t.sword(), t.axe(), t.pickaxe(), t.shovel(), t.hoe(),
                        t.ingot(),
                        t.unlockName()
                );
            }

            if (t.helmet() != null) {
                registerStandardArmor(
                        recipeOutput,
                        t.helmet(), t.chestplate(), t.leggings(), t.boots(),
                        t.ingot(),
                        t.unlockName()
                );
            }
        }

        TagKey<Item> CELESTIUM_TAG = TagKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "celestium_ingot")
        );

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CELESTIUM_SWORD.get())
                .pattern(" C ")
                .pattern(" C ")
                .pattern(" S ")
                .define('C', CELESTIUM_TAG)
                .define('S', Items.STICK)
                .unlockedBy("has_celestium_ingot", has(CELESTIUM_TAG))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CELESTIUM_AXE.get())
                .pattern("CC ")
                .pattern("CS ")
                .pattern(" S ")
                .define('C', CELESTIUM_TAG)
                .define('S', Items.STICK)
                .unlockedBy("has_celestium_ingot", has(CELESTIUM_TAG))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CELESTIUM_PICKAXE.get())
                .pattern("CCC")
                .pattern(" S ")
                .pattern(" S ")
                .define('C', CELESTIUM_TAG)
                .define('S', Items.STICK)
                .unlockedBy("has_celestium_ingot", has(CELESTIUM_TAG))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CELESTIUM_SHOVEL.get())
                .pattern(" C ")
                .pattern(" S ")
                .pattern(" S ")
                .define('C', CELESTIUM_TAG)
                .define('S', Items.STICK)
                .unlockedBy("has_celestium_ingot", has(CELESTIUM_TAG))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CELESTIUM_HOE.get())
                .pattern("CC ")
                .pattern(" S ")
                .pattern(" S ")
                .define('C', CELESTIUM_TAG)
                .define('S', Items.STICK)
                .unlockedBy("has_celestium_ingot", has(CELESTIUM_TAG))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.COBALT_FURNACE.get())
                .pattern("III")
                .pattern("IFI")
                .pattern("III")
                .define('I', ModItems.COBALT_INGOT.get())
                .define('F', Items.FURNACE)
                .unlockedBy("has_cobalt_ingot", has(ModItems.COBALT_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ADAMANTITE_FURNACE.get())
                .pattern("AAA")
                .pattern("AFA")
                .pattern("AAA")
                .define('A', ModItems.ADAMANTITE_INGOT.get())
                .define('F', ModBlocks.COBALT_FURNACE.get().asItem())
                .unlockedBy("has_adamantite_ingot", has(ModItems.ADAMANTITE_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MORPHITE_SYNTHESIZER.get())
                .pattern("MMM")
                .pattern("QMQ")
                .pattern("QMQ")
                .define('M', ModItems.RAW_MORPHITE.get())
                .define('Q', Items.QUARTZ_BLOCK)
                .unlockedBy("has_morphite_ingot", has(ModItems.RAW_MORPHITE.get()))
                .save(recipeOutput);
    }
}
