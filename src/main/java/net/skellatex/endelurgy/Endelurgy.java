package net.skellatex.endelurgy;

import com.mojang.logging.LogUtils;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.skellatex.endelurgy.block.EBlocks;
import net.skellatex.endelurgy.client.NoxrockCloudParticleProvider;
import net.skellatex.endelurgy.item.EItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.skellatex.endelurgy.potion.EMobEffects;
import net.skellatex.endelurgy.world.loot.ModLootModifiers;
import net.skellatex.endelurgy.misc.EParticleTypes;
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
        ModLootModifiers.register(modEventBus);
        EParticleTypes.register(modEventBus);
        EMobEffects.DEF_REG.register(modEventBus);
        EMobEffects.POTION_DEF_REG.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            EMobEffects.setup();
        });
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
