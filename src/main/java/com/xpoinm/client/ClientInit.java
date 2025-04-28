package com.xpoinm.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;

public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof InventoryScreen inv) {
                int x = (screen.width - 176) / 2;
                int y = (screen.height - 166) / 2;
                Button statsBtn = new Button(
                        x + 182, y + 6, 20, 20,
                        Component.literal("S"),
                        button -> client.setScreen(new com.xpoinm.client.screen.StatsScreen(screen))
                );
                inv.addRenderableWidget(statsBtn);
            }
        });
    }
}
