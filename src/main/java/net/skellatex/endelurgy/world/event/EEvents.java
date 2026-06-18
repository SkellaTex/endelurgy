package net.skellatex.endelurgy.world.event;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.skellatex.endelurgy.Endelurgy;
import net.skellatex.endelurgy.registry.EAttributes;
import net.skellatex.endelurgy.registry.ETags;
import net.skellatex.endelurgy.content.misc.NoxrockCloud;

import java.util.Collection;

@Mod.EventBusSubscriber(modid = Endelurgy.MOD_ID)
public class EEvents {

    @SubscribeEvent
    public static void onBlockBreak(final BlockEvent.BreakEvent event) {
        if (event.getState().is(ETags.Blocks.CREATES_NOXROCK_CLOUD)) {
            NoxrockCloud.create(event.getPos(), event.getPlayer().level(), 5F, 0.02F, 280);
        }
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity target = event.getEntity();
        DamageSource damageSource = event.getSource();

        if (damageSource.is(ETags.DamageTypes.ENDERITE_ARMOR_RESISTS)) {
            float damageResistance = 0.0F;
            for (EquipmentSlot slot : EquipmentSlot.values()) {
                if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                    ItemStack stack = target.getItemBySlot(slot);
                    Collection<AttributeModifier> dmgRes = stack.getAttributeModifiers(slot).get(EAttributes.DAMAGE_RESISTANCE.get());
                    if (!dmgRes.isEmpty()) {
                        damageResistance += dmgRes.stream().mapToDouble(AttributeModifier::getAmount).sum();
                    }
                }
            }
            if (damageResistance > 0.0F) {
                event.setAmount(event.getAmount() - event.getAmount() * damageResistance);
            }
        }
    }

}