package net.skellatex.endelurgy.content.block;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.skellatex.endelurgy.content.misc.NoxrockCloud;

public class ConcentratedNoxrockBlock extends Block {
    public ConcentratedNoxrockBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        NoxrockCloud.create(pos, level, 4F, 0.01F, 80);
        super.randomTick(state, level, pos, random);
    }
}
