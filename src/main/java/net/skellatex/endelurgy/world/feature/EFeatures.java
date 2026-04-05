package net.skellatex.endelurgy.world.feature;


import com.google.common.collect.Maps;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skellatex.endelurgy.Endelurgy;

import java.util.Map;
@Mod.EventBusSubscriber(modid = Endelurgy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class EFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Endelurgy.MOD_ID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> CHORUS_ENDRITUS = FEATURES.register("chorus_endritus", () -> new ChorusEndritusFeature(NoneFeatureConfiguration.CODEC));
}
