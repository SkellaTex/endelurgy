package net.skellatex.endelurgy.content.block;

import java.util.stream.Stream;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.skellatex.endelurgy.Endelurgy;
import net.skellatex.endelurgy.registry.ECriteriaTriggers;
import net.skellatex.endelurgy.registry.EParticleTypes;
import net.skellatex.endelurgy.registry.ETags;
import net.skellatex.endelurgy.content.potion.EMobEffects;

@Mod.EventBusSubscriber(modid = Endelurgy.MOD_ID)
public class NoxrockBlock {

    private static Stream<MobEffectInstance> getEffects() {
        return Stream.of(
                new MobEffectInstance(MobEffects.POISON, 120, 1),
                new MobEffectInstance(MobEffects.CONFUSION, 120),
                new MobEffectInstance(EMobEffects.CORROSION.get(), 120, 1),
                new MobEffectInstance(EMobEffects.CORROSION.get(), 600)

        );
    }

    public static void trySpawnNoxrockCloud(BlockState state, Level level, BlockPos pos, ItemStack held) {
        if (shouldSpawnCloud(state, level, pos, held)) {
            spawnCloud(level, pos, 2F);
        }
    }

    @SubscribeEvent
    public static void onBreak(BlockEvent.BreakEvent event) {
        var state = event.getState();
        var pos = event.getPos();

        if (!(event.getLevel() instanceof Level level)) return;
        if (!(event.getPlayer() instanceof ServerPlayer player)) return;

        var held = player.getMainHandItem();

        if (shouldSpawnCloud(state, level, pos, held)) {
            ECriteriaTriggers.IN_NOXROCK_CLOUD.trigger(player);
        }
    }

    private static boolean shouldSpawnCloud(BlockState state, LevelAccessor level, BlockPos pos, ItemStack stack) {
        return state.is(ETags.Blocks.CREATES_NOXROCK_CLOUD);
    }

    public static void spawnCloud(Level level, BlockPos pos, float size) {
        var vec = Vec3.atCenterOf(pos);
        var cloud = new AreaEffectCloud(level, vec.x, vec.y, vec.z);

        getEffects().forEach(cloud::addEffect);

        cloud.setParticle(EParticleTypes.NOXROCK_CLOUD.get());
        cloud.setRadius(2.5F * size);
        cloud.setRadiusPerTick(-0.02F);
        cloud.setDuration((int) (140 * size));

        level.addFreshEntity(cloud);
    }
}