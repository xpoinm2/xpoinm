package com.xpoinm.client.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

public class StatsScreen extends Screen {
    private final Screen parent;

    public StatsScreen(Screen parent) {
        super(Component.literal("Your Stats"));
        this.parent = parent;
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, delta);
        // ... your bar‐drawing code here ...
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(parent);
    }
}
