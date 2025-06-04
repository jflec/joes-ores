package com.bigchadguys.ores.item;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JoesOres.MOD_ID);

    public static final Supplier<CreativeModeTab> ORES =
            CREATIVE_MODE_TABS.register("ores_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ores.ores_tab"))
                    .icon(() -> new ItemStack(ModItems.RAW_MORPHITE.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.COPPER_SWORD);
                        output.accept(ModItems.COBALT_SWORD);
                        output.accept(ModItems.MAGNITE_SWORD);
                        output.accept(ModItems.MYTHRIL_SWORD);
                        output.accept(ModItems.ORICHALCUM_SWORD);
                        output.accept(ModItems.ADAMANTITE_SWORD);
                        output.accept(ModItems.VIRIDIUM_SWORD);
                        output.accept(ModItems.CELESTIUM_SWORD);
                        output.accept(ModItems.NECRONIUM_SWORD);

                        output.accept(ModItems.COPPER_PICKAXE);
                        output.accept(ModItems.COBALT_PICKAXE);
                        output.accept(ModItems.MAGNITE_PICKAXE);
                        output.accept(ModItems.MYTHRIL_PICKAXE);
                        output.accept(ModItems.ORICHALCUM_PICKAXE);
                        output.accept(ModItems.ADAMANTITE_PICKAXE);
                        output.accept(ModItems.VIRIDIUM_PICKAXE);
                        output.accept(ModItems.CELESTIUM_PICKAXE);
                        output.accept(ModItems.GEOVAR_PICKAXE);

                        output.accept(ModItems.COPPER_AXE);
                        output.accept(ModItems.COBALT_AXE);
                        output.accept(ModItems.MAGNITE_AXE);
                        output.accept(ModItems.MYTHRIL_AXE);
                        output.accept(ModItems.ORICHALCUM_AXE);
                        output.accept(ModItems.ADAMANTITE_AXE);
                        output.accept(ModItems.VIRIDIUM_AXE);
                        output.accept(ModItems.CELESTIUM_AXE);
                        output.accept(ModItems.PETRAFITE_AXE);

                        output.accept(ModItems.COPPER_SHOVEL);
                        output.accept(ModItems.COBALT_SHOVEL);
                        output.accept(ModItems.MAGNITE_SHOVEL);
                        output.accept(ModItems.MYTHRIL_SHOVEL);
                        output.accept(ModItems.ORICHALCUM_SHOVEL);
                        output.accept(ModItems.ADAMANTITE_SHOVEL);
                        output.accept(ModItems.VIRIDIUM_SHOVEL);
                        output.accept(ModItems.CELESTIUM_SHOVEL);
                        output.accept(ModItems.SWIFTITE_SHOVEL);

                        output.accept(ModItems.COPPER_HOE);
                        output.accept(ModItems.COBALT_HOE);
                        output.accept(ModItems.MAGNITE_HOE);
                        output.accept(ModItems.MYTHRIL_HOE);
                        output.accept(ModItems.ORICHALCUM_HOE);
                        output.accept(ModItems.ADAMANTITE_HOE);
                        output.accept(ModItems.VIRIDIUM_HOE);
                        output.accept(ModItems.CELESTIUM_HOE);
                        output.accept(ModItems.FLORITE_HOE);

                        output.accept(ModItems.COPPER_HELMET);
                        output.accept(ModItems.COBALT_HELMET);
                        output.accept(ModItems.MAGNITE_HELMET);
                        output.accept(ModItems.MYTHRIL_HELMET);
                        output.accept(ModItems.ORICHALCUM_HELMET);
                        output.accept(ModItems.ADAMANTITE_HELMET);
                        output.accept(ModItems.VIRIDIUM_HELMET);
                        output.accept(ModItems.LUNARIUM_HELMET);
                        output.accept(ModItems.SOLARIUM_HELMET);

                        output.accept(ModItems.COPPER_CHESTPLATE);
                        output.accept(ModItems.COBALT_CHESTPLATE);
                        output.accept(ModItems.MAGNITE_CHESTPLATE);
                        output.accept(ModItems.MYTHRIL_CHESTPLATE);
                        output.accept(ModItems.ORICHALCUM_CHESTPLATE);
                        output.accept(ModItems.ADAMANTITE_CHESTPLATE);
                        output.accept(ModItems.VIRIDIUM_CHESTPLATE);
                        output.accept(ModItems.LUNARIUM_CHESTPLATE);
                        output.accept(ModItems.SOLARIUM_CHESTPLATE);

                        output.accept(ModItems.COPPER_LEGGINGS);
                        output.accept(ModItems.COBALT_LEGGINGS);
                        output.accept(ModItems.MAGNITE_LEGGINGS);
                        output.accept(ModItems.MYTHRIL_LEGGINGS);
                        output.accept(ModItems.ORICHALCUM_LEGGINGS);
                        output.accept(ModItems.ADAMANTITE_LEGGINGS);
                        output.accept(ModItems.VIRIDIUM_LEGGINGS);
                        output.accept(ModItems.LUNARIUM_LEGGINGS);
                        output.accept(ModItems.SOLARIUM_LEGGINGS);

                        output.accept(ModItems.COPPER_BOOTS);
                        output.accept(ModItems.COBALT_BOOTS);
                        output.accept(ModItems.MAGNITE_BOOTS);
                        output.accept(ModItems.MYTHRIL_BOOTS);
                        output.accept(ModItems.ORICHALCUM_BOOTS);
                        output.accept(ModItems.ADAMANTITE_BOOTS);
                        output.accept(ModItems.VIRIDIUM_BOOTS);
                        output.accept(ModItems.LUNARIUM_BOOTS);
                        output.accept(ModItems.SOLARIUM_BOOTS);

                        output.accept(ModItems.RAW_COBALT);
                        output.accept(ModItems.RAW_MAGNITE);
                        output.accept(ModItems.RAW_MYTHRIL);
                        output.accept(ModItems.RAW_ORICHALCUM);
                        output.accept(ModItems.RAW_ADAMANTITE);
                        output.accept(ModItems.RAW_VIRIDIUM);
                        output.accept(ModItems.RAW_CELESTIUM);

                        output.accept(ModItems.COBALT_INGOT);
                        output.accept(ModItems.MAGNITE_INGOT);
                        output.accept(ModItems.MYTHRIL_INGOT);
                        output.accept(ModItems.ORICHALCUM_INGOT);
                        output.accept(ModItems.ADAMANTITE_INGOT);
                        output.accept(ModItems.VIRIDIUM_INGOT);
                        output.accept(ModItems.LUNARIUM_INGOT);
                        output.accept(ModItems.SOLARIUM_INGOT);

                        output.accept(ModItems.ECTOPLASM);
                        output.accept(ModItems.NECRONIUM_INGOT);
                        output.accept(ModItems.TECTONIC_SHARD);
                        output.accept(ModItems.GEOVAR_INGOT);
                        output.accept(ModItems.QUICKSILVER);
                        output.accept(ModItems.SWIFTITE_INGOT);
                        output.accept(ModItems.PETRIFIED_BARK);
                        output.accept(ModItems.PETRAFITE_INGOT);
                        output.accept(ModItems.MUSH);
                        output.accept(ModItems.FLORITE_INGOT);

                        output.accept(ModBlocks.COBALT_ORE);
                        output.accept(ModBlocks.MAGNITE_ORE);
                        output.accept(ModBlocks.MYTHRIL_ORE);
                        output.accept(ModBlocks.ORICHALCUM_ORE);
                        output.accept(ModBlocks.ADAMANTITE_ORE);
                        output.accept(ModBlocks.CELESTIUM_ORE);
                        output.accept(ModBlocks.VIRIDIUM_ORE);
                        output.accept(ModBlocks.TECTONIC_ORE);
                        output.accept(ModBlocks.MORPHITE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_COBALT_ORE);
                        output.accept(ModBlocks.DEEPSLATE_MAGNITE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_MYTHRIL_ORE);
                        output.accept(ModBlocks.DEEPSLATE_ORICHALCUM_ORE);
                        output.accept(ModBlocks.DEEPSLATE_ADAMANTITE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_CELESTIUM_ORE);
                        output.accept(ModBlocks.DEEPSLATE_MORPHITE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_TECTONIC_ORE);

                        output.accept(ModBlocks.COBALT_FURNACE);
                        output.accept(ModBlocks.ADAMANTITE_FURNACE);
                        output.accept(ModBlocks.MORPHITE_SYNTHESIZER);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
