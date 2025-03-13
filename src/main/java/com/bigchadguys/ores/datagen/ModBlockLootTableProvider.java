package com.bigchadguys.ores.datagen;

import com.bigchadguys.ores.block.ModBlocks;
import com.bigchadguys.ores.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.COBALT_ORE.get(), block -> createOreDrop(ModBlocks.COBALT_ORE.get(), ModItems.RAW_COBALT.get()));
        this.add(ModBlocks.DEEPSLATE_COBALT_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_COBALT_ORE.get(), ModItems.RAW_COBALT.get()));

        this.add(ModBlocks.MAGNITE_ORE.get(), block -> createOreDrop(ModBlocks.MAGNITE_ORE.get(), ModItems.RAW_MAGNITE.get()));
        this.add(ModBlocks.DEEPSLATE_MAGNITE_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_MAGNITE_ORE.get(), ModItems.RAW_MAGNITE.get()));

        this.add(ModBlocks.MYTHRIL_ORE.get(), block -> createOreDrop(ModBlocks.MYTHRIL_ORE.get(), ModItems.RAW_MYTHRIL.get()));
        this.add(ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(), ModItems.RAW_MYTHRIL.get()));

        this.add(ModBlocks.ORICHALCUM_ORE.get(), block -> createOreDrop(ModBlocks.ORICHALCUM_ORE.get(), ModItems.RAW_ORICHALCUM.get()));
        this.add(ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(), ModItems.RAW_ORICHALCUM.get()));

        this.add(ModBlocks.ADAMANTITE_ORE.get(), block -> createOreDrop(ModBlocks.ADAMANTITE_ORE.get(), ModItems.RAW_ADAMANTITE.get()));
        this.add(ModBlocks.DEEPSLATE_ADAMANTITE_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_ADAMANTITE_ORE.get(), ModItems.RAW_ADAMANTITE.get()));

        this.add(ModBlocks.CELESTIUM_ORE.get(), block -> createOreDrop(ModBlocks.CELESTIUM_ORE.get(), ModItems.RAW_CELESTIUM.get()));
        this.add(ModBlocks.DEEPSLATE_CELESTIUM_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_CELESTIUM_ORE.get(), ModItems.RAW_CELESTIUM.get()));

        this.add(ModBlocks.VIRIDIUM_ORE.get(), block -> createOreDrop(ModBlocks.VIRIDIUM_ORE.get(), ModItems.RAW_VIRIDIUM.get()));
        this.add(ModBlocks.DEEPSLATE_VIRIDIUM_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_VIRIDIUM_ORE.get(), ModItems.RAW_VIRIDIUM.get()));

        this.add(ModBlocks.MORPHITE_ORE.get(), block -> createOreDrop(ModBlocks.MORPHITE_ORE.get(), ModItems.RAW_MORPHITE.get()));
        this.add(ModBlocks.DEEPSLATE_MORPHITE_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_MORPHITE_ORE.get(), ModItems.RAW_MORPHITE.get()));

        this.add(ModBlocks.TECTONIC_ORE.get(), block -> createOreDrop(ModBlocks.TECTONIC_ORE.get(), ModItems.TECTONIC_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_TECTONIC_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_TECTONIC_ORE.get(), ModItems.TECTONIC_SHARD.get()));

        dropSelf(ModBlocks.MORPHITE_SYNTHESIZER.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
