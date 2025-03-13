package com.bigchadguys.ores.datagen;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JoesOres.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
//        blockWithItem(ModBlocks.COBALT_ORE);
//        blockWithItem(ModBlocks.DEEPSLATE_COBALT_ORE);
//
//        blockWithItem(ModBlocks.MAGNITE_ORE);
//        blockWithItem(ModBlocks.DEEPSLATE_MAGNITE_ORE);
//
        blockWithItem(ModBlocks.MYTHRIL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_MYTHRIL_ORE);

        blockWithItem(ModBlocks.ORICHALCUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ORICHALCUM_ORE);

        blockWithItem(ModBlocks.ADAMANTITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ADAMANTITE_ORE);
//
//        blockWithItem(ModBlocks.CELESTIUM_ORE);
//        blockWithItem(ModBlocks.DEEPSLATE_CELESTIUM_ORE);
//
//        blockWithItem(ModBlocks.VIRIDIUM_ORE);
//        blockWithItem(ModBlocks.DEEPSLATE_VIRIDIUM_ORE);

        blockWithItem(ModBlocks.MORPHITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_MORPHITE_ORE);

        blockWithItem(ModBlocks.TECTONIC_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TECTONIC_ORE);
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
