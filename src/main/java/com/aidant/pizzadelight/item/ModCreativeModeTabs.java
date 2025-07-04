package com.aidant.pizzadelight.item;

import com.aidant.pizzadelight.PizzaDelight;
import com.aidant.pizzadelight.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PizzaDelight.MOD_ID);

    public static final Supplier<CreativeModeTab> PIZZA_DELIGHT_TAB = CREATIVE_MODE_TAB.register("pizzadelight_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.pizzadelight_tab"))
                    .icon(() -> new ItemStack(ModItems.ROLLING_PIN.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.ROLLING_PIN.get());

                        output.accept(ModItems.CHEESE.get());
                        output.accept(ModItems.CHEESE_SLICE.get());
                        output.accept(ModBlocks.CHEESE_BLOCK.get());
                        output.accept(ModBlocks.CHEESE_BRICKS.get());
                        output.accept(ModBlocks.POLISHED_CHEESE.get());
                        output.accept(ModItems.CHEESE_BREAD.get());

                        output.accept(ModItems.RAW_SAUSAGE.get());
                        output.accept(ModItems.SAUSAGE.get());
                        output.accept(ModItems.HOTDOG.get());

                        output.accept(ModItems.FLAT_DOUGH.get());
                        output.accept(ModBlocks.PIZZA.get());
                        output.accept(ModItems.PIZZA_SLICE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
