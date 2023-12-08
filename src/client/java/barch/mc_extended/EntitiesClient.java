package barch.mc_extended;

import barch.mc_extended.Entities.EnderCube;
import barch.mc_extended.Entities.Lost;
import barch.mc_extended.Entities.SilverGolem;
import barch.mc_extended.Entities.TroutFish;

public class EntitiesClient {


    public static void registerClient() {

        Lost.registerClient();
        TroutFish.registerClient();
        SilverGolem.registerClient();
        EnderCube.registerClient();

    }

}
