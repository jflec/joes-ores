package com.bigchadguys.ores.block;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.block.custom.AdamantiteFurnaceBlock;
import com.bigchadguys.ores.block.custom.CobaltFurnaceBlock;
import com.bigchadguys.ores.block.custom.MorphiteSynthesizerBlock;
import com.bigchadguys.ores.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(JoesOres.MOD_ID);

    private static BlockBehaviour.Properties baseOreProperties(float strength, SoundType sound) {
        return BlockBehaviour.Properties.of()
                .strength(strength)
                .requiresCorrectToolForDrops()
                .sound(sound);
    }

    public static final DeferredBlock<Block> COBALT_ORE = registerBlock("cobalt_ore", () ->
            new Block(baseOreProperties(3.0f, SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore", () ->
            new Block(baseOreProperties(4.5f, SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> MAGNITE_ORE = registerBlock("magnite_ore", () ->
            new Block(baseOreProperties(3.0f, SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_MAGNITE_ORE = registerBlock("deepslate_magnite_ore", () ->
            new Block(baseOreProperties(4.5f, SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> MYTHRIL_ORE = registerBlock("mythril_ore", () ->
            new Block(baseOreProperties(3.0f, SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_MYTHRIL_ORE = registerBlock("deepslate_mythril_ore", () ->
            new Block(baseOreProperties(4.5f, SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> ORICHALCUM_ORE = registerBlock("orichalcum_ore", () ->
            new Block(baseOreProperties(3.0f, SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_ORICHALCUM_ORE = registerBlock("deepslate_orichalcum_ore", () ->
            new Block(baseOreProperties(4.5f, SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> ADAMANTITE_ORE = registerBlock("adamantite_ore", () ->
            new Block(baseOreProperties(3.0f, SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_ADAMANTITE_ORE = registerBlock("deepslate_adamantite_ore", () ->
            new Block(baseOreProperties(4.5f, SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> CELESTIUM_ORE = registerBlock("celestium_ore", () ->
            new Block(baseOreProperties(3.0f, SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_CELESTIUM_ORE = registerBlock("deepslate_celestium_ore", () ->
            new Block(baseOreProperties(4.5f, SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> VIRIDIUM_ORE = registerBlock("viridium_ore", () ->
            new Block(baseOreProperties(4.5f, SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> MORPHITE_ORE = registerBlock("morphite_ore", () ->
            new Block(baseOreProperties(3.0f, SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_MORPHITE_ORE = registerBlock("deepslate_morphite_ore", () ->
            new Block(baseOreProperties(4.5f, SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> TECTONIC_ORE = registerBlock("tectonic_ore", () ->
            new Block(baseOreProperties(3.0f, SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_TECTONIC_ORE = registerBlock("deepslate_tectonic_ore", () ->
            new Block(baseOreProperties(4.5f, SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> COBALT_FURNACE = registerBlock("cobalt_furnace", () ->
            new CobaltFurnaceBlock(BlockBehaviour.Properties.of()
                    .strength(3.0f)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 13 : 0)));

    public static final DeferredBlock<Block> ADAMANTITE_FURNACE = registerBlock("adamantite_furnace", () ->
            new AdamantiteFurnaceBlock(BlockBehaviour.Properties.of()
                    .strength(3.0f)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 13 : 0)));

    public static final DeferredBlock<Block> MORPHITE_SYNTHESIZER = registerBlock("morphite_synthesizer", () ->
            new MorphiteSynthesizerBlock(BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .requiresCorrectToolForDrops()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
