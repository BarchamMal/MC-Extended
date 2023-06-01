package barch.mc_extended.Villagers;

import barch.mc_extended.MCExtended;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

public class VillagerPOIs {

    public static final VillagerPOIs INSTANCE = new VillagerPOIs();


    // initialize POIs

    // gem dealer
    public static PointOfInterestType GEM_DEALER_POI;


    public static void registerPOIs() {




        // register points of interest

        // gem dealer
        GEM_DEALER_POI = PointOfInterestHelper.register(new Identifier("mc-extended", "gem_dealer"), 1, 10, MCExtended.GEM_TABLE);

    }
}
