package com.bigchadguys.ores.worldgen;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_COBALT_KEY = registerKey("cobalt_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MAGNITE_KEY = registerKey("magnite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MYTHRIL_KEY = registerKey("mythril_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ORICHALCUM_KEY = registerKey("orichalcum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ADAMANTITE_KEY = registerKey("adamantite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_CELESTIUM_KEY = registerKey("celestium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_VIRIDIUM_KEY = registerKey("viridium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MORPHITE_KEY = registerKey("morphite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TECTONIC_KEY = registerKey("tectonic_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest endStoneReplaceables = new BlockMatchTest(Blocks.END_STONE);


        List<OreConfiguration.TargetBlockState> overworldCobaltOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.COBALT_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_COBALT_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldMagniteOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.MAGNITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_MAGNITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldMythrilOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.MYTHRIL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_MYTHRIL_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldOrichalcumOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ORICHALCUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldAdamantiteOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ADAMANTITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ADAMANTITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldCelestiumOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.CELESTIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_CELESTIUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> endViridiumOres = List.of(
                OreConfiguration.target(endStoneReplaceables, ModBlocks.VIRIDIUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldMorphiteOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.MORPHITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_MORPHITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldTectonicOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.TECTONIC_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_TECTONIC_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_COBALT_KEY, Feature.ORE, new OreConfiguration(overworldCobaltOres, 8));
        register(context, OVERWORLD_MAGNITE_KEY, Feature.ORE, new OreConfiguration(overworldMagniteOres, 7));
        register(context, OVERWORLD_MYTHRIL_KEY, Feature.ORE, new OreConfiguration(overworldMythrilOres, 6));
        register(context, OVERWORLD_ORICHALCUM_KEY, Feature.ORE, new OreConfiguration(overworldOrichalcumOres, 6));
        register(context, OVERWORLD_ADAMANTITE_KEY, Feature.ORE, new OreConfiguration(overworldAdamantiteOres, 5));
        register(context, OVERWORLD_CELESTIUM_KEY, Feature.ORE, new OreConfiguration(overworldCelestiumOres, 4));
        register(context, END_VIRIDIUM_KEY, Feature.ORE, new OreConfiguration(endViridiumOres, 3));
        register(context, OVERWORLD_MORPHITE_KEY, Feature.ORE, new OreConfiguration(overworldMorphiteOres, 3));
        register(context, OVERWORLD_TECTONIC_KEY, Feature.ORE, new OreConfiguration(overworldTectonicOres, 3));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}