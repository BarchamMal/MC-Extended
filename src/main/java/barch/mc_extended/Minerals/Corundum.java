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
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.NAMESPACE;

public class Corundum {

    public static final Block CORUNDUM_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.IRON_BLOCK).requiresTool());

    public static final Item CORUNDUM = new Item(new FabricItemSettings());

    public static void RegisterAll() {

        Corundum.RegisterBlocks();
        Corundum.RegisterBlockItems();
        Corundum.RegisterItems();
        Corundum.GroupItems();

    }

    public static void RegisterBlocks() {

        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "corundum_block"), CORUNDUM_BLOCK);

    }

    public static void RegisterBlockItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_block"), new BlockItem(CORUNDUM_BLOCK, new FabricItemSettings()));

    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum"), CORUNDUM);

    }

    public static void GroupItems() {

        ItemGrouper.GroupItem(CORUNDUM, new ItemGrouped[]{new ItemGrouped(ItemGroups.INGREDIENTS, Items.NETHERITE_INGOT)});
        ItemGrouper.GroupItem(CORUNDUM_BLOCK, new ItemGrouped[]{new ItemGrouped(ItemGroups.BUILDING_BLOCKS, Blocks.NETHERITE_BLOCK)});

    }
}