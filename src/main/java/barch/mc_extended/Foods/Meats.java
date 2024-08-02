package barch.mc_extended.Foods;

import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.barch.barch_lib.Items.ItemGroupItem;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class Meats {

    public static final Item TROUT = new Item(new Item.Settings().food(FoodComponents.SALMON));
    public static final Item COOKED_TROUT = new Item(new Item.Settings().food(FoodComponents.COOKED_SALMON));

    public static void RegisterAll() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "trout"), TROUT);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "cooked_trout"), COOKED_TROUT);


    }
    public static void GroupItems() {

        MCE_ITEM_GROUPER.GroupItem(TROUT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, Items.COOKED_SALMON)});
        MCE_ITEM_GROUPER.GroupItem(COOKED_TROUT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, TROUT)});

    }

}
