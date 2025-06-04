package com.bigchadguys.ores.datagen;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(
            PackOutput packOutput,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            BlockTagsProvider blockTags,
            ExistingFileHelper helper
    ) {
        super(packOutput, lookupProvider, blockTags.contentsGetter(), JoesOres.MOD_ID, helper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ModItemTags.CELESTIUM_INGOT).add(
                ModItems.SOLARIUM_INGOT.get(),
                ModItems.LUNARIUM_INGOT.get()
        );

        tag(ModItemTags.MYTHRIL_TOOLS).add(
                ModItems.MYTHRIL_PICKAXE.get(),
                ModItems.MYTHRIL_AXE.get(),
                ModItems.MYTHRIL_SHOVEL.get(),
                ModItems.MYTHRIL_HOE.get()
        );

        tag(ModItemTags.ORICHALCUM_TOOLS).add(
                ModItems.ORICHALCUM_PICKAXE.get(),
                ModItems.ORICHALCUM_AXE.get(),
                ModItems.ORICHALCUM_SHOVEL.get(),
                ModItems.ORICHALCUM_HOE.get()
        );

        tag(ModItemTags.ADAMANTITE_TOOLS).add(
                ModItems.ADAMANTITE_PICKAXE.get(),
                ModItems.ADAMANTITE_AXE.get(),
                ModItems.ADAMANTITE_SHOVEL.get(),
                ModItems.ADAMANTITE_HOE.get()
        );

        tag(ModItemTags.CELESTIUM_TOOLS).add(
                ModItems.CELESTIUM_PICKAXE.get(),
                ModItems.CELESTIUM_AXE.get(),
                ModItems.CELESTIUM_SHOVEL.get(),
                ModItems.CELESTIUM_HOE.get()
        );

        tag(ItemTags.SWORDS).add(
                ModItems.COPPER_SWORD.get(),
                ModItems.MAGNITE_SWORD.get(),
                ModItems.COBALT_SWORD.get(),
                ModItems.MYTHRIL_SWORD.get(),
                ModItems.ORICHALCUM_SWORD.get(),
                ModItems.ADAMANTITE_SWORD.get(),
                ModItems.CELESTIUM_SWORD.get(),
                ModItems.VIRIDIUM_SWORD.get(),
                ModItems.NECRONIUM_SWORD.get()
        );

        tag(ItemTags.AXES).add(
                ModItems.COPPER_AXE.get(),
                ModItems.MAGNITE_AXE.get(),
                ModItems.COBALT_AXE.get(),
                ModItems.MYTHRIL_AXE.get(),
                ModItems.ORICHALCUM_AXE.get(),
                ModItems.ADAMANTITE_AXE.get(),
                ModItems.CELESTIUM_AXE.get(),
                ModItems.VIRIDIUM_AXE.get(),
                ModItems.PETRAFITE_AXE.get()
        );

        tag(ItemTags.PICKAXES).add(
                ModItems.COPPER_PICKAXE.get(),
                ModItems.MAGNITE_PICKAXE.get(),
                ModItems.COBALT_PICKAXE.get(),
                ModItems.MYTHRIL_PICKAXE.get(),
                ModItems.ORICHALCUM_PICKAXE.get(),
                ModItems.ADAMANTITE_PICKAXE.get(),
                ModItems.CELESTIUM_PICKAXE.get(),
                ModItems.VIRIDIUM_PICKAXE.get(),
                ModItems.GEOVAR_PICKAXE.get()
        );

        tag(ItemTags.SHOVELS).add(
                ModItems.COPPER_SHOVEL.get(),
                ModItems.MAGNITE_SHOVEL.get(),
                ModItems.COBALT_SHOVEL.get(),
                ModItems.MYTHRIL_SHOVEL.get(),
                ModItems.ORICHALCUM_SHOVEL.get(),
                ModItems.ADAMANTITE_SHOVEL.get(),
                ModItems.CELESTIUM_SHOVEL.get(),
                ModItems.VIRIDIUM_SHOVEL.get(),
                ModItems.SWIFTITE_SHOVEL.get()
        );

        tag(ItemTags.HOES).add(
                ModItems.COPPER_HOE.get(),
                ModItems.MAGNITE_HOE.get(),
                ModItems.COBALT_HOE.get(),
                ModItems.MYTHRIL_HOE.get(),
                ModItems.ORICHALCUM_HOE.get(),
                ModItems.ADAMANTITE_HOE.get(),
                ModItems.CELESTIUM_HOE.get(),
                ModItems.VIRIDIUM_HOE.get(),
                ModItems.FLORITE_HOE.get()
        );

        tag(ItemTags.MINING_ENCHANTABLE).add(
                ModItems.COPPER_SHOVEL.get(),
                ModItems.COPPER_PICKAXE.get(),
                ModItems.COPPER_AXE.get(),
                ModItems.COPPER_HOE.get(),
                ModItems.MAGNITE_PICKAXE.get(),
                ModItems.MAGNITE_AXE.get(),
                ModItems.MAGNITE_SHOVEL.get(),
                ModItems.MAGNITE_HOE.get(),
                ModItems.COBALT_PICKAXE.get(),
                ModItems.COBALT_AXE.get(),
                ModItems.COBALT_SHOVEL.get(),
                ModItems.COBALT_HOE.get(),
                ModItems.MYTHRIL_PICKAXE.get(),
                ModItems.MYTHRIL_AXE.get(),
                ModItems.MYTHRIL_SHOVEL.get(),
                ModItems.MYTHRIL_HOE.get(),
                ModItems.ORICHALCUM_PICKAXE.get(),
                ModItems.ORICHALCUM_AXE.get(),
                ModItems.ORICHALCUM_SHOVEL.get(),
                ModItems.ORICHALCUM_HOE.get(),
                ModItems.ADAMANTITE_PICKAXE.get(),
                ModItems.ADAMANTITE_AXE.get(),
                ModItems.ADAMANTITE_SHOVEL.get(),
                ModItems.ADAMANTITE_HOE.get(),
                ModItems.CELESTIUM_PICKAXE.get(),
                ModItems.CELESTIUM_AXE.get(),
                ModItems.CELESTIUM_SHOVEL.get(),
                ModItems.CELESTIUM_HOE.get(),
                ModItems.VIRIDIUM_PICKAXE.get(),
                ModItems.VIRIDIUM_AXE.get(),
                ModItems.VIRIDIUM_SHOVEL.get(),
                ModItems.VIRIDIUM_HOE.get(),
                ModItems.FLORITE_HOE.get(),
                ModItems.GEOVAR_PICKAXE.get(),
                ModItems.PETRAFITE_AXE.get(),
                ModItems.SWIFTITE_SHOVEL.get()
        );

        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(
                ModItems.COPPER_SHOVEL.get(),
                ModItems.COPPER_PICKAXE.get(),
                ModItems.COPPER_AXE.get(),
                ModItems.COPPER_HOE.get(),
                ModItems.MAGNITE_PICKAXE.get(),
                ModItems.MAGNITE_AXE.get(),
                ModItems.MAGNITE_SHOVEL.get(),
                ModItems.MAGNITE_HOE.get(),
                ModItems.COBALT_PICKAXE.get(),
                ModItems.COBALT_AXE.get(),
                ModItems.COBALT_SHOVEL.get(),
                ModItems.COBALT_HOE.get(),
                ModItems.MYTHRIL_PICKAXE.get(),
                ModItems.MYTHRIL_AXE.get(),
                ModItems.MYTHRIL_SHOVEL.get(),
                ModItems.MYTHRIL_HOE.get(),
                ModItems.ORICHALCUM_PICKAXE.get(),
                ModItems.ORICHALCUM_AXE.get(),
                ModItems.ORICHALCUM_SHOVEL.get(),
                ModItems.ORICHALCUM_HOE.get(),
                ModItems.ADAMANTITE_PICKAXE.get(),
                ModItems.ADAMANTITE_AXE.get(),
                ModItems.ADAMANTITE_SHOVEL.get(),
                ModItems.ADAMANTITE_HOE.get(),
                ModItems.CELESTIUM_PICKAXE.get(),
                ModItems.CELESTIUM_AXE.get(),
                ModItems.CELESTIUM_SHOVEL.get(),
                ModItems.CELESTIUM_HOE.get(),
                ModItems.VIRIDIUM_PICKAXE.get(),
                ModItems.VIRIDIUM_AXE.get(),
                ModItems.VIRIDIUM_SHOVEL.get(),
                ModItems.VIRIDIUM_HOE.get(),
                ModItems.FLORITE_HOE.get(),
                ModItems.GEOVAR_PICKAXE.get(),
                ModItems.PETRAFITE_AXE.get(),
                ModItems.SWIFTITE_SHOVEL.get()
        );

        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(
                ModItems.COPPER_SWORD.get(),
                ModItems.MAGNITE_SWORD.get(),
                ModItems.COBALT_SWORD.get(),
                ModItems.MYTHRIL_SWORD.get(),
                ModItems.ORICHALCUM_SWORD.get(),
                ModItems.ADAMANTITE_SWORD.get(),
                ModItems.CELESTIUM_SWORD.get(),
                ModItems.VIRIDIUM_SWORD.get(),
                ModItems.NECRONIUM_SWORD.get()
        );

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(
                ModItems.COPPER_SWORD.get(),
                ModItems.COPPER_AXE.get(),
                ModItems.MAGNITE_SWORD.get(),
                ModItems.MAGNITE_AXE.get(),
                ModItems.COBALT_SWORD.get(),
                ModItems.COBALT_AXE.get(),
                ModItems.MYTHRIL_SWORD.get(),
                ModItems.MYTHRIL_AXE.get(),
                ModItems.ORICHALCUM_SWORD.get(),
                ModItems.ORICHALCUM_AXE.get(),
                ModItems.ADAMANTITE_SWORD.get(),
                ModItems.ADAMANTITE_AXE.get(),
                ModItems.CELESTIUM_SWORD.get(),
                ModItems.CELESTIUM_AXE.get(),
                ModItems.VIRIDIUM_SWORD.get(),
                ModItems.VIRIDIUM_AXE.get(),
                ModItems.NECRONIUM_SWORD.get(),
                ModItems.PETRAFITE_AXE.get()
        );

        tag(ItemTags.HEAD_ARMOR).add(
                ModItems.COPPER_HELMET.get(),
                ModItems.COBALT_HELMET.get(),
                ModItems.MAGNITE_HELMET.get(),
                ModItems.MYTHRIL_HELMET.get(),
                ModItems.ORICHALCUM_HELMET.get(),
                ModItems.ADAMANTITE_HELMET.get(),
                ModItems.LUNARIUM_HELMET.get(),
                ModItems.SOLARIUM_HELMET.get(),
                ModItems.VIRIDIUM_HELMET.get()
        );

        tag(ItemTags.CHEST_ARMOR).add(
                ModItems.COPPER_CHESTPLATE.get(),
                ModItems.COBALT_CHESTPLATE.get(),
                ModItems.MAGNITE_CHESTPLATE.get(),
                ModItems.MYTHRIL_CHESTPLATE.get(),
                ModItems.ORICHALCUM_CHESTPLATE.get(),
                ModItems.ADAMANTITE_CHESTPLATE.get(),
                ModItems.LUNARIUM_CHESTPLATE.get(),
                ModItems.SOLARIUM_CHESTPLATE.get(),
                ModItems.VIRIDIUM_CHESTPLATE.get()
        );

        tag(ItemTags.LEG_ARMOR).add(
                ModItems.COPPER_LEGGINGS.get(),
                ModItems.COBALT_LEGGINGS.get(),
                ModItems.MAGNITE_LEGGINGS.get(),
                ModItems.MYTHRIL_LEGGINGS.get(),
                ModItems.ORICHALCUM_LEGGINGS.get(),
                ModItems.ADAMANTITE_LEGGINGS.get(),
                ModItems.LUNARIUM_LEGGINGS.get(),
                ModItems.SOLARIUM_LEGGINGS.get(),
                ModItems.VIRIDIUM_LEGGINGS.get()
        );

        tag(ItemTags.FOOT_ARMOR).add(
                ModItems.COPPER_BOOTS.get(),
                ModItems.COBALT_BOOTS.get(),
                ModItems.MAGNITE_BOOTS.get(),
                ModItems.MYTHRIL_BOOTS.get(),
                ModItems.ORICHALCUM_BOOTS.get(),
                ModItems.ADAMANTITE_BOOTS.get(),
                ModItems.LUNARIUM_BOOTS.get(),
                ModItems.SOLARIUM_BOOTS.get(),
                ModItems.VIRIDIUM_BOOTS.get()
        );

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(
                ModItems.COPPER_HELMET.get(),
                ModItems.COBALT_HELMET.get(),
                ModItems.MAGNITE_HELMET.get(),
                ModItems.MYTHRIL_HELMET.get(),
                ModItems.ORICHALCUM_HELMET.get(),
                ModItems.ADAMANTITE_HELMET.get(),
                ModItems.LUNARIUM_HELMET.get(),
                ModItems.SOLARIUM_HELMET.get(),
                ModItems.VIRIDIUM_HELMET.get()
        );

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(
                ModItems.COPPER_CHESTPLATE.get(),
                ModItems.COBALT_CHESTPLATE.get(),
                ModItems.MAGNITE_CHESTPLATE.get(),
                ModItems.MYTHRIL_CHESTPLATE.get(),
                ModItems.ORICHALCUM_CHESTPLATE.get(),
                ModItems.ADAMANTITE_CHESTPLATE.get(),
                ModItems.LUNARIUM_CHESTPLATE.get(),
                ModItems.SOLARIUM_CHESTPLATE.get(),
                ModItems.VIRIDIUM_CHESTPLATE.get()
        );

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(
                ModItems.COPPER_LEGGINGS.get(),
                ModItems.COBALT_LEGGINGS.get(),
                ModItems.MAGNITE_LEGGINGS.get(),
                ModItems.MYTHRIL_LEGGINGS.get(),
                ModItems.ORICHALCUM_LEGGINGS.get(),
                ModItems.ADAMANTITE_LEGGINGS.get(),
                ModItems.LUNARIUM_LEGGINGS.get(),
                ModItems.SOLARIUM_LEGGINGS.get(),
                ModItems.VIRIDIUM_LEGGINGS.get()
        );

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(
                ModItems.COPPER_BOOTS.get(),
                ModItems.COBALT_BOOTS.get(),
                ModItems.MAGNITE_BOOTS.get(),
                ModItems.MYTHRIL_BOOTS.get(),
                ModItems.ORICHALCUM_BOOTS.get(),
                ModItems.ADAMANTITE_BOOTS.get(),
                ModItems.LUNARIUM_BOOTS.get(),
                ModItems.SOLARIUM_BOOTS.get(),
                ModItems.VIRIDIUM_BOOTS.get()
        );
    }
}
