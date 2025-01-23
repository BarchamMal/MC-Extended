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

import java.util.EnumMap;
import java.util.Map;

import net.minecraft.util.Util;

import static barch.mc_extended.MCExtended.MC_EXTENDED;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class SilverArmorData {

    public static final ArmorMaterial SILVER = new ArmorMaterial(14,
            (Map) Util.make(new EnumMap(EquipmentType.class), (map) -> {
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
            Tags.EaKeys.SILVER_KEY)
            ;

    public static final Item SILVER_HELMET = new ArmorItem(SILVER, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item SILVER_CHESTPLATE = new ArmorItem(SILVER, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item SILVER_LEGGINGS = new ArmorItem(SILVER, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item SILVER_BOOTS = new ArmorItem(SILVER, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item SILVER_HORSE_ARMOR = new AnimalArmorItem(SILVER, EQUESTRIAN, new Item.Settings().maxCount(1));

    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "silver_helmet"), SILVER_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "silver_chestplate"), SILVER_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "silver_leggings"), SILVER_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "silver_boots"), SILVER_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "silver_horse_armor"), SILVER_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        MCE_ITEM_GROUPER.GroupItem(SILVER_HELMET, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, Items.GOLDEN_BOOTS)});
        MCE_ITEM_GROUPER.GroupItem(SILVER_CHESTPLATE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, SILVER_HELMET)});
        MCE_ITEM_GROUPER.GroupItem(SILVER_LEGGINGS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, SILVER_CHESTPLATE)});
        MCE_ITEM_GROUPER.GroupItem(SILVER_BOOTS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, SILVER_LEGGINGS)});
        MCE_ITEM_GROUPER.GroupItem(SILVER_HORSE_ARMOR, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, Items.GOLDEN_HORSE_ARMOR)});

    }

}