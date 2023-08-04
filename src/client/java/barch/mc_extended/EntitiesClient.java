package barch.mc_extended;

import barch.mc_extended.Entities.EnderCube;
import barch.mc_extended.Entities.Lost;
import barch.mc_extended.Entities.SilverGolem;
import barch.mc_extended.Entities.TroutFish;

public class EntitiesClient {

    public static final EntitiesClient INSTANCE = new EntitiesClient();

    public static final Lost LOST = Lost.INSTANCE;
    public static final TroutFish TROUT_FISH = TroutFish.INSTANCE;
    public static final SilverGolem SILVER_GOLEM = SilverGolem.INSTANCE;
    public static final EnderCube ENDER_CUBE = EnderCube.INSTANCE;

    public static void registerClient() {

        LOST.registerClient();
        TROUT_FISH.registerClient();
        SILVER_GOLEM.registerClient();
        ENDER_CUBE.registerClient();

    }

}
