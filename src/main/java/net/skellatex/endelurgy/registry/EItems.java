package net.skellatex.endelurgy.registry;

import net.minecraft.world.item.*;
import net.minecraftforge.fml.ModList;
import net.skellatex.endelurgy.Endelurgy;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skellatex.endelurgy.content.compat.FarmersDelightCompat;
import net.skellatex.endelurgy.content.item.*;

import java.util.function.Function;
import java.util.function.Supplier;

import static net.skellatex.endelurgy.content.compat.ModCompat.FARMERS_DELIGHT_ID;

public class EItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Endelurgy.MOD_ID);

    // Materials
    public static final RegistryObject<Item> RAW_ADAMANTITE = ITEMS.register("raw_adamantite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTITE_INGOT = ITEMS.register("adamantite_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTITE_NUGGET = ITEMS.register("adamantite_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LUXITE = ITEMS.register("luxite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ENDERITE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("enderite_upgrade_smithing_template",
            () -> new EnderiteUpgradeItem());

    // Foods
    public static final RegistryObject<Item> ENDERITE_APPLE = ITEMS.register("enderite_apple",
            () -> new EnchantedGoldenAppleItem((new Item.Properties().food(EFoods.ENDERITE_APPLE).rarity(Rarity.EPIC).fireResistant())));
    public static final RegistryObject<Item> DRAGON_EGG_OMELET = ITEMS.register("dragon_egg_omelet",
            () -> new BowlFoodItem((new Item.Properties().food(EFoods.DRAGON_EGG_OMELET).rarity(Rarity.EPIC))));

    // Admanantite Equipment
    public static final RegistryObject<Item> ADAMANTITE_SWORD = ITEMS.register("adamantite_sword",
            () -> new SwordItem(EToolTiers.ADAMANTITE,2, -2.2F, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTITE_PICKAXE = ITEMS.register("adamantite_pickaxe",
            () -> new PickaxeItem(EToolTiers.ADAMANTITE,0, -2.6F, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTITE_AXE = ITEMS.register("adamantite_axe",
            () -> new AxeItem(EToolTiers.ADAMANTITE,4, -2.9F, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTITE_SHOVEL = ITEMS.register("adamantite_shovel",
            () -> new ShovelItem(EToolTiers.ADAMANTITE,0.5F, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTITE_HOE = ITEMS.register("adamantite_hoe",
            () -> new HoeItem(EToolTiers.ADAMANTITE,-4, 0F, new Item.Properties()));

    public static final RegistryObject<Item> ADAMANTITE_HELMET = ITEMS.register("adamantite_helmet",
            () -> new AdamantiteArmorItem(EArmorMaterials.ADAMANTITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTITE_CHESTPLATE = ITEMS.register("adamantite_chestplate",
            () -> new AdamantiteArmorItem(EArmorMaterials.ADAMANTITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTITE_LEGGINGS = ITEMS.register("adamantite_leggings",
            () -> new AdamantiteArmorItem(EArmorMaterials.ADAMANTITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTITE_BOOTS = ITEMS.register("adamantite_boots",
            () -> new AdamantiteArmorItem(EArmorMaterials.ADAMANTITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> ADAMANTITE_HORSE_ARMOR = ITEMS.register("adamantite_horse_armor",
            () -> new AdamantiteHorseArmorItem(new Item.Properties().stacksTo(1)));

    // Enderite Equipment
    public static final RegistryObject<Item> ENDERITE_SWORD = ITEMS.register("enderite_sword",
            () -> new SwordItem(EToolTiers.ENDERITE,5, -2.4F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe",
            () -> new PickaxeItem(EToolTiers.ENDERITE,3, -2.8F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ENDERITE_AXE = ITEMS.register("enderite_axe",
            () -> new AxeItem(EToolTiers.ENDERITE,7, -3F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel",
            () -> new ShovelItem(EToolTiers.ENDERITE,3.5F, -3F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ENDERITE_HOE = ITEMS.register("enderite_hoe",
            () -> new HoeItem(EToolTiers.ENDERITE,-4, 0F, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> ENDERITE_HELMET = ITEMS.register("enderite_helmet",
            () -> new EnderiteHelmetItem(EArmorMaterials.ENDERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate",
            () -> new EnderiteArmorItem(EArmorMaterials.ENDERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ENDERITE_LEGGINGS = ITEMS.register("enderite_leggings",
            () -> new EnderiteArmorItem(EArmorMaterials.ENDERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ENDERITE_BOOTS = ITEMS.register("enderite_boots",
            () -> new EnderiteArmorItem(EArmorMaterials.ENDERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> WINGED_ENDERITE_CHESTPLATE = ITEMS.register("winged_enderite_chestplate",
            () -> new WingedEnderiteChestplateItem(EArmorMaterials.ENDERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> ENDERITE_HORSE_ARMOR = ITEMS.register("enderite_horse_armor",
            () -> new EnderiteHorseArmorItem(new Item.Properties().fireResistant().stacksTo(1)));

    // Compat
    public static final RegistryObject<Item> CRUSHED_RAW_ADAMANTITE = ITEMS.register("crushed_raw_adamantite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ADAMANTITE_NUGGET = ITEMS.register("raw_adamantite_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROUGH_LUXITE = ITEMS.register("rough_luxite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LUXITE_SHARD = ITEMS.register("luxite_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROUGH_LUXITE_SHARD = ITEMS.register("rough_luxite_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTITE_KNIFE = ITEMS.register("adamantite_knife",
            compat(FARMERS_DELIGHT_ID, it -> FarmersDelightCompat.KNIFE_FACTORY_ADAMANTITE.apply(it), new Item.Properties()));
    public static final RegistryObject<Item> ENDERITE_KNIFE = ITEMS.register("enderite_knife",
            compat(FARMERS_DELIGHT_ID, it -> FarmersDelightCompat.KNIFE_FACTORY_ENDERITE.apply(it), new Item.Properties().fireResistant()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static Supplier<? extends Item> compat(String modid, Function<Item.Properties, ? extends Item> supplier, Item.Properties properties) {
        if (ModList.get().isLoaded(modid)) return () -> supplier.apply(properties);
        return () -> new Item(properties);
    }
}