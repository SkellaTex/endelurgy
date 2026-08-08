package net.skellatex.endelurgy.content.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class TelekinesisEnchantment extends Enchantment {
    protected TelekinesisEnchantment() {
        super(Rarity.VERY_RARE, EEnchantmentCategories.ALL_WEAPONS, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    public int getMinCost(int p_45264_) {
        return 15;
    }

    public int getMaxCost(int p_45268_) {
        return super.getMinCost(p_45268_) + 50;
    }

    public int getMaxLevel() {
        return 1;
    }

    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

}
