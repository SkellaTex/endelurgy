package net.skellatex.endelurgy.registry;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.skellatex.endelurgy.Endelurgy;
import net.skellatex.endelurgy.content.misc.DummyCriterionTrigger;

@Mod.EventBusSubscriber(modid = Endelurgy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ECriteriaTriggers {

    public static final DummyCriterionTrigger IN_NOXROCK_CLOUD = CriteriaTriggers.register(new DummyCriterionTrigger(ResourceLocation.fromNamespaceAndPath(Endelurgy.MOD_ID,"in_noxrock_cloud")));

    public static void register() {
        // Loads this class
    }
}
