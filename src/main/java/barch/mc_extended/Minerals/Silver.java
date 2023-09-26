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

public class Silver {

    public static final Block SILVER_ORE = new Block(BlockBuilder.CloneBlock(Blocks.GOLD_ORE).mapColor(DyeColor.LIGHT_GRAY).requiresTool());
    public static final Block DEEPSLATE_SILVER_ORE = new Block(BlockBuilder.CloneBlock(Blocks.DEEPSLATE_GOLD_ORE).mapColor(DyeColor.GRAY).requiresTool());
    public static final Block SILVER_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.GOLD_BLOCK).mapColor(DyeColor.WHITE).requiresTool());
    public static final Block RAW_SILVER_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.RAW_GOLD_BLOCK).mapColor(DyeColor.WHITE).requiresTool());

    public static final Item SILVER_INGOT = new Item(new FabricItemSettings());
    public static final Item SILVER_NUGGET = new Item(new FabricItemSettings());
    public static final Item RAW_SILVER = new Item(new FabricItemSettings());

    public static void RegisterAll() {

        Silver.RegisterBlocks();
        Silver.RegisterBlockItems();
        Silver.RegisterItems();
        Silver.GroupItems();

    }

    public static void RegisterBlocks() {

        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "silver_ore"), SILVER_ORE);
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "deepslate_silver_ore"), DEEPSLATE_SILVER_ORE);
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "silver_block"), SILVER_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "raw_silver_block"), RAW_SILVER_BLOCK);

    }

    public static void RegisterBlockItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "deepslate_silver_ore"), new BlockItem(DEEPSLATE_SILVER_ORE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_ore"), new BlockItem(SILVER_ORE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_block"), new BlockItem(SILVER_BLOCK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "raw_silver_block"), new BlockItem(RAW_SILVER_BLOCK, new FabricItemSettings()));

    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_ingot"), SILVER_INGOT);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_nugget"), SILVER_NUGGET);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "raw_silver"), RAW_SILVER);

    }

    public static void GroupItems() {

        ItemGrouper.GroupItem(SILVER_INGOT, new ItemGrouped[]{new ItemGrouped(ItemGroups.INGREDIENTS, Items.GOLD_INGOT)});
        ItemGrouper.GroupItem(SILVER_NUGGET, new ItemGrouped[]{new ItemGrouped(ItemGroups.INGREDIENTS, Items.GOLD_NUGGET)});
        ItemGrouper.GroupItem(RAW_SILVER, new ItemGrouped[]{new ItemGrouped(ItemGroups.INGREDIENTS, Items.RAW_GOLD)});
        ItemGrouper.GroupItem(SILVER_ORE, new ItemGrouped[]{new ItemGrouped(ItemGroups.NATURAL, Blocks.DEEPSLATE_GOLD_ORE)});
        ItemGrouper.GroupItem(DEEPSLATE_SILVER_ORE, new ItemGrouped[]{new ItemGrouped(ItemGroups.NATURAL, SILVER_ORE)});
        ItemGrouper.GroupItem(RAW_SILVER_BLOCK, new ItemGrouped[]{new ItemGrouped(ItemGroups.NATURAL, Blocks.RAW_GOLD_BLOCK)});
        ItemGrouper.GroupItem(SILVER_BLOCK, new ItemGrouped[]{new ItemGrouped(ItemGroups.BUILDING_BLOCKS, Blocks.GOLD_BLOCK)});

    }
}