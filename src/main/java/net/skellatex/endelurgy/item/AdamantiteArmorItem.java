package net.skellatex.endelurgy.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public class AdamantiteArmorItem extends ArmorItem {

    public AdamantiteArmorItem(ArmorMaterial material, ArmorItem.Type slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.putAll(super.getAttributeModifiers(slot, stack));
        UUID uuid = ArmorItem.ARMOR_MODIFIER_UUID_PER_TYPE.get(this.type);
        builder.put(Attributes.MAX_HEALTH, new AttributeModifier(uuid, "Max Health", 2D, AttributeModifier.Operation.ADDITION));
        return slot == this.getEquipmentSlot() ? builder.build() : super.getAttributeModifiers(slot, stack);
    }
}
