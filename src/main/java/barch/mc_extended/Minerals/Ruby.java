package barch.mc_extended.Minerals;

import barch.mc_extended.Glue.BlockBuilder;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Glue.ItemGrouped;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
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

    public static final Block RUBY_ORE = new Block(BlockBuilder.CloneBlock(Blocks.DIAMOND_ORE).mapColor(DyeColor.LIGHT_GRAY).requiresTool().resistance(1200).hardness(30));
    public static final Block DEEPSLATE_RUBY_ORE = new Block(BlockBuilder.CloneBlock(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(DyeColor.GRAY).requiresTool().resistance(1200).hardness(30));
    public static final Block RUBY_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.DIAMOND_BLOCK).mapColor(DyeColor.RED).requiresTool().resistance(1200).hardness(30));

    public static final Item RUBY = new Item(new FabricItemSettings());

    public static void RegisterAll() {

        Ruby.RegisterBlocks();
        Ruby.RegisterBlockItems();
        Ruby.RegisterItems();
        Ruby.GroupItems();

    }

    public static void RegisterBlocks() {

        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "ruby_ore"), RUBY_ORE);
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "deepslate_ruby_ore"), DEEPSLATE_RUBY_ORE);
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "ruby_block"), RUBY_BLOCK);

    }

    public static void RegisterBlockItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "deepslate_ruby_ore"), new BlockItem(DEEPSLATE_RUBY_ORE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby_ore"), new BlockItem(RUBY_ORE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby_block"), new BlockItem(RUBY_BLOCK, new FabricItemSettings()));


    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby"), RUBY);

    }

    public static void GroupItems() {

        ItemGrouper.GroupItem(RUBY, new ItemGrouped[]{new ItemGrouped(ItemGroups.INGREDIENTS, Items.DIAMOND)});
        ItemGrouper.GroupItem(RUBY_ORE, new ItemGrouped[]{new ItemGrouped(ItemGroups.NATURAL, Blocks.DEEPSLATE_DIAMOND_ORE)});
        ItemGrouper.GroupItem(DEEPSLATE_RUBY_ORE, new ItemGrouped[]{new ItemGrouped(ItemGroups.NATURAL, RUBY_ORE)});
        ItemGrouper.GroupItem(RUBY_BLOCK, new ItemGrouped[]{new ItemGrouped(ItemGroups.BUILDING_BLOCKS, Blocks.DIAMOND_BLOCK)});

    }
}