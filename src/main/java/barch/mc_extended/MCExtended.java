package barch.mc_extended;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.poi.PointOfInterestType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCExtended implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("mc-extended");


    // initialize the ruby armor
    private static final RubyArmorMaterial RubyArmorThing = RubyArmorMaterial.INSTANCE;

    // initialize the ruby tools
    private static final RubyToolMaterial RubyToolThing = RubyToolMaterial.INSTANCE;

    // initialize the silver armor
    private static final SilverArmorMaterial SilverArmorThing = SilverArmorMaterial.INSTANCE;

    // initialize the silver tools
    private static final SilverToolMaterial SilverToolThing = SilverToolMaterial.INSTANCE;

    // initialize the mushrooms
    private static final Mushrooms MushroomThing = Mushrooms.INSTANCE;


    // initialize the blocks

    // ruby
    // ruby ore
    public static final Block RUBY_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2f).resistance(10f).requiresTool());
    // deepslate ruby ore
    public static final Block DEEPSLATE_RUBY_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.5f).resistance(15.0f).requiresTool());
    // ruby block
    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.5f).resistance(15.0f).requiresTool());
    // gem table
    public static final Block GEM_TABLE = new Block(FabricBlockSettings.of(Material.WOOD)
            .strength(Blocks.FLETCHING_TABLE.getHardness())
            .resistance(Blocks.FLETCHING_TABLE.getBlastResistance()));


    // silver
    // silver ore
    public static final Block SILVER_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2f).resistance(10f).requiresTool());
    // deepslate silver ore
    public static final Block DEEPSLATE_SILVER_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.5f).resistance(15.0f).requiresTool());
    // silver block
    public static final Block SILVER_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.5f).resistance(15.0f).requiresTool());
    // raw silver block
    public static final Block RAW_SILVER_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.5f).resistance(15.0f).requiresTool());







    // initialize the items

    // ruby
    public static final Item RUBY = new Item(new FabricItemSettings());

    // silver ingot
    public static final Item SILVER_INGOT = new Item(new FabricItemSettings());

    // silver nugget
    public static final Item SILVER_NUGGET = new Item(new FabricItemSettings());

    // raw silver
    public static final Item RAW_SILVER = new Item(new FabricItemSettings());






    // initialize the item groups

    // MC-Extended
    public static  final ItemGroup MC_EXTENDED_GROUP = FabricItemGroup.builder(new Identifier("mc-extended", "mc-extended"))
            .icon(() -> new ItemStack(RUBY))
            .build();



    // initialize features

    // ores

    // ruby
    public static final RegistryKey<PlacedFeature> RUBY_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("mc-extended", "ore_ruby"));

    // silver
    public static final RegistryKey<PlacedFeature> SILVER_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("mc-extended", "ore_silver"));




    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");

        // register the ruby armor
        RubyArmorThing.RegisterArmor();
        RubyArmorThing.GroupArmor();

        // register the ruby tools
        RubyToolThing.RegisterTools();
        RubyToolThing.GroupTools();

        // register the silver armor
        SilverArmorThing.RegisterArmor();
        SilverArmorThing.GroupArmor();

        // register the silver tools
        SilverToolThing.RegisterTools();
        SilverToolThing.GroupTools();

        // register the mushrooms
        MushroomThing.RegisterItems();
        MushroomThing.GroupItems();


        // register the blocks

        // ruby ore
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "ruby_ore"), RUBY_ORE);
        // deepslate ruby ore
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "deepslate_ruby_ore"), DEEPSLATE_RUBY_ORE);
        // ruby block
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "ruby_block"), RUBY_BLOCK);

        // gem table
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "gem_table"), GEM_TABLE);

        // silver ore
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "silver_ore"), SILVER_ORE);
        // deepslate silver ore
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "deepslate_silver_ore"), DEEPSLATE_SILVER_ORE);
        // silver block
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "silver_block"), SILVER_BLOCK);
        // raw silver block
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "raw_silver_block"), RAW_SILVER_BLOCK);




        // register the block-items

        // ruby ore
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "deepslate_ruby_ore"), new BlockItem(DEEPSLATE_RUBY_ORE, new FabricItemSettings()));
        // deepslate ruby ore
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_ore"), new BlockItem(RUBY_ORE, new FabricItemSettings()));
        // ruby block
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_block"), new BlockItem(RUBY_BLOCK, new FabricItemSettings()));

        // gem table
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "gem_table"), new BlockItem(GEM_TABLE, new FabricItemSettings()));

        // silver ore
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "deepslate_silver_ore"), new BlockItem(DEEPSLATE_SILVER_ORE, new FabricItemSettings()));
        // deepslate silver ore
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "silver_ore"), new BlockItem(SILVER_ORE, new FabricItemSettings()));
        // silver block
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "silver_block"), new BlockItem(SILVER_BLOCK, new FabricItemSettings()));
        // raw silver block
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "raw_silver_block"), new BlockItem(RAW_SILVER_BLOCK, new FabricItemSettings()));


        // register the items
        // ruby
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby"), RUBY);
        // silver ingot
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "silver_ingot"), SILVER_INGOT);
        // silver nugget
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "silver_nugget"), SILVER_NUGGET);
        // raw silver
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "raw_silver"), RAW_SILVER);






        // add items into item groups

        // MC-EXTENDED

        // ruby
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.DIAMOND, RUBY);
        });
        // ruby ore
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.DEEPSLATE_DIAMOND_ORE, RUBY_ORE);
        });
        // deepslate ruby ore
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(DEEPSLATE_RUBY_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(RUBY_ORE, DEEPSLATE_RUBY_ORE);
        });
        // ruby block
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_BLOCK);
        });

        // silver ingot
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_INGOT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.GOLD_INGOT, SILVER_INGOT);
        });
        // silver nugget
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_INGOT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.GOLD_NUGGET, SILVER_NUGGET);
        });
        // raw silver
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_NUGGET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.RAW_GOLD, RAW_SILVER);
        });
        // silver ore
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(DEEPSLATE_RUBY_ORE, SILVER_ORE);
        });
        // deepslate silver ore
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(DEEPSLATE_SILVER_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.RAW_GOLD_BLOCK, RAW_SILVER_BLOCK);
        });
        // raw silver block
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RAW_SILVER_BLOCK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(SILVER_ORE, DEEPSLATE_SILVER_ORE);
        });
        // silver block
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_BLOCK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.GOLD_BLOCK, SILVER_BLOCK);
        });
        // gem table
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(GEM_TABLE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.addAfter(Items.FLETCHING_TABLE, GEM_TABLE);
        });



        // place the features

        // ores

        // ruby
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RUBY_ORE_PLACED_KEY);

        // silver
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, SILVER_ORE_PLACED_KEY);


        // register villager stuff

        // register villager POIs
        VillagerPOIs.registerPOIs();
        // register villager professions
        VillagerProfessions.registerProfessions();
        // register villager trades
        VillagerTrades.RegisterTrades();

    }
}