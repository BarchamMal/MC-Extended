package barch.mc_extended.Minerals;

import barch.mc_extended.Glue.BlockBuilder;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Glue.ItemGrouped;
//import barch.mc_extended.Misc.PlantSpecimenItem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.*;

public class Bronze {

    public static final Block BRONZE_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.IRON_BLOCK).requiresTool());
    public static final Block RAW_BRONZE_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.RAW_IRON_BLOCK).requiresTool());

    public static final Item BRONZE_INGOT = new Item(new Item.Settings());
    public static final Item BRONZE_NUGGET = new Item(new Item.Settings());
    public static final Item RAW_BRONZE = new Item(new Item.Settings());

    public static void RegisterAll() {

        Bronze.RegisterBlocks();
        Bronze.RegisterBlockItems();
        Bronze.RegisterItems();
        Bronze.GroupItems();

    }

    public static void RegisterBlocks() {

        Registry.register(Registries.BLOCK, Identifier.of(NAMESPACE, "bronze_block"), BRONZE_BLOCK);
        Registry.register(Registries.BLOCK, Identifier.of(NAMESPACE, "raw_bronze_block"), RAW_BRONZE_BLOCK);

    }

    public static void RegisterBlockItems() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "bronze_block"), new BlockItem(BRONZE_BLOCK, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "raw_bronze_block"), new BlockItem(RAW_BRONZE_BLOCK, new Item.Settings()));

    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "bronze_ingot"), BRONZE_INGOT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "bronze_nugget"), BRONZE_NUGGET);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "raw_bronze"), RAW_BRONZE);

    }

    public static void GroupItems() {

        ItemGrouper.GroupItem(BRONZE_INGOT, new ItemGrouped[]{new ItemGrouped(ItemGroups.INGREDIENTS, Items.IRON_INGOT)});
        ItemGrouper.GroupItem(BRONZE_NUGGET, new ItemGrouped[]{new ItemGrouped(ItemGroups.INGREDIENTS, Items.IRON_NUGGET)});
        ItemGrouper.GroupItem(RAW_BRONZE, new ItemGrouped[]{new ItemGrouped(ItemGroups.INGREDIENTS, Items.RAW_IRON)});
        ItemGrouper.GroupItem(RAW_BRONZE_BLOCK, new ItemGrouped[]{new ItemGrouped(ItemGroups.NATURAL, Blocks.RAW_IRON_BLOCK)});
        ItemGrouper.GroupItem(BRONZE_BLOCK, new ItemGrouped[]{new ItemGrouped(ItemGroups.BUILDING_BLOCKS, Blocks.IRON_BLOCK)});

    }
}