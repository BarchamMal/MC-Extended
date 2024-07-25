package barch.mc_extended.Foods;

import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Glue.ItemGrouped;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.NAMESPACE;

public class Specialty {

    public static final FoodComponent ONION_SAUCE_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(9).saturationModifier(8f).build();
    public static final FoodComponent BACON_AND_MUSHROOMS_FOOD_COMPONENT = new FoodComponent.Builder().nutrition(12).saturationModifier(12).build();
    public static final FoodComponent CHEESY_SAAG_FOOD_COMPONENT = new FoodComponent.Builder().nutrition(18).saturationModifier(20).build();

    public static final Item ONION_TOMATO_SAUCE = new ContainedFood(new Item.Settings().food(ONION_SAUCE_FOOD_COMPONANT), Items.BOWL);
    public static final Item BACON_AND_MUSHROOMS = new ContainedFood(new Item.Settings().food(BACON_AND_MUSHROOMS_FOOD_COMPONENT).maxCount(16), Items.BOWL);
    public static final Item CHEESY_SAAG = new ContainedFood(new Item.Settings().food(CHEESY_SAAG_FOOD_COMPONENT).maxCount(16), Items.BOWL);


    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }
    public static void GroupItems() {

        ItemGrouper.GroupItem(ONION_TOMATO_SAUCE, new ItemGrouped[]{new ItemGrouped(ItemGroups.FOOD_AND_DRINK, Items.RABBIT_STEW)});
        ItemGrouper.GroupItem(BACON_AND_MUSHROOMS, new ItemGrouped[]{new ItemGrouped(ItemGroups.FOOD_AND_DRINK, ONION_TOMATO_SAUCE)});
        ItemGrouper.GroupItem(CHEESY_SAAG, new ItemGrouped[]{new ItemGrouped(ItemGroups.FOOD_AND_DRINK, BACON_AND_MUSHROOMS)});

    }

    public static void RegisterItems() {
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "onion_tomato_sauce"), ONION_TOMATO_SAUCE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "bacon_and_mushrooms"), BACON_AND_MUSHROOMS);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "cheesy_saag"), CHEESY_SAAG);

    }


}
