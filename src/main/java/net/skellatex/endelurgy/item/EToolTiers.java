package net.skellatex.endelurgy.item;

import net.skellatex.endelurgy.Endelurgy;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.skellatex.endelurgy.misc.ETags;

import java.util.List;

public class EToolTiers {
    public static final Tier ENDERITE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2500, 12f, 4f, 25,
                    ETags.Blocks.NEEDS_ENDERITE_TOOL, () -> Ingredient.of(EItems.ENDERITE_INGOT.get())),
            new ResourceLocation(Endelurgy.MOD_ID, "enderite"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier ADAMANTITE = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1800, 9f, 4f, 20,
                    ETags.Blocks.NEEDS_ADAMANTITE_TOOL, () -> Ingredient.of(EItems.ADAMANTITE_INGOT.get())),
            new ResourceLocation(Endelurgy.MOD_ID, "adamantite"), List.of(Tiers.DIAMOND), List.of());
}
