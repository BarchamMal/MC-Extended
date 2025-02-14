package barch.mc_extended.Items;

import barch.mc_extended.MCExtended;
import barch.mc_extended.Tags;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.Map;

public class Armor {

    public static class EnumArmorMaterial {

        public ArmorMaterial armorMaterial;
        public MCExtended.Type type;

        public EnumArmorMaterial(int i, Map<EquipmentType, Integer> map, int j, RegistryEntry<SoundEvent> registryEntry, float f, float g, TagKey<Item> tagKey, RegistryKey<EquipmentAsset> registryKey, MCExtended.Type type) {
            this.armorMaterial = new ArmorMaterial(i, map, j, registryEntry, f, g, tagKey, registryKey);
            this.type = type;
        }
    }
    
    public static final EnumArmorMaterial BRONZE_AD = new EnumArmorMaterial(10,
            Util.make(new EnumMap(EquipmentType.class), (map) -> {
                map.put(EquipmentType.BOOTS, 2);
                map.put(EquipmentType.LEGGINGS, 5);
                map.put(EquipmentType.CHESTPLATE, 6);
                map.put(EquipmentType.HELMET, 2);
                map.put(EquipmentType.BODY, 4);
            }),
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            Tags.ItemTags.BRONZE_REPAIRS,
            Tags.EaKeys.BRONZE_KEY,
            MCExtended.Type.BRONZE)
            ;

    public static final EnumArmorMaterial COPPER_AD = new EnumArmorMaterial(8,
            Util.make(new EnumMap(EquipmentType.class), (map) -> {
                map.put(EquipmentType.BOOTS, 1);
                map.put(EquipmentType.LEGGINGS, 4);
                map.put(EquipmentType.CHESTPLATE, 5);
                map.put(EquipmentType.HELMET, 1);
                map.put(EquipmentType.BODY, 3);
            }),
            25,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.1F,
            Tags.ItemTags.COPPER_REPAIRS,
            Tags.EaKeys.COPPER_KEY,
            MCExtended.Type.COPPER)
            ;

    public static final EnumArmorMaterial CORUNDUM_AD = new EnumArmorMaterial(60,
            Util.make(new EnumMap(EquipmentType.class), (map) -> {
                map.put(EquipmentType.BOOTS, 4);
                map.put(EquipmentType.LEGGINGS, 8);
                map.put(EquipmentType.CHESTPLATE, 10);
                map.put(EquipmentType.HELMET, 4);
                map.put(EquipmentType.BODY, 13);
            }),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            4.0F,
            1.5F,
            Tags.ItemTags.CORUNDUM_REPAIRS,
            Tags.EaKeys.CORUNDUM_KEY,
            MCExtended.Type.CORUNDUM)
            ;

    public static final EnumArmorMaterial RUBY_AD = new EnumArmorMaterial(33,
            Util.make(new EnumMap(EquipmentType.class), (map) -> {
                map.put(EquipmentType.BOOTS, 3);
                map.put(EquipmentType.LEGGINGS, 8);
                map.put(EquipmentType.CHESTPLATE, 6);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 11);
            }),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            2.0F,
            0.0F,
            Tags.ItemTags.RUBY_REPAIRS,
            Tags.EaKeys.RUBY_KEY,
            MCExtended.Type.RUBY)
            ;

    public static final EnumArmorMaterial SAPPHIRE_AD = new EnumArmorMaterial(33,
            Util.make(new EnumMap(EquipmentType.class), (map) -> {
                map.put(EquipmentType.BOOTS, 3);
                map.put(EquipmentType.LEGGINGS, 8);
                map.put(EquipmentType.CHESTPLATE, 6);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 11);
            }),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            2.0F,
            0.0F,
            Tags.ItemTags.SAPPHIRE_REPAIRS,
            Tags.EaKeys.SAPPHIRE_KEY,
            MCExtended.Type.SAPPHIRE)
            ;

    public static final EnumArmorMaterial SILVER_AD = new EnumArmorMaterial(14,
            Util.make(new EnumMap(EquipmentType.class), (map) -> {
                map.put(EquipmentType.BOOTS, 4);
                map.put(EquipmentType.LEGGINGS, 8);
                map.put(EquipmentType.CHESTPLATE, 10);
                map.put(EquipmentType.HELMET, 4);
                map.put(EquipmentType.BODY, 13);
            }),
            20,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            4.0F,
            0.5F,
            Tags.ItemTags.SILVER_REPAIRS,
            Tags.EaKeys.SILVER_KEY,
            MCExtended.Type.SILVER)
            ;

    public static final EnumArmorMaterial TIN_AD = new EnumArmorMaterial(10,
            Util.make(new EnumMap(EquipmentType.class), (map) -> {
                map.put(EquipmentType.BOOTS, 1);
                map.put(EquipmentType.LEGGINGS, 4);
                map.put(EquipmentType.CHESTPLATE, 5);
                map.put(EquipmentType.HELMET, 1);
                map.put(EquipmentType.BODY, 3);
            }),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.1F,
            Tags.ItemTags.TIN_REPAIRS,
            Tags.EaKeys.TIN_KEY,
            MCExtended.Type.TIN)
            ;


}
