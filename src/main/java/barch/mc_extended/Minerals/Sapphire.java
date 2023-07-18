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

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;

public class Sapphire {

    public static final Sapphire INSTANCE = new Sapphire();


    // Initialize the blocks

    // sapphire ore
    public static final Block SAPPHIRE_ORE = new Block(BlockBuilder.CloneBlock(Blocks.DIAMOND_ORE).mapColor(DyeColor.LIGHT_GRAY).requiresTool().resistance(1200).hardness(30));
    // deepslate sapphire ore
    public static final Block DEEPSLATE_SAPPHIRE_ORE = new Block(BlockBuilder.CloneBlock(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(DyeColor.GRAY).requiresTool().resistance(1200).hardness(30));
    // sapphire block
    public static final Block SAPPHIRE_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.DIAMOND_BLOCK).mapColor(DyeColor.RED).requiresTool().resistance(1200).hardness(30));



    // Initialize the items
    // sapphire 
    public static final Item SAPPHIRE = new Item(new FabricItemSettings());


    public static void RegisterAll() {

        Sapphire.RegisterBlocks();
        Sapphire.RegisterBlockItems();
        Sapphire.RegisterItems();
        Sapphire.GroupItems();

    }

    public static void RegisterBlocks() {

        // sapphire ore
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "sapphire_ore"), SAPPHIRE_ORE);
        // deepslate sapphire ore
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "deepslate_sapphire_ore"), DEEPSLATE_SAPPHIRE_ORE);
        // sapphire block
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "sapphire_block"), SAPPHIRE_BLOCK);



    }

    public static void RegisterBlockItems() {

        // sapphire ore
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "deepslate_sapphire_ore"), new BlockItem(DEEPSLATE_SAPPHIRE_ORE, new FabricItemSettings()));
        // deepslate sapphire ore
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "sapphire_ore"), new BlockItem(SAPPHIRE_ORE, new FabricItemSettings()));
        // sapphire block
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "sapphire_block"), new BlockItem(SAPPHIRE_BLOCK, new FabricItemSettings()));


    }

    public static void RegisterItems() {

        // sapphire 
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "sapphire"), SAPPHIRE);

    }

    public static void GroupItems() {



        // sapphire
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SAPPHIRE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.DIAMOND, SAPPHIRE);
        });

        // sapphire ore
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SAPPHIRE_ORE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(DEEPSLATE_SAPPHIRE_ORE, SAPPHIRE_ORE);
        });

        // deepslate sapphire ore
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(DEEPSLATE_SAPPHIRE_ORE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(SAPPHIRE_ORE, DEEPSLATE_SAPPHIRE_ORE);
        });

        // sapphire block
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SAPPHIRE_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.GOLD_BLOCK, SAPPHIRE_BLOCK);
        });


    }
}