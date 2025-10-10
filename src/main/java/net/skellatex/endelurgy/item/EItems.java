package net.skellatex.endelurgy.item;

import net.minecraft.world.item.*;
import net.skellatex.endelurgy.Endelurgy;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Endelurgy.MOD_ID);

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
    public static final RegistryObject<Item> ENDERITE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("enderite_upgrade_smithing_template", () -> new EnderiteUpgradeItem());
    public static final RegistryObject<Item> ENDERITE_APPLE = ITEMS.register("enderite_apple",
            () -> new EnchantedGoldenAppleItem((new Item.Properties().food(EFoods.ENDERITE_APPLE).rarity(Rarity.EPIC).fireResistant())));
    public static final RegistryObject<Item> CRUSHED_RAW_ADAMANTITE = ITEMS.register("crushed_raw_adamantite",
            () -> new Item(new Item.Properties()));

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
            () -> new ArmorItem(EArmorMaterials.ENDERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ENDERITE_LEGGINGS = ITEMS.register("enderite_leggings",
            () -> new ArmorItem(EArmorMaterials.ENDERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ENDERITE_BOOTS = ITEMS.register("enderite_boots",
            () -> new ArmorItem(EArmorMaterials.ENDERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}