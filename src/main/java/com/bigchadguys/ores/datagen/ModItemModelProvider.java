package com.bigchadguys.ores.datagen;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JoesOres.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_MORPHITE.get());
        basicItem(ModItems.MORPHITE_INGOT.get());
        basicItem(ModItems.PETRIFIED_BARK.get());
        basicItem(ModItems.PETRAFITE_INGOT.get());
        basicItem(ModItems.MUSH.get());
        basicItem(ModItems.FLORITE_INGOT.get());
        basicItem(ModItems.ECTOPLASM.get());
        basicItem(ModItems.NECRONIUM_INGOT.get());
        basicItem(ModItems.TECTONIC_SHARD.get());
        basicItem(ModItems.GEOVAR_INGOT.get());
        basicItem(ModItems.QUICKSILVER.get());
        basicItem(ModItems.SWIFTITE_INGOT.get());
        handheldItem(ModItems.COPPER_SWORD.get());
        handheldItem(ModItems.COPPER_PICKAXE.get());
        handheldItem(ModItems.COPPER_AXE.get());
        handheldItem(ModItems.COPPER_SHOVEL.get());
        handheldItem(ModItems.COPPER_HOE.get());
        basicItem(ModItems.COPPER_HELMET.get());
        basicItem(ModItems.COPPER_CHESTPLATE.get());
        basicItem(ModItems.COPPER_LEGGINGS.get());
        basicItem(ModItems.COPPER_BOOTS.get());
        handheldItem(ModItems.SWIFTITE_SHOVEL.get());
        handheldItem(ModItems.NECRONIUM_SWORD.get());
        handheldItem(ModItems.GEOVAR_PICKAXE.get());
        handheldItem(ModItems.PETRAFITE_AXE.get());
        handheldItem(ModItems.FLORITE_HOE.get());
        handheldItem(ModItems.COBALT_SWORD.get());
        handheldItem(ModItems.COBALT_PICKAXE.get());
        handheldItem(ModItems.COBALT_AXE.get());
        handheldItem(ModItems.COBALT_SHOVEL.get());
        handheldItem(ModItems.COBALT_HOE.get());
        handheldItem(ModItems.MYTHRIL_SWORD.get());
        handheldItem(ModItems.MYTHRIL_PICKAXE.get());
        handheldItem(ModItems.MYTHRIL_AXE.get());
        handheldItem(ModItems.MYTHRIL_SHOVEL.get());
        handheldItem(ModItems.MYTHRIL_HOE.get());
        handheldItem(ModItems.ORICHALCUM_SWORD.get());
        handheldItem(ModItems.ORICHALCUM_PICKAXE.get());
        handheldItem(ModItems.ORICHALCUM_AXE.get());
        handheldItem(ModItems.ORICHALCUM_SHOVEL.get());
        handheldItem(ModItems.ORICHALCUM_HOE.get());
        handheldItem(ModItems.ADAMANTITE_SWORD.get());
        handheldItem(ModItems.ADAMANTITE_PICKAXE.get());
        handheldItem(ModItems.ADAMANTITE_AXE.get());
        handheldItem(ModItems.ADAMANTITE_SHOVEL.get());
        handheldItem(ModItems.ADAMANTITE_HOE.get());
        handheldItem(ModItems.CELESTIUM_SWORD.get());
        handheldItem(ModItems.CELESTIUM_PICKAXE.get());
        handheldItem(ModItems.CELESTIUM_AXE.get());
        handheldItem(ModItems.CELESTIUM_SHOVEL.get());
        handheldItem(ModItems.CELESTIUM_HOE.get());
        handheldItem(ModItems.VIRIDIUM_SWORD.get());
        handheldItem(ModItems.VIRIDIUM_PICKAXE.get());
        handheldItem(ModItems.VIRIDIUM_AXE.get());
        handheldItem(ModItems.VIRIDIUM_SHOVEL.get());
        handheldItem(ModItems.VIRIDIUM_HOE.get());
    }
}
