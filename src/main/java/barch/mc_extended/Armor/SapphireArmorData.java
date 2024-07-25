package barch.mc_extended.Armor;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Minerals.Sapphire;
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
import static barch.mc_extended.Armor.RubyArmorData.RUBY_BOOTS;
import static barch.mc_extended.Armor.RubyArmorData.RUBY_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.*;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class SapphireArmorData {

    public static final RegistryEntry<ArmorMaterial> SAPPHIRE = registerMaterial(
            "sapphire",
            Map.of(
                    ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 6,
                    ArmorItem.Type.BOOTS, 3,
                    ArmorItem.Type.BODY, 11
            ),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.ofItems(Sapphire.SAPPHIRE),
            2.0F,
            0.0F,
            false);


    public static final Item SAPPHIRE_HELMET = new ArmorItem(SAPPHIRE, ArmorItem.Type.HELMET, new Item.Settings());
    public static final Item SAPPHIRE_CHESTPLATE = new ArmorItem(SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item SAPPHIRE_LEGGINGS = new ArmorItem(SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item SAPPHIRE_BOOTS = new ArmorItem(SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item SAPPHIRE_HORSE_ARMOR = new AnimalArmorItem(SAPPHIRE, EQUESTRIAN, false, new Item.Settings().maxCount(1));


    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sapphire_helmet"), SAPPHIRE_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sapphire_chestplate"), SAPPHIRE_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sapphire_leggings"), SAPPHIRE_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sapphire_boots"), SAPPHIRE_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sapphire_horse_armor"), SAPPHIRE_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        ItemGrouper.GroupItem(SAPPHIRE_HELMET, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, RUBY_BOOTS)});
        ItemGrouper.GroupItem(SAPPHIRE_CHESTPLATE, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SAPPHIRE_HELMET)});
        ItemGrouper.GroupItem(SAPPHIRE_LEGGINGS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SAPPHIRE_CHESTPLATE)});
        ItemGrouper.GroupItem(SAPPHIRE_BOOTS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SAPPHIRE_LEGGINGS)});
        ItemGrouper.GroupItem(SAPPHIRE_HORSE_ARMOR, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, RUBY_HORSE_ARMOR)});

    }
}