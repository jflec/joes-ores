package com.bigchadguys.ores.datagen;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JoesOres.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.COBALT_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_COBALT_ORE);

        blockWithItem(ModBlocks.MAGNITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_MAGNITE_ORE);

        blockWithItem(ModBlocks.MYTHRIL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_MYTHRIL_ORE);

        blockWithItem(ModBlocks.ORICHALCUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ORICHALCUM_ORE);

        blockWithItem(ModBlocks.ADAMANTITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ADAMANTITE_ORE);

        blockWithItem(ModBlocks.CELESTIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_CELESTIUM_ORE);

        blockWithItem(ModBlocks.VIRIDIUM_ORE);

        blockWithItem(ModBlocks.MORPHITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_MORPHITE_ORE);

        blockWithItem(ModBlocks.TECTONIC_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TECTONIC_ORE);

        furnaceBlock(ModBlocks.COBALT_FURNACE.get(), "cobalt_furnace");
        furnaceBlock(ModBlocks.ADAMANTITE_FURNACE.get(), "adamantite_furnace");

        morphiteSynthesizerBlock(ModBlocks.MORPHITE_SYNTHESIZER.get());
    }

    private void morphiteSynthesizerBlock(Block block) {
        ResourceLocation top = modLoc("block/morphite_synthesizer_top");
        ResourceLocation topOn = modLoc("block/morphite_synthesizer_top_on");
        ResourceLocation front = modLoc("block/morphite_synthesizer_front");
        ResourceLocation frontOn = modLoc("block/morphite_synthesizer_front_on");

        ModelFile offModel = models().orientable("morphite_synthesizer", front, front, top);
        ModelFile onModel = models().orientable("morphite_synthesizer_on", frontOn, frontOn, topOn);

        getVariantBuilder(block).forAllStates(state -> {
            boolean lit = state.getValue(BlockStateProperties.LIT);
            return ConfiguredModel.builder()
                    .modelFile(lit ? onModel : offModel)
                    .build();
        });

        simpleBlockItem(block, offModel);
    }

    private void furnaceBlock(Block block, String name) {
        ResourceLocation side = modLoc("block/" + name + "_side");
        ResourceLocation top = modLoc("block/" + name + "_top");
        ResourceLocation front = modLoc("block/" + name + "_front");
        ResourceLocation frontOn = modLoc("block/" + name + "_front_on");

        ModelFile offModel = models().orientable(name, side, front, top);
        ModelFile onModel = models().orientable(name + "_on", side, frontOn, top);

        getVariantBuilder(block).forAllStates(state -> {
            boolean lit = state.getValue(BlockStateProperties.LIT);
            Direction dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
            int rotationY = ((int) dir.toYRot() + 180) % 360;
            return ConfiguredModel.builder()
                    .modelFile(lit ? onModel : offModel)
                    .rotationY(rotationY)
                    .build();
        });

        simpleBlockItem(block, offModel);
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
