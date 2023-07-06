package barch.mc_extended.Villagers;

import barch.mc_extended.Glue.BlockBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;

public class WorkStations {

    // initialize the blocks

    // gem table
    public static final Block GEM_TABLE = new Block(BlockBuilder.CloneBlock(Blocks.FLETCHING_TABLE));

    // botany table
    public static final Block BOTANY_TABLE = new Block(BlockBuilder.CloneBlock(Blocks.FLETCHING_TABLE).nonOpaque());

    public static void RegisterBlocks() {

        // gem table
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "gem_table"), GEM_TABLE);

        // botany table
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "botany_table"), BOTANY_TABLE);
    };

    public static void RegisterAll() {
        RegisterBlocks();
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {

        // register the block-items

        // gem table
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "gem_table"), new BlockItem(GEM_TABLE, new FabricItemSettings()));
        // botany table
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "botany_table"), new BlockItem(BOTANY_TABLE, new FabricItemSettings()));

    }

    public static void GroupItems() {

        // gem table
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(GEM_TABLE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.addAfter(Items.FLETCHING_TABLE, GEM_TABLE);
        });

        // gem table
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(BOTANY_TABLE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.addAfter(GEM_TABLE, BOTANY_TABLE);
        });
    }


}
