package com.xpoinm;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("xpoinm");

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
    }
}
