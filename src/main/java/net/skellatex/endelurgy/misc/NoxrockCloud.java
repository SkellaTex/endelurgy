package net.skellatex.endelurgy.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.skellatex.endelurgy.potion.EMobEffects;

public class NoxrockCloud {

    public static void create(BlockPos pos, Level level, float radius, float shrinkage, int duration) {
        var vec = Vec3.atCenterOf(pos).add(0, 0.05, 0);
        var cloud = new AreaEffectCloud(level, vec.x, vec.y, vec.z);


        cloud.addEffect(new MobEffectInstance(MobEffects.POISON, 120, 1));
        cloud.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120));
        cloud.addEffect(new MobEffectInstance(EMobEffects.CORROSION.get(), 600));
        cloud.setParticle(EParticleTypes.NOXROCK_CLOUD.get());
        cloud.setRadius(radius);
        cloud.setRadiusPerTick(-shrinkage);
        cloud.setDuration(duration);
        level.addFreshEntity(cloud);
    }

}
