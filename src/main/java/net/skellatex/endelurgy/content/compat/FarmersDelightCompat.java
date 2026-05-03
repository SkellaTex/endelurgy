package net.skellatex.endelurgy.content.compat;

import java.util.function.Function;
import net.minecraft.world.item.Item;
import net.skellatex.endelurgy.registry.EToolTiers;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class FarmersDelightCompat {

    public static final Function<Item.Properties, ? extends Item> KNIFE_FACTORY_ADAMANTITE = (it) ->
            new KnifeItem(EToolTiers.ADAMANTITE, -0.5F, -1.8F, it);

    public static final Function<Item.Properties, ? extends Item> KNIFE_FACTORY_ENDERITE = (it) ->
            new KnifeItem(EToolTiers.ENDERITE, 2.5F, -2F, it);

}
