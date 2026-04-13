package net.skellatex.endelurgy.content.block;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class InfestedEndritusBlock extends Block implements Fallable {
    private final Block hostBlock;
    private static final Map<Block, Block> BLOCK_BY_HOST_BLOCK = Maps.newIdentityHashMap();
    private static final Map<BlockState, BlockState> HOST_TO_INFESTED_STATES = Maps.newIdentityHashMap();
    private static final Map<BlockState, BlockState> INFESTED_TO_HOST_STATES = Maps.newIdentityHashMap();

    public InfestedEndritusBlock(Block p_54178_, BlockBehaviour.Properties p_54179_) {
        super(p_54179_.destroyTime(p_54178_.defaultDestroyTime() / 2.0F).explosionResistance(0.75F));
        this.hostBlock = p_54178_;
        BLOCK_BY_HOST_BLOCK.put(p_54178_, this);
    }

    public Block getHostBlock() {
        return this.hostBlock;
    }

    public static boolean isCompatibleHostBlock(BlockState p_54196_) {
        return BLOCK_BY_HOST_BLOCK.containsKey(p_54196_.getBlock());
    }

    private void spawnInfestation(ServerLevel p_54181_, BlockPos p_54182_) {
        Endermite endermite = EntityType.ENDERMITE.create(p_54181_);
        if (endermite != null) {
            endermite.moveTo((double)p_54182_.getX() + 0.5D, (double)p_54182_.getY(), (double)p_54182_.getZ() + 0.5D, 0.0F, 0.0F);
            p_54181_.addFreshEntity(endermite);
            endermite.spawnAnim();
        }

    }

    public void spawnAfterBreak(BlockState p_221360_, ServerLevel p_221361_, BlockPos p_221362_, ItemStack p_221363_, boolean p_221364_) {
        super.spawnAfterBreak(p_221360_, p_221361_, p_221362_, p_221363_, p_221364_);
        if (p_221361_.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, p_221363_) == 0) {
            this.spawnInfestation(p_221361_, p_221362_);
        }

    }

    public static BlockState infestedStateByHost(BlockState p_153431_) {
        return getNewStateWithProperties(HOST_TO_INFESTED_STATES, p_153431_, () -> {
            return BLOCK_BY_HOST_BLOCK.get(p_153431_.getBlock()).defaultBlockState();
        });
    }

    public BlockState hostStateByInfested(BlockState p_153433_) {
        return getNewStateWithProperties(INFESTED_TO_HOST_STATES, p_153433_, () -> {
            return this.getHostBlock().defaultBlockState();
        });
    }

    private static BlockState getNewStateWithProperties(Map<BlockState, BlockState> p_153424_, BlockState p_153425_, Supplier<BlockState> p_153426_) {
        return p_153424_.computeIfAbsent(p_153425_, (p_153429_) -> {
            BlockState blockstate = p_153426_.get();

            for(Property property : p_153429_.getProperties()) {
                blockstate = blockstate.hasProperty(property) ? blockstate.setValue(property, p_153429_.getValue(property)) : blockstate;
            }

            return blockstate;
        });
    }

    public void onPlace(BlockState p_53233_, Level p_53234_, BlockPos p_53235_, BlockState p_53236_, boolean p_53237_) {
        p_53234_.scheduleTick(p_53235_, this, this.getDelayAfterPlace());
    }

    public BlockState updateShape(BlockState p_53226_, Direction p_53227_, BlockState p_53228_, LevelAccessor p_53229_, BlockPos p_53230_, BlockPos p_53231_) {
        p_53229_.scheduleTick(p_53230_, this, this.getDelayAfterPlace());
        return super.updateShape(p_53226_, p_53227_, p_53228_, p_53229_, p_53230_, p_53231_);
    }

    public void tick(BlockState p_221124_, ServerLevel p_221125_, BlockPos p_221126_, RandomSource p_221127_) {
        if (isFree(p_221125_.getBlockState(p_221126_.below())) && p_221126_.getY() >= p_221125_.getMinBuildHeight()) {
            FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(p_221125_, p_221126_, p_221124_);
            this.falling(fallingblockentity);
        }
    }

    protected void falling(FallingBlockEntity p_53206_) {
    }

    protected int getDelayAfterPlace() {
        return 2;
    }

    public static boolean isFree(BlockState p_53242_) {
        return p_53242_.isAir() || p_53242_.is(BlockTags.FIRE) || p_53242_.liquid() || p_53242_.canBeReplaced();
    }

    public void animateTick(BlockState p_221129_, Level p_221130_, BlockPos p_221131_, RandomSource p_221132_) {
        if (p_221132_.nextInt(16) == 0) {
            BlockPos blockpos = p_221131_.below();
            if (isFree(p_221130_.getBlockState(blockpos))) {
                ParticleUtils.spawnParticleBelow(p_221130_, p_221131_, p_221132_, new BlockParticleOption(ParticleTypes.FALLING_DUST, p_221129_));
            }
        }

    }

    public int getDustColor(BlockState p_53238_, BlockGetter p_53239_, BlockPos p_53240_) {
        return -16777216;
    }
}

