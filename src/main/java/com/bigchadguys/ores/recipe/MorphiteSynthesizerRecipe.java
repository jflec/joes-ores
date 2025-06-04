package com.bigchadguys.ores.recipe;

import com.bigchadguys.ores.item.ModItems;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public record MorphiteSynthesizerRecipe(
        Ingredient catalystItem,
        Ingredient morphiteItem,
        Ingredient upgradeItem,
        ItemStack output
) implements Recipe<MorphiteSynthesizerRecipeInput> {
    private static final Ingredient HARD_CODED_CATALYST =
            Ingredient.of(Items.DRAGON_BREATH);
    private static final Ingredient HARD_CODED_MORPHITE =
            Ingredient.of(ModItems.RAW_MORPHITE.get());

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(HARD_CODED_CATALYST);
        list.add(HARD_CODED_MORPHITE);
        list.add(upgradeItem);
        return list;
    }

    @Override
    public boolean matches(@NotNull MorphiteSynthesizerRecipeInput pInput, Level pLevel) {
        if (pLevel.isClientSide()) return false;

        boolean match0 = HARD_CODED_CATALYST.test(pInput.getItem(0));
        boolean match1 = HARD_CODED_MORPHITE.test(pInput.getItem(1));
        boolean match2 = upgradeItem.test(pInput.getItem(2));

        return match0 && match1 && match2;
    }

    @Override
    public @NotNull ItemStack assemble(
            @NotNull MorphiteSynthesizerRecipeInput pInput,
            HolderLookup.@NotNull Provider pRegistries
    ) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.@NotNull Provider registries) {
        return output;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return ModRecipes.MORPHITE_SYNTHESIZER_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return ModRecipes.MORPHITE_SYNTHESIZER_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<MorphiteSynthesizerRecipe> {
        public static final MapCodec<MorphiteSynthesizerRecipe> CODEC =
                RecordCodecBuilder.mapCodec(inst -> inst.group(
                        RecordCodecBuilder.point(HARD_CODED_CATALYST),
                        RecordCodecBuilder.point(HARD_CODED_MORPHITE),
                        Ingredient.CODEC
                                .fieldOf("upgrade")
                                .forGetter(MorphiteSynthesizerRecipe::upgradeItem),
                        ItemStack.CODEC
                                .fieldOf("result")
                                .forGetter(MorphiteSynthesizerRecipe::output)
                ).apply(inst, MorphiteSynthesizerRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, MorphiteSynthesizerRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, recipe -> HARD_CODED_CATALYST,
                        Ingredient.CONTENTS_STREAM_CODEC, recipe -> HARD_CODED_MORPHITE,
                        Ingredient.CONTENTS_STREAM_CODEC, MorphiteSynthesizerRecipe::upgradeItem,
                        ItemStack.STREAM_CODEC, MorphiteSynthesizerRecipe::output,
                        (catalystIgnored, morphiteIgnored, upgrade, result) ->
                                new MorphiteSynthesizerRecipe(
                                        HARD_CODED_CATALYST,
                                        HARD_CODED_MORPHITE,
                                        upgrade,
                                        result
                                )
                );

        @Override
        public @NotNull MapCodec<MorphiteSynthesizerRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, MorphiteSynthesizerRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
