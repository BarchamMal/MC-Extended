package barch.mc_extended.Villagers;


import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

import static barch.mc_extended.MCExtended.*;

public class VillagerPOIs {

    public static final VillagerPOIs INSTANCE = new VillagerPOIs();


    // initialize POIs

    // gem dealer
    public static PointOfInterestType GEM_DEALER_POI;
    // miner
    public static PointOfInterestType MINER_POI;


    public static void registerPOIs() {




        // register points of interest

        // gem dealer
        GEM_DEALER_POI = PointOfInterestHelper.register(new Identifier(NAMESPACE, "gem_dealer"), 1, 10, GEM_TABLE);

        // miner
        MINER_POI = PointOfInterestHelper.register(new Identifier(NAMESPACE, "miner"), 1, 50, Blocks.FURNACE);

    }
}
