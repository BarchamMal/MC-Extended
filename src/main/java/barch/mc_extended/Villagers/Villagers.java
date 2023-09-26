package barch.mc_extended.Villagers;


public class Villagers {

    public static void RegisterAll() {

        VillagerPOIs.registerPOIs();
        VillagerProfessions.registerProfessions();
        VillagerTrades.RegisterTrades();
        WorkStations.RegisterAll();

    };


}
