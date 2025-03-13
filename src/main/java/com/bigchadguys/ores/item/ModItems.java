package com.bigchadguys.ores.item;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.item.custom.FloriteHoeItem;
import com.bigchadguys.ores.item.custom.LunariumArmorItem;
import com.bigchadguys.ores.item.custom.NecroniumScytheItem;
import com.bigchadguys.ores.item.custom.SolariumArmorItem;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(JoesOres.MOD_ID);

    public static final DeferredItem<Item> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(ModToolTiers.COPPER, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 1.0f, -2.8f))));
    public static final DeferredItem<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COPPER, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 1.0f, -2.8f))));
    public static final DeferredItem<Item> COPPER_AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(ModToolTiers.COPPER, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.COPPER, 5.0f, -3.0f))));
    public static final DeferredItem<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(ModToolTiers.COPPER, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.COPPER, 1.5f, -3.0f))));
    public static final DeferredItem<Item> COPPER_HOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(ModToolTiers.COPPER, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.COPPER, -3.0f, 0.0f))));

    public static final DeferredItem<Item> COPPER_HELMET = ITEMS.register("copper_helmet",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredItem<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredItem<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredItem<Item> COPPER_BOOTS = ITEMS.register("copper_boots",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final DeferredItem<Item> RAW_MORPHITE = ITEMS.registerSimpleItem("raw_morphite");
    public static final DeferredItem<Item> MORPHITE_INGOT = ITEMS.registerSimpleItem("morphite_ingot");

    public static final DeferredItem<Item> ECTOPLASM = ITEMS.registerSimpleItem("ectoplasm");
    public static final DeferredItem<Item> NECRONIUM_INGOT = ITEMS.registerSimpleItem("necronium_ingot");
    public static final DeferredItem<Item> MUSH = ITEMS.registerSimpleItem("mush");
    public static final DeferredItem<Item> FLORITE_INGOT = ITEMS.registerSimpleItem("florite_ingot");
    public static final DeferredItem<Item> TECTONIC_SHARD = ITEMS.registerSimpleItem("tectonic_shard");
    public static final DeferredItem<Item> GEOVAR_INGOT = ITEMS.registerSimpleItem("geovar_ingot");
    public static final DeferredItem<Item> PETRIFIED_BARK = ITEMS.registerSimpleItem("petrified_bark");
    public static final DeferredItem<Item> PETRAFITE_INGOT = ITEMS.registerSimpleItem("petrafite_ingot");
    public static final DeferredItem<Item> QUICKSILVER = ITEMS.registerSimpleItem("quicksilver");
    public static final DeferredItem<Item> SWIFTITE_INGOT = ITEMS.registerSimpleItem("swiftite_ingot");

    public static final DeferredItem<Item> RAW_COBALT = ITEMS.registerSimpleItem("raw_cobalt");
    public static final DeferredItem<Item> COBALT_INGOT = ITEMS.registerSimpleItem("cobalt_ingot");
    public static final DeferredItem<Item> COBALT_SWORD = ITEMS.register("cobalt_sword",
            () -> new SwordItem(ModToolTiers.COBALT, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.COBALT, 3.0f, -2.4f))));
    public static final DeferredItem<Item> COBALT_PICKAXE = ITEMS.register("cobalt_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COBALT, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.COBALT, 1.0f, -2.8f))));
    public static final DeferredItem<Item> COBALT_AXE = ITEMS.register("cobalt_axe",
            () -> new AxeItem(ModToolTiers.COBALT, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.COBALT, 6.0f, -3.1f))));
    public static final DeferredItem<Item> COBALT_SHOVEL = ITEMS.register("cobalt_shovel",
            () -> new ShovelItem(ModToolTiers.COBALT, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.COBALT, 1.5f, -3.0f))));
    public static final DeferredItem<Item> COBALT_HOE = ITEMS.register("cobalt_hoe",
            () -> new HoeItem(ModToolTiers.COBALT, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.COBALT, -2.0f, -1.0f))));
    public static final DeferredItem<Item> COBALT_HELMET = ITEMS.register("cobalt_helmet",
            () -> new ArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredItem<Item> COBALT_CHESTPLATE = ITEMS.register("cobalt_chestplate",
            () -> new ArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredItem<Item> COBALT_LEGGINGS = ITEMS.register("cobalt_leggings",
            () -> new ArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredItem<Item> COBALT_BOOTS = ITEMS.register("cobalt_boots",
            () -> new ArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final DeferredItem<Item> RAW_MAGNITE = ITEMS.registerSimpleItem("raw_magnite");
    public static final DeferredItem<Item> MAGNITE_INGOT = ITEMS.registerSimpleItem("magnite_ingot");
    public static final DeferredItem<Item> MAGNITE_SWORD = ITEMS.register("magnite_sword",
            () -> new SwordItem(ModToolTiers.MAGNITE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.MAGNITE, 3.0f, -2.4f))));
    public static final DeferredItem<Item> MAGNITE_PICKAXE = ITEMS.register("magnite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.MAGNITE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.MAGNITE, 1.0f, -2.8f))));
    public static final DeferredItem<Item> MAGNITE_AXE = ITEMS.register("magnite_axe",
            () -> new AxeItem(ModToolTiers.MAGNITE, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.MAGNITE, 6.0f, -3.1f))));
    public static final DeferredItem<Item> MAGNITE_SHOVEL = ITEMS.register("magnite_shovel",
            () -> new ShovelItem(ModToolTiers.MAGNITE, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.MAGNITE, 1.5f, -3.0f))));
    public static final DeferredItem<Item> MAGNITE_HOE = ITEMS.register("magnite_hoe",
            () -> new HoeItem(ModToolTiers.MAGNITE, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.MAGNITE, -2.0f, -1.0f))));
    public static final DeferredItem<Item> MAGNITE_HELMET = ITEMS.register("magnite_helmet",
            () -> new ArmorItem(ModArmorMaterials.MAGNITE, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredItem<Item> MAGNITE_CHESTPLATE = ITEMS.register("magnite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.MAGNITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredItem<Item> MAGNITE_LEGGINGS = ITEMS.register("magnite_leggings",
            () -> new ArmorItem(ModArmorMaterials.MAGNITE, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredItem<Item> MAGNITE_BOOTS = ITEMS.register("magnite_boots",
            () -> new ArmorItem(ModArmorMaterials.MAGNITE, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final DeferredItem<Item> RAW_MYTHRIL = ITEMS.registerSimpleItem("raw_mythril");
    public static final DeferredItem<Item> MYTHRIL_INGOT = ITEMS.registerSimpleItem("mythril_ingot");
    public static final DeferredItem<Item> MYTHRIL_SWORD = ITEMS.register("mythril_sword",
            () -> new SwordItem(ModToolTiers.MYTHRIL, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.MYTHRIL, 3.0f, -2.4f))));
    public static final DeferredItem<Item> MYTHRIL_PICKAXE = ITEMS.register("mythril_pickaxe",
            () -> new PickaxeItem(ModToolTiers.MYTHRIL, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.MYTHRIL, 1.0f, -2.8f))));
    public static final DeferredItem<Item> MYTHRIL_AXE = ITEMS.register("mythril_axe",
            () -> new AxeItem(ModToolTiers.MYTHRIL, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.MYTHRIL, 5.0f, -3.0f))));
    public static final DeferredItem<Item> MYTHRIL_SHOVEL = ITEMS.register("mythril_shovel",
            () -> new ShovelItem(ModToolTiers.MYTHRIL, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.MYTHRIL, 1.5f, -3.0f))));
    public static final DeferredItem<Item> MYTHRIL_HOE = ITEMS.register("mythril_hoe",
            () -> new HoeItem(ModToolTiers.MYTHRIL, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.MYTHRIL, -3.0f, 0.0f))));
    public static final DeferredItem<Item> MYTHRIL_HELMET = ITEMS.register("mythril_helmet",
            () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredItem<Item> MYTHRIL_CHESTPLATE = ITEMS.register("mythril_chestplate",
            () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredItem<Item> MYTHRIL_LEGGINGS = ITEMS.register("mythril_leggings",
            () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredItem<Item> MYTHRIL_BOOTS = ITEMS.register("mythril_boots",
            () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final DeferredItem<Item> RAW_ORICHALCUM = ITEMS.registerSimpleItem("raw_orichalcum");
    public static final DeferredItem<Item> ORICHALCUM_INGOT = ITEMS.registerSimpleItem("orichalcum_ingot");
    public static final DeferredItem<Item> ORICHALCUM_SWORD = ITEMS.register("orichalcum_sword",
            () -> new SwordItem(ModToolTiers.ORICHALCUM, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.ORICHALCUM, 3.0f, -2.4f))));
    public static final DeferredItem<Item> ORICHALCUM_PICKAXE = ITEMS.register("orichalcum_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ORICHALCUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.ORICHALCUM, 1.0f, -2.8f))));
    public static final DeferredItem<Item> ORICHALCUM_AXE = ITEMS.register("orichalcum_axe",
            () -> new AxeItem(ModToolTiers.ORICHALCUM, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.ORICHALCUM, 5.0f, -3.0f))));
    public static final DeferredItem<Item> ORICHALCUM_SHOVEL = ITEMS.register("orichalcum_shovel",
            () -> new ShovelItem(ModToolTiers.ORICHALCUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.ORICHALCUM, 1.5f, -3.0f))));
    public static final DeferredItem<Item> ORICHALCUM_HOE = ITEMS.register("orichalcum_hoe",
            () -> new HoeItem(ModToolTiers.ORICHALCUM, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.ORICHALCUM, -3.0f, 0.0f))));
    public static final DeferredItem<Item> ORICHALCUM_HELMET = ITEMS.register("orichalcum_helmet",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredItem<Item> ORICHALCUM_CHESTPLATE = ITEMS.register("orichalcum_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredItem<Item> ORICHALCUM_LEGGINGS = ITEMS.register("orichalcum_leggings",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredItem<Item> ORICHALCUM_BOOTS = ITEMS.register("orichalcum_boots",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final DeferredItem<Item> RAW_ADAMANTITE = ITEMS.registerSimpleItem("raw_adamantite");
    public static final DeferredItem<Item> ADAMANTITE_INGOT = ITEMS.registerSimpleItem("adamantite_ingot");
    public static final DeferredItem<Item> ADAMANTITE_SWORD = ITEMS.register("adamantite_sword",
            () -> new SwordItem(ModToolTiers.ADAMANTITE, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.ADAMANTITE, 3.0f, -2.4f))));
    public static final DeferredItem<Item> ADAMANTITE_PICKAXE = ITEMS.register("adamantite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ADAMANTITE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.ADAMANTITE, 1.0f, -2.8f))));
    public static final DeferredItem<Item> ADAMANTITE_AXE = ITEMS.register("adamantite_axe",
            () -> new AxeItem(ModToolTiers.ADAMANTITE, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.ADAMANTITE, 5.0f, -3.0f))));
    public static final DeferredItem<Item> ADAMANTITE_SHOVEL = ITEMS.register("adamantite_shovel",
            () -> new ShovelItem(ModToolTiers.ADAMANTITE, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.ADAMANTITE, 1.5f, -3.0f))));
    public static final DeferredItem<Item> ADAMANTITE_HOE = ITEMS.register("adamantite_hoe",
            () -> new HoeItem(ModToolTiers.ADAMANTITE, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.ADAMANTITE, -3.0f, 0.0f))));
    public static final DeferredItem<Item> ADAMANTITE_HELMET = ITEMS.register("adamantite_helmet",
            () -> new ArmorItem(ModArmorMaterials.ADAMANTITE, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredItem<Item> ADAMANTITE_CHESTPLATE = ITEMS.register("adamantite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ADAMANTITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredItem<Item> ADAMANTITE_LEGGINGS = ITEMS.register("adamantite_leggings",
            () -> new ArmorItem(ModArmorMaterials.ADAMANTITE, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredItem<Item> ADAMANTITE_BOOTS = ITEMS.register("adamantite_boots",
            () -> new ArmorItem(ModArmorMaterials.ADAMANTITE, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final DeferredItem<Item> RAW_CELESTIUM = ITEMS.registerSimpleItem("raw_celestium");
    public static final DeferredItem<Item> LUNARIUM_INGOT = ITEMS.registerSimpleItem("lunarium_ingot");
    public static final DeferredItem<Item> SOLARIUM_INGOT = ITEMS.registerSimpleItem("solarium_ingot");
    public static final DeferredItem<Item> CELESTIUM_SWORD = ITEMS.register("celestium_sword",
            () -> new SwordItem(ModToolTiers.CELESTIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.CELESTIUM, 3.0f, -2.4f))));
    public static final DeferredItem<Item> CELESTIUM_PICKAXE = ITEMS.register("celestium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CELESTIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.CELESTIUM, 1.0f, -2.8f))));
    public static final DeferredItem<Item> CELESTIUM_AXE = ITEMS.register("celestium_axe",
            () -> new AxeItem(ModToolTiers.CELESTIUM, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.CELESTIUM, 5.0f, -3.0f))));
    public static final DeferredItem<Item> CELESTIUM_SHOVEL = ITEMS.register("celestium_shovel",
            () -> new ShovelItem(ModToolTiers.CELESTIUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.CELESTIUM, 1.5f, -3.0f))));
    public static final DeferredItem<Item> CELESTIUM_HOE = ITEMS.register("celestium_hoe",
            () -> new HoeItem(ModToolTiers.CELESTIUM, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.CELESTIUM, -4.0f, 0.0f))));
    public static final DeferredItem<Item> LUNARIUM_HELMET = ITEMS.register("lunarium_helmet",
            () -> new LunariumArmorItem(ModArmorMaterials.LUNARIUM, LunariumArmorItem.Type.HELMET, new Item.Properties().durability(LunariumArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredItem<Item> LUNARIUM_CHESTPLATE = ITEMS.register("lunarium_chestplate",
            () -> new LunariumArmorItem(ModArmorMaterials.LUNARIUM, LunariumArmorItem.Type.CHESTPLATE, new Item.Properties().durability(LunariumArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredItem<Item> LUNARIUM_LEGGINGS = ITEMS.register("lunarium_leggings",
            () -> new LunariumArmorItem(ModArmorMaterials.LUNARIUM, LunariumArmorItem.Type.LEGGINGS, new Item.Properties().durability(LunariumArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredItem<Item> LUNARIUM_BOOTS = ITEMS.register("lunarium_boots",
            () -> new LunariumArmorItem(ModArmorMaterials.LUNARIUM, LunariumArmorItem.Type.BOOTS, new Item.Properties().durability(LunariumArmorItem.Type.BOOTS.getDurability(37))));
    public static final DeferredItem<Item> SOLARIUM_HELMET = ITEMS.register("solarium_helmet",
            () -> new SolariumArmorItem(ModArmorMaterials.SOLARIUM, SolariumArmorItem.Type.HELMET, new Item.Properties().durability(SolariumArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredItem<Item> SOLARIUM_CHESTPLATE = ITEMS.register("solarium_chestplate",
            () -> new SolariumArmorItem(ModArmorMaterials.SOLARIUM, SolariumArmorItem.Type.CHESTPLATE, new Item.Properties().durability(SolariumArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredItem<Item> SOLARIUM_LEGGINGS = ITEMS.register("solarium_leggings",
            () -> new SolariumArmorItem(ModArmorMaterials.SOLARIUM, SolariumArmorItem.Type.LEGGINGS, new Item.Properties().durability(SolariumArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredItem<Item> SOLARIUM_BOOTS = ITEMS.register("solarium_boots",
            () -> new SolariumArmorItem(ModArmorMaterials.SOLARIUM, SolariumArmorItem.Type.BOOTS, new Item.Properties().durability(SolariumArmorItem.Type.BOOTS.getDurability(37))));

    public static final DeferredItem<Item> RAW_VIRIDIUM = ITEMS.registerSimpleItem("raw_viridium");
    public static final DeferredItem<Item> VIRIDIUM_INGOT = ITEMS.registerSimpleItem("viridium_ingot");
    public static final DeferredItem<Item> VIRIDIUM_SWORD = ITEMS.register("viridium_sword",
            () -> new SwordItem(ModToolTiers.VIRIDIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.VIRIDIUM, 3.0f, -2.4f))));
    public static final DeferredItem<Item> VIRIDIUM_PICKAXE = ITEMS.register("viridium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.VIRIDIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.VIRIDIUM, 1.0f, -2.8f))));
    public static final DeferredItem<Item> VIRIDIUM_AXE = ITEMS.register("viridium_axe",
            () -> new AxeItem(ModToolTiers.VIRIDIUM, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.VIRIDIUM, 5.0f, -3.0f))));
    public static final DeferredItem<Item> VIRIDIUM_SHOVEL = ITEMS.register("viridium_shovel",
            () -> new ShovelItem(ModToolTiers.VIRIDIUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.VIRIDIUM, 1.5f, -3.0f))));
    public static final DeferredItem<Item> VIRIDIUM_HOE = ITEMS.register("viridium_hoe",
            () -> new HoeItem(ModToolTiers.VIRIDIUM, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.VIRIDIUM, -4.0f, 0.0f))));
    public static final DeferredItem<Item> VIRIDIUM_HELMET = ITEMS.register("viridium_helmet",
            () -> new ArmorItem(ModArmorMaterials.VIRIDIUM, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredItem<Item> VIRIDIUM_CHESTPLATE = ITEMS.register("viridium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.VIRIDIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredItem<Item> VIRIDIUM_LEGGINGS = ITEMS.register("viridium_leggings",
            () -> new ArmorItem(ModArmorMaterials.VIRIDIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredItem<Item> VIRIDIUM_BOOTS = ITEMS.register("viridium_boots",
            () -> new ArmorItem(ModArmorMaterials.VIRIDIUM, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final DeferredItem<Item> NECRONIUM_SWORD = ITEMS.register("necronium_sword",
            () -> new NecroniumScytheItem(ModToolTiers.NECRONIUM,
                    new Item.Properties()
                            .attributes(SwordItem.createAttributes(ModToolTiers.NECRONIUM, 3.0f, -2.4f))));
    public static final DeferredItem<Item> FLORITE_HOE = ITEMS.register("florite_hoe",
            () -> new FloriteHoeItem(ModToolTiers.FLORITE, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.FLORITE, -3.0f, 0.0f))));
    public static final DeferredItem<Item> GEOVAR_PICKAXE = ITEMS.register("geovar_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GEOVAR, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.GEOVAR, 1.0f, -2.8f))));
    public static final DeferredItem<Item> PETRAFITE_AXE = ITEMS.register("petrafite_axe",
            () -> new AxeItem(ModToolTiers.PETRAFITE, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.PETRAFITE, 5.0f, -3.0f))));
    public static final DeferredItem<Item> SWIFTITE_SHOVEL = ITEMS.register("swiftite_shovel",
            () -> new ShovelItem(ModToolTiers.SWIFTITE, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.SWIFTITE, 1.5f, -3.0f))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
