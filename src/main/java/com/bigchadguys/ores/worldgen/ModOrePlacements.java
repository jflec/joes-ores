package com.bigchadguys.ores.worldgen;

import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModOrePlacements {
    public static List<PlacementModifier> orePlacement(PlacementModifier countPlacement, PlacementModifier heightRange) {
        return List.of(countPlacement, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange) {
        return orePlacement(CountPlacement.of(count), heightRange);
    }
}
