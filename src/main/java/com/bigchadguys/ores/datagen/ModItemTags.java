package com.bigchadguys.ores.datagen;

import com.bigchadguys.ores.JoesOres;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class ModItemTags {
    public static final TagKey<Item> CELESTIUM_INGOT = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "celestium_ingot")
    );

    public static final TagKey<Item> MYTHRIL_TOOLS = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "mythril_tools")
    );

    public static final TagKey<Item> ORICHALCUM_TOOLS = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "orichalcum_tools")
    );

    public static final TagKey<Item> ADAMANTITE_TOOLS = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "adamantite_tools")
    );

    public static final TagKey<Item> CELESTIUM_TOOLS = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, "celestium_tools")
    );
}
