package barch.mc_extended;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

import static barch.mc_extended.MCExtended.MC_EXTENDED;
import static net.minecraft.item.equipment.EquipmentAssetKeys.REGISTRY_KEY;

public class Tags {

    public static class BiomeTags {

        public static final TagKey<Biome> RUBY_SPAWNS_IN = ofBiome(MC_EXTENDED,"ruby_spawns_in");
        public static final  TagKey<Biome> SAPPHIRE_SPAWNS_IN = ofBiome(MC_EXTENDED,"sapphire_spawns_in");
        public static final  TagKey<Biome> LOSTS_SPAWN_IN = ofBiome(MC_EXTENDED,"losts_spawn_in");

        public static final  TagKey<Biome> WHITE_MUSHROOMS_SPAWN_IN = ofBiome(MC_EXTENDED,"white_mushrooms_spawn_in");


    }

    public static class ItemTags {

        public static final TagKey<Item> BRONZE_REPAIRS = ofItem(MC_EXTENDED, "bronze_repairs");
        public static final TagKey<Item> COPPER_REPAIRS = ofItem(MC_EXTENDED, "copper_repairs");
        public static final TagKey<Item> CORUNDUM_REPAIRS = ofItem(MC_EXTENDED, "corundum_repairs");
        public static final TagKey<Item> RUBY_REPAIRS = ofItem(MC_EXTENDED, "ruby_repairs");
        public static final TagKey<Item> SAPPHIRE_REPAIRS = ofItem(MC_EXTENDED, "sapphire_repairs");
        public static final TagKey<Item> SILVER_REPAIRS = ofItem(MC_EXTENDED, "silver_repairs");
        public static final TagKey<Item> TIN_REPAIRS = ofItem(MC_EXTENDED, "tin_repairs");

    }

    public static class EaKeys {

        public static final RegistryKey<EquipmentAsset> BRONZE_KEY = registerEaKey("bronze");
        public static final RegistryKey<EquipmentAsset> COPPER_KEY = registerEaKey("copper");
        public static final RegistryKey<EquipmentAsset> CORUNDUM_KEY = registerEaKey("corundum");
        public static final RegistryKey<EquipmentAsset> RUBY_KEY = registerEaKey("ruby");
        public static final RegistryKey<EquipmentAsset> SAPPHIRE_KEY = registerEaKey("sapphire");
        public static final RegistryKey<EquipmentAsset> SILVER_KEY = registerEaKey("silver");
        public static final RegistryKey<EquipmentAsset> TIN_KEY = registerEaKey("tin");

    }

    static RegistryKey<EquipmentAsset> registerEaKey(String name) {
        return RegistryKey.of(REGISTRY_KEY, Identifier.ofVanilla(name));
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
