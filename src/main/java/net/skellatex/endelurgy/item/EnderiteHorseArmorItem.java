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
import net.skellatex.endelurgy.misc.EAttributes;

import java.util.UUID;

public class EnderiteHorseArmorItem extends HorseArmorItem {

    public EnderiteHorseArmorItem(Item.Properties builder) {
        super(15, new ResourceLocation(Endelurgy.MOD_ID,"textures/entity/horse/armor/horse_armor_enderite.png"), builder);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.putAll(super.getAttributeModifiers(slot, stack));
        UUID uuid = ArmorItem.ARMOR_MODIFIER_UUID_PER_TYPE.get(ArmorItem.Type.CHESTPLATE);
        builder.put(EAttributes.DAMAGE_RESISTANCE.get(), new AttributeModifier(uuid, "Damage Resistance", 0.25D, AttributeModifier.Operation.MULTIPLY_BASE));
        return slot == EquipmentSlot.CHEST ? builder.build() : super.getAttributeModifiers(slot, stack);
    }
}
