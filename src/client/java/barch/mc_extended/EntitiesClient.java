package barch.mc_extended;

public class EntitiesClient {

    public static final EntitiesClient INSTANCE = new EntitiesClient();

    public static final Lost LOST = Lost.INSTANCE;
    public static final TroutFish TROUT_FISH = TroutFish.INSTANCE;

    public static void registerClient() {

        LOST.registerClient();
        TROUT_FISH.registerClient();

    }

}
