package barch.mc_extended;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

import static barch.mc_extended.MCExtended.NAMESPACE;

public class Tags {

    public static class BiomeTags {


        public static final TagKey<Biome> RUBY_SPAWNS_IN = ofBiome(NAMESPACE,"ruby_spawns_in");
        public static final  TagKey<Biome> SAPPHIRE_SPAWNS_IN = ofBiome(NAMESPACE,"sapphire_spawns_in");
        public static final  TagKey<Biome> LOSTS_SPAWN_IN = ofBiome(NAMESPACE,"losts_spawn_in");

        public static final  TagKey<Biome> WHITE_MUSHROOMS_SPAWN_IN = ofBiome(NAMESPACE,"white_mushrooms_spawn_in");


    }

    private static TagKey<Biome> ofBiome(String namespace, String path) {
        return TagKey.of(RegistryKeys.BIOME, new Identifier(namespace, path));
    }
    private static TagKey<Block> ofBlock(String namespace, String path) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(namespace, path));
    }
    private static TagKey<Item> ofItem(String namespace, String path) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(namespace, path));
    }

}
