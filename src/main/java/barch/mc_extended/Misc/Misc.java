package barch.mc_extended.Misc;

public class Misc {

    public static final Misc INSTANCE = new Misc();

    public static final FishBuckets FISH_BUCKETS = new FishBuckets();
    public static final OtherMisc OTHER_MISC = new OtherMisc();

    public static void RegisterAll() {

        FISH_BUCKETS.RegisterAll();
        OTHER_MISC.RegisterAll();

    }
}
