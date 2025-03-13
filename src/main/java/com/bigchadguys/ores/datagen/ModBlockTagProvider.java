package com.bigchadguys.ores.datagen;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, JoesOres.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.COBALT_ORE.get())
                .add(ModBlocks.DEEPSLATE_COBALT_ORE.get())

                .add(ModBlocks.MAGNITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_MAGNITE_ORE.get())

                .add(ModBlocks.MYTHRIL_ORE.get())
                .add(ModBlocks.DEEPSLATE_MYTHRIL_ORE.get())

                .add(ModBlocks.ORICHALCUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get())

                .add(ModBlocks.ADAMANTITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_ADAMANTITE_ORE.get())

                .add(ModBlocks.CELESTIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_CELESTIUM_ORE.get())

                .add(ModBlocks.VIRIDIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_VIRIDIUM_ORE.get())

                .add(ModBlocks.MORPHITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_MORPHITE_ORE.get())

                .add(ModBlocks.TECTONIC_ORE.get())
                .add(ModBlocks.DEEPSLATE_TECTONIC_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MORPHITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_MORPHITE_ORE.get())

                .add(ModBlocks.TECTONIC_ORE.get())
                .add(ModBlocks.DEEPSLATE_TECTONIC_ORE.get());
    }
}
