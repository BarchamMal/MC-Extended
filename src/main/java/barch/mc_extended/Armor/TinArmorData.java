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

import static barch.mc_extended.Armor.BronzeArmorData.BRONZE_BOOTS;
import static barch.mc_extended.Armor.BronzeArmorData.BRONZE_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.*;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class TinArmorData {
    
    public static final ArmorMaterial TIN = new ArmorMaterial(10,
            (Map) Util.make(new EnumMap(EquipmentType.class), (map) -> {
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
            Tags.EaKeys.TIN_KEY)
            ;

    public static final Item TIN_HELMET = new ArmorItem(TIN, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item TIN_CHESTPLATE = new ArmorItem(TIN, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item TIN_LEGGINGS = new ArmorItem(TIN, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item TIN_BOOTS = new ArmorItem(TIN, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item TIN_HORSE_ARMOR = new AnimalArmorItem(TIN, EQUESTRIAN, new Item.Settings().maxCount(1));


    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "tin_helmet"), TIN_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "tin_chestplate"), TIN_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "tin_leggings"), TIN_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "tin_boots"), TIN_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "tin_horse_armor"), TIN_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        MCE_ITEM_GROUPER.GroupItem(TIN_HELMET, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, BRONZE_BOOTS)});
        MCE_ITEM_GROUPER.GroupItem(TIN_CHESTPLATE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, TIN_HELMET)});
        MCE_ITEM_GROUPER.GroupItem(TIN_LEGGINGS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, TIN_CHESTPLATE)});
        MCE_ITEM_GROUPER.GroupItem(TIN_BOOTS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, TIN_LEGGINGS)});
        MCE_ITEM_GROUPER.GroupItem(TIN_HORSE_ARMOR, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, BRONZE_HORSE_ARMOR)});

    }
}