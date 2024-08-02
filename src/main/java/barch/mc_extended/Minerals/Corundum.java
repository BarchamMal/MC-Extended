package barch.mc_extended.Minerals;

import net.barch.barch_lib.Blocks.BlockBuilder;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.barch.barch_lib.Items.ItemGroupItem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class Corundum {

    public static final Block CORUNDUM_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.IRON_BLOCK).requiresTool());

    public static final Item CORUNDUM = new Item(new Item.Settings());

    public static void RegisterAll() {

        Corundum.RegisterBlocks();
        Corundum.RegisterBlockItems();
        Corundum.RegisterItems();
        Corundum.GroupItems();

    }

    public static void RegisterBlocks() {

        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "corundum_block"), CORUNDUM_BLOCK);

    }

    public static void RegisterBlockItems() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "corundum_block"), new BlockItem(CORUNDUM_BLOCK, new Item.Settings()));

    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "corundum"), CORUNDUM);

    }

    public static void GroupItems() {

        MCE_ITEM_GROUPER.GroupItem(CORUNDUM, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, Items.NETHERITE_INGOT)});
        MCE_ITEM_GROUPER.GroupItem(CORUNDUM_BLOCK, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.BUILDING_BLOCKS, Blocks.NETHERITE_BLOCK)});

    }
}