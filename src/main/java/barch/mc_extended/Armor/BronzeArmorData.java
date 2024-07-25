package barch.mc_extended.Armor;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Minerals.Bronze;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static barch.mc_extended.Armor.ArmorMaterials.registerMaterial;
import static barch.mc_extended.MCExtended.*;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class BronzeArmorData {

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


    public static final Item BRONZE_HELMET = new ArmorItem(BRONZE, ArmorItem.Type.HELMET, new Item.Settings());
    public static final Item BRONZE_CHESTPLATE = new ArmorItem(BRONZE, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item BRONZE_LEGGINGS = new ArmorItem(BRONZE, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item BRONZE_BOOTS = new ArmorItem(BRONZE, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item BRONZE_HORSE_ARMOR = new AnimalArmorItem(BRONZE, EQUESTRIAN, false, new Item.Settings().maxCount(1));


    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "bronze_helmet"), BRONZE_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "bronze_chestplate"), BRONZE_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "bronze_leggings"), BRONZE_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "bronze_boots"), BRONZE_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "bronze_horse_armor"), BRONZE_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        ItemGrouper.GroupItem(BRONZE_HELMET, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.IRON_BOOTS)});
        ItemGrouper.GroupItem(BRONZE_CHESTPLATE, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, BRONZE_HELMET)});
        ItemGrouper.GroupItem(BRONZE_LEGGINGS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, BRONZE_CHESTPLATE)});
        ItemGrouper.GroupItem(BRONZE_BOOTS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, BRONZE_LEGGINGS)});
        ItemGrouper.GroupItem(BRONZE_HORSE_ARMOR, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.IRON_HORSE_ARMOR)});

    }
}