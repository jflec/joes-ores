package com.bigchadguys.ores.worldgen;

import com.bigchadguys.ores.JoesOres;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> COBALT_ORE_PLACED_KEY = registerKey("cobalt_ore_placed");
    public static final ResourceKey<PlacedFeature> MAGNITE_ORE_PLACED_KEY = registerKey("magnite_ore_placed");
    public static final ResourceKey<PlacedFeature> MYTHRIL_ORE_PLACED_KEY = registerKey("mythril_ore_placed");
    public static final ResourceKey<PlacedFeature> ORICHALCUM_ORE_PLACED_KEY = registerKey("orichalcum_ore_placed");
    public static final ResourceKey<PlacedFeature> ADAMANTITE_ORE_PLACED_KEY = registerKey("adamantite_ore_placed");
    public static final ResourceKey<PlacedFeature> CELESTIUM_ORE_PLACED_KEY = registerKey("celestium_ore_placed");
    public static final ResourceKey<PlacedFeature> VIRIDIUM_ORE_PLACED_KEY = registerKey("viridium_ore_placed");
    public static final ResourceKey<PlacedFeature> MORPHITE_ORE_PLACED_KEY = registerKey("morphite_ore_placed");
    public static final ResourceKey<PlacedFeature> TECTONIC_ORE_PLACED_KEY = registerKey("tectonic_ore_placed");

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(JoesOres.MOD_ID, name));
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, COBALT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_COBALT_KEY),
                ModOrePlacements.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-120), VerticalAnchor.absolute(60))));

        register(context, MAGNITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_MAGNITE_KEY),
                ModOrePlacements.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-130), VerticalAnchor.absolute(50))));

        register(context, MYTHRIL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_MYTHRIL_KEY),
                ModOrePlacements.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-140), VerticalAnchor.absolute(40))));

        register(context, ORICHALCUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ORICHALCUM_KEY),
                ModOrePlacements.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-150), VerticalAnchor.absolute(30))));

        register(context, ADAMANTITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ADAMANTITE_KEY),
                ModOrePlacements.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-160), VerticalAnchor.absolute(20))));

        register(context, CELESTIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_CELESTIUM_KEY),
                ModOrePlacements.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-170), VerticalAnchor.absolute(10))));

        register(context, MORPHITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_MORPHITE_KEY),
                ModOrePlacements.commonOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.absolute(-180), VerticalAnchor.absolute(0))));

        register(context, TECTONIC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_TECTONIC_KEY),
                ModOrePlacements.commonOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.absolute(-180), VerticalAnchor.absolute(-10))));

        register(context, VIRIDIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_VIRIDIUM_KEY),
                ModOrePlacements.commonOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.absolute(30), VerticalAnchor.absolute(110))));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}