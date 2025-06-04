package com.bigchadguys.ores.datagen;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.block.ModBlockTags;
import com.bigchadguys.ores.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper
    ) {
        super(output, lookupProvider, JoesOres.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).add(
                ModBlocks.MAGNITE_ORE.get(),
                ModBlocks.DEEPSLATE_MAGNITE_ORE.get(),
                ModBlocks.COBALT_ORE.get(),
                ModBlocks.DEEPSLATE_COBALT_ORE.get(),
                ModBlocks.MYTHRIL_ORE.get(),
                ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(),
                ModBlocks.ORICHALCUM_ORE.get(),
                ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(),
                ModBlocks.ADAMANTITE_ORE.get(),
                ModBlocks.DEEPSLATE_ADAMANTITE_ORE.get(),
                ModBlocks.CELESTIUM_ORE.get(),
                ModBlocks.DEEPSLATE_CELESTIUM_ORE.get(),
                ModBlocks.VIRIDIUM_ORE.get(),
                ModBlocks.MORPHITE_ORE.get(),
                ModBlocks.DEEPSLATE_MORPHITE_ORE.get(),
                ModBlocks.TECTONIC_ORE.get(),
                ModBlocks.DEEPSLATE_TECTONIC_ORE.get()
        );

        tag(BlockTags.INCORRECT_FOR_STONE_TOOL).add(
                ModBlocks.MAGNITE_ORE.get(),
                ModBlocks.DEEPSLATE_MAGNITE_ORE.get(),
                ModBlocks.COBALT_ORE.get(),
                ModBlocks.DEEPSLATE_COBALT_ORE.get(),
                ModBlocks.MYTHRIL_ORE.get(),
                ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(),
                ModBlocks.ORICHALCUM_ORE.get(),
                ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(),
                ModBlocks.ADAMANTITE_ORE.get(),
                ModBlocks.DEEPSLATE_ADAMANTITE_ORE.get(),
                ModBlocks.CELESTIUM_ORE.get(),
                ModBlocks.DEEPSLATE_CELESTIUM_ORE.get(),
                ModBlocks.VIRIDIUM_ORE.get(),
                ModBlocks.MORPHITE_ORE.get(),
                ModBlocks.DEEPSLATE_MORPHITE_ORE.get(),
                ModBlocks.TECTONIC_ORE.get(),
                ModBlocks.DEEPSLATE_TECTONIC_ORE.get()
        );

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.COBALT_ORE.get(),
                ModBlocks.DEEPSLATE_COBALT_ORE.get(),
                ModBlocks.MAGNITE_ORE.get(),
                ModBlocks.DEEPSLATE_MAGNITE_ORE.get(),
                ModBlocks.MYTHRIL_ORE.get(),
                ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(),
                ModBlocks.ORICHALCUM_ORE.get(),
                ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(),
                ModBlocks.ADAMANTITE_ORE.get(),
                ModBlocks.DEEPSLATE_ADAMANTITE_ORE.get(),
                ModBlocks.CELESTIUM_ORE.get(),
                ModBlocks.DEEPSLATE_CELESTIUM_ORE.get(),
                ModBlocks.VIRIDIUM_ORE.get(),
                ModBlocks.MORPHITE_ORE.get(),
                ModBlocks.DEEPSLATE_MORPHITE_ORE.get(),
                ModBlocks.TECTONIC_ORE.get(),
                ModBlocks.DEEPSLATE_TECTONIC_ORE.get(),
                ModBlocks.COBALT_FURNACE.get(),
                ModBlocks.ADAMANTITE_FURNACE.get(),
                ModBlocks.MORPHITE_SYNTHESIZER.get()

        );

        tag(BlockTags.INCORRECT_FOR_IRON_TOOL).add(
                ModBlocks.MYTHRIL_ORE.get(),
                ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(),
                ModBlocks.ORICHALCUM_ORE.get(),
                ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(),
                ModBlocks.ADAMANTITE_ORE.get(),
                ModBlocks.DEEPSLATE_ADAMANTITE_ORE.get(),
                ModBlocks.CELESTIUM_ORE.get(),
                ModBlocks.DEEPSLATE_CELESTIUM_ORE.get(),
                ModBlocks.VIRIDIUM_ORE.get(),
                ModBlocks.MORPHITE_ORE.get(),
                ModBlocks.DEEPSLATE_MORPHITE_ORE.get(),
                ModBlocks.TECTONIC_ORE.get(),
                ModBlocks.DEEPSLATE_TECTONIC_ORE.get()
        );

        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL).add(
                ModBlocks.MYTHRIL_ORE.get(),
                ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(),
                ModBlocks.ORICHALCUM_ORE.get(),
                ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(),
                ModBlocks.ADAMANTITE_ORE.get(),
                ModBlocks.DEEPSLATE_ADAMANTITE_ORE.get(),
                ModBlocks.CELESTIUM_ORE.get(),
                ModBlocks.DEEPSLATE_CELESTIUM_ORE.get(),
                ModBlocks.VIRIDIUM_ORE.get(),
                ModBlocks.MORPHITE_ORE.get(),
                ModBlocks.DEEPSLATE_MORPHITE_ORE.get(),
                ModBlocks.TECTONIC_ORE.get(),
                ModBlocks.DEEPSLATE_TECTONIC_ORE.get()
        );

        tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL).add(
                ModBlocks.ORICHALCUM_ORE.get(),
                ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(),
                ModBlocks.ADAMANTITE_ORE.get(),
                ModBlocks.DEEPSLATE_ADAMANTITE_ORE.get(),
                ModBlocks.CELESTIUM_ORE.get(),
                ModBlocks.DEEPSLATE_CELESTIUM_ORE.get(),
                ModBlocks.VIRIDIUM_ORE.get(),
                ModBlocks.MORPHITE_ORE.get(),
                ModBlocks.DEEPSLATE_MORPHITE_ORE.get(),
                ModBlocks.TECTONIC_ORE.get(),
                ModBlocks.DEEPSLATE_TECTONIC_ORE.get()
        );

        tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL).add(
                ModBlocks.ADAMANTITE_ORE.get(),
                ModBlocks.DEEPSLATE_ADAMANTITE_ORE.get(),
                ModBlocks.CELESTIUM_ORE.get(),
                ModBlocks.DEEPSLATE_CELESTIUM_ORE.get(),
                ModBlocks.VIRIDIUM_ORE.get(),
                ModBlocks.MORPHITE_ORE.get(),
                ModBlocks.DEEPSLATE_MORPHITE_ORE.get(),
                ModBlocks.TECTONIC_ORE.get(),
                ModBlocks.DEEPSLATE_TECTONIC_ORE.get()
        );

        tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.MAGNITE_ORE.get(),
                ModBlocks.DEEPSLATE_MAGNITE_ORE.get(),
                ModBlocks.COBALT_ORE.get(),
                ModBlocks.DEEPSLATE_COBALT_ORE.get(),
                ModBlocks.COBALT_FURNACE.get()
        );

        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ModBlocks.MYTHRIL_ORE.get(),
                ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(),
                ModBlocks.ADAMANTITE_FURNACE.get(),
                ModBlocks.MORPHITE_SYNTHESIZER.get()
        );

        tag(ModBlockTags.NEEDS_MYTHRIL_TOOL).add(
                ModBlocks.ORICHALCUM_ORE.get(),
                ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get()
        );

        tag(ModBlockTags.NEEDS_ORICHALCUM_TOOL).add(
                ModBlocks.ADAMANTITE_ORE.get(),
                ModBlocks.DEEPSLATE_ADAMANTITE_ORE.get()
        );

        tag(ModBlockTags.NEEDS_ADAMANTITE_TOOL).add(
                ModBlocks.CELESTIUM_ORE.get(),
                ModBlocks.DEEPSLATE_CELESTIUM_ORE.get()
        );

        tag(ModBlockTags.NEEDS_CELESTIUM_TIER_TOOL).add(
                ModBlocks.VIRIDIUM_ORE.get(),
                ModBlocks.MORPHITE_ORE.get(),
                ModBlocks.DEEPSLATE_MORPHITE_ORE.get(),
                ModBlocks.TECTONIC_ORE.get(),
                ModBlocks.DEEPSLATE_TECTONIC_ORE.get()
        );

        tag(ModBlockTags.INCORRECT_FOR_MAGNITE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(
                        ModBlocks.MAGNITE_ORE.get(),
                        ModBlocks.DEEPSLATE_MAGNITE_ORE.get(),
                        ModBlocks.COBALT_ORE.get(),
                        ModBlocks.DEEPSLATE_COBALT_ORE.get()
                )
                .add(
                        ModBlocks.VIRIDIUM_ORE.get(),
                        ModBlocks.MORPHITE_ORE.get(),
                        ModBlocks.DEEPSLATE_MORPHITE_ORE.get(),
                        ModBlocks.TECTONIC_ORE.get(),
                        ModBlocks.DEEPSLATE_TECTONIC_ORE.get()
                );

        tag(ModBlockTags.INCORRECT_FOR_COBALT_TOOL)
                .addTag(ModBlockTags.INCORRECT_FOR_MAGNITE_TOOL)
                .add(
                        ModBlocks.VIRIDIUM_ORE.get(),
                        ModBlocks.MORPHITE_ORE.get(),
                        ModBlocks.DEEPSLATE_MORPHITE_ORE.get(),
                        ModBlocks.TECTONIC_ORE.get(),
                        ModBlocks.DEEPSLATE_TECTONIC_ORE.get(),
                        Blocks.OBSIDIAN
                );

        tag(ModBlockTags.INCORRECT_FOR_MYTHRIL_TOOL)
                .addTag(ModBlockTags.INCORRECT_FOR_COBALT_TOOL)
                .remove(
                        ModBlocks.MYTHRIL_ORE.get(),
                        ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(),
                        ModBlocks.ORICHALCUM_ORE.get(),
                        ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(),
                        Blocks.OBSIDIAN
                )
                .add(
                        ModBlocks.VIRIDIUM_ORE.get(),
                        ModBlocks.MORPHITE_ORE.get(),
                        ModBlocks.DEEPSLATE_MORPHITE_ORE.get(),
                        ModBlocks.TECTONIC_ORE.get(),
                        ModBlocks.DEEPSLATE_TECTONIC_ORE.get()
                );

        tag(ModBlockTags.INCORRECT_FOR_ORICHALCUM_TOOL)
                .addTag(ModBlockTags.INCORRECT_FOR_MYTHRIL_TOOL)
                .remove(
                        ModBlocks.ADAMANTITE_ORE.get(),
                        ModBlocks.DEEPSLATE_ADAMANTITE_ORE.get()
                )
                .add(
                        ModBlocks.VIRIDIUM_ORE.get(),
                        ModBlocks.MORPHITE_ORE.get(),
                        ModBlocks.DEEPSLATE_MORPHITE_ORE.get(),
                        ModBlocks.TECTONIC_ORE.get(),
                        ModBlocks.DEEPSLATE_TECTONIC_ORE.get()
                );

        tag(ModBlockTags.INCORRECT_FOR_ADAMANTITE_TOOL)
                .addTag(ModBlockTags.INCORRECT_FOR_ORICHALCUM_TOOL)
                .remove(
                        ModBlocks.CELESTIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_CELESTIUM_ORE.get()
                )
                .add(
                        ModBlocks.VIRIDIUM_ORE.get(),
                        ModBlocks.MORPHITE_ORE.get(),
                        ModBlocks.DEEPSLATE_MORPHITE_ORE.get(),
                        ModBlocks.TECTONIC_ORE.get(),
                        ModBlocks.DEEPSLATE_TECTONIC_ORE.get()
                );

        tag(ModBlockTags.INCORRECT_FOR_CELESTIUM_TOOL)
                .addTag(ModBlockTags.INCORRECT_FOR_ADAMANTITE_TOOL)
                .remove(
                        ModBlocks.VIRIDIUM_ORE.get(),
                        ModBlocks.MORPHITE_ORE.get(),
                        ModBlocks.DEEPSLATE_MORPHITE_ORE.get(),
                        ModBlocks.TECTONIC_ORE.get(),
                        ModBlocks.DEEPSLATE_TECTONIC_ORE.get()
                );
    }
}
