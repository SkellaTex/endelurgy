package net.skellatex.endelurgy.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skellatex.endelurgy.Endelurgy;
import net.skellatex.endelurgy.item.EItems;

public class EMobEffects {

    public static final DeferredRegister<MobEffect> DEF_REG = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Endelurgy.MOD_ID);
    public static final DeferredRegister<Potion> POTION_DEF_REG = DeferredRegister.create(ForgeRegistries.POTIONS, Endelurgy.MOD_ID);

    public static final RegistryObject<MobEffect> ENERVATION = DEF_REG.register("enervation", () -> new EnervationEffect());
    public static final RegistryObject<MobEffect> RESTORATION = DEF_REG.register("restoration", () -> new RestorationEffect());
    public static final RegistryObject<MobEffect> CORROSION = DEF_REG.register("corrosion", () -> new CorrosionEffect());

    public static final RegistryObject<Potion> VITALITY_POTION = POTION_DEF_REG.register("vitality", () -> new Potion(new MobEffectInstance(MobEffects.HEALTH_BOOST, 3600)));
    public static final RegistryObject<Potion> LONG_VITALITY_POTION = POTION_DEF_REG.register("long_vitality", () -> new Potion(new MobEffectInstance(MobEffects.HEALTH_BOOST, 9600)));
    public static final RegistryObject<Potion> STRONG_VITALITY_POTION = POTION_DEF_REG.register("strong_vitality", () -> new Potion(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1800, 1)));
    public static final RegistryObject<Potion> ENERVATION_POTION = POTION_DEF_REG.register("enervation", () -> new Potion(new MobEffectInstance(ENERVATION.get(), 3600)));
    public static final RegistryObject<Potion> LONG_ENERVATION_POTION = POTION_DEF_REG.register("long_enervation", () -> new Potion(new MobEffectInstance(ENERVATION.get(), 9600)));
    public static final RegistryObject<Potion> STRONG_ENERVATION_POTION = POTION_DEF_REG.register("strong_enervation", () -> new Potion(new MobEffectInstance(ENERVATION.get(), 1800, 1)));
    public static final RegistryObject<Potion> CORROSION_POTION = POTION_DEF_REG.register("corrosion", () -> new Potion(new MobEffectInstance(CORROSION.get(), 3600)));
    public static final RegistryObject<Potion> LONG_CORROSION_POTION = POTION_DEF_REG.register("long_corrosion", () -> new Potion(new MobEffectInstance(CORROSION.get(), 9600)));
    public static final RegistryObject<Potion> STRONG_CORROSION_POTION = POTION_DEF_REG.register("strong_corrosion", () -> new Potion(new MobEffectInstance(CORROSION.get(), 1800, 1)));
    public static final RegistryObject<Potion> RESTORATION_POTION = POTION_DEF_REG.register("restoration", () -> new Potion(new MobEffectInstance(RESTORATION.get(), 3600)));
    public static final RegistryObject<Potion> LONG_RESTORATION_POTION = POTION_DEF_REG.register("long_restoration", () -> new Potion(new MobEffectInstance(RESTORATION.get(), 9600)));
    public static final RegistryObject<Potion> STRONG_RESTORATION_POTION = POTION_DEF_REG.register("strong_restoration", () -> new Potion(new MobEffectInstance(RESTORATION.get(), 1800, 1)));

    public static void setup() {
        BrewingRecipeRegistry.addRecipe(new ProperBrewingRecipe(Ingredient.of(createPotion(Potions.AWKWARD)), Ingredient.of(EItems.ADAMANTITE_INGOT.get()), createPotion(VITALITY_POTION)));
        BrewingRecipeRegistry.addRecipe(new ProperBrewingRecipe(Ingredient.of(createPotion(VITALITY_POTION)), Ingredient.of(Items.REDSTONE), createPotion(LONG_VITALITY_POTION)));
        BrewingRecipeRegistry.addRecipe(new ProperBrewingRecipe(Ingredient.of(createPotion(VITALITY_POTION)), Ingredient.of(Items.GLOWSTONE_DUST), createPotion(STRONG_VITALITY_POTION)));

        BrewingRecipeRegistry.addRecipe(new ProperBrewingRecipe(Ingredient.of(createPotion(EMobEffects.VITALITY_POTION)), Ingredient.of(Items.FERMENTED_SPIDER_EYE), createPotion(ENERVATION_POTION)));
        BrewingRecipeRegistry.addRecipe(new ProperBrewingRecipe(Ingredient.of(createPotion(ENERVATION_POTION)), Ingredient.of(Items.REDSTONE), createPotion(LONG_ENERVATION_POTION)));
        BrewingRecipeRegistry.addRecipe(new ProperBrewingRecipe(Ingredient.of(createPotion(ENERVATION_POTION)), Ingredient.of(Items.GLOWSTONE_DUST), createPotion(STRONG_ENERVATION_POTION)));

        BrewingRecipeRegistry.addRecipe(new ProperBrewingRecipe(Ingredient.of(createPotion(Potions.AWKWARD)), Ingredient.of(EItems.LUXITE.get()), createPotion(RESTORATION_POTION)));
        BrewingRecipeRegistry.addRecipe(new ProperBrewingRecipe(Ingredient.of(createPotion(RESTORATION_POTION)), Ingredient.of(Items.REDSTONE), createPotion(LONG_RESTORATION_POTION)));
        BrewingRecipeRegistry.addRecipe(new ProperBrewingRecipe(Ingredient.of(createPotion(RESTORATION_POTION)), Ingredient.of(Items.GLOWSTONE_DUST), createPotion(STRONG_RESTORATION_POTION)));

        BrewingRecipeRegistry.addRecipe(new ProperBrewingRecipe(Ingredient.of(createPotion(EMobEffects.RESTORATION_POTION)), Ingredient.of(Items.FERMENTED_SPIDER_EYE), createPotion(CORROSION_POTION)));
        BrewingRecipeRegistry.addRecipe(new ProperBrewingRecipe(Ingredient.of(createPotion(CORROSION_POTION)), Ingredient.of(Items.REDSTONE), createPotion(LONG_CORROSION_POTION)));
        BrewingRecipeRegistry.addRecipe(new ProperBrewingRecipe(Ingredient.of(createPotion(CORROSION_POTION)), Ingredient.of(Items.GLOWSTONE_DUST), createPotion(STRONG_CORROSION_POTION)));
    }

    public static ItemStack createPotion(RegistryObject<Potion> potion) {
        return createPotion(potion.get());
    }

    public static ItemStack createPotion(Potion potion) {
        return PotionUtils.setPotion(new ItemStack(Items.POTION), potion);
    }

    public static ItemStack createSplashPotion(Potion potion) {
        return PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), potion);
    }

    public static ItemStack createLingeringPotion(Potion potion) {
        return PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), potion);
    }
}