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

import static barch.mc_extended.Armor.SapphireArmorData.SAPPHIRE_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.MC_EXTENDED;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class CorundumArmorData {

    public static final ArmorMaterial CORUNDUM = new ArmorMaterial(60,
            (Map) Util.make(new EnumMap(EquipmentType.class), (map) -> {
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
            Tags.EaKeys.CORUNDUM_KEY)
            ;

    public static final Item CORUNDUM_HELMET = new ArmorItem(CORUNDUM, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item CORUNDUM_CHESTPLATE = new ArmorItem(CORUNDUM, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item CORUNDUM_LEGGINGS = new ArmorItem(CORUNDUM, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item CORUNDUM_BOOTS = new ArmorItem(CORUNDUM, EquipmentType.HELMET, new Item.Settings().maxCount(1));
    public static final Item CORUNDUM_HORSE_ARMOR = new AnimalArmorItem(CORUNDUM, EQUESTRIAN, new Item.Settings().maxCount(1));

    public static void RegisterArmor() {
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "corundum_helmet"), CORUNDUM_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "corundum_chestplate"), CORUNDUM_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "corundum_leggings"), CORUNDUM_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "corundum_boots"), CORUNDUM_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "corundum_horse_armor"), CORUNDUM_HORSE_ARMOR);
    }

    public static void GroupArmor() {
        MCE_ITEM_GROUPER.GroupItem(CORUNDUM_HELMET, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, Items.NETHERITE_BOOTS)});
        MCE_ITEM_GROUPER.GroupItem(CORUNDUM_CHESTPLATE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, CORUNDUM_HELMET)});
        MCE_ITEM_GROUPER.GroupItem(CORUNDUM_LEGGINGS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, CORUNDUM_CHESTPLATE)});
        MCE_ITEM_GROUPER.GroupItem(CORUNDUM_BOOTS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, CORUNDUM_LEGGINGS)});
        MCE_ITEM_GROUPER.GroupItem(CORUNDUM_HORSE_ARMOR, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, SAPPHIRE_HORSE_ARMOR)});
    }
}