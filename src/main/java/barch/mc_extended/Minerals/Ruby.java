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

public class Ruby {

    public static final Ruby INSTANCE = new Ruby();


    // Initialize the blocks

    // ruby ore
    public static final Block RUBY_ORE = new Block(BlockBuilder.CloneBlock(Blocks.DIAMOND_ORE).mapColor(DyeColor.LIGHT_GRAY).requiresTool());
    // deepslate ruby ore
    public static final Block DEEPSLATE_RUBY_ORE = new Block(BlockBuilder.CloneBlock(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(DyeColor.GRAY).requiresTool());
    // ruby block
    public static final Block RUBY_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.DIAMOND_BLOCK).mapColor(DyeColor.RED).requiresTool());



    // Initialize the items
    // ruby 
    public static final Item RUBY = new Item(new FabricItemSettings());


    public static void RegisterAll() {

        Ruby.RegisterBlocks();
        Ruby.RegisterBlockItems();
        Ruby.RegisterItems();
        Ruby.GroupItems();

    }

    public static void RegisterBlocks() {

        // ruby ore
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "ruby_ore"), RUBY_ORE);
        // deepslate ruby ore
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "deepslate_ruby_ore"), DEEPSLATE_RUBY_ORE);
        // ruby block
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "ruby_block"), RUBY_BLOCK);



    }

    public static void RegisterBlockItems() {

        // ruby ore
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "deepslate_ruby_ore"), new BlockItem(DEEPSLATE_RUBY_ORE, new FabricItemSettings()));
        // deepslate ruby ore
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby_ore"), new BlockItem(RUBY_ORE, new FabricItemSettings()));
        // ruby block
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby_block"), new BlockItem(RUBY_BLOCK, new FabricItemSettings()));


    }

    public static void RegisterItems() {

        // ruby 
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby"), RUBY);

    }

    public static void GroupItems() {



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
            content.addAfter(DEEPSLATE_RUBY_ORE, RUBY_ORE);
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
            content.addAfter(Items.GOLD_BLOCK, RUBY_BLOCK);
        });


    }
}