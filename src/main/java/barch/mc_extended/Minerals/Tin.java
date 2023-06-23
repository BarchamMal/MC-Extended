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

public class Tin {

    public static final Tin INSTANCE = new Tin();


    // Initialize the blocks
    // tin ore
    public static final Block TIN_ORE = new Block(BlockBuilder.CloneBlock(Blocks.COPPER_BLOCK).mapColor(DyeColor.GRAY).requiresTool());
    // deepslate tin ore
    public static final Block DEEPSLATE_TIN_ORE = new Block(BlockBuilder.CloneBlock(Blocks.DEEPSLATE_COPPER_ORE).mapColor(DyeColor.GRAY).requiresTool());
    // tin block
    public static final Block TIN_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.COPPER_ORE).mapColor(DyeColor.GRAY).requiresTool());
    // raw tin block
    public static final Block RAW_TIN_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.RAW_COPPER_BLOCK).mapColor(DyeColor.GRAY).requiresTool());




    // Initialize the items

    // tin ingot
    public static final Item TIN_INGOT = new Item(new FabricItemSettings());

    // tin nugget
    public static final Item TIN_NUGGET = new Item(new FabricItemSettings());

    // raw tin
    public static final Item RAW_TIN = new Item(new FabricItemSettings());


    public static void RegisterAll() {

        Tin.RegisterBlocks();
        Tin.RegisterBlockItems();
        Tin.RegisterItems();
        Tin.GroupItems();

    }


    public static void RegisterBlocks() {

        // tin ore
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "tin_ore"), TIN_ORE);
        // deepslate tin ore
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "deepslate_tin_ore"), DEEPSLATE_TIN_ORE);
        // tin block
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "tin_block"), TIN_BLOCK);
        // raw tin block
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "raw_tin_block"), RAW_TIN_BLOCK);

    }

    public static void RegisterBlockItems() {


        // tin ore
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "deepslate_tin_ore"), new BlockItem(DEEPSLATE_TIN_ORE, new FabricItemSettings()));
        // deepslate tin ore
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_ore"), new BlockItem(TIN_ORE, new FabricItemSettings()));
        // tin block
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_block"), new BlockItem(TIN_BLOCK, new FabricItemSettings()));
        // raw tin block
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "raw_tin_block"), new BlockItem(RAW_TIN_BLOCK, new FabricItemSettings()));


    }

    public static void RegisterItems() {


        // tin ingot
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_ingot"), TIN_INGOT);
        // tin nugget
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_nugget"), TIN_NUGGET);
        // raw tin
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "raw_tin"), RAW_TIN);

    }

    public static void GroupItems() {

        // tin ingot
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TIN_INGOT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.IRON_INGOT, TIN_INGOT);
        });

        // tin nugget
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TIN_NUGGET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.IRON_NUGGET, TIN_NUGGET);
        });

        // raw tin
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RAW_TIN);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.RAW_IRON, RAW_TIN);
        });

        // tin ore
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TIN_ORE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.IRON_ORE, TIN_ORE);
        });

        // deepslate tin ore
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(DEEPSLATE_TIN_ORE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(TIN_ORE, DEEPSLATE_TIN_ORE);
        });

        // raw tin block
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RAW_TIN_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.RAW_IRON_BLOCK, RAW_TIN_BLOCK);
        });

        // tin block
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TIN_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.IRON_BLOCK, TIN_BLOCK);
        });


    }
}