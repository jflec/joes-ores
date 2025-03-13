package com.bigchadguys.ores.screen;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.screen.custom.MorphiteSynthesizerMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, JoesOres.MOD_ID);

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(IContainerFactory<T> factory) {
        return MENUS.register("morphite_synthesizer_menu", () -> IMenuTypeExtension.create(factory));
    }

    public static final DeferredHolder<MenuType<?>, MenuType<MorphiteSynthesizerMenu>> MORPHITE_SYNTHESIZER_MENU =
            registerMenuType(MorphiteSynthesizerMenu::new);

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
