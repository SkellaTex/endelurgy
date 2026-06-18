package net.skellatex.endelurgy.client;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.skellatex.endelurgy.Endelurgy;
import net.skellatex.endelurgy.registry.EEntityTypes;

@Mod.EventBusSubscriber(modid = Endelurgy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WingedEnderiteChestplateModel.WINGS_LAYER_LOCATION, WingedEnderiteChestplateModel::createLayer);
    }

    @SubscribeEvent
    public static void addPlayerLayers(EntityRenderersEvent.AddLayers event) {
        for (String skin : event.getSkins()) {
            LivingEntityRenderer<? extends Player, ? extends EntityModel<? extends Player>> renderer = event.getSkin(skin);

            if (renderer != null) {
                renderer.addLayer(new WingedEnderiteChestplateLayer(renderer, event.getEntityModels()));
            }
        }
        LivingEntityRenderer<ArmorStand, ? extends EntityModel<ArmorStand>> renderer = event.getRenderer(EntityType.ARMOR_STAND);
        if (renderer != null) {
            renderer.addLayer(new WingedEnderiteChestplateLayer(renderer, event.getEntityModels()));
        }
    }
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EEntityTypes.PRIMED_DIRTY_BOMB.get(), DirtyBombRender::new);
        event.registerEntityRenderer(EEntityTypes.DIRTY_BOMB_MINECART.get(), DirtyBombMinecartRender::new);
    }

}