package net.skellatex.endelurgy.registry;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;

public class EFlammables {
    public static void register() {
        FireBlock fireBlock = (FireBlock) Blocks.FIRE;

        fireBlock.setFlammable(EBlocks.DIRTY_BOMB.get(), 15, 100);
    }
}