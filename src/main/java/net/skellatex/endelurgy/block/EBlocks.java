package net.skellatex.endelurgy.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.*;
import net.skellatex.endelurgy.Endelurgy;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skellatex.endelurgy.item.EItems;

import java.util.function.Supplier;

public class EBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Endelurgy.MOD_ID);

    public static final RegistryObject<Block> NOXROCK_LUXITE_ORE = registerBlock("noxrock_luxite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE).sound(SoundType.TUFF)
                    .strength(3f, 3f).requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    public static final RegistryObject<Block> NOXROCK = registerBlock("noxrock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)
                    .strength(2f, 1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NOXROCK_STAIRS = registerBlock("noxrock_stairs",
            () -> new StairBlock(() -> EBlocks.NOXROCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.TUFF).strength(2f, 1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NOXROCK_SLAB = registerBlock("noxrock_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)
                    .strength(2f, 1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NOXROCK_WALL = registerBlock("noxrock_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF).strength(2f, 1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> POLISHED_NOXROCK = registerBlock("polished_noxrock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)
                    .strength(2.5f, 1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> POLISHED_NOXROCK_STAIRS = registerBlock("polished_noxrock_stairs",
            () -> new StairBlock(() -> EBlocks.POLISHED_NOXROCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.TUFF).strength(2.5f, 1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> POLISHED_NOXROCK_SLAB = registerBlock("polished_noxrock_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)
                    .strength(2.5f, 1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> POLISHED_NOXROCK_WALL = registerBlock("polished_noxrock_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF).strength(2.5f, 1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CHISELED_NOXROCK = registerBlock("chiseled_noxrock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)
                    .strength(2.5f, 1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NOXROCK_BRICKS = registerBlock("noxrock_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)
                    .strength(2.5f, 1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NOXROCK_BRICK_STAIRS = registerBlock("noxrock_brick_stairs",
            () -> new StairBlock(() -> EBlocks.NOXROCK_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.TUFF).strength(2.5f, 1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NOXROCK_BRICK_SLAB = registerBlock("noxrock_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)
                    .strength(2.5f, 1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NOXROCK_BRICK_WALL = registerBlock("noxrock_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF).strength(2.5f, 1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOIDSLATE = registerBlock("voidslate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4f, 12f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOIDSLATE_STAIRS = registerBlock("voidslate_stairs",
            () -> new StairBlock(() -> EBlocks.VOIDSLATE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(4f, 12f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOIDSLATE_SLAB = registerBlock("voidslate_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4f, 12f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOIDSLATE_WALL = registerBlock("voidslate_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(4f, 12f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> POLISHED_VOIDSLATE = registerBlock("polished_voidslate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4.5f, 12f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> POLISHED_VOIDSLATE_STAIRS = registerBlock("polished_voidslate_stairs",
            () -> new StairBlock(() -> EBlocks.POLISHED_VOIDSLATE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(4.5f, 12f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> POLISHED_VOIDSLATE_SLAB = registerBlock("polished_voidslate_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4.5f, 12f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> POLISHED_VOIDSLATE_WALL = registerBlock("polished_voidslate_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(4.5f, 12f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CHISELED_VOIDSLATE = registerBlock("chiseled_voidslate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4.5f, 12f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOIDSLATE_BRICKS = registerBlock("voidslate_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4.5f, 12f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOIDSLATE_BRICK_STAIRS = registerBlock("voidslate_brick_stairs",
            () -> new StairBlock(() -> EBlocks.VOIDSLATE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(4.5f, 12f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOIDSLATE_BRICK_SLAB = registerBlock("voidslate_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4.5f, 12f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOIDSLATE_BRICK_WALL = registerBlock("voidslate_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(4.5f, 12f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> END_LAPIS_ORE = registerBlock("end_lapis_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE).sound(SoundType.STONE)
                    .strength(4.5f, 3f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));

    public static final RegistryObject<Block> END_ADAMANTITE_ORE = registerBlock("end_adamantite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE).sound(SoundType.STONE)
                    .strength(4.5f, 4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOIDSLATE_LAPIS_ORE = registerBlock("voidslate_lapis_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE).sound(SoundType.DEEPSLATE)
                    .strength(5f, 3f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));

    public static final RegistryObject<Block> VOIDSLATE_ADAMANTITE_ORE = registerBlock("voidslate_adamantite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE).sound(SoundType.DEEPSLATE)
                    .strength(5f, 3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ROOTED_END_STONE = registerBlock("rooted_end_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ENDRITUS = registerBlock("endritus",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL)));

    public static final RegistryObject<Block> RAW_PURPUR_BLOCK = registerBlock("raw_purpur_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(1f, 4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RAW_PURPUR_SLAB = registerBlock("raw_purpur_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(1f, 4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RAW_PURPUR_STAIRS = registerBlock("raw_purpur_stairs",
            () -> new StairBlock(() -> EBlocks.RAW_PURPUR_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.NETHERRACK).strength(1f, 4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RAW_PURPUR_WALL = registerBlock("raw_purpur_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).strength(1f, 4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> PURPUR_WALL = registerBlock("purpur_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_BLOCK).strength(1.5f, 6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LUXITE_BLOCK = registerBlock("luxite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(5f, 6f).lightLevel((state) -> 15).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RAW_ADAMANTITE_BLOCK = registerBlock("raw_adamantite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)
                    .strength(5f, 6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ADAMANTITE_BLOCK = registerBlock("adamantite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5f, 6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ENDERITE_BLOCK = registerItemPropertiesBlock("enderite_block", () ->
            new Block(BlockBehaviour.Properties.of().strength(50f, 1200f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)), new Item.Properties().fireResistant());

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerItemPropertiesBlock(String name, Supplier<T> block, Item.Properties properties) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        EItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), properties));
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return EItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}