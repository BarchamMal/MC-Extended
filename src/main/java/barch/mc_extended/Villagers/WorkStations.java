package barch.mc_extended.Villagers;

import barch.mc_extended.Glue.BlockBuilder;
import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class WorkStations {

    public static final Block GEM_TABLE = new Block(BlockBuilder.CloneBlock(Blocks.FLETCHING_TABLE));
    public static final Block BOTANY_TABLE = new Block(BlockBuilder.CloneBlock(Blocks.FLETCHING_TABLE).nonOpaque().notSolid());

    public static void RegisterBlocks() {

        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "gem_table"), GEM_TABLE);
        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "botany_table"), BOTANY_TABLE);
    };

    public static void RegisterAll() {
        RegisterBlocks();
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "gem_table"), new BlockItem(GEM_TABLE, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "botany_table"), new BlockItem(BOTANY_TABLE, new Item.Settings()));

    }

    public static void GroupItems() {

        ItemGrouper.GroupItem(GEM_TABLE, new ItemGrouped[]{new ItemGrouped(ItemGroups.FUNCTIONAL, Items.FLETCHING_TABLE)});
        ItemGrouper.GroupItem(BOTANY_TABLE, new ItemGrouped[]{new ItemGrouped(ItemGroups.FUNCTIONAL, GEM_TABLE)});

    }


}
