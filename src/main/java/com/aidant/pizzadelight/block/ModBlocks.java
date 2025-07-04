package com.aidant.pizzadelight.block;

import com.aidant.pizzadelight.PizzaDelight;
import com.aidant.pizzadelight.block.custom.PizzaBlock;
import com.aidant.pizzadelight.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PizzaDelight.MOD_ID);

    public static final DeferredBlock<Block> CHEESE_BLOCK = registerBlock("cheese_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD).pushReaction(PushReaction.NORMAL)));

    public static final DeferredBlock<Block> CHEESE_BRICKS = registerBlock("cheese_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CHEESE_BLOCK.get())));

    public static final DeferredBlock<Block> POLISHED_CHEESE = registerBlock("polished_cheese",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CHEESE_BLOCK.get())));

    // -- Pizza --

    public static final DeferredBlock<Block> PIZZA = registerBlock("pizza",
            () -> new PizzaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE).mapColor(MapColor.COLOR_ORANGE).noOcclusion().noLootTable(),
                    ModItems.PIZZA_SLICE::get
            ));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
