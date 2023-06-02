package barch.mc_extended;

import barch.mc_extended.Armor.*;
import barch.mc_extended.Crops.Tomato;
import barch.mc_extended.Minerals.Bronze;
import barch.mc_extended.Minerals.Silver;
import barch.mc_extended.Minerals.Tin;
import barch.mc_extended.Tools.*;
import barch.mc_extended.Villagers.VillagerPOIs;
import barch.mc_extended.Villagers.VillagerProfessions;
import barch.mc_extended.Villagers.VillagerTrades;
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
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
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

    // initialize the silver things
    private static final SilverArmorMaterial SilverArmorThing = SilverArmorMaterial.INSTANCE;
    private static final SilverToolMaterial SilverToolThing = SilverToolMaterial.INSTANCE;
    private static final Silver SilverThing = Silver.INSTANCE;

    // initialize the tin things
    private static final TinArmorMaterial TinArmorThing = TinArmorMaterial.INSTANCE;
    private static final TinToolMaterial TinToolThing = TinToolMaterial.INSTANCE;
    private static final Tin TinThing = Tin.INSTANCE;

    // initialize the tin things
    private static final CopperArmorMaterial CopperArmorThing = CopperArmorMaterial.INSTANCE;
    private static final CopperToolMaterial CopperToolThing = CopperToolMaterial.INSTANCE;

    // initialize the bronze things
    private static final BronzeArmorMaterial BronzeArmorThing = BronzeArmorMaterial.INSTANCE;
    private static final BronzeToolMaterial BronzeToolThing = BronzeToolMaterial.INSTANCE;
    private static final Bronze BronzeThing = Bronze.INSTANCE;

    // initialize the mushrooms
    private static final Mushrooms MushroomThing = Mushrooms.INSTANCE;

    // initialize the crops
    private static final Tomato CropsThing = Tomato.INSTANCE;


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



    // initialize the items


    // items

    // ruby
    public static final Item RUBY = new Item(new FabricItemSettings());





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

    // silver
    public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("mc-extended", "ore_tin"));



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

        // register the silver things
        SilverArmorThing.RegisterArmor();
        SilverArmorThing.GroupArmor();
        SilverToolThing.RegisterTools();
        SilverToolThing.GroupTools();
        SilverThing.RegisterAll();
        SilverThing.GroupItems();

        // register the tin things
        TinArmorThing.RegisterArmor();
        TinArmorThing.GroupArmor();
        TinToolThing.RegisterTools();
        TinToolThing.GroupTools();
        TinThing.RegisterAll();
        TinThing.GroupItems();

        // register the copper things
        CopperArmorThing.RegisterArmor();
        CopperArmorThing.GroupArmor();
        CopperToolThing.RegisterTools();
        CopperToolThing.GroupTools();

        // register the bronze things
        BronzeArmorThing.RegisterArmor();
        BronzeArmorThing.GroupArmor();
        BronzeToolThing.RegisterTools();
        BronzeToolThing.GroupTools();
        BronzeThing.RegisterAll();
        BronzeThing.GroupItems();

        // register the mushrooms
        MushroomThing.RegisterItems();
        MushroomThing.GroupItems();

        // register the crop stuff
        CropsThing.RegisterCrops();
        CropsThing.GroupItems();


        // register the blocks

        // ruby ore
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "ruby_ore"), RUBY_ORE);
        // deepslate ruby ore
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "deepslate_ruby_ore"), DEEPSLATE_RUBY_ORE);
        // ruby block
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "ruby_block"), RUBY_BLOCK);

        // gem table
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "gem_table"), GEM_TABLE);



        // register the block-items

        // ruby ore
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "deepslate_ruby_ore"), new BlockItem(DEEPSLATE_RUBY_ORE, new FabricItemSettings()));
        // deepslate ruby ore
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_ore"), new BlockItem(RUBY_ORE, new FabricItemSettings()));
        // ruby block
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_block"), new BlockItem(RUBY_BLOCK, new FabricItemSettings()));

        // gem table
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "gem_table"), new BlockItem(GEM_TABLE, new FabricItemSettings()));



        // register the items
        // ruby
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby"), RUBY);



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
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.addAfter(Items.DIAMOND_BLOCK, RUBY_BLOCK);
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
        // tin
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, TIN_ORE_PLACED_KEY);



        // register villager stuff

        // register villager POIs
        VillagerPOIs.registerPOIs();
        // register villager professions
        VillagerProfessions.registerProfessions();
        // register villager trades
        VillagerTrades.RegisterTrades();



    }
}