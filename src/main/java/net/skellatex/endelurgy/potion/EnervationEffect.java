package net.skellatex.endelurgy.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EnervationEffect extends MobEffect {

    protected EnervationEffect() {
        super(MobEffectCategory.HARMFUL, 3276800);
        this.addAttributeModifier(Attributes.MAX_HEALTH, "91AEAA56-376B-4498-935B-2F7F68020638", -4F, AttributeModifier.Operation.ADDITION);
    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration > 0;
    }
}