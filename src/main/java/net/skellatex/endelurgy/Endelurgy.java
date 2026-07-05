package net.skellatex.endelurgy;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.skellatex.endelurgy.content.misc.CustomTNTDispenseBehavior;
import net.skellatex.endelurgy.registry.*;
import net.skellatex.endelurgy.client.NoxrockCloudParticleProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.skellatex.endelurgy.content.potion.EMobEffects;
import net.skellatex.endelurgy.world.feature.EFeatures;
import net.skellatex.endelurgy.world.loot.ELootModifiers;
import org.slf4j.Logger;

@Mod(Endelurgy.MOD_ID)
public class Endelurgy {
    public static final String MOD_ID = "endelurgy";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Endelurgy() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        EItems.register(modEventBus);
        EBlocks.register(modEventBus);
        ELootModifiers.register(modEventBus);
        EParticleTypes.register(modEventBus);
        EMobEffects.MOB_EFFECTS.register(modEventBus);
        EMobEffects.POTIONS.register(modEventBus);
        EFeatures.FEATURES.register(modEventBus);
        EAttributes.ATTRIBUTES.register(modEventBus);
        EEntityTypes.ENTITIES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            EMobEffects.setup();
        });
        DispenserBlock.registerBehavior(
                EBlocks.DIRTY_BOMB.get(), // Register against the ITEM, not the Block
                new CustomTNTDispenseBehavior()
        );
    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
        @SubscribeEvent
        public static void registerParticleProvider(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(EParticleTypes.NOXROCK_CLOUD.get(), NoxrockCloudParticleProvider:: new);
        }

    }
}
