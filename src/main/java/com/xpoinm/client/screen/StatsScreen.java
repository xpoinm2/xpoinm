package com.xpoinm.client.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class StatsScreen extends Screen {
    private final Screen parent;

    public StatsScreen(Screen parent) {

        super(Text.literal("Your Stats"));
        this.parent = parent;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {

        this.renderBackground(context, mouseX, mouseY, delta);


        super.render(context, mouseX, mouseY, delta);


    }

    @Override
    public void close() {

        MinecraftClient.getInstance().setScreen(parent);
    }
}
