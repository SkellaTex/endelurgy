package net.skellatex.endelurgy.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class CorrosionEffect extends MobEffect {
    private static final Random RANDOM = new Random();

    protected CorrosionEffect () {
        super(MobEffectCategory.HARMFUL, 76289);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof Player player && !livingEntity.level().isClientSide) {
            for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                ItemStack stack = player.getInventory().getItem(i);
                if (!stack.isEmpty() && stack.isDamageableItem()) {
                    if (RANDOM.nextInt(16) == 0) {
                        int damage = 1 + amplifier;
                        stack.hurtAndBreak(damage, player, (p) -> p.broadcastBreakEvent(p.getUsedItemHand()));
                    }
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}