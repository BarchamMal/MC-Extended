package barch.mc_extended.Armor;

import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import barch.mc_extended.Minerals.Tin;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

import static barch.mc_extended.Armor.MCEArmorMaterials.registerMaterial;
import static barch.mc_extended.Armor.BronzeArmorData.BRONZE_BOOTS;
import static barch.mc_extended.Armor.BronzeArmorData.BRONZE_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.*;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class TinArmorData {

    private static final int[] BASE_DURABILITY = new int[] {9,17,15,10};

    public static final RegistryEntry<ArmorMaterial> TIN = registerMaterial(
            "tin",
            Map.of(
                    ArmorItem.Type.HELMET, 1,
                    ArmorItem.Type.CHESTPLATE, 5,
                    ArmorItem.Type.LEGGINGS,  4,
                    ArmorItem.Type.BOOTS, 1,
                    ArmorItem.Type.BODY, 3
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            () -> Ingredient.ofItems(Tin.TIN_INGOT),
            0.0F,
            0.1F,
            false);


    public static final Item TIN_HELMET = new ArmorItem(TIN, ArmorItem.Type.HELMET, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[0]*10));
    public static final Item TIN_CHESTPLATE = new ArmorItem(TIN, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[1]*10));
    public static final Item TIN_LEGGINGS = new ArmorItem(TIN, ArmorItem.Type.LEGGINGS, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[2]*10));
    public static final Item TIN_BOOTS = new ArmorItem(TIN, ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[3]*10));
    public static final Item TIN_HORSE_ARMOR = new AnimalArmorItem(TIN, EQUESTRIAN, false, new Item.Settings().maxCount(1));


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