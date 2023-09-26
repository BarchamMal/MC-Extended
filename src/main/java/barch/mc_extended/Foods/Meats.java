package barch.mc_extended.Foods;

import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Glue.ItemGrouped;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.NAMESPACE;

public class Meats {

    public static final Item TROUT = new Item(new FabricItemSettings().food(FoodComponents.SALMON));
    public static final Item COOKED_TROUT = new Item(new FabricItemSettings().food(FoodComponents.COOKED_SALMON));

    public static void RegisterAll() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "trout"), TROUT);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "cooked_trout"), COOKED_TROUT);


    }
    public static void GroupItems() {

        ItemGrouper.GroupItem(TROUT, new ItemGrouped[]{new ItemGrouped(ItemGroups.FOOD_AND_DRINK, Items.COOKED_SALMON)});
        ItemGrouper.GroupItem(COOKED_TROUT, new ItemGrouped[]{new ItemGrouped(ItemGroups.FOOD_AND_DRINK, TROUT)});

    }

}
