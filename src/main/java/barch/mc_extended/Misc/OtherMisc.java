package barch.mc_extended.Misc;

import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Glue.ItemGrouped;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.NAMESPACE;

public class OtherMisc {

    public static final Item ENDER_CREAM = new Item(new FabricItemSettings());

    public static void RegisterAll() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ender_cream"), ENDER_CREAM);

        GroupItems();
    }

    public static void GroupItems() {

        ItemGrouper.GroupItem(ENDER_CREAM, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, Items.MAGMA_CREAM)});

    }
}
