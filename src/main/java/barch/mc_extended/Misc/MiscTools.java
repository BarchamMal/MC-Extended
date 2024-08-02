package barch.mc_extended.Misc;

import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class MiscTools {
    public static final PlantSpecimenItem PLANT_SPECIMEN = new PlantSpecimenItem(new Item.Settings().maxDamage(36));

    public static void RegisterAll() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "plant_specimen"), PLANT_SPECIMEN);

        GroupItems();

    }

    public static void GroupItems() {

        MCE_ITEM_GROUPER.GroupItem(PLANT_SPECIMEN, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, Items.FLINT_AND_STEEL)});

    }
}
