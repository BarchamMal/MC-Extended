package barch.mc_extended;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class Tags {

    public static class BiomeTags {


        public static final TagKey<Biome> RUBY_SPAWNS_IN = ofBiome(MC_EXTENDED,"ruby_spawns_in");
        public static final  TagKey<Biome> SAPPHIRE_SPAWNS_IN = ofBiome(MC_EXTENDED,"sapphire_spawns_in");
        public static final  TagKey<Biome> LOSTS_SPAWN_IN = ofBiome(MC_EXTENDED,"losts_spawn_in");

        public static final  TagKey<Biome> WHITE_MUSHROOMS_SPAWN_IN = ofBiome(MC_EXTENDED,"white_mushrooms_spawn_in");


    }

    private static TagKey<Biome> ofBiome(String namespace, String path) {
        return TagKey.of(RegistryKeys.BIOME, Identifier.of(namespace, path));
    }
    private static TagKey<Block> ofBlock(String namespace, String path) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(namespace, path));
    }
    private static TagKey<Item> ofItem(String namespace, String path) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(namespace, path));
    }

}
