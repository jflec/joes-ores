package com.bigchadguys.ores.item;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.datagen.ModItemTags;
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
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, JoesOres.MOD_ID);

    public static final Holder<ArmorMaterial> COPPER =
            ARMOR_MATERIALS.register("copper", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 1);
                        map.put(ArmorItem.Type.CHESTPLATE, 4);
                        map.put(ArmorItem.Type.LEGGINGS, 3);
                        map.put(ArmorItem.Type.BOOTS, 1);
                    }),
                    10,
                    SoundEvents.ARMOR_EQUIP_LEATHER,
                    () -> Ingredient.of(Items.COPPER_INGOT),
                    List.of(new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "copper")
                    )),
                    0.0f,
                    0.0f
            ));

    public static final Holder<ArmorMaterial> COBALT =
            ARMOR_MATERIALS.register("cobalt", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.CHESTPLATE, 7);
                        map.put(ArmorItem.Type.LEGGINGS, 5);
                        map.put(ArmorItem.Type.BOOTS, 2);
                    }),
                    18,
                    SoundEvents.ARMOR_EQUIP_IRON,
                    () -> Ingredient.of(ModItems.COBALT_INGOT.get()),
                    List.of(new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "cobalt")
                    )),
                    1.0f,
                    0.0f
            ));

    public static final Holder<ArmorMaterial> MAGNITE =
            ARMOR_MATERIALS.register("magnite", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.CHESTPLATE, 7);
                        map.put(ArmorItem.Type.LEGGINGS, 5);
                        map.put(ArmorItem.Type.BOOTS, 3);
                    }),
                    25,
                    SoundEvents.ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.of(ModItems.MAGNITE_INGOT.get()),
                    List.of(new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "magnite")
                    )),
                    1.5f,
                    0.05f
            ));

    public static final Holder<ArmorMaterial> MYTHRIL =
            ARMOR_MATERIALS.register("mythril", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.BOOTS, 3);
                    }),
                    33,
                    SoundEvents.ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.of(ModItems.MYTHRIL_INGOT.get()),
                    List.of(new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "mythril")
                    )),
                    2.0f,
                    0.0f
            ));

    public static final Holder<ArmorMaterial> ORICHALCUM =
            ARMOR_MATERIALS.register("orichalcum", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.BOOTS, 3);
                    }),
                    37,
                    SoundEvents.ARMOR_EQUIP_NETHERITE,
                    () -> Ingredient.of(ModItems.ORICHALCUM_INGOT.get()),
                    List.of(new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "orichalcum")
                    )),
                    3.0f,
                    0.1f
            ));

    public static final Holder<ArmorMaterial> ADAMANTITE =
            ARMOR_MATERIALS.register("adamantite", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 9);
                        map.put(ArmorItem.Type.LEGGINGS, 7);
                        map.put(ArmorItem.Type.BOOTS, 4);
                    }),
                    40,
                    SoundEvents.ARMOR_EQUIP_NETHERITE,
                    () -> Ingredient.of(ModItems.ADAMANTITE_INGOT.get()),
                    List.of(new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "adamantite")
                    )),
                    4.0f,
                    0.2f
            ));

    public static final Holder<ArmorMaterial> CELESTIUM =
            ARMOR_MATERIALS.register("celestium", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 10);
                        map.put(ArmorItem.Type.LEGGINGS, 8);
                        map.put(ArmorItem.Type.BOOTS, 4);
                    }),
                    45,
                    SoundEvents.ARMOR_EQUIP_NETHERITE,
                    () -> Ingredient.of(ModItemTags.CELESTIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "celestium")
                    )),
                    4.5f,
                    0.25f
            ));

    public static final Holder<ArmorMaterial> VIRIDIUM =
            ARMOR_MATERIALS.register("viridium", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 5);
                        map.put(ArmorItem.Type.CHESTPLATE, 11);
                        map.put(ArmorItem.Type.LEGGINGS, 9);
                        map.put(ArmorItem.Type.BOOTS, 5);
                    }),
                    50,
                    SoundEvents.ARMOR_EQUIP_NETHERITE,
                    () -> Ingredient.of(ModItems.VIRIDIUM_INGOT.get()),
                    List.of(new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "viridium")
                    )),
                    5.0f,
                    0.3f
            ));

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }
}
