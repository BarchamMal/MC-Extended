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
import static barch.mc_extended.MCExtended.*;
import static barch.mc_extended.Minerals.Ruby.RUBY;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class RubyArmorData {

    private static final int[] BASE_DURABILITY = new int[] {11,16,15,13};

    public static final RegistryEntry<ArmorMaterial> RUBY_ARMOR_MATERIAL = registerMaterial(
            "ruby",
            Map.of(
                    ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 6,
                    ArmorItem.Type.BOOTS, 3,
                    ArmorItem.Type.BODY, 11
            ),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.ofItems(RUBY),
            2.0F,
            0.0F,
            false);


    public static final Item RUBY_HELMET = new ArmorItem(RUBY_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[0]*33));
    public static final Item RUBY_CHESTPLATE = new ArmorItem(RUBY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[1]*33));
    public static final Item RUBY_LEGGINGS = new ArmorItem(RUBY_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[2]*33));
    public static final Item RUBY_BOOTS = new ArmorItem(RUBY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[3]*33));
    public static final Item RUBY_HORSE_ARMOR = new AnimalArmorItem(RUBY_ARMOR_MATERIAL, EQUESTRIAN, false, new Item.Settings().maxCount(1));


    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "ruby_helmet"), RUBY_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "ruby_chestplate"), RUBY_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "ruby_leggings"), RUBY_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "ruby_boots"), RUBY_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "ruby_horse_armor"), RUBY_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        ItemGrouper.GroupItem(RUBY_HELMET, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.DIAMOND_BOOTS)});
        ItemGrouper.GroupItem(RUBY_CHESTPLATE, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, RUBY_HELMET)});
        ItemGrouper.GroupItem(RUBY_LEGGINGS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, RUBY_CHESTPLATE)});
        ItemGrouper.GroupItem(RUBY_BOOTS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, RUBY_LEGGINGS)});
        ItemGrouper.GroupItem(RUBY_HORSE_ARMOR, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.DIAMOND_HORSE_ARMOR)});

    }
}