package net.skellatex.endelurgy.world.event;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.skellatex.endelurgy.Endelurgy;
import net.skellatex.endelurgy.content.enchantment.EEnchantments;
import net.skellatex.endelurgy.registry.EAttributes;
import net.skellatex.endelurgy.registry.ETags;
import net.skellatex.endelurgy.content.misc.NoxrockCloud;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mod.EventBusSubscriber(modid = Endelurgy.MOD_ID)
public class EEvents {

    @SubscribeEvent
    public static void onBlockBreak(final BlockEvent.BreakEvent event) {
        if (event.getState().is(ETags.Blocks.CREATES_NOXROCK_CLOUD)) {
            NoxrockCloud.create(event.getPos(), event.getPlayer().level(), 5F, 0.02F, 280);
        }
    }

    @SubscribeEvent
    public static void onEntityTeleport(EntityTeleportEvent event) {
        if (event.getEntity() instanceof LivingEntity livingEntity) {
            if (livingEntity.getPersistentData().getInt("NoTeleportTimer") > 0) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity target = event.getEntity();
        var data = target.getPersistentData();

        if (data.contains("NoTeleportTimer", 3)) { // 3 = TagType.INT
            int timer = data.getInt("NoTeleportTimer");

            if (timer > 0) {
                data.putInt("NoTeleportTimer", timer - 1);
            } else {
                data.remove("NoTeleportTimer");
            }
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
        LivingEntity attacker = null;
        if (event.getSource().getDirectEntity() instanceof LivingEntity) {
            attacker = (LivingEntity) event.getSource().getDirectEntity();
        }

        if (attacker != null) {
            ItemStack weapon = attacker.getMainHandItem();

            if (weapon.is(ETags.Items.ENDERITE_TOOLS)) {
                target.getPersistentData().putInt("NoTeleportTimer", 160);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        Entity attacker = event.getSource().getDirectEntity();

        if (attacker instanceof Player player) {
            if (EnchantmentHelper.getItemEnchantmentLevel(EEnchantments.TELEKINESIS.get(), player.getMainHandItem()) > 0) {
                List<ItemStack> stacks = getStacksFromEntityItems(event.getDrops());

                for (ItemEntity itemEntity : event.getDrops()) {
                    if (player.addItem(itemEntity.getItem())) {
                        stacks.remove(itemEntity.getItem());
                    }
                }

            }
        }
        else if (attacker instanceof AbstractArrow arrow) {
            Entity shooter = arrow.getOwner();

            if (shooter instanceof Player player) {
                ItemStack heldItem = player.getMainHandItem();

                if (EnchantmentHelper.getItemEnchantmentLevel(EEnchantments.TELEKINESIS.get(), heldItem) > 0) {
                    List<ItemStack> stacks = getStacksFromEntityItems(event.getDrops());

                    for (ItemEntity itemEntity : event.getDrops()) {
                        if (player.addItem(itemEntity.getItem())) {
                            stacks.remove(itemEntity.getItem());
                        }
                    }
                }
            }
        }
    }

    public static List<ItemStack> getStacksFromEntityItems(Collection<ItemEntity> l) {
        List<ItemStack> stacks = new ArrayList<>();
        for (ItemEntity item : l) {
            stacks.add(item.getItem());
        }
        return stacks;
    }
}