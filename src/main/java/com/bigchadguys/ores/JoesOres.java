package com.bigchadguys.ores;

import com.bigchadguys.ores.block.ModBlocks;
import com.bigchadguys.ores.block.entity.ModBlockEntities;
import com.bigchadguys.ores.item.ModArmorMaterials;
import com.bigchadguys.ores.item.ModCreativeModeTabs;
import com.bigchadguys.ores.item.ModItems;
import com.bigchadguys.ores.item.custom.FloriteHoeEffect;
import com.bigchadguys.ores.loot.AddItemModifier;
import com.bigchadguys.ores.recipe.ModRecipes;
import com.bigchadguys.ores.screen.ModMenuTypes;
import com.bigchadguys.ores.screen.custom.MorphiteSynthesizerScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@Mod(JoesOres.MOD_ID)
public class JoesOres {
    public static final String MOD_ID = "ores";
    public JoesOres(IEventBus modEventBus) {
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModArmorMaterials.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        AddItemModifier.GLOBAL_LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.MORPHITE_SYNTHESIZER_MENU.get(), MorphiteSynthesizerScreen::new);
        }
    }
}