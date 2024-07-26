package barch.mc_extended.Armor;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

import static barch.mc_extended.Armor.MCEArmorMaterials.registerMaterial;
import static barch.mc_extended.Armor.SilverArmorData.SILVER_BOOTS;
import static barch.mc_extended.Armor.SilverArmorData.SILVER_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.*;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class CopperArmorData {

    private static final int[] BASE_DURABILITY = new int[] {9,17,15,10};

    public static final RegistryEntry<ArmorMaterial> COPPER = registerMaterial(
            "copper",
            Map.of(
                    ArmorItem.Type.HELMET, 1,
                    ArmorItem.Type.CHESTPLATE, 5,
                    ArmorItem.Type.LEGGINGS,  4,
                    ArmorItem.Type.BOOTS, 1,
                    ArmorItem.Type.BODY, 3
            ),
            25,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            () -> Ingredient.ofItems(Items.COPPER_INGOT),
            0.0F,
            0.1F,
            false);


    public static final Item COPPER_HELMET = new ArmorItem(COPPER, ArmorItem.Type.HELMET, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[0]));
    public static final Item COPPER_CHESTPLATE = new ArmorItem(COPPER, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[1]));
    public static final Item COPPER_LEGGINGS = new ArmorItem(COPPER, ArmorItem.Type.LEGGINGS, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[2]));
    public static final Item COPPER_BOOTS = new ArmorItem(COPPER, ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[3]));
    public static final Item COPPER_HORSE_ARMOR = new AnimalArmorItem(COPPER, EQUESTRIAN, false, new Item.Settings().maxCount(1));


    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "copper_helmet"), COPPER_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "copper_chestplate"), COPPER_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "copper_leggings"), COPPER_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "copper_boots"), COPPER_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "copper_horse_armor"), COPPER_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        ItemGrouper.GroupItem(COPPER_HELMET, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SILVER_BOOTS)});
        ItemGrouper.GroupItem(COPPER_CHESTPLATE, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, COPPER_HELMET)});
        ItemGrouper.GroupItem(COPPER_LEGGINGS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, COPPER_CHESTPLATE)});
        ItemGrouper.GroupItem(COPPER_BOOTS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, COPPER_LEGGINGS)});
        ItemGrouper.GroupItem(COPPER_HORSE_ARMOR, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SILVER_HORSE_ARMOR)});

    }
}