package barch.mc_extended.Misc;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static barch.mc_extended.Entities.Entities.TROUT_FISH;
import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;
import static barch.mc_extended.MCExtended.NAMESPACE;

public class OtherMisc {

    public static final OtherMisc INSTANCE = new OtherMisc();

    // trout bucket
    public static final Item ENDER_CREAM = new Item(new FabricItemSettings());



    public static void RegisterAll() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ender_cream"), ENDER_CREAM);

        GroupItems();
    }

    public static void GroupItems() {

        // ender cream
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(ENDER_CREAM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.MAGMA_CREAM, ENDER_CREAM);
        });
    }
}
