package barch.mc_extended.Foods;

import net.barch.barch_lib.Blocks.BlockBuilder;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.barch.barch_lib.Items.ItemGroupItem;
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

        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "cheese"), CHEESE);

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "cheese"), new BlockItem(CHEESE, new Item.Settings()));

    };

    public static void GroupItems() {

        MCE_ITEM_GROUPER.GroupItem(CHEESE.asItem(), new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, Items.CAKE)});


    }

}
