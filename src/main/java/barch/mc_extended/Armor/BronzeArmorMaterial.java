package barch.mc_extended.Armor;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Minerals.Bronze;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.*;

public class BronzeArmorMaterial implements ArmorMaterial {

    public static final BronzeArmorMaterial INSTANCE = new BronzeArmorMaterial();

    private static final int[] BASE_DURABILITY = new int[] {13,18,17,15};
    private static final int[] PROTECTION_VALUES = new int[] {2,6,5,2};

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
        return 15;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Bronze.BRONZE_INGOT);
    }

    @Override
    public String getName() {
        return "bronze";
    }

    @Override
    public float getToughness() {
        return 0f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.075f;
    }


    public static final Item BRONZE_HELMET = new ArmorItem(INSTANCE, ArmorItem.Type.HELMET, new FabricItemSettings());
    public static final Item BRONZE_CHESTPLATE = new ArmorItem(INSTANCE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings());
    public static final Item BRONZE_LEGGINGS = new ArmorItem(INSTANCE, ArmorItem.Type.LEGGINGS, new FabricItemSettings());
    public static final Item BRONZE_BOOTS = new ArmorItem(INSTANCE, ArmorItem.Type.BOOTS, new FabricItemSettings());
    public static final Item BRONZE_HORSE_ARMOR = new HorseArmorItem(2, "bronze", new FabricItemSettings().maxCount(1));

    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bronze_helmet"), BRONZE_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bronze_chestplate"), BRONZE_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bronze_leggings"), BRONZE_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bronze_boots"), BRONZE_BOOTS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bronze_horse_armor"), BRONZE_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        ItemGrouper.GroupItem(BRONZE_HELMET, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.IRON_BOOTS)});
        ItemGrouper.GroupItem(BRONZE_CHESTPLATE, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, BRONZE_HELMET)});
        ItemGrouper.GroupItem(BRONZE_LEGGINGS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, BRONZE_CHESTPLATE)});
        ItemGrouper.GroupItem(BRONZE_BOOTS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, BRONZE_LEGGINGS)});
        ItemGrouper.GroupItem(BRONZE_HORSE_ARMOR, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.IRON_HORSE_ARMOR)});

    }

}
