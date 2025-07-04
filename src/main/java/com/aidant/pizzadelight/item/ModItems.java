package com.aidant.pizzadelight.item;

import com.aidant.pizzadelight.PizzaDelight;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(PizzaDelight.MOD_ID);

    // --- ITEMS ---

    public static final DeferredItem<Item> ROLLING_PIN = ITEMS.register("rolling_pin",
            () -> new Item(new Item.Properties().durability(120)));

    // -- Cheese --

    public static final DeferredItem<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHEESE_SLICE = ITEMS.register("cheese_slice",
            () -> new ConsumableItem(
                    new Item.Properties().food(ModFoods.CHEESE_SLICE),
                    false,
                    false
            ));

    public static final DeferredItem<Item> CHEESE_BREAD = ITEMS.register("cheese_bread",
            () -> new ConsumableItem(
                    new Item.Properties().food(ModFoods.CHEESE_BREAD),
                    false,
                    false
            ));

    // -- Hotdog --
    public static final DeferredItem<Item> RAW_SAUSAGE = ITEMS.register("raw_sausage",
            () -> new ConsumableItem(
                    new Item.Properties().food(ModFoods.RAW_SAUSAGE),
                    false,
                    false
            ));

    public static final DeferredItem<Item> SAUSAGE = ITEMS.register("cooked_sausage",
            () -> new ConsumableItem(
                    new Item.Properties().food(ModFoods.SAUSAGE),
                    false,
                    false
            ));

    public static final DeferredItem<Item> HOTDOG = ITEMS.register("hotdog",
            () -> new ConsumableItem(
                    new Item.Properties().food(ModFoods.HOTDOG),
                    true,
                    false
            ));

    // -- Pizza --

    public static final DeferredItem<Item> FLAT_DOUGH = ITEMS.register("flat_dough",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SequencedAssemblyItem> INCOMPLETE_PIZZA = ITEMS.register("incomplete_pizza",
            () -> new SequencedAssemblyItem(new Item.Properties()));

    // public static final RegistryObject<Item> PIZZA = ITEMS.register("pizza",
    //         () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PIZZA_SLICE = ITEMS.register("pizza_slice",
            () -> new ConsumableItem(
                    new Item.Properties().food(ModFoods.PIZZA_SLICE),
                    true,
                    false
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
