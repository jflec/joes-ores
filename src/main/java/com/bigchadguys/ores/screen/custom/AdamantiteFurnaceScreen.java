package com.bigchadguys.ores.screen.custom;

import com.bigchadguys.ores.JoesOres;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class AdamantiteFurnaceScreen extends AbstractContainerScreen<AdamantiteFurnaceMenu> {
    private static final ResourceLocation GUI_TEXTURE   = ResourceLocation.fromNamespaceAndPath(
            JoesOres.MOD_ID, "textures/gui/adamantite_furnace.png"
    );
    private static final ResourceLocation FLAME_TEXTURE = ResourceLocation.fromNamespaceAndPath(
            JoesOres.MOD_ID, "textures/gui/lit_progress.png"
    );
    private static final ResourceLocation ARROW_TEXTURE = ResourceLocation.fromNamespaceAndPath(
            JoesOres.MOD_ID, "textures/gui/burn_progress.png"
    );
    private static final ResourceLocation DAY_ICON     = ResourceLocation.fromNamespaceAndPath(
            JoesOres.MOD_ID, "textures/gui/day.png"
    );
    private static final ResourceLocation NIGHT_ICON   = ResourceLocation.fromNamespaceAndPath(
            JoesOres.MOD_ID, "textures/gui/night.png"
    );

    public AdamantiteFurnaceScreen(AdamantiteFurnaceMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.imageWidth  = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        int x = (width  - imageWidth)  / 2;
        int y = (height - imageHeight) / 2;
        guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        if (menu.isLit()) {
            int raw    = menu.getLitProgress();
            int flameH = Math.min(raw + 1, 14);
            int srcV   = 14 - flameH;
            int destY  = y + 36 + srcV;
            RenderSystem.setShaderTexture(0, FLAME_TEXTURE);
            RenderSystem.enableBlend(); RenderSystem.defaultBlendFunc();
            guiGraphics.blit(
                    FLAME_TEXTURE,
                    x + 56, destY,
                    0, srcV,
                    14, flameH,
                    14, 14
            );
        }

        int prog = menu.getBurnProgress(); // 0–24
        if (prog > 0) {
            RenderSystem.setShaderTexture(0, ARROW_TEXTURE);
            RenderSystem.enableBlend(); RenderSystem.defaultBlendFunc();
            guiGraphics.blit(
                    ARROW_TEXTURE,
                    x + 79, y + 34,
                    0, 0,
                    prog, 16,
                    24, 16
            );
        }

        assert this.minecraft != null;
        if (this.minecraft.level != null) {
            long dayTime = this.minecraft.level.getDayTime() % 24000L;
            boolean isDay = dayTime < 12000L;
            ResourceLocation icon = isDay ? DAY_ICON : NIGHT_ICON;

            int iconW   = 18;
            int iconH   = 19;
            int margin  = 7;
            int iconX   = x + imageWidth - iconW - margin;
            int iconY   = y + margin;

            RenderSystem.setShaderTexture(0, icon);
            guiGraphics.blit(
                    icon,
                    iconX, iconY,
                    0, 0,
                    iconW, iconH,
                    iconW, iconH
            );
        }
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics, mouseX, mouseY, delta);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void init() {
        super.init();
        inventoryLabelY = 10000;
        titleLabelY     = 10000;
    }
}
