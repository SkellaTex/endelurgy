package net.skellatex.endelurgy.item;

import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class EnderiteHelmetItem extends ArmorItem {
    public EnderiteHelmetItem(ArmorMaterial material, Type slot, Properties properties) {
        super(material, slot, properties);
    }
    @Override
    public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
        return true;
    }
}