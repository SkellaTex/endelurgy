package net.skellatex.endelurgy.content.entity;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.skellatex.endelurgy.content.misc.DirtyBombCloud;
import net.skellatex.endelurgy.registry.EBlocks;
import net.skellatex.endelurgy.registry.EEntityTypes;
import net.skellatex.endelurgy.registry.EItems;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MinecartDirtyBomb extends AbstractMinecart {
    private static final byte EVENT_PRIME = 10;
    private int fuse = -1;

    public MinecartDirtyBomb(EntityType<? extends MinecartDirtyBomb> entityType, Level world) {
        super(entityType, world);
    }

    public MinecartDirtyBomb(Level world, double x, double y, double z) {
        super(EEntityTypes.DIRTY_BOMB_MINECART.get(), world, x, y, z);
    }

    @Override
    public AbstractMinecart.Type getMinecartType() {
        return AbstractMinecart.Type.TNT;
    }

    @Override
    public BlockState getDefaultDisplayBlockState() {
        return EBlocks.DIRTY_BOMB.get().defaultBlockState();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.fuse > 0) {
            --this.fuse;
            this.level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.5D, this.getZ(), 0.0D, 0.0D, 0.0D);
        } else if (this.fuse == 0) {
            this.explode(this.getDeltaMovement().horizontalDistanceSqr());
        }

        if (this.horizontalCollision) {
            double d0 = this.getDeltaMovement().horizontalDistanceSqr();
            if (d0 >= (double)0.01F) {
                this.explode(d0);
            }
        }

    }

    @Override
    public boolean hurt(DamageSource p_38666_, float p_38667_) {
        Entity entity = p_38666_.getDirectEntity();
        if (entity instanceof AbstractArrow abstractarrow) {
            if (abstractarrow.isOnFire()) {
                this.explode(abstractarrow.getDeltaMovement().lengthSqr());
            }
        }

        return super.hurt(p_38666_, p_38667_);
    }

    @Override
    public void destroy(DamageSource source) {
        double d0 = this.getDeltaMovement().horizontalDistanceSqr();
        if (!source.is(DamageTypeTags.IS_FIRE) && !source.is(DamageTypeTags.IS_EXPLOSION) && !(d0 >= (double)0.01F)) {
            super.destroy(source);
        } else {
            if (this.fuse < 0) {
                this.primeFuse();
                this.fuse = this.random.nextInt(20) + this.random.nextInt(20);
            }

        }
    }

    @Override
    protected Item getDropItem() {
        return EItems.DIRTY_BOMB_MINECART.get();
    }

    protected void explode(double p_38689_) {
        {
            DirtyBombCloud.spawnCloud(level(), position(), 5f, 120, 120, 600, 120);
            this.level().explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 4.0F, Level.ExplosionInteraction.NONE);
        }
        this.discard();
    }

    @Override
    public boolean causeFallDamage(float p_150347_, float p_150348_, DamageSource p_150349_) {
        if (p_150347_ >= 3.0F) {
            float f = p_150347_ / 10.0F;
            this.explode((double)(f * f));
        }

        return super.causeFallDamage(p_150347_, p_150348_, p_150349_);
    }

    @Override
    public void activateMinecart(int p_38659_, int p_38660_, int p_38661_, boolean p_38662_) {
        if (p_38662_ && this.fuse < 0) {
            this.primeFuse();
        }

    }

    @Override
    public void handleEntityEvent(byte p_38657_) {
        if (p_38657_ == 10) {
            this.primeFuse();
        } else {
            super.handleEntityEvent(p_38657_);
        }

    }

    public void primeFuse() {
        this.fuse = 80;
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)10);
            if (!this.isSilent()) {
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
        }
    }

    public int getFuse() {
        return this.fuse;
    }

    public boolean isPrimed() {
        return this.fuse > -1;
    }

    @Override
    public float getBlockExplosionResistance(Explosion p_38675_, BlockGetter p_38676_, BlockPos p_38677_, BlockState p_38678_, FluidState p_38679_, float p_38680_) {
        return !this.isPrimed() || !p_38678_.is(BlockTags.RAILS) && !p_38676_.getBlockState(p_38677_.above()).is(BlockTags.RAILS) ? super.getBlockExplosionResistance(p_38675_, p_38676_, p_38677_, p_38678_, p_38679_, p_38680_) : 0.0F;
    }

    @Override
    public boolean shouldBlockExplode(Explosion p_38669_, BlockGetter p_38670_, BlockPos p_38671_, BlockState p_38672_, float p_38673_) {
        return (!this.isPrimed() || !p_38672_.is(BlockTags.RAILS) && !p_38670_.getBlockState(p_38671_.above()).is(BlockTags.RAILS)) && super.shouldBlockExplode(p_38669_, p_38670_, p_38671_, p_38672_, p_38673_);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        if (nbt.contains("DirtyBombFuse", 99)) {
            this.fuse = nbt.getInt("DirtyBombFuse");
        }

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("DirtyBombFuse", this.fuse);
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(EItems.DIRTY_BOMB_MINECART.get());
    }
}
