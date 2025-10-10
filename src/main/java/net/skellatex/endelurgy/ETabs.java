package net.skellatex.endelurgy;

import net.minecraftforge.fml.ModList;
import net.skellatex.endelurgy.block.EBlocks;
import net.skellatex.endelurgy.item.EItems;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import static net.skellatex.endelurgy.ModCompat.CREATE_ID;

@EventBusSubscriber(modid = Endelurgy.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ETabs {

    @SubscribeEvent
    public static void buildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> tab = event.getTabKey();
        MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries = event.getEntries();

        if (tab == CreativeModeTabs.BUILDING_BLOCKS) {
            putBefore(entries, Blocks.PURPUR_BLOCK, EBlocks.RAW_PURPUR_BLOCK);
            putAfter(entries, EBlocks.RAW_PURPUR_BLOCK.get(), EBlocks.RAW_PURPUR_STAIRS);
            putAfter(entries, EBlocks.RAW_PURPUR_STAIRS.get(), EBlocks.RAW_PURPUR_SLAB);
            putAfter(entries, EBlocks.RAW_PURPUR_SLAB.get(), EBlocks.RAW_PURPUR_WALL);
            putAfter(entries, Blocks.PURPUR_SLAB, EBlocks.PURPUR_WALL);
            putAfter(entries, EBlocks.PURPUR_WALL.get(), EBlocks.VOIDSLATE);
            putAfter(entries, EBlocks.VOIDSLATE.get(), EBlocks.VOIDSLATE_STAIRS);
            putAfter(entries, EBlocks.VOIDSLATE_STAIRS.get(), EBlocks.VOIDSLATE_SLAB);
            putAfter(entries, EBlocks.VOIDSLATE_SLAB.get(), EBlocks.VOIDSLATE_WALL);
            putAfter(entries, EBlocks.VOIDSLATE_WALL.get(), EBlocks.POLISHED_VOIDSLATE);
            putAfter(entries, EBlocks.POLISHED_VOIDSLATE.get(), EBlocks.POLISHED_VOIDSLATE_STAIRS);
            putAfter(entries, EBlocks.POLISHED_VOIDSLATE_STAIRS.get(), EBlocks.POLISHED_VOIDSLATE_SLAB);
            putAfter(entries, EBlocks.POLISHED_VOIDSLATE_SLAB.get(), EBlocks.POLISHED_VOIDSLATE_WALL);
            putAfter(entries, EBlocks.POLISHED_VOIDSLATE_WALL.get(), EBlocks.CHISELED_VOIDSLATE);
            putAfter(entries, EBlocks.CHISELED_VOIDSLATE.get(), EBlocks.VOIDSLATE_BRICKS);
            putAfter(entries, EBlocks.VOIDSLATE_BRICKS.get(), EBlocks.VOIDSLATE_BRICK_STAIRS);
            putAfter(entries, EBlocks.VOIDSLATE_BRICK_STAIRS.get(), EBlocks.VOIDSLATE_BRICK_SLAB);
            putAfter(entries, EBlocks.VOIDSLATE_BRICK_SLAB.get(), EBlocks.VOIDSLATE_BRICK_WALL);
            putAfter(entries, EBlocks.VOIDSLATE_BRICK_WALL.get(), EBlocks.NOXROCK);
            putAfter(entries, EBlocks.NOXROCK.get(), EBlocks.NOXROCK_STAIRS);
            putAfter(entries, EBlocks.NOXROCK_STAIRS.get(), EBlocks.NOXROCK_SLAB);
            putAfter(entries, EBlocks.NOXROCK_SLAB.get(), EBlocks.NOXROCK_WALL);
            putAfter(entries, EBlocks.NOXROCK_WALL.get(), EBlocks.POLISHED_NOXROCK);
            putAfter(entries, EBlocks.POLISHED_NOXROCK.get(), EBlocks.POLISHED_NOXROCK_STAIRS);
            putAfter(entries, EBlocks.POLISHED_NOXROCK_STAIRS.get(), EBlocks.POLISHED_NOXROCK_SLAB);
            putAfter(entries, EBlocks.POLISHED_NOXROCK_SLAB.get(), EBlocks.POLISHED_NOXROCK_WALL);
            putAfter(entries, EBlocks.POLISHED_NOXROCK_WALL.get(), EBlocks.CHISELED_NOXROCK);
            putAfter(entries, EBlocks.CHISELED_NOXROCK.get(), EBlocks.NOXROCK_BRICKS);
            putAfter(entries, EBlocks.NOXROCK_BRICKS.get(), EBlocks.NOXROCK_BRICK_STAIRS);
            putAfter(entries, EBlocks.NOXROCK_BRICK_STAIRS.get(), EBlocks.NOXROCK_BRICK_SLAB);
            putAfter(entries, EBlocks.NOXROCK_BRICK_SLAB.get(), EBlocks.NOXROCK_BRICK_WALL);
            putBefore(entries, Blocks.REDSTONE_BLOCK, EBlocks.ADAMANTITE_BLOCK);
            putBefore(entries, Blocks.NETHERITE_BLOCK, EBlocks.LUXITE_BLOCK);
            putAfter(entries, Blocks.NETHERITE_BLOCK, EBlocks.ENDERITE_BLOCK);
        }

        if (tab == CreativeModeTabs.NATURAL_BLOCKS) {
            putAfter(entries, Blocks.NETHER_QUARTZ_ORE, EBlocks.END_LAPIS_ORE);
            putAfter(entries, EBlocks.END_LAPIS_ORE.get(), EBlocks.VOIDSLATE_LAPIS_ORE);
            putAfter(entries, EBlocks.VOIDSLATE_LAPIS_ORE.get(), EBlocks.END_ADAMANTITE_ORE);
            putAfter(entries, EBlocks.END_ADAMANTITE_ORE.get(), EBlocks.VOIDSLATE_ADAMANTITE_ORE);
            putAfter(entries, EBlocks.VOIDSLATE_ADAMANTITE_ORE.get(), EBlocks.NOXROCK_LUXITE_ORE);
            putAfter(entries, Blocks.RAW_GOLD_BLOCK, EBlocks.RAW_ADAMANTITE_BLOCK);
        }

        if (tab == CreativeModeTabs.INGREDIENTS) {
            putBefore(entries, Items.EMERALD, EItems.RAW_ADAMANTITE);
            putBefore(entries, Items.IRON_NUGGET, EItems.LUXITE);
            putBefore(entries, Items.IRON_INGOT, EItems.ADAMANTITE_NUGGET);
            putBefore(entries, Items.NETHERITE_SCRAP, EItems.ADAMANTITE_INGOT);
            putAfter(entries, Items.NETHERITE_INGOT, EItems.ENDERITE_INGOT);
            putAfter(entries, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, EItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE);
            if (ModList.get().isLoaded(CREATE_ID))  {
                putAfter(entries, EItems.RAW_ADAMANTITE.get(), EItems.CRUSHED_RAW_ADAMANTITE);
            }
        }

        if (tab == CreativeModeTabs.FOOD_AND_DRINKS) {
            putAfter(entries, Items.ENCHANTED_GOLDEN_APPLE, EItems.ENDERITE_APPLE);
        }

        if (tab == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            putBefore(entries, Items.NETHERITE_SHOVEL, EItems.ADAMANTITE_SHOVEL);
            putAfter(entries, EItems.ADAMANTITE_SHOVEL.get(), EItems.ADAMANTITE_PICKAXE);
            putAfter(entries, EItems.ADAMANTITE_PICKAXE.get(), EItems.ADAMANTITE_AXE);
            putAfter(entries, EItems.ADAMANTITE_AXE.get(), EItems.ADAMANTITE_HOE);
            putAfter(entries, Items.NETHERITE_HOE, EItems.ENDERITE_SHOVEL);
            putAfter(entries, EItems.ENDERITE_SHOVEL.get(), EItems.ENDERITE_PICKAXE);
            putAfter(entries, EItems.ENDERITE_PICKAXE.get(), EItems.ENDERITE_AXE);
            putAfter(entries, EItems.ENDERITE_AXE.get(), EItems.ENDERITE_HOE);
        }

        if (tab == CreativeModeTabs.COMBAT) {
            putBefore(entries, Items.NETHERITE_SWORD, EItems.ADAMANTITE_SWORD);
            putBefore(entries, Items.NETHERITE_AXE, EItems.ADAMANTITE_AXE);
            putBefore(entries, Items.NETHERITE_HELMET, EItems.ADAMANTITE_HELMET);
            putAfter(entries, EItems.ADAMANTITE_HELMET.get(), EItems.ADAMANTITE_CHESTPLATE);
            putAfter(entries, EItems.ADAMANTITE_CHESTPLATE.get(), EItems.ADAMANTITE_LEGGINGS);
            putAfter(entries, EItems.ADAMANTITE_LEGGINGS.get(), EItems.ADAMANTITE_BOOTS);
            putAfter(entries, Items.NETHERITE_SWORD, EItems.ENDERITE_SWORD);
            putAfter(entries, Items.NETHERITE_AXE, EItems.ENDERITE_AXE);
            putAfter(entries, Items.NETHERITE_BOOTS, EItems.ENDERITE_HELMET);
            putAfter(entries, EItems.ENDERITE_HELMET.get(), EItems.ENDERITE_CHESTPLATE);
            putAfter(entries, EItems.ENDERITE_CHESTPLATE.get(), EItems.ENDERITE_LEGGINGS);
            putAfter(entries, EItems.ENDERITE_LEGGINGS.get(), EItems.ENDERITE_BOOTS);
        }

    }

    private static void putAfter(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries, ItemLike after, Supplier<? extends ItemLike> supplier) {
        ItemLike key = supplier.get();
        if (!entries.contains(new ItemStack(after))) return;
        entries.putAfter(new ItemStack(after), new ItemStack(key), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    private static void putBefore(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries, ItemLike before, Supplier<? extends ItemLike> supplier) {
        ItemLike key = supplier.get();
        if (!entries.contains(new ItemStack(before))) return;
        entries.putBefore(new ItemStack(before), new ItemStack(key), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

}
