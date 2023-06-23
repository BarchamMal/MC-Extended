package barch.mc_extended.Minerals;

import barch.mc_extended.Glue.BlockBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.*;
import static barch.mc_extended.Minerals.Ruby.*;

public class Silver {

    public static final Silver INSTANCE = new Silver();


    // Initialize the blocks

    // silver ore
    public static final Block SILVER_ORE = new Block(BlockBuilder.CloneBlock(Blocks.GOLD_ORE).mapColor(DyeColor.LIGHT_GRAY).requiresTool());
    // deepslate silver ore
    public static final Block DEEPSLATE_SILVER_ORE = new Block(BlockBuilder.CloneBlock(Blocks.DEEPSLATE_GOLD_ORE).mapColor(DyeColor.GRAY).requiresTool());
    // silver block
    public static final Block SILVER_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.GOLD_BLOCK).mapColor(DyeColor.WHITE).requiresTool());
    // raw silver block
    public static final Block RAW_SILVER_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.RAW_GOLD_BLOCK).mapColor(DyeColor.WHITE).requiresTool());



    // Initialize the items
    // silver ingot
    public static final Item SILVER_INGOT = new Item(new FabricItemSettings());

    // silver nugget
    public static final Item SILVER_NUGGET = new Item(new FabricItemSettings());

    // raw silver
    public static final Item RAW_SILVER = new Item(new FabricItemSettings());


    public static void RegisterAll() {

        Silver.RegisterBlocks();
        Silver.RegisterBlockItems();
        Silver.RegisterItems();
        Silver.GroupItems();

    }

    public static void RegisterBlocks() {

        // silver ore
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "silver_ore"), SILVER_ORE);
        // deepslate silver ore
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "deepslate_silver_ore"), DEEPSLATE_SILVER_ORE);
        // silver block
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "silver_block"), SILVER_BLOCK);
        // raw silver block
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "raw_silver_block"), RAW_SILVER_BLOCK);


    }

    public static void RegisterBlockItems() {

        // silver ore
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "deepslate_silver_ore"), new BlockItem(DEEPSLATE_SILVER_ORE, new FabricItemSettings()));
        // deepslate silver ore
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_ore"), new BlockItem(SILVER_ORE, new FabricItemSettings()));
        // silver block
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_block"), new BlockItem(SILVER_BLOCK, new FabricItemSettings()));
        // raw silver block
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "raw_silver_block"), new BlockItem(RAW_SILVER_BLOCK, new FabricItemSettings()));


    }

    public static void RegisterItems() {

        // silver ingot
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_ingot"), SILVER_INGOT);
        // silver nugget
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_nugget"), SILVER_NUGGET);
        // raw silver
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "raw_silver"), RAW_SILVER);

    }

    public static void GroupItems() {



        // silver ingot
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_INGOT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.GOLD_INGOT, SILVER_INGOT);
        });

        // silver nugget
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_NUGGET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.GOLD_NUGGET, SILVER_NUGGET);
        });

        // raw silver
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RAW_SILVER);
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
            content.addAfter(SILVER_ORE, DEEPSLATE_SILVER_ORE);
        });

        // raw silver block
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RAW_SILVER_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.RAW_GOLD_BLOCK, RAW_SILVER_BLOCK);
        });

        // silver block
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.GOLD_BLOCK, SILVER_BLOCK);
        });


    }
}