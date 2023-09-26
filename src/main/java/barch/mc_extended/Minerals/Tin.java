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
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.*;
import static barch.mc_extended.Minerals.Bronze.*;

public class Tin {

    public static final Block TIN_ORE = new Block(BlockBuilder.CloneBlock(Blocks.COPPER_BLOCK).mapColor(DyeColor.GRAY).requiresTool());
    public static final Block DEEPSLATE_TIN_ORE = new Block(BlockBuilder.CloneBlock(Blocks.DEEPSLATE_COPPER_ORE).mapColor(DyeColor.GRAY).requiresTool());
    public static final Block TIN_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.COPPER_ORE).mapColor(DyeColor.GRAY).requiresTool());
    public static final Block RAW_TIN_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.RAW_COPPER_BLOCK).mapColor(DyeColor.GRAY).requiresTool());
    
    public static final Item TIN_INGOT = new Item(new FabricItemSettings());
    public static final Item TIN_NUGGET = new Item(new FabricItemSettings());
    public static final Item RAW_TIN = new Item(new FabricItemSettings());
    
    public static void RegisterAll() {

        Tin.RegisterBlocks();
        Tin.RegisterBlockItems();
        Tin.RegisterItems();
        Tin.GroupItems();

    }


    public static void RegisterBlocks() {

        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "tin_ore"), TIN_ORE);
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "deepslate_tin_ore"), DEEPSLATE_TIN_ORE);
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "tin_block"), TIN_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "raw_tin_block"), RAW_TIN_BLOCK);

    }

    public static void RegisterBlockItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "deepslate_tin_ore"), new BlockItem(DEEPSLATE_TIN_ORE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_ore"), new BlockItem(TIN_ORE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_block"), new BlockItem(TIN_BLOCK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "raw_tin_block"), new BlockItem(RAW_TIN_BLOCK, new FabricItemSettings()));
        
    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_ingot"), TIN_INGOT);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_nugget"), TIN_NUGGET);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "raw_tin"), RAW_TIN);

    }

    public static void GroupItems() {

        ItemGrouper.GroupItem(TIN_INGOT, new ItemGrouped[]{new ItemGrouped(ItemGroups.INGREDIENTS, BRONZE_INGOT)});
        ItemGrouper.GroupItem(TIN_NUGGET, new ItemGrouped[]{new ItemGrouped(ItemGroups.INGREDIENTS, BRONZE_NUGGET)});
        ItemGrouper.GroupItem(RAW_TIN, new ItemGrouped[]{new ItemGrouped(ItemGroups.INGREDIENTS, RAW_BRONZE)});
        ItemGrouper.GroupItem(TIN_ORE, new ItemGrouped[]{new ItemGrouped(ItemGroups.NATURAL, Blocks.IRON_ORE)});
        ItemGrouper.GroupItem(DEEPSLATE_TIN_ORE, new ItemGrouped[]{new ItemGrouped(ItemGroups.NATURAL, Blocks.DEEPSLATE_IRON_ORE)});
        ItemGrouper.GroupItem(RAW_TIN_BLOCK, new ItemGrouped[]{new ItemGrouped(ItemGroups.NATURAL, RAW_BRONZE_BLOCK)});
        ItemGrouper.GroupItem(TIN_BLOCK, new ItemGrouped[]{new ItemGrouped(ItemGroups.BUILDING_BLOCKS, BRONZE_BLOCK)});

    }
}