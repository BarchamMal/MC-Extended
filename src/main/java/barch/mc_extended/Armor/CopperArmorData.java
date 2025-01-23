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

import static barch.mc_extended.Armor.SilverArmorData.SILVER_BOOTS;
import static barch.mc_extended.Armor.SilverArmorData.SILVER_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.*;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class CopperArmorData {

    public static final ArmorMaterial COPPER = new ArmorMaterial(8,
            (Map) Util.make(new EnumMap(EquipmentType.class), (map) -> {
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
            Tags.EaKeys.COPPER_KEY)
            ;

    public static final Item COPPER_HELMET = new ArmorItem(COPPER, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item COPPER_CHESTPLATE = new ArmorItem(COPPER, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item COPPER_LEGGINGS = new ArmorItem(COPPER, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item COPPER_BOOTS = new ArmorItem(COPPER, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item COPPER_HORSE_ARMOR = new AnimalArmorItem(COPPER, EQUESTRIAN, new Item.Settings().maxCount(1));


    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "copper_helmet"), COPPER_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "copper_chestplate"), COPPER_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "copper_leggings"), COPPER_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "copper_boots"), COPPER_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "copper_horse_armor"), COPPER_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        MCE_ITEM_GROUPER.GroupItem(COPPER_HELMET, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, SILVER_BOOTS)});
        MCE_ITEM_GROUPER.GroupItem(COPPER_CHESTPLATE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, COPPER_HELMET)});
        MCE_ITEM_GROUPER.GroupItem(COPPER_LEGGINGS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, COPPER_CHESTPLATE)});
        MCE_ITEM_GROUPER.GroupItem(COPPER_BOOTS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, COPPER_LEGGINGS)});
        MCE_ITEM_GROUPER.GroupItem(COPPER_HORSE_ARMOR, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, SILVER_HORSE_ARMOR)});

    }
}