package net.skellatex.endelurgy.content.enchantment;

import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class EEnchantmentCategories {

    public static final EnchantmentCategory ALL_WEAPONS = EnchantmentCategory.create("all_weapons", item ->
            item instanceof SwordItem || item instanceof AxeItem || item instanceof TridentItem || item instanceof BowItem || item instanceof CrossbowItem
    );
}
