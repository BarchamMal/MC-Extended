package barch.mc_extended.Foods;

import barch.mc_extended.Glue.BlockBuilder;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Glue.ItemGrouped;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CakeBlock;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.*;

public class Cheese {

    public static final Block CHEESE = new CakeBlock(BlockBuilder.CloneBlock(Blocks.CAKE));

    public static void RegisterAll() {

        Registry.register(Registries.BLOCK, Identifier.of(NAMESPACE, "cheese"), CHEESE);

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "cheese"), new BlockItem(CHEESE, new Item.Settings()));

    };

    public static void GroupItems() {

        ItemGrouper.GroupItem(CHEESE.asItem(), new ItemGrouped[]{new ItemGrouped(ItemGroups.FOOD_AND_DRINK, Items.CAKE)});


    }

}
