package com.xpoinm.client.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class StatsScreen extends Screen {
    private static final int WIDTH = 120;
    private static final int HEIGHT = 70;

    // Текущее значение шкал (0–100)
    private int fatigue = 0;
    private int thirst = 0;
    private int disease = 0;

    public StatsScreen() {
        super(Component.literal("Stats"));
    }

    @Override
    protected void init() {
        int centerX = (width - WIDTH) / 2;
        int centerY = (height - HEIGHT) / 2;
        // Кнопка закрытия
        addRenderableWidget(new Button(centerX + WIDTH - 20, centerY, 20, 20, Component.literal("X"), btn -> onClose()));
    }

    @Override
    public void render(PoseStack pose, int mouseX, int mouseY, float delta) {
        renderBackground(pose);
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;

        // Рамка окна
        fill(pose, x, y, x + WIDTH, y + HEIGHT, 0xFF202020);

        // Отступы
        int labelX = x + 10;
        int barX = x + 60;
        int lineHeight = 15;

        // Рисуем подписи и пустые шкалы
        drawString(pose, font, "Fatigue:", labelX, y + 10, 0xFFFFFF);
        drawBar(pose, barX, y + 10, fatigue);

        drawString(pose, font, "Thirst:", labelX, y + 10 + lineHeight, 0xFFFFFF);
        drawBar(pose, barX, y + 10 + lineHeight, thirst);

        drawString(pose, font, "Disease:", labelX, y + 10 + 2 * lineHeight, 0xFFFFFF);
        drawBar(pose, barX, y + 10 + 2 * lineHeight, disease);

        super.render(pose, mouseX, mouseY, delta);
    }

    private void drawBar(PoseStack pose, int x, int y, int value) {
        int width = 40;
        int height = 8;
        // фон
        fill(pose, x, y, x + width, y + height, 0xFF444444);
        // заполнение пропорционально value (0–100)
        int filled = (int)(width * (value / 100.0f));
        fill(pose, x, y, x + filled, y + height, 0xFF00FF00);
        // рамка
        drawOutline(pose, x, y, width, height, 0xFFFFFFFF);
    }

    private void drawOutline(PoseStack pose, int x, int y, int w, int h, int color) {
        // 4 линии
        fill(pose, x, y, x + w, y + 1, color);
        fill(pose, x, y + h - 1, x + w, y + h, color);
        fill(pose, x, y, x + 1, y + h, color);
        fill(pose, x + w - 1, y, x + w, y + h, color);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
