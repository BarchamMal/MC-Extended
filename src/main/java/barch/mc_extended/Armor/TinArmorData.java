package barch.mc_extended.Armor;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Minerals.Tin;
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
import static barch.mc_extended.Armor.BronzeArmorData.BRONZE_BOOTS;
import static barch.mc_extended.Armor.BronzeArmorData.BRONZE_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.*;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class TinArmorData {

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


    public static final Item TIN_HELMET = new ArmorItem(TIN, ArmorItem.Type.HELMET, new Item.Settings());
    public static final Item TIN_CHESTPLATE = new ArmorItem(TIN, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item TIN_LEGGINGS = new ArmorItem(TIN, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item TIN_BOOTS = new ArmorItem(TIN, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item TIN_HORSE_ARMOR = new AnimalArmorItem(TIN, EQUESTRIAN, false, new Item.Settings().maxCount(1));


    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "tin_helmet"), TIN_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "tin_chestplate"), TIN_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "tin_leggings"), TIN_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "tin_boots"), TIN_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "tin_horse_armor"), TIN_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        ItemGrouper.GroupItem(TIN_HELMET, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, BRONZE_BOOTS)});
        ItemGrouper.GroupItem(TIN_CHESTPLATE, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, TIN_HELMET)});
        ItemGrouper.GroupItem(TIN_LEGGINGS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, TIN_CHESTPLATE)});
        ItemGrouper.GroupItem(TIN_BOOTS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, TIN_LEGGINGS)});
        ItemGrouper.GroupItem(TIN_HORSE_ARMOR, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, BRONZE_HORSE_ARMOR)});

    }
}