package barch.mc_extended.Minerals;

import net.barch.barch_lib.Blocks.BlockBuilder;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.barch.barch_lib.Items.ItemGroupItem;
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
    
    public static final Item TIN_INGOT = new Item(new Item.Settings());
    public static final Item TIN_NUGGET = new Item(new Item.Settings());
    public static final Item RAW_TIN = new Item(new Item.Settings());
    
    public static void RegisterAll() {

        Tin.RegisterBlocks();
        Tin.RegisterBlockItems();
        Tin.RegisterItems();
        Tin.GroupItems();

    }


    public static void RegisterBlocks() {

        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "tin_ore"), TIN_ORE);
        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "deepslate_tin_ore"), DEEPSLATE_TIN_ORE);
        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "tin_block"), TIN_BLOCK);
        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "raw_tin_block"), RAW_TIN_BLOCK);

    }

    public static void RegisterBlockItems() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "deepslate_tin_ore"), new BlockItem(DEEPSLATE_TIN_ORE, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "tin_ore"), new BlockItem(TIN_ORE, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "tin_block"), new BlockItem(TIN_BLOCK, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "raw_tin_block"), new BlockItem(RAW_TIN_BLOCK, new Item.Settings()));
        
    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "tin_ingot"), TIN_INGOT);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "tin_nugget"), TIN_NUGGET);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "raw_tin"), RAW_TIN);

    }

    public static void GroupItems() {

        MCE_ITEM_GROUPER.GroupItem(TIN_INGOT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, BRONZE_INGOT)});
        MCE_ITEM_GROUPER.GroupItem(TIN_NUGGET, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, BRONZE_NUGGET)});
        MCE_ITEM_GROUPER.GroupItem(RAW_TIN, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, RAW_BRONZE)});
        MCE_ITEM_GROUPER.GroupItem(TIN_ORE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.NATURAL, Blocks.IRON_ORE)});
        MCE_ITEM_GROUPER.GroupItem(DEEPSLATE_TIN_ORE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.NATURAL, Blocks.DEEPSLATE_IRON_ORE)});
        MCE_ITEM_GROUPER.GroupItem(RAW_TIN_BLOCK, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.NATURAL, RAW_BRONZE_BLOCK)});
        MCE_ITEM_GROUPER.GroupItem(TIN_BLOCK, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.BUILDING_BLOCKS, BRONZE_BLOCK)});

    }
}