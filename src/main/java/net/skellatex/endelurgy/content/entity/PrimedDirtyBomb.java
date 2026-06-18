package net.skellatex.endelurgy.content.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Level;
import net.skellatex.endelurgy.content.misc.DirtyBombCloud;
import net.skellatex.endelurgy.registry.EEntityTypes;
import org.jetbrains.annotations.Nullable;

public class PrimedDirtyBomb extends PrimedTnt {

    private final @Nullable LivingEntity owner;

    public PrimedDirtyBomb(EntityType<? extends PrimedDirtyBomb> type, Level level) {
        super(type, level);
        this.owner = null;
    }

    public PrimedDirtyBomb(Level level, double d, double e, double f, @Nullable LivingEntity igniter) {
        super(EEntityTypes.PRIMED_DIRTY_BOMB.get(), level);
        this.setPos(d, e, f);
        double g = level.getRandom().nextDouble() * Math.PI * 2F;
        setDeltaMovement(-Math.sin(g) * 0.02D, 0.2F, -Math.cos(g) * 0.02D);
        setFuse(80);
        this.xo = d;
        this.yo = e;
        this.zo = f;
        this.owner = igniter;
    }

    @Override
    public @Nullable LivingEntity getOwner() {
        return owner;
    }

    protected void explode() {
        DirtyBombCloud.spawnCloud(level(), position(), 5f, 120, 120, 600, 120);
        this.level().explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 4.0F, Level.ExplosionInteraction.NONE);
    }

}
