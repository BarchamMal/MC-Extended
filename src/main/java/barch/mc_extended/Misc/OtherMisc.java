package barch.mc_extended.Misc;

import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Glue.ItemGrouped;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.component.ComponentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.NAMESPACE;

public class OtherMisc {

    public static final ComponentType<String> FLOWER_COMPONENT_TYPE = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(NAMESPACE, "flower_component_type"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final Item ENDER_CREAM = new Item(new Item.Settings());

    public static void RegisterAll() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "ender_cream"), ENDER_CREAM);

        GroupItems();
    }

    public static void GroupItems() {

        ItemGrouper.GroupItem(ENDER_CREAM, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, Items.MAGMA_CREAM)});

    }
}
