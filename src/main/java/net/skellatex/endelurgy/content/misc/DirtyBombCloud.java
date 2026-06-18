package net.skellatex.endelurgy.content.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.skellatex.endelurgy.content.potion.EMobEffects;
import net.skellatex.endelurgy.registry.EParticleTypes;

public class DirtyBombCloud {

    public static AreaEffectCloud spawnCloud(Level level, Vec3 at, float size, int poisonDuration, int confusionDuration, int corrosionDuration, int strongCorrosionDuration) {
        level.explode(null, at.x, at.y, at.z, size / 10, Level.ExplosionInteraction.NONE);

        var cloud = new AreaEffectCloud(level, at.x, at.y, at.z);

        cloud.addEffect(new MobEffectInstance(MobEffects.POISON, poisonDuration, 1));
        cloud.addEffect(new MobEffectInstance(MobEffects.CONFUSION, confusionDuration));
        cloud.addEffect(new MobEffectInstance(EMobEffects.CORROSION.get(), strongCorrosionDuration, 2));
        cloud.addEffect(new MobEffectInstance(EMobEffects.CORROSION.get(), corrosionDuration, 1));

        cloud.setParticle(EParticleTypes.NOXROCK_CLOUD.get());
        cloud.setRadius(2F * size);
        cloud.setRadiusPerTick(-0.005F);
        cloud.setDuration(800);

        level.addFreshEntity(cloud);
        return cloud;
    }

    public static void tickCloud(Level level, BlockPos pos, int range) {
        var x = pos.getX() + level.getRandom().nextFloat() * range * 2 - range + 0.5;
        var y = pos.getY() + level.getRandom().nextFloat() * range * 2 - range + 0.5;
        var z = pos.getZ() + level.getRandom().nextFloat() * range * 2 - range + 0.5;

        var containing = BlockPos.containing(x, y, z);
        if(level.getBlockState(containing).isSolid()) return;

        level.addParticle(EParticleTypes.NOXROCK_CLOUD.get(), x, y, z, 0.01, 0.01, 0.01);

    }

}