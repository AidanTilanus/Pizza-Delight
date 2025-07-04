package com.aidant.pizzadelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class ModFoods {

    public static final FoodProperties CHEESE_SLICE = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(0.3F).build();

    public static final FoodProperties CHEESE_BREAD = new FoodProperties.Builder()
            .nutrition(7).saturationModifier(0.7F).build();

    public static final FoodProperties PIZZA_SLICE = new FoodProperties.Builder()
            .nutrition(10).saturationModifier(1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3600, 0), 1.0F).build();

    public static final FoodProperties RAW_SAUSAGE = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(0.3F).build();

    public static final FoodProperties SAUSAGE = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.6F).build();

    public static final FoodProperties HOTDOG = new FoodProperties.Builder()
            .nutrition(12).saturationModifier(0.8F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT, 600, 0), 1.0F).build();
}
