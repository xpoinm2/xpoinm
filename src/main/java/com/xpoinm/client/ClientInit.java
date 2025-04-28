package com.xpoinm.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import com.xpoinm.client.screen.StatsScreen;

public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof InventoryScreen inv) {
                final int BG_WIDTH  = 176;
                final int BG_HEIGHT = 166;
                int x = (scaledWidth  - BG_WIDTH ) / 2;
                int y = (scaledHeight - BG_HEIGHT) / 2;

                // строим кнопку через Builder
                ButtonWidget btn = ButtonWidget.builder(
                                Text.literal("Stats"),
                                button -> client.setScreen(new StatsScreen(inv))
                        )
                        .dimensions(x + 80, y + 10, 20, 20)
                        .build();

                // добавляем её в экран
                Screens.getButtons(screen).add(btn);
            }
        });
    }
}
