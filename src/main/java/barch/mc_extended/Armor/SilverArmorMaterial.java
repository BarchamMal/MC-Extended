package barch.mc_extended.Armor;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Minerals.Silver;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.*;

public class SilverArmorMaterial implements ArmorMaterial {



    public static final SilverArmorMaterial INSTANCE = new SilverArmorMaterial();

    private static final int[] BASE_DURABILITY = new int[] {13,15,16,11};
    private static final int[] PROTECTION_VALUES = new int[] {4,8,10,4};

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * 14;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return PROTECTION_VALUES[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Silver.SILVER_INGOT);
    }

    @Override
    public String getName() {
        return "silver";
    }

    @Override
    public float getToughness() {
        return 4f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.5f;
    }

    public static final Item SILVER_HELMET = new ArmorItem(INSTANCE, ArmorItem.Type.HELMET, new FabricItemSettings());
    public static final Item SILVER_CHESTPLATE = new ArmorItem(INSTANCE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings());
    public static final Item SILVER_LEGGINGS = new ArmorItem(INSTANCE, ArmorItem.Type.LEGGINGS, new FabricItemSettings());
    public static final Item SILVER_BOOTS = new ArmorItem(INSTANCE, ArmorItem.Type.BOOTS, new FabricItemSettings());
    public static final Item SILVER_HORSE_ARMOR = new HorseArmorItem(5, "silver", new FabricItemSettings().maxCount(1));

    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_helmet"), SILVER_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_chestplate"), SILVER_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_leggings"), SILVER_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_boots"), SILVER_BOOTS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_horse_armor"), SILVER_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        ItemGrouper.GroupItem(SILVER_HELMET, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.GOLDEN_BOOTS)});
        ItemGrouper.GroupItem(SILVER_CHESTPLATE, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SILVER_HELMET)});
        ItemGrouper.GroupItem(SILVER_LEGGINGS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SILVER_CHESTPLATE)});
        ItemGrouper.GroupItem(SILVER_BOOTS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SILVER_LEGGINGS)});
        ItemGrouper.GroupItem(SILVER_HORSE_ARMOR, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.GOLDEN_HORSE_ARMOR)});

    }

}
