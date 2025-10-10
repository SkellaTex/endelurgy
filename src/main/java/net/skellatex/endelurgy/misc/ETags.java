package net.skellatex.endelurgy.misc;

import net.skellatex.endelurgy.Endelurgy;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ETags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ENDERITE_TOOL = tag("needs_enderite_tool");
        public static final TagKey<Block> NEEDS_ADAMANTITE_TOOL = tag("needs_adamantite_tool");
        public static final TagKey<Block> CREATES_NOXROCK_CLOUD = tag("creates_noxrock_cloud");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Endelurgy.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Endelurgy.MOD_ID, name));
        }
    }
}
