package barch.mc_extended;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static barch.mc_extended.Minerals.Ruby.RUBY;


public class MCExtended implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.

    public static final String NAMESPACE = "mc-extended";

    public static final Logger LOGGER = LoggerFactory.getLogger(NAMESPACE);


    // initialize my mod things
    public static final ArFoMiToVi AR_FO_MI_TO_VI = new ArFoMiToVi();


    // initialize the item groups

    // MC-Extended
    public static final RegistryKey<ItemGroup> MC_EXTENDED_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(NAMESPACE, "mc-extended"));


    // initialize features

    // ores

    // ruby
    public static final RegistryKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(NAMESPACE, "ore_sapphire"));
    // sapphire
    public static final RegistryKey<PlacedFeature> RUBY_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(NAMESPACE, "ore_ruby"));
    // silver
    public static final RegistryKey<PlacedFeature> SILVER_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(NAMESPACE, "ore_silver"));
    // tin
    public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(NAMESPACE, "ore_tin"));

    // mushrooms

    // white mushroom
    public static final RegistryKey<PlacedFeature> WHITE_MUSHROOM_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(NAMESPACE, "huge_white_mushroom"));

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");

        // register everything
        AR_FO_MI_TO_VI.RegisterAll();

        // register the item groups
        Registry.register(Registries.ITEM_GROUP, MC_EXTENDED_GROUP, FabricItemGroup.builder()
                .icon(() -> new ItemStack(RUBY))
                .displayName(Text.translatable("itemGroup."+NAMESPACE+".mc-extended"))
                .build());

        // place the features

        // ores
        // ruby
        BiomeModifications.addFeature(BiomeSelectors.tag(Tags.BiomeTags.RUBY_SPAWNS_IN), GenerationStep.Feature.UNDERGROUND_ORES, RUBY_ORE_PLACED_KEY);
        // sapphire
        BiomeModifications.addFeature(BiomeSelectors.tag(Tags.BiomeTags.SAPPHIRE_SPAWNS_IN), GenerationStep.Feature.UNDERGROUND_ORES, SAPPHIRE_ORE_PLACED_KEY);
        // silver
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, SILVER_ORE_PLACED_KEY);
        // tin
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, TIN_ORE_PLACED_KEY);

        // mushrooms

        // white mushroom
        BiomeModifications.addFeature(BiomeSelectors.tag(Tags.BiomeTags.WHITE_MUSHROOMS_SPAWN_IN), GenerationStep.Feature.VEGETAL_DECORATION, WHITE_MUSHROOM_PLACED_KEY);


    }
}