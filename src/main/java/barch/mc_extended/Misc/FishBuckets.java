package barch.mc_extended.Misc;

import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.barch.barch_lib.Items.ItemGroupItem;
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
import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class FishBuckets {

    public static final Item TROUT_BUCKET = new EntityBucketItem(TROUT_FISH, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings());

    public static void RegisterAll() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "trout_bucket"), TROUT_BUCKET);

        GroupItems();
    }

    public static void GroupItems() {

        MCE_ITEM_GROUPER.GroupItem(TROUT_BUCKET, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, Items.SALMON_BUCKET)});

    }
}
