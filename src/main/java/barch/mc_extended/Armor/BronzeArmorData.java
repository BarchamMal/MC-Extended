package barch.mc_extended.Armor;

import barch.mc_extended.Tags;
import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.Map;

import static barch.mc_extended.MCExtended.*;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class BronzeArmorData {

    public static final ArmorMaterial BRONZE = new ArmorMaterial(10,
        (Map)Util.make(new EnumMap(EquipmentType.class), (map) -> {
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
        Tags.EaKeys.BRONZE_KEY)
    ;

    public static final Item BRONZE_HELMET = new ArmorItem(BRONZE, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item BRONZE_CHESTPLATE = new ArmorItem(BRONZE, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item BRONZE_LEGGINGS = new ArmorItem(BRONZE, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item BRONZE_BOOTS = new ArmorItem(BRONZE, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item BRONZE_HORSE_ARMOR = new AnimalArmorItem(BRONZE, EQUESTRIAN, new Item.Settings().maxCount(1));


    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "bronze_helmet"), BRONZE_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "bronze_chestplate"), BRONZE_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "bronze_leggings"), BRONZE_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "bronze_boots"), BRONZE_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "bronze_horse_armor"), BRONZE_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        MCE_ITEM_GROUPER.GroupItem(BRONZE_HELMET, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, Items.IRON_BOOTS)});
        MCE_ITEM_GROUPER.GroupItem(BRONZE_CHESTPLATE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, BRONZE_HELMET)});
        MCE_ITEM_GROUPER.GroupItem(BRONZE_LEGGINGS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, BRONZE_CHESTPLATE)});
        MCE_ITEM_GROUPER.GroupItem(BRONZE_BOOTS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, BRONZE_LEGGINGS)});
        MCE_ITEM_GROUPER.GroupItem(BRONZE_HORSE_ARMOR, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, Items.IRON_HORSE_ARMOR)});

    }
}