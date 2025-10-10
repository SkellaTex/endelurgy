package net.skellatex.endelurgy.client;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ExplodeParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class NoxrockCloudParticleProvider implements ParticleProvider<SimpleParticleType> {

    private final ParticleProvider<SimpleParticleType> inner;

    public NoxrockCloudParticleProvider(SpriteSet sprites) {
        inner = new ExplodeParticle.Provider(sprites);
    }

    @Override
    public @Nullable Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        if (level.random.nextInt(8) != 0) return null;
        return inner.createParticle(type, level, x, y, z, xSpeed, ySpeed, zSpeed);
    }
}