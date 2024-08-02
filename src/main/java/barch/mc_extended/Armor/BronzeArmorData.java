package barch.mc_extended.Armor;

import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import barch.mc_extended.Minerals.Bronze;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

import static barch.mc_extended.Armor.MCEArmorMaterials.registerMaterial;
import static barch.mc_extended.MCExtended.*;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class BronzeArmorData {

    private static final int[] BASE_DURABILITY = new int[] {13,18,17,15};

    public static final RegistryEntry<ArmorMaterial> BRONZE = registerMaterial(
            "bronze",
            Map.of(
                    ArmorItem.Type.HELMET, 2,
                    ArmorItem.Type.CHESTPLATE, 6,
                    ArmorItem.Type.LEGGINGS,  5,
                    ArmorItem.Type.BOOTS, 2,
                    ArmorItem.Type.BODY, 4

            ),
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            () -> Ingredient.ofItems(Bronze.BRONZE_INGOT),
            0.0F,
            0.0F,
            false);


    public static final Item BRONZE_HELMET = new ArmorItem(BRONZE, ArmorItem.Type.HELMET, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[0]*10));
    public static final Item BRONZE_CHESTPLATE = new ArmorItem(BRONZE, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[1]*10));
    public static final Item BRONZE_LEGGINGS = new ArmorItem(BRONZE, ArmorItem.Type.LEGGINGS, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[2]*10));
    public static final Item BRONZE_BOOTS = new ArmorItem(BRONZE, ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[3]*10));
    public static final Item BRONZE_HORSE_ARMOR = new AnimalArmorItem(BRONZE, EQUESTRIAN, false, new Item.Settings().maxCount(1));


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