package net.skellatex.endelurgy.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class EFoods {
    public static final FoodProperties ENDERITE_APPLE = new FoodProperties.Builder().nutrition(4).alwaysEat()
            .saturationMod(1.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 4), 1.0f)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 600, 1), 1.0F).build();
    public static final FoodProperties DRAGON_EGG_OMELET = new FoodProperties.Builder().nutrition(20).alwaysEat()
            .saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.SATURATION, 72000, 0), 1.0F).build();
}