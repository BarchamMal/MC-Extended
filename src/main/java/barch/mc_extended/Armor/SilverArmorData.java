package barch.mc_extended.Armor;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Minerals.Silver;
import barch.mc_extended.Minerals.Tin;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.registry.entry.RegistryEntry;

import static barch.mc_extended.Armor.ArmorMaterials.registerMaterial;
import static barch.mc_extended.Armor.BronzeArmorData.BRONZE_BOOTS;
import static barch.mc_extended.Armor.BronzeArmorData.BRONZE_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.NAMESPACE;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class SilverArmorData {

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

    public static final Item SILVER_HELMET = new ArmorItem(SILVER, ArmorItem.Type.HELMET, new Item.Settings());
    public static final Item SILVER_CHESTPLATE = new ArmorItem(SILVER, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item SILVER_LEGGINGS = new ArmorItem(SILVER, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item SILVER_BOOTS = new ArmorItem(SILVER, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item SILVER_HORSE_ARMOR = new AnimalArmorItem(SILVER, EQUESTRIAN, false, new Item.Settings().maxCount(1));

    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "silver_helmet"), SILVER_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "silver_chestplate"), SILVER_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "silver_leggings"), SILVER_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "silver_boots"), SILVER_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "silver_horse_armor"), SILVER_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        ItemGrouper.GroupItem(SILVER_HELMET, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.GOLDEN_BOOTS)});
        ItemGrouper.GroupItem(SILVER_CHESTPLATE, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SILVER_HELMET)});
        ItemGrouper.GroupItem(SILVER_LEGGINGS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SILVER_CHESTPLATE)});
        ItemGrouper.GroupItem(SILVER_BOOTS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SILVER_LEGGINGS)});
        ItemGrouper.GroupItem(SILVER_HORSE_ARMOR, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.GOLDEN_HORSE_ARMOR)});

    }

}