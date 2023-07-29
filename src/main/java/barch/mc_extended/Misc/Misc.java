package barch.mc_extended.Misc;

public class Misc {

    public static final Misc INSTANCE = new Misc();

    // fish buckets

    public static final FishBuckets FISH_BUCKETS = FishBuckets.INSTANCE;

    public static void RegisterAll() {

        FISH_BUCKETS.RegisterAll();

    }
}
