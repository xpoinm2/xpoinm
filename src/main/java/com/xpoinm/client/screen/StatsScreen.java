package com.xpoinm.client.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

public class StatsScreen extends Screen {
    private final Screen parent;

    public StatsScreen(Screen parent) {
        super(Component.literal("Статистика"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        super.init();
        // Кнопка "Назад"
        addRenderableWidget(new Button(
                (width - 100) / 2, height - 30, 100, 20,
                Component.literal("Назад"),
                btn -> Minecraft.getInstance().setScreen(parent)
        ));
    }

    @Override
    public void render(PoseStack pose, int mouseX, int mouseY, float delta) {
        renderBackground(pose);
        super.render(pose, mouseX, mouseY, delta);

        int barX = (width - 100) / 2;
        int barY = (height - 60) / 2;
        drawBar(pose, barX,     barY,     10);
        drawBar(pose, barX,     barY + 15, 20);
        drawBar(pose, barX,     barY + 30, 5);
    }

    private void drawBar(PoseStack pose, int x, int y, int value) {
        int w = value * 2;
        fill(pose, x, y, x + w, y + 10, 0xFF00FF00);         // заливка
        drawOutline(pose, x, y, 40, 10, 0xFFFFFFFF);         // рамка
    }

    private void drawOutline(PoseStack pose, int x, int y, int w, int h, int color) {
        // две горизонтали
        fill(pose, x,     y,     x + w, y + 1, color);
        fill(pose, x,     y + h - 1, x + w, y + h, color);
        // две вертикали
        fill(pose, x,     y,     x + 1, y + h, color);
        fill(pose, x + w - 1, y, x + w, y + h, color);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
