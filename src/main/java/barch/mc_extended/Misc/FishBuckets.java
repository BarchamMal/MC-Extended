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

public class FishBuckets {

    public static final FishBuckets INSTANCE = new FishBuckets();

    // trout bucket
    public static final Item TROUT_BUCKET = new EntityBucketItem(TROUT_FISH, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new FabricItemSettings());



    public static void RegisterAll() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "trout_bucket"), TROUT_BUCKET);

        GroupItems();
    }

    public static void GroupItems() {

        // onion tomato sauce
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TROUT_BUCKET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.SALMON_BUCKET, TROUT_BUCKET);
        });
    }
}
