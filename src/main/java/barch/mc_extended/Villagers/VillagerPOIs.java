package barch.mc_extended.Villagers;


import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

import static barch.mc_extended.MCExtended.*;
import static barch.mc_extended.Villagers.WorkStations.BOTANY_TABLE;
import static barch.mc_extended.Villagers.WorkStations.GEM_TABLE;

public class VillagerPOIs {

    public static final VillagerPOIs INSTANCE = new VillagerPOIs();


    // initialize POIs

    // gem dealer
    public static PointOfInterestType GEM_DEALER_POI;
    // miner
    public static PointOfInterestType MINER_POI;
    // miner
    public static PointOfInterestType BOTANY_POI;


    public static void registerPOIs() {




        // register points of interest

        // gem dealer
        GEM_DEALER_POI = PointOfInterestHelper.register(new Identifier(NAMESPACE, "gem_dealer"), 1, 10, GEM_TABLE);

        // miner
        MINER_POI = PointOfInterestHelper.register(new Identifier(NAMESPACE, "miner"), 1, 50, Blocks.FURNACE);

        // miner
        BOTANY_POI = PointOfInterestHelper.register(new Identifier(NAMESPACE, "botanist"), 1, 50, BOTANY_TABLE);

    }
}
