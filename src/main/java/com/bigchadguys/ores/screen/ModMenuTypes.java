package com.bigchadguys.ores.screen;

import com.bigchadguys.ores.JoesOres;
import com.bigchadguys.ores.screen.custom.AdamantiteFurnaceMenu;
import com.bigchadguys.ores.screen.custom.CobaltFurnaceMenu;
import com.bigchadguys.ores.screen.custom.MorphiteSynthesizerMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, JoesOres.MOD_ID);

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(
            String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static final DeferredHolder<MenuType<?>, MenuType<MorphiteSynthesizerMenu>> MORPHITE_SYNTHESIZER_MENU =
            registerMenuType("morphite_synthesizer_menu", MorphiteSynthesizerMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<CobaltFurnaceMenu>> COBALT_FURNACE_MENU =
            registerMenuType("cobalt_furnace_menu", CobaltFurnaceMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<AdamantiteFurnaceMenu>> ADAMANTITE_FURNACE_MENU =
            registerMenuType("adamantite_furnace_menu", AdamantiteFurnaceMenu::new);


    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
