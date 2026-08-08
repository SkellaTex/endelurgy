package net.skellatex.endelurgy.world.loot;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.skellatex.endelurgy.Endelurgy;

public class ELootModifiers {

    private static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Endelurgy.MOD_ID);

    static {
        GLM.register("add_item", AddItemModifier.CODEC);
    }
    static {
        GLM.register("add_loot_table", AddLootTableModifier.CODEC);
    }

    private ELootModifiers() {}

    public static void register(IEventBus bus) {
        GLM.register(bus);
    }
}
