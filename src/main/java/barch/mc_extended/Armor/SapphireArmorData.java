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

import static barch.mc_extended.Armor.RubyArmorData.RUBY_BOOTS;
import static barch.mc_extended.Armor.RubyArmorData.RUBY_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.*;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class SapphireArmorData {

    public static final ArmorMaterial SAPPHIRE = new ArmorMaterial(33,
            (Map) Util.make(new EnumMap(EquipmentType.class), (map) -> {
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
            Tags.EaKeys.SAPPHIRE_KEY)
            ;

    public static final Item SAPPHIRE_HELMET = new ArmorItem(SAPPHIRE, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item SAPPHIRE_CHESTPLATE = new ArmorItem(SAPPHIRE, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item SAPPHIRE_LEGGINGS = new ArmorItem(SAPPHIRE, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item SAPPHIRE_BOOTS = new ArmorItem(SAPPHIRE, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item SAPPHIRE_HORSE_ARMOR = new AnimalArmorItem(SAPPHIRE, EQUESTRIAN, new Item.Settings().maxCount(1));


    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "sapphire_helmet"), SAPPHIRE_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "sapphire_chestplate"), SAPPHIRE_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "sapphire_leggings"), SAPPHIRE_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "sapphire_boots"), SAPPHIRE_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "sapphire_horse_armor"), SAPPHIRE_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_HELMET, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, RUBY_BOOTS)});
        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_CHESTPLATE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, SAPPHIRE_HELMET)});
        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_LEGGINGS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, SAPPHIRE_CHESTPLATE)});
        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_BOOTS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, SAPPHIRE_LEGGINGS)});
        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_HORSE_ARMOR, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, RUBY_HORSE_ARMOR)});

    }
}