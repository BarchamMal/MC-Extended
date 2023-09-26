package barch.mc_extended.Armor;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static barch.mc_extended.Armor.SilverArmorMaterial.SILVER_BOOTS;
import static barch.mc_extended.Armor.SilverArmorMaterial.SILVER_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.*;

public class CopperArmorMaterial implements ArmorMaterial {

    public static final CopperArmorMaterial INSTANCE = new CopperArmorMaterial();

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
        return 25;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }

    @Override
    public String getName() {
        return "copper";
    }

    @Override
    public float getToughness() {
        return 0f;
    }
    @Override
    public float getKnockbackResistance() {
        return 0.1f;
    }
    
    public static final Item COPPER_HELMET = new ArmorItem(INSTANCE, ArmorItem.Type.HELMET, new FabricItemSettings());
    public static final Item COPPER_CHESTPLATE = new ArmorItem(INSTANCE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings());

    public static final Item COPPER_LEGGINGS = new ArmorItem(INSTANCE, ArmorItem.Type.LEGGINGS, new FabricItemSettings());
    public static final Item COPPER_BOOTS = new ArmorItem(INSTANCE, ArmorItem.Type.BOOTS, new FabricItemSettings());
    public static final Item COPPER_HORSE_ARMOR = new HorseArmorItem(2, "copper", new FabricItemSettings().maxCount(1));

    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "copper_helmet"), COPPER_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "copper_chestplate"), COPPER_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "copper_leggings"), COPPER_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "copper_boots"), COPPER_BOOTS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "copper_horse_armor"), COPPER_HORSE_ARMOR);
        
    }

    public static void GroupArmor() {

        ItemGrouper.GroupItem(COPPER_HELMET, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SILVER_BOOTS)});
        ItemGrouper.GroupItem(COPPER_CHESTPLATE, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, COPPER_HELMET)});
        ItemGrouper.GroupItem(COPPER_LEGGINGS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, COPPER_CHESTPLATE)});
        ItemGrouper.GroupItem(COPPER_BOOTS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, COPPER_LEGGINGS)});
        ItemGrouper.GroupItem(COPPER_HORSE_ARMOR, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SILVER_HORSE_ARMOR)});

    }

}
