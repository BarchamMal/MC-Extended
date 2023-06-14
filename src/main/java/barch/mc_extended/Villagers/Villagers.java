package barch.mc_extended.Villagers;

import barch.mc_extended.Villagers.VillagerPOIs;
import barch.mc_extended.Villagers.VillagerProfessions;
import barch.mc_extended.Villagers.VillagerTrades;

public class Villagers {

    public static final Villagers INSTANCE = new Villagers();


    public static void RegisterAll() {

        // register villager POIs
        VillagerPOIs.registerPOIs();
        // register villager professions
        VillagerProfessions.registerProfessions();
        // register villager trades
        VillagerTrades.RegisterTrades();

    };


}
