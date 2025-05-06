package barch.mc_extended.Registry;

import barch.mc_extended.Tags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class Features {


    public static final RegistryKey<PlacedFeature> HUGE_WHITE_MUSHROOM = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MC_EXTENDED, "huge_white_mushroom"));
    public static final RegistryKey<ConfiguredFeature<?, ?>> HUGE_WHITE_MUSHROOM_CONFIG = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MC_EXTENDED, "huge_white_mushroom"));


    public static final RegistryKey<PlacedFeature> TOMATO_PATCH_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MC_EXTENDED, "patch_tomato"));
    public static final RegistryKey<PlacedFeature> ONION_PATCH_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MC_EXTENDED, "patch_onion"));
    public static final RegistryKey<PlacedFeature> SPINACH_PATCH_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MC_EXTENDED, "patch_spinach"));


    public static final RegistryKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MC_EXTENDED, "ore_sapphire"));
    // sapphire
    public static final RegistryKey<PlacedFeature> RUBY_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MC_EXTENDED, "ore_ruby"));
    // silver
    public static final RegistryKey<PlacedFeature> SILVER_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MC_EXTENDED, "ore_silver"));
    // tin
    public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MC_EXTENDED, "ore_tin"));
    // white mushroom
    public static final RegistryKey<PlacedFeature> WHITE_MUSHROOM_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MC_EXTENDED, "huge_white_mushroom"));



    public static void doSomething() {

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, TOMATO_PATCH_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, ONION_PATCH_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, SPINACH_PATCH_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(Tags.BiomeTags.RUBY_SPAWNS_IN), GenerationStep.Feature.UNDERGROUND_ORES, RUBY_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(Tags.BiomeTags.SAPPHIRE_SPAWNS_IN), GenerationStep.Feature.UNDERGROUND_ORES, SAPPHIRE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, SILVER_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, TIN_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(Tags.BiomeTags.WHITE_MUSHROOMS_SPAWN_IN), GenerationStep.Feature.VEGETAL_DECORATION, WHITE_MUSHROOM_PLACED_KEY);

    }

}
