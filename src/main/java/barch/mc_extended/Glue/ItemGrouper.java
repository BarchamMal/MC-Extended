package barch.mc_extended.Glue;

import barch.mc_extended.Misc.ItemGrouped;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;

public class ItemGrouper {

    public static void GroupItem(Item item, ItemGrouped[] groups) {

        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(item);
        });

        for (ItemGrouped group: groups) {

            ItemGroupEvents.modifyEntriesEvent(group.group).register(content -> {
                content.addAfter(group.getItem(), item);
            });
        }

    }

}
