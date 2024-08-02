package barch.mc_extended.Armor;

import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import barch.mc_extended.Minerals.Sapphire;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

import static barch.mc_extended.Armor.MCEArmorMaterials.registerMaterial;
import static barch.mc_extended.Armor.RubyArmorData.RUBY_BOOTS;
import static barch.mc_extended.Armor.RubyArmorData.RUBY_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.*;
import static net.minecraft.item.AnimalArmorItem.Type.EQUESTRIAN;

public class SapphireArmorData {

    private static final int[] BASE_DURABILITY = new int[] {11,16,15,13};

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


    public static final Item SAPPHIRE_HELMET = new ArmorItem(SAPPHIRE, ArmorItem.Type.HELMET, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[0]*33));
    public static final Item SAPPHIRE_CHESTPLATE = new ArmorItem(SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[1]*33));
    public static final Item SAPPHIRE_LEGGINGS = new ArmorItem(SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[2]*33));
    public static final Item SAPPHIRE_BOOTS = new ArmorItem(SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1).maxDamage(BASE_DURABILITY[3]*33));
    public static final Item SAPPHIRE_HORSE_ARMOR = new AnimalArmorItem(SAPPHIRE, EQUESTRIAN, false, new Item.Settings().maxCount(1));


    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "sapphire_helmet"), SAPPHIRE_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "sapphire_chestplate"), SAPPHIRE_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "sapphire_leggings"), SAPPHIRE_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "sapphire_boots"), SAPPHIRE_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "sapphire_horse_armor"), SAPPHIRE_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_HELMET, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, RUBY_BOOTS)});
        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_CHESTPLATE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, SAPPHIRE_HELMET)});
        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_LEGGINGS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, SAPPHIRE_CHESTPLATE)});
        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_BOOTS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, SAPPHIRE_LEGGINGS)});
        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_HORSE_ARMOR, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, RUBY_HORSE_ARMOR)});

    }
}