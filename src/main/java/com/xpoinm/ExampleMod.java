package com.xpoinm;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
    public static final String MOD_ID = "xpoinm";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // Здесь позже будем регистрировать блоки, предметы и т.д.
        LOGGER.info("Xpoinm Mod has initialized!");
    }
}
