package barch.mc_extended.Misc;

import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Glue.ItemGrouped;
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
import static barch.mc_extended.MCExtended.NAMESPACE;

public class FishBuckets {

    public static final Item TROUT_BUCKET = new EntityBucketItem(TROUT_FISH, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings());

    public static void RegisterAll() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "trout_bucket"), TROUT_BUCKET);

        GroupItems();
    }

    public static void GroupItems() {

        ItemGrouper.GroupItem(TROUT_BUCKET, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, Items.SALMON_BUCKET)});

    }
}
