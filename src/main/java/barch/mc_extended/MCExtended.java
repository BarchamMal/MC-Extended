package barch.mc_extended;

import barch.mc_extended.Armor.*;
import barch.mc_extended.Foods.Cheese;
import barch.mc_extended.Foods.Mushrooms;
import barch.mc_extended.Foods.Tomato;
import barch.mc_extended.Minerals.Bronze;
import barch.mc_extended.Minerals.Silver;
import barch.mc_extended.Minerals.Tin;
import barch.mc_extended.Tools.*;
import barch.mc_extended.Villagers.Villagers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static barch.mc_extended.Minerals.Ruby.RUBY;


public class MCExtended implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("mc-extended");


    // initialize my mod things
    public static final ArFoMiToVi AR_FO_MI_TO_VI = new ArFoMiToVi();


    // initialize the item groups

    // MC-Extended
    public static  final ItemGroup MC_EXTENDED_GROUP = FabricItemGroup.builder(new Identifier("mc-extended", "mc-extended"))
            .icon(() -> new ItemStack(RUBY))
            .build();


    // initialize features

    // ores

    // ruby
    public static final RegistryKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(NAMESPACE, "ore_sapphire"));
    // sapphire
    public static final RegistryKey<PlacedFeature> RUBY_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(NAMESPACE, "ore_ruby"));
    // silver
    public static final RegistryKey<PlacedFeature> SILVER_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("mc-extended", "ore_silver"));
    // tin
    public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("mc-extended", "ore_tin"));

    // mushrooms

    // white mushroom
    public static final RegistryKey<PlacedFeature> WHITE_MUSHROOM_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("mc-extended", "huge_white_mushroom"));

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");

        // register everything
        AR_FO_MI_TO_VI.RegisterAll();

        // place the features

        // ores

        // ruby
        BiomeModifications.addFeature(BiomeSelectors.spawnsOneOf(EntityType.HUSK), GenerationStep.Feature.UNDERGROUND_ORES, RUBY_ORE_PLACED_KEY);
        // sapphire
        BiomeModifications.addFeature(BiomeSelectors.spawnsOneOf(EntityType.STRAY), GenerationStep.Feature.UNDERGROUND_ORES, SAPPHIRE_ORE_PLACED_KEY);
        // silver
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, SILVER_ORE_PLACED_KEY);
        // tin
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, TIN_ORE_PLACED_KEY);

        // mushrooms

        // white mushroom
        BiomeModifications.addFeature(BiomeSelectors.spawnsOneOf(EntityType.MOOSHROOM), GenerationStep.Feature.VEGETAL_DECORATION, WHITE_MUSHROOM_PLACED_KEY);


    }
}