package barch.mc_extended.Foods;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;
import static barch.mc_extended.MCExtended.NAMESPACE;

public class Meats {

    public static final Meats INSTANCE = new Meats();

    // trout
    public static final Item TROUT = new Item(new FabricItemSettings().food(FoodComponents.SALMON));
    public static final Item COOKED_TROUT = new Item(new FabricItemSettings().food(FoodComponents.COOKED_SALMON));


    public static void RegisterAll() {

        // trout
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "trout"), TROUT);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "cooked_trout"), COOKED_TROUT);

        GroupItems();

    }
    public static void GroupItems() {


        // trout
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TROUT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.SALMON, TROUT);
        });
        // cooked trout
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(COOKED_TROUT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.COOKED_SALMON, COOKED_TROUT);
        });

    }

}
