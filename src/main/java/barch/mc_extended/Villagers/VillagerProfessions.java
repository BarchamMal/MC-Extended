package barch.mc_extended.Villagers;

import com.google.common.collect.ImmutableSet;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;

public class VillagerProfessions {

    public static final VillagerProfessions INSTANCE = new VillagerProfessions();

    // initialize Professions

    // gem dealer
    public static VillagerProfession GEM_DEALER;
    public static void registerProfessions() {

        // register professions

        // gem dealer
        GEM_DEALER = Registry.register(Registries.VILLAGER_PROFESSION, new Identifier("mc-extended", "gem_dealer"),
                new VillagerProfession("gem_dealer", holder -> holder.value().equals(VillagerPOIs.GEM_DEALER_POI), holder -> holder.value().equals(VillagerPOIs.GEM_DEALER_POI),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_CARTOGRAPHER));




    }

}
