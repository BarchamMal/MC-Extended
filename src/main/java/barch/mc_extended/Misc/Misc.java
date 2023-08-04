package barch.mc_extended.Misc;

public class Misc {

    public static final Misc INSTANCE = new Misc();

    // fish buckets
    public static final FishBuckets FISH_BUCKETS = FishBuckets.INSTANCE;

    // other misc
    public static final OtherMisc OTHER_MISC = OtherMisc.INSTANCE;

    public static void RegisterAll() {

        FISH_BUCKETS.RegisterAll();
        OTHER_MISC.RegisterAll();

    }
}
