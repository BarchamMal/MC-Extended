package barch.mc_extended.Armor;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Minerals.Tin;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static barch.mc_extended.Armor.BronzeArmorMaterial.BRONZE_BOOTS;
import static barch.mc_extended.Armor.BronzeArmorMaterial.BRONZE_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.*;

public class TinArmorMaterial implements ArmorMaterial {

    public static final TinArmorMaterial INSTANCE = new TinArmorMaterial();

    private static final int[] BASE_DURABILITY = new int[] {9,17,15,10};
    private static final int[] PROTECTION_VALUES = new int[] {1,5,4,1};

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * 10;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return PROTECTION_VALUES[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Tin.TIN_INGOT);
    }

    @Override
    public String getName() {
        return "tin";
    }

    @Override
    public float getToughness() {
        return 0f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.1f;
    }

    public static final Item TIN_HELMET = new ArmorItem(INSTANCE, ArmorItem.Type.HELMET, new FabricItemSettings());
    public static final Item TIN_CHESTPLATE = new ArmorItem(INSTANCE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings());
    public static final Item TIN_LEGGINGS = new ArmorItem(INSTANCE, ArmorItem.Type.LEGGINGS, new FabricItemSettings());
    public static final Item TIN_BOOTS = new ArmorItem(INSTANCE, ArmorItem.Type.BOOTS, new FabricItemSettings());
    public static final Item TIN_HORSE_ARMOR = new HorseArmorItem(2, "tin", new FabricItemSettings().maxCount(1));

    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_helmet"), TIN_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_chestplate"), TIN_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_leggings"), TIN_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_boots"), TIN_BOOTS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_horse_armor"), TIN_HORSE_ARMOR);
        
    }

    public static void GroupArmor() {
        
        ItemGrouper.GroupItem(TIN_HELMET, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, BRONZE_BOOTS)});
        ItemGrouper.GroupItem(TIN_CHESTPLATE, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, TIN_HELMET)});
        ItemGrouper.GroupItem(TIN_LEGGINGS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, TIN_CHESTPLATE)});
        ItemGrouper.GroupItem(TIN_BOOTS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, TIN_LEGGINGS)});
        ItemGrouper.GroupItem(TIN_HORSE_ARMOR, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, BRONZE_HORSE_ARMOR)});
        
    }

}