package barch.mc_extended.Misc;

import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.barch.barch_lib.Items.ItemGroupItem;
import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class OtherMisc {

    public static final ComponentType<String> FLOWER_COMPONENT_TYPE = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(MC_EXTENDED, "flower_component_type"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final Item ENDER_CREAM = new Item(new Item.Settings());

    public static void RegisterAll() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "ender_cream"), ENDER_CREAM);

        GroupItems();
    }

    public static void GroupItems() {

        MCE_ITEM_GROUPER.GroupItem(ENDER_CREAM, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, Items.MAGMA_CREAM)});

    }
}
