package barch.mc_extended.Villagers;

import com.google.common.collect.ImmutableSet;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;

import static barch.mc_extended.MCExtended.*;

public class VillagerProfessions {

    public static VillagerProfession GEM_DEALER;
    public static VillagerProfession MINER;
    public static VillagerProfession BOTANIST;

    public static void registerProfessions() {
        GEM_DEALER = Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(NAMESPACE, "gem_dealer"),
                new VillagerProfession("gem_dealer", holder -> holder.value().equals(VillagerPOIs.GEM_DEALER_POI), holder -> holder.value().equals(VillagerPOIs.GEM_DEALER_POI),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_CARTOGRAPHER));

        MINER = Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(NAMESPACE, "miner"),
                new VillagerProfession("miner", holder -> holder.value().equals(VillagerPOIs.MINER_POI), holder -> holder.value().equals(VillagerPOIs.MINER_POI),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_ARMORER));

        BOTANIST = Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(NAMESPACE, "botanist"),
                new VillagerProfession("botanist", holder -> holder.value().equals(VillagerPOIs.BOTANY_POI), holder -> holder.value().equals(VillagerPOIs.BOTANY_POI),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_FARMER));

    }

}
