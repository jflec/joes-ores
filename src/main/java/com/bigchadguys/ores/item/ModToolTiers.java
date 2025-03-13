package com.bigchadguys.ores.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier COPPER = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 200, 4.0f, 1.5f, 5, () -> Ingredient.of(Items.COPPER_INGOT));

    // IRON(BlockTags.INCORRECT_FOR_IRON_TOOL, uses 250, speed 6.0F, attackDamageBonus 2.0F, enchantmentValue 14, () -> Ingredient.of(Items.IRON_INGOT)),

    public static final Tier COBALT = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 500, 6.5f, 2.5f, 15, () -> Ingredient.of(ModItems.COBALT_INGOT));
    public static final Tier MAGNITE = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 1000, 7.0f, 3.0f, 10, () -> Ingredient.of(ModItems.MAGNITE_INGOT));

    // DIAMOND(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, uses 1561, speed 8.0F, attackDamageBonus 3.0F, enchantmentValue 10, () -> Ingredient.of(Items.DIAMOND)),

    public static final Tier MYTHRIL = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2000, 8.0f, 3.5f, 10, () -> Ingredient.of(ModItems.MYTHRIL_INGOT));
    public static final Tier ORICHALCUM = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2000, 8.5f, 3.0f, 10, () -> Ingredient.of(ModItems.ORICHALCUM_INGOT));
    public static final Tier ADAMANTITE = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2000, 8.75f, 3.75f, 15, () -> Ingredient.of(ModItems.ADAMANTITE_INGOT));

    // NETHERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, uses 2031, speed 9.0F, attackDamageBonus 4.0F, enchantmentValue 15, () -> Ingredient.of(Items.NETHERITE_INGOT));

    public static final Tier CELESTIUM = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.25f, 4.0f, 10, () -> Ingredient.of(ModItems.LUNARIUM_INGOT));
    public static final Tier VIRIDIUM = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3000, 10.0f, 5.0f, 15, () -> Ingredient.of(ModItems.VIRIDIUM_INGOT));

    public static final Tier NECRONIUM = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 5000, 8.0f, 8.0f, 15, () -> Ingredient.of(ModItems.NECRONIUM_INGOT.get()));
    public static final Tier FLORITE = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 5000, 8.0f, 1.0f, 15, () -> Ingredient.of(ModItems.FLORITE_INGOT.get()));
    public static final Tier GEOVAR = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 5000, 12.0f, 1.0f, 15, () -> Ingredient.of(ModItems.GEOVAR_INGOT.get()));
    public static final Tier PETRAFITE = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 5000, 12.0f, 1.0f, 15, () -> Ingredient.of(ModItems.PETRAFITE_INGOT.get()));
    public static final Tier SWIFTITE = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 5000, 12.0f, 1.0f, 15, () -> Ingredient.of(ModItems.SWIFTITE_INGOT.get()));
}
