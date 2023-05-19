package barch.mc_extended;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCExtended implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("mc-extended");


    // initialize the blocks

    // ruby ore
    public static final Block RUBY_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2f).resistance(10f).requiresTool());
    // deepslate ruby ore
    public static final Block DEEPSLATE_RUBY_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.5f).resistance(15.0f).requiresTool());
    // ruby block
    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.5f).resistance(15.0f).requiresTool());




    // initialize the items

    // ruby
    public static final Item RUBY = new Item(new FabricItemSettings());
    // ruby sword
    public static ToolItem RUBY_SWORD = new SwordItem(RubyToolMaterial.INSTANCE, 4, -2f, new Item.Settings());
    // ruby axe
    public static ToolItem RUBY_AXE = new AxeItem(RubyToolMaterial.INSTANCE, 5f, -3f, new Item.Settings());

    // ruby hoe
    public static ToolItem RUBY_HOE = new HoeItem(RubyToolMaterial.INSTANCE, -5, 0, new Item.Settings());

    // ruby shovel
    public static ToolItem RUBY_SHOVEL = new ShovelItem(RubyToolMaterial.INSTANCE, 1.5f, -3f, new Item.Settings());

    // ruby pickaxe
    public static ToolItem RUBY_PICKAXE = new PickaxeItem(RubyToolMaterial.INSTANCE, 0, -2f, new Item.Settings());

    // ruby helmet
    public static final Item RUBY_HELMET = new ArmorItem(RubyArmorMaterial.INSTANCE, ArmorItem.Type.HELMET, new Item.Settings());

    // ruby helmet
    public static final Item RUBY_CHESTPLATE = new ArmorItem(RubyArmorMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings());

    // ruby helmet
    public static final Item RUBY_LEGGINGS = new ArmorItem(RubyArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings());

    // ruby helmet
    public static final Item RUBY_BOOTS = new ArmorItem(RubyArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings());



    // initialize the item groups

    // MC-Extended
    private  static  final ItemGroup MC_EXTENDED_GROUP = FabricItemGroup.builder(new Identifier("mc-extended", "mc-extended"))
            .icon(() -> new ItemStack(RUBY))
            .build();



    // initialize features

    // ores

    // ruby
    public static  final RegistryKey<PlacedFeature> RUBY_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("mc-extended", "ore_ruby"));


    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");

        //register the blocks

        // ruby ore
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "ruby_ore"), RUBY_ORE);
        // deepslate ruby ore
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "deepslate_ruby_ore"), DEEPSLATE_RUBY_ORE);
        // ruby block
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "ruby_block"), RUBY_BLOCK);




        // register the block-items

        // ruby ore
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "deepslate_ruby_ore"), new BlockItem(DEEPSLATE_RUBY_ORE, new FabricItemSettings()));
        // deepslate ruby ore
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_ore"), new BlockItem(RUBY_ORE, new FabricItemSettings()));
        // ruby block
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_block"), new BlockItem(RUBY_BLOCK, new FabricItemSettings()));



        // register the items
        // ruby
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby"), RUBY);

        // ruby sword
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_sword"), RUBY_SWORD);
        // ruby axe
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_axe"), RUBY_AXE);
        // ruby hoe
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_hoe"), RUBY_HOE);
        // ruby shovel
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_shovel"), RUBY_SHOVEL);
        // ruby pickaxe

        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_pickaxe"), RUBY_PICKAXE);
        // ruby helmet
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_helmet"), RUBY_HELMET);
        // ruby chestplate
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_chestplate"), RUBY_CHESTPLATE);
        // ruby leggings
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_leggings"), RUBY_LEGGINGS);
        // ruby boots
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_boots"), RUBY_BOOTS);




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


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.DIAMOND_BLOCK, RUBY_BLOCK);
        });
        // ruby sword
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_SWORD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.DIAMOND_SWORD, RUBY_SWORD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(RUBY_AXE, RUBY_HOE);
        });
        // ruby shovel
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_SHOVEL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.DIAMOND_HOE, RUBY_SHOVEL);
        });
        // ruby pickaxe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_PICKAXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(RUBY_SHOVEL, RUBY_PICKAXE);
        });
        // ruby axe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.DIAMOND_AXE, RUBY_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(RUBY_PICKAXE, RUBY_AXE);
        });
        // ruby hoe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(RUBY_AXE, RUBY_HOE);
        });


        // ruby helmet
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_HELMET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.DIAMOND_BOOTS, RUBY_HELMET);
        });
        // ruby chestplate
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_CHESTPLATE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(RUBY_HELMET, RUBY_CHESTPLATE);
        });
        // ruby leggings
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_LEGGINGS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(RUBY_CHESTPLATE, RUBY_LEGGINGS);
        });
        // ruby boots
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(RUBY_LEGGINGS, RUBY_BOOTS);
        });



        // place the features

        // ores

        // ruby
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RUBY_ORE_PLACED_KEY);


    }
}