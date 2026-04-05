package net.skellatex.endelurgy.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.skellatex.endelurgy.Endelurgy;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.UUID;

public class AdamantiteHorseArmorItem extends HorseArmorItem {

    public AdamantiteHorseArmorItem(Item.Properties builder) {
        super(11, new ResourceLocation(Endelurgy.MOD_ID,"textures/entity/horse/armor/horse_armor_adamantite.png"), builder);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.putAll(super.getAttributeModifiers(slot, stack));
        UUID uuid = ArmorItem.ARMOR_MODIFIER_UUID_PER_TYPE.get(ArmorItem.Type.CHESTPLATE);
        builder.put(Attributes.MAX_HEALTH, new AttributeModifier(uuid, "Max Health", 5D, AttributeModifier.Operation.ADDITION));
        return slot == EquipmentSlot.CHEST ? builder.build() : super.getAttributeModifiers(slot, stack);
    }
}
