package net.skellatex.endelurgy.potion;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class CorrosionEffect extends MobEffect {
    private static final Random RANDOM = new Random();

    protected CorrosionEffect () {
        super(MobEffectCategory.HARMFUL, 76289);
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
                    int damage = 2 + amplifier * 2;
                    mainhand.hurtAndBreak(damage, pLivingEntity, (p) -> p.broadcastBreakEvent(p.getUsedItemHand()));
                }
            }
        }
        if (!pLivingEntity.level().isClientSide) {
            if (!offhand.isEmpty() && offhand.isDamageableItem()) {
                if (RANDOM.nextInt(16) == 0) {
                    int damage = 2 + amplifier * 2;
                    offhand.hurtAndBreak(damage, pLivingEntity, (p) -> p.broadcastBreakEvent(p.getUsedItemHand()));
                }
            }
        }
        if (!pLivingEntity.level().isClientSide) {
            if (!head.isEmpty() && head.isDamageableItem()) {
                if (RANDOM.nextInt(16) == 0) {
                    int damage = 1 + amplifier;
                    head.hurtAndBreak(damage, pLivingEntity, (p) -> p.broadcastBreakEvent(p.getUsedItemHand()));
                }
            }
        }
        if (!pLivingEntity.level().isClientSide) {
            if (!chest.isEmpty() && chest.isDamageableItem()) {
                if (RANDOM.nextInt(16) == 0) {
                    int damage = 1 + amplifier;
                    chest.hurtAndBreak(damage, pLivingEntity, (p) -> p.broadcastBreakEvent(p.getUsedItemHand()));
                }
            }
        }
        if (!pLivingEntity.level().isClientSide) {
            if (!legs.isEmpty() && legs.isDamageableItem()) {
                if (RANDOM.nextInt(16) == 0) {
                    int damage = 1 + amplifier;
                    legs.hurtAndBreak(damage, pLivingEntity, (p) -> p.broadcastBreakEvent(p.getUsedItemHand()));
                }
            }
        }
        if (!pLivingEntity.level().isClientSide) {
            if (!feet.isEmpty() && feet.isDamageableItem()) {
                if (RANDOM.nextInt(16) == 0) {
                    int damage = 1 + amplifier;
                    feet.hurtAndBreak(damage, pLivingEntity, (p) -> p.broadcastBreakEvent(p.getUsedItemHand()));
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}