package net.skellatex.endelurgy.content.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.skellatex.endelurgy.registry.EParticleTypes;

public class NoxrockCloud {

    public static void create(BlockPos pos, Level level, float radius, float shrinkage, int duration) {
        var vec = Vec3.atCenterOf(pos).add(0, 0.05, 0);
        var cloud = new AreaEffectCloud(level, vec.x, vec.y, vec.z);

        cloud.setParticle(EParticleTypes.NOXROCK_CLOUD.get());
        cloud.setRadius(radius);
        cloud.setRadiusPerTick(-shrinkage);
        cloud.setDuration(duration);
        level.addFreshEntity(cloud);
    }
}
