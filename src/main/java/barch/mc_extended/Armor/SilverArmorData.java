package barch.mc_extended.Armor;

import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import barch.mc_extended.Minerals.Silver;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

import net.minecraft.registry.entry.RegistryEntry;

import static barch.mc_extended.Armor.MCEArmorMaterials.registerMaterial;
import static barch.mc_extended.MCExtended.MC_EXTENDED;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class SilverArmorData {

    private static final int[] BASE_DURABILITY = new int[] {13,15,16,11};

    public static final RegistryEntry<ArmorMaterial> SILVER = registerMaterial(
            "silver",
            Map.of(
                    ArmorItem.Type.HELMET, 4,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 10,
                    ArmorItem.Type.BOOTS, 4,
                    ArmorItem.Type.BODY, 11
            ),
            20,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.ofItems(Silver.SILVER_INGOT),
            4.0F,
            0.5F,
            false);

    public static final Item SILVER_HELMET = new ArmorItem(SILVER, ArmorItem.Type.HELMET, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[0]*14));
    public static final Item SILVER_CHESTPLATE = new ArmorItem(SILVER, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[1]*14));
    public static final Item SILVER_LEGGINGS = new ArmorItem(SILVER, ArmorItem.Type.LEGGINGS, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[2]*14));
    public static final Item SILVER_BOOTS = new ArmorItem(SILVER, ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[3]*14));
    public static final Item SILVER_HORSE_ARMOR = new AnimalArmorItem(SILVER, EQUESTRIAN, false, new Item.Settings().maxCount(1));

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