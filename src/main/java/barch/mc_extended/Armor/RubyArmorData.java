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

public class RubyArmorData {

    public static final ArmorMaterial RUBY = new ArmorMaterial(33,
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
            Tags.ItemTags.RUBY_REPAIRS,
            Tags.EaKeys.RUBY_KEY)
            ;

    public static final Item RUBY_HELMET = new ArmorItem(RUBY, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item RUBY_CHESTPLATE = new ArmorItem(RUBY, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item RUBY_LEGGINGS = new ArmorItem(RUBY, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item RUBY_BOOTS = new ArmorItem(RUBY, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item RUBY_HORSE_ARMOR = new AnimalArmorItem(RUBY, EQUESTRIAN, new Item.Settings().maxCount(1));


    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "ruby_helmet"), RUBY_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "ruby_chestplate"), RUBY_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "ruby_leggings"), RUBY_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "ruby_boots"), RUBY_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "ruby_horse_armor"), RUBY_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        MCE_ITEM_GROUPER.GroupItem(RUBY_HELMET, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, Items.DIAMOND_BOOTS)});
        MCE_ITEM_GROUPER.GroupItem(RUBY_CHESTPLATE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, RUBY_HELMET)});
        MCE_ITEM_GROUPER.GroupItem(RUBY_LEGGINGS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, RUBY_CHESTPLATE)});
        MCE_ITEM_GROUPER.GroupItem(RUBY_BOOTS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, RUBY_LEGGINGS)});
        MCE_ITEM_GROUPER.GroupItem(RUBY_HORSE_ARMOR, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, Items.DIAMOND_HORSE_ARMOR)});

    }
}