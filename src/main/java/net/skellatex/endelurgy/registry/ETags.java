package net.skellatex.endelurgy.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageType;
import net.skellatex.endelurgy.Endelurgy;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ETags {

    public static class Blocks {
        public static final TagKey<Block> NEEDS_ENDERITE_TOOL = registerBlockTag("needs_enderite_tool");
        public static final TagKey<Block> NEEDS_ADAMANTITE_TOOL = registerBlockTag("needs_adamantite_tool");
        public static final TagKey<Block> CREATES_NOXROCK_CLOUD = registerBlockTag("creates_noxrock_cloud");
    }

        public static class DamageTypes {
            public static final TagKey<DamageType> ENDERITE_ARMOR_RESISTS = registerDamageTypeTag("enderite_armor_resists");
        }

        private static TagKey<Item> registerItemTag(String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Endelurgy.MOD_ID, name));
        }

        private static TagKey<Block> registerBlockTag(String name) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Endelurgy.MOD_ID, name));
        }

        private static TagKey<DamageType> registerDamageTypeTag(String name) {
            return TagKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Endelurgy.MOD_ID, name));
        }
    }
