package net.skellatex.endelurgy.potion;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class RestorationEffect extends MobEffect {
    private static final Random RANDOM = new Random();

    protected RestorationEffect() {
        super(MobEffectCategory.BENEFICIAL, 15263744);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity pLivingEntity, int amplifier) {

        ItemStack mainhand = pLivingEntity.getMainHandItem();
        ItemStack offhand = pLivingEntity.getOffhandItem();
        ItemStack head = pLivingEntity.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = pLivingEntity.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = pLivingEntity.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = pLivingEntity.getItemBySlot(EquipmentSlot.FEET);

        if (!pLivingEntity.level().isClientSide) {
                if (!mainhand.isEmpty() && mainhand.isDamageableItem()) {
                    if (RANDOM.nextInt(16) == 0) {
                        int repair = 2 + amplifier * 2;
                        mainhand.setDamageValue(mainhand.getDamageValue() - repair);
                    }
                }
        }
        if (!pLivingEntity.level().isClientSide) {
                if (!offhand.isEmpty() && offhand.isDamageableItem()) {
                    if (RANDOM.nextInt(16) == 0) {
                        int repair = 2 + amplifier * 2;
                        offhand.setDamageValue(offhand.getDamageValue() - repair);
                    }
                }
        }
        if (!pLivingEntity.level().isClientSide) {
                if (!head.isEmpty() && head.isDamageableItem()) {
                    if (RANDOM.nextInt(16) == 0) {
                        int repair = 1 + amplifier;
                        head.setDamageValue(head.getDamageValue() - repair);
                    }
                }
        }
        if (!pLivingEntity.level().isClientSide) {
                if (!chest.isEmpty() && chest.isDamageableItem()) {
                    if (RANDOM.nextInt(16) == 0) {
                        int repair = 1 + amplifier;
                        chest.setDamageValue(chest.getDamageValue() - repair);
                    }
                }
        }
        if (!pLivingEntity.level().isClientSide) {
                if (!legs.isEmpty() && legs.isDamageableItem()) {
                    if (RANDOM.nextInt(16) == 0) {
                        int repair = 1 + amplifier;
                        legs.setDamageValue(legs.getDamageValue() - repair);
                    }
                }
        }
        if (!pLivingEntity.level().isClientSide) {
                if (!feet.isEmpty() && feet.isDamageableItem()) {
                    if (RANDOM.nextInt(16) == 0) {
                        int repair = 1 + amplifier;
                        feet.setDamageValue(feet.getDamageValue() - repair);
                    }
                }
            }
        }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}