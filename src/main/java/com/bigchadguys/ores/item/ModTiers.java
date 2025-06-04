package com.bigchadguys.ores.item;

import com.bigchadguys.ores.block.ModBlockTags;
import com.bigchadguys.ores.datagen.ModItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;
import com.google.common.base.Suppliers;

public enum ModTiers implements Tier {
    COPPER(1, BlockTags.INCORRECT_FOR_STONE_TOOL, 200, 5.0F, 1.5F, 10, () -> Ingredient.of(Items.COPPER_INGOT)),
    COBALT(2, ModBlockTags.INCORRECT_FOR_COBALT_TOOL, 300, 6.2F, 2.1F, 14, () -> Ingredient.of(ModItems.COBALT_INGOT.get())),
    MAGNITE(3, ModBlockTags.INCORRECT_FOR_MAGNITE_TOOL, 800, 7.0F, 2.5F, 14, () -> Ingredient.of(ModItems.MAGNITE_INGOT.get())),
    MYTHRIL(4, ModBlockTags.INCORRECT_FOR_MYTHRIL_TOOL, 1561, 8.0F, 3.0F, 14, () -> Ingredient.of(ModItems.MYTHRIL_INGOT.get())),
    ORICHALCUM(5, ModBlockTags.INCORRECT_FOR_ORICHALCUM_TOOL, 2031, 9.0F, 4.0F, 15, () -> Ingredient.of(ModItems.ORICHALCUM_INGOT.get())),
    ADAMANTITE(6, ModBlockTags.INCORRECT_FOR_ADAMANTITE_TOOL, 2500, 9.5F, 4.5F, 18, () -> Ingredient.of(ModItems.ADAMANTITE_INGOT.get())),
    CELESTIUM(7, ModBlockTags.INCORRECT_FOR_CELESTIUM_TOOL, 3000, 10.0F, 5.0F, 20, () -> Ingredient.of(ModItemTags.CELESTIUM_INGOT)),
    VIRIDIUM(8, ModBlockTags.INCORRECT_FOR_CELESTIUM_TOOL, 3500, 10.5F, 5.5F, 22, () -> Ingredient.of(ModItems.VIRIDIUM_INGOT.get())),
    NECRONIUM(9, ModBlockTags.INCORRECT_FOR_CELESTIUM_TOOL, 8000, 20F, 7.5F, 22, () -> Ingredient.of(ModItems.NECRONIUM_INGOT.get())),
    FLORITE(10, ModBlockTags.INCORRECT_FOR_CELESTIUM_TOOL, 8000, 20F, 7.5F, 22, () -> Ingredient.of(ModItems.FLORITE_INGOT.get())),
    GEOVAR(11, ModBlockTags.INCORRECT_FOR_CELESTIUM_TOOL, 8000, 20F, 7.5F, 22, () -> Ingredient.of(ModItems.GEOVAR_INGOT.get())),
    PETRAFITE(12, ModBlockTags.INCORRECT_FOR_CELESTIUM_TOOL, 8000, 20F, 7.5F, 22, () -> Ingredient.of(ModItems.PETRAFITE_INGOT.get())),
    SWIFTITE(13, ModBlockTags.INCORRECT_FOR_CELESTIUM_TOOL, 8000, 20F, 7.5F, 22, () -> Ingredient.of(ModItems.SWIFTITE_INGOT.get()));

    private final int tierLevel;
    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    ModTiers(int tierLevel, TagKey<Block> incorrectBlocksForDrops, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.tierLevel = tierLevel;
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    public int getLevel() {
        return tierLevel;
    }
}
