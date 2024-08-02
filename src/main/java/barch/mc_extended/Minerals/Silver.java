package barch.mc_extended.Minerals;

import net.barch.barch_lib.Blocks.BlockBuilder;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.barch.barch_lib.Items.ItemGroupItem;
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

    public static final Item SILVER_INGOT = new Item(new Item.Settings());
    public static final Item SILVER_NUGGET = new Item(new Item.Settings());
    public static final Item RAW_SILVER = new Item(new Item.Settings());

    public static void RegisterAll() {

        Silver.RegisterBlocks();
        Silver.RegisterBlockItems();
        Silver.RegisterItems();
        Silver.GroupItems();

    }

    public static void RegisterBlocks() {

        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "silver_ore"), SILVER_ORE);
        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "deepslate_silver_ore"), DEEPSLATE_SILVER_ORE);
        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "silver_block"), SILVER_BLOCK);
        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "raw_silver_block"), RAW_SILVER_BLOCK);

    }

    public static void RegisterBlockItems() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "deepslate_silver_ore"), new BlockItem(DEEPSLATE_SILVER_ORE, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "silver_ore"), new BlockItem(SILVER_ORE, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "silver_block"), new BlockItem(SILVER_BLOCK, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "raw_silver_block"), new BlockItem(RAW_SILVER_BLOCK, new Item.Settings()));

    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "silver_ingot"), SILVER_INGOT);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "silver_nugget"), SILVER_NUGGET);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "raw_silver"), RAW_SILVER);

    }

    public static void GroupItems() {

        MCE_ITEM_GROUPER.GroupItem(SILVER_INGOT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, Items.GOLD_INGOT)});
        MCE_ITEM_GROUPER.GroupItem(SILVER_NUGGET, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, Items.GOLD_NUGGET)});
        MCE_ITEM_GROUPER.GroupItem(RAW_SILVER, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, Items.RAW_GOLD)});
        MCE_ITEM_GROUPER.GroupItem(SILVER_ORE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.NATURAL, Blocks.DEEPSLATE_GOLD_ORE)});
        MCE_ITEM_GROUPER.GroupItem(DEEPSLATE_SILVER_ORE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.NATURAL, SILVER_ORE)});
        MCE_ITEM_GROUPER.GroupItem(RAW_SILVER_BLOCK, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.NATURAL, Blocks.RAW_GOLD_BLOCK)});
        MCE_ITEM_GROUPER.GroupItem(SILVER_BLOCK, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.BUILDING_BLOCKS, Blocks.GOLD_BLOCK)});

    }
}