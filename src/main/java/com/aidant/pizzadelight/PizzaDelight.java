package com.aidant.pizzadelight;

import com.aidant.pizzadelight.block.ModBlocks;
import com.aidant.pizzadelight.block.PizzaBlockEvents;
import com.aidant.pizzadelight.item.ModCreativeModeTabs;
import com.aidant.pizzadelight.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in META-INF/neoforge.mods.toml
@Mod(PizzaDelight.MOD_ID)
public class PizzaDelight {

    public static final String MOD_ID = "pizzadelight";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PizzaDelight(IEventBus modEventBus, ModContainer modContainer) {
        // Register lifecycle event handlers
        modEventBus.addListener(this::commonSetup);

        // Register server events
        NeoForge.EVENT_BUS.register(this);

        NeoForge.EVENT_BUS.addListener(PizzaBlockEvents::onRightClickBlock);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // (Optional) Config registration — only if Config.java exists and is used
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {    }
}
