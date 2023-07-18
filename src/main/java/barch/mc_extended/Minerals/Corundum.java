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
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;

public class Corundum {

    public static final Corundum INSTANCE = new Corundum();


    // Initialize the blocks

    // corundum block
    public static final Block CORUNDUM_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.IRON_BLOCK).requiresTool());


    // Initialize the items
    // corundum 
    public static final Item CORUNDUM = new Item(new FabricItemSettings());

    


    public static void RegisterAll() {

        Corundum.RegisterBlocks();
        Corundum.RegisterBlockItems();
        Corundum.RegisterItems();
        Corundum.GroupItems();

    }

    public static void RegisterBlocks() {

        // corundum block
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "corundum_block"), CORUNDUM_BLOCK);


    }

    public static void RegisterBlockItems() {

        // corundum block
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "corundum_block"), new BlockItem(CORUNDUM_BLOCK, new FabricItemSettings()));


    }

    public static void RegisterItems() {

        // corundum 
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "corundum"), CORUNDUM);

    }

    public static void GroupItems() {



        // corundum 
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(CORUNDUM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.NETHERITE_INGOT, CORUNDUM);
        });
        
        // corundum block
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(CORUNDUM_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.NETHERITE_BLOCK, CORUNDUM_BLOCK);
        });


    }
}