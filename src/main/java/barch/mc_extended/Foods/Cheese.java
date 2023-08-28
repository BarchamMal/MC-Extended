package barch.mc_extended.Foods;

import barch.mc_extended.Glue.BlockBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CakeBlock;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.*;

public class Cheese {

    public static final Cheese INSTANCE = new Cheese();

    public static final Block CHEESE = new CakeBlock(BlockBuilder.CloneBlock(Blocks.CAKE));

    public static final FoodComponent BACON_AND_MUSHROOMS_FOOD_COMPONENT = new FoodComponent
            .Builder()
            .hunger(12)
            .saturationModifier(12)
            .build();

    public static final Item BACON_AND_MUSHROOMS = new StewItem(new FabricItemSettings().food(BACON_AND_MUSHROOMS_FOOD_COMPONENT));

    public static void RegisterAll() {

        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "cheese"), CHEESE);

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "cheese"), new BlockItem(CHEESE, new FabricItemSettings()));

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bacon_and_mushrooms"), BACON_AND_MUSHROOMS);

    };

    public static void GroupItems() {

        // cheese
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(CHEESE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.CAKE, CHEESE);
        });

        // bacon and mushrooms
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(BACON_AND_MUSHROOMS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.RABBIT_STEW, BACON_AND_MUSHROOMS);
        });

    };


}
