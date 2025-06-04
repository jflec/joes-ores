package com.bigchadguys.ores.block;

import com.bigchadguys.ores.JoesOres;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class ModBlockTags {
    public static final TagKey<Block> NEEDS_MYTHRIL_TOOL = create("needs_mythril_tool");
    public static final TagKey<Block> NEEDS_ORICHALCUM_TOOL = create("needs_orichalcum_tool");
    public static final TagKey<Block> NEEDS_ADAMANTITE_TOOL = create("needs_adamantite_tool");
    public static final TagKey<Block> NEEDS_CELESTIUM_TIER_TOOL = create("needs_celestium_tier_tool");

    public static final TagKey<Block> INCORRECT_FOR_MAGNITE_TOOL = create("incorrect_for_magnite_tool");
    public static final TagKey<Block> INCORRECT_FOR_COBALT_TOOL = create("incorrect_for_cobalt_tool");
    public static final TagKey<Block> INCORRECT_FOR_MYTHRIL_TOOL = create("incorrect_for_mythril_tool");
    public static final TagKey<Block> INCORRECT_FOR_ORICHALCUM_TOOL = create("incorrect_for_orichalcum_tool");
    public static final TagKey<Block> INCORRECT_FOR_ADAMANTITE_TOOL = create("incorrect_for_adamantite_tool");
    public static final TagKey<Block> INCORRECT_FOR_CELESTIUM_TOOL = create("incorrect_for_celestium_tool");

    private static TagKey<Block> create(String name) {
        return TagKey.create(
                Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, name)
        );
    }
}
