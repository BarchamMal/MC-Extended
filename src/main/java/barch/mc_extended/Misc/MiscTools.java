package barch.mc_extended.Misc;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
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

        ItemGrouper.GroupItem(PLANT_SPECIMEN, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, Items.FLINT_AND_STEEL)});

    }
}
