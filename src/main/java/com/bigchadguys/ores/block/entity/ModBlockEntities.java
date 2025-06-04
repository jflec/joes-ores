package com.bigchadguys.ores.block.entity;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.block.ModBlocks;
import com.bigchadguys.ores.block.entity.custom.AdamantiteFurnaceBlockEntity;
import com.bigchadguys.ores.block.entity.custom.CobaltFurnaceBlockEntity;
import com.bigchadguys.ores.block.entity.custom.MorphiteSynthesizerBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, JoesOres.MOD_ID);

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

    public static final Supplier<BlockEntityType<MorphiteSynthesizerBlockEntity>> MORPHITE_SYNTHESIZER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register(
                    "morphite_synthesizer_block_entity",
                    () -> BlockEntityType.Builder.of(
                            MorphiteSynthesizerBlockEntity::new,
                            ModBlocks.MORPHITE_SYNTHESIZER.get()
                    ).build(null)
            );

    public static final Supplier<BlockEntityType<CobaltFurnaceBlockEntity>> COBALT_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register(
                    "cobalt_furnace_block_entity",
                    () -> BlockEntityType.Builder.of(
                            CobaltFurnaceBlockEntity::new,
                            ModBlocks.COBALT_FURNACE.get()
                    ).build(null)
            );

    public static final Supplier<BlockEntityType<AdamantiteFurnaceBlockEntity>> ADAMANTITE_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register(
                    "adamantite_furnace_block_entity",
                    () -> BlockEntityType.Builder.of(
                            AdamantiteFurnaceBlockEntity::new,
                            ModBlocks.ADAMANTITE_FURNACE.get()
                    ).build(null)
            );
}
