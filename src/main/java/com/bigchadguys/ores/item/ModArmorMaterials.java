package com.bigchadguys.ores.item;

import com.bigchadguys.ores.JoesOres;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, JoesOres.MOD_ID);
    public static final Holder<ArmorMaterial> COPPER =
            ARMOR_MATERIALS.register("copper", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.BODY, 11);
                    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(Items.COPPER_INGOT),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "copper"))),
                    2.0f, 0));

    public static final Holder<ArmorMaterial> COBALT =
            ARMOR_MATERIALS.register("cobalt", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.BODY, 11);
                    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(ModItems.COBALT_INGOT),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "cobalt"))),
                    2.0f, 0));

    public static final Holder<ArmorMaterial> MAGNITE =
            ARMOR_MATERIALS.register("magnite", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.BODY, 11);
                    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(ModItems.MAGNITE_INGOT),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "magnite"))),
                    2.0f, 0));

    public static final Holder<ArmorMaterial> MYTHRIL =
            ARMOR_MATERIALS.register("mythril", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.BODY, 11);
                    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(ModItems.MYTHRIL_INGOT),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "mythril"))),
                    2.0f, 0));

    public static final Holder<ArmorMaterial> ORICHALCUM =
            ARMOR_MATERIALS.register("orichalcum", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.BODY, 11);
                    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(ModItems.ORICHALCUM_INGOT),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "orichalcum"))),
                    2.0f, 0));

    public static final Holder<ArmorMaterial> ADAMANTITE =
            ARMOR_MATERIALS.register("adamantite", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.BODY, 11);
                    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(ModItems.ADAMANTITE_INGOT),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "adamantite"))),
                    2.0f, 0));

    public static final Holder<ArmorMaterial> LUNARIUM =
            ARMOR_MATERIALS.register("lunarium", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.BODY, 11);
                    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(ModItems.LUNARIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "lunarium"))),
                    2.0f, 0));

    public static final Holder<ArmorMaterial> SOLARIUM =
            ARMOR_MATERIALS.register("solarium", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.BODY, 11);
                    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(ModItems.SOLARIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "solarium"))),
                    2.0f, 0));

    public static final Holder<ArmorMaterial> VIRIDIUM =
            ARMOR_MATERIALS.register("viridium", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.BODY, 11);
                    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(ModItems.VIRIDIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "viridium"))),
                    2.0f, 0));

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }
}
