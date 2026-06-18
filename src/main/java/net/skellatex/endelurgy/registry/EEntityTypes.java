package net.skellatex.endelurgy.registry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skellatex.endelurgy.Endelurgy;
import net.skellatex.endelurgy.content.entity.MinecartDirtyBomb;
import net.skellatex.endelurgy.content.entity.PrimedDirtyBomb;

@Mod.EventBusSubscriber(modid = Endelurgy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Endelurgy.MOD_ID);

    public static final RegistryObject<EntityType<PrimedDirtyBomb>> PRIMED_DIRTY_BOMB = ENTITIES.register("primed_dirty_bomb",
            () -> EntityType.Builder.<PrimedDirtyBomb>of(PrimedDirtyBomb::new, MobCategory.MISC).fireImmune().sized(1.0F, 1.0F).clientTrackingRange(10).updateInterval(10).build("primed_dirty_bomb"));
    public static final RegistryObject<EntityType<MinecartDirtyBomb>> DIRTY_BOMB_MINECART = ENTITIES.register("dirty_bomb_minecart",
            () -> EntityType.Builder.<MinecartDirtyBomb>of(MinecartDirtyBomb::new, MobCategory.MISC).sized(0.98F, 0.7F).clientTrackingRange(8).build("dirty_bomb_minecart"));

    public static void register(IEventBus modBus) {
        ENTITIES.register(modBus);
    }
}
