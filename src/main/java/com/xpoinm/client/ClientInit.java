package com.xpoinm.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.xpoinm.client.screen.StatsScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;

@Environment(EnvType.CLIENT)
public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // После инициализации любой экран, если это InventoryScreen, добавляем кнопку
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof InventoryScreen inv) {
                int x = (screen.width - inv.getImageWidth()) / 2;
                int y = (screen.height - inv.getImageHeight()) / 2;
                // Кнопка размером 20x20 слева от "Crafting"
                Button statsButton = new Button(x + 8, y + 8, 20, 20, "§aS", btn -> {
                    Minecraft.getInstance().setScreen(new StatsScreen());
                });
                screen.addRenderableWidget(statsButton);
            }
        });
    }
}
