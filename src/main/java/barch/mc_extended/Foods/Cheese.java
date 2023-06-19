package barch.mc_extended.Foods;

import barch.mc_extended.Glue.BlockBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CakeBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;

public class Cheese {

    public static final Cheese INSTANCE = new Cheese();

    public static final Block CHEESE = new CakeBlock(BlockBuilder.CloneBlock(Blocks.CAKE));

    public static void RegisterAll() {

        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "cheese"), CHEESE);

        Registry.register(Registries.ITEM, new Identifier("mc-extended", "cheese"), new BlockItem(CHEESE, new FabricItemSettings()));

    };

    public static void GroupItems() {

        // cheese
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(CHEESE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.CAKE, CHEESE);
        });

    };


}
