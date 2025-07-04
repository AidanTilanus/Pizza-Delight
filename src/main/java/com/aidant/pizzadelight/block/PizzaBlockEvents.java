package com.aidant.pizzadelight.block;

import com.aidant.pizzadelight.block.custom.PizzaBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class PizzaBlockEvents {

    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {

        Level level = event.getLevel();
        if (level.isClientSide()) return;

        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        ItemStack heldItem = player.getItemInHand(hand);

        if (!(state.getBlock() instanceof PizzaBlock pizzaBlock)) return;

        if (heldItem.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath("farmersdelight", "tools/knives")))) {
            int bites = state.getValue(PizzaBlock.BITES);

            ItemStack dropStack = new ItemStack(pizzaBlock.getSliceItem(), 2);
            PizzaBlock.popResource(level, pos, dropStack);

            heldItem.hurtAndBreak(1, player,
                    hand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);

            if (bites < 3) {
                level.setBlock(pos, state.setValue(PizzaBlock.BITES, bites + 1), 3);
            } else {
                level.removeBlock(pos, false);
            }

            event.setCanceled(true);
            event.setCancellationResult(InteractionResult.SUCCESS);
        }
    }
}
