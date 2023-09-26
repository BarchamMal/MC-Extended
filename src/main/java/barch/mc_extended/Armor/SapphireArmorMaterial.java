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

import static barch.mc_extended.Armor.RubyArmorMaterial.RUBY_BOOTS;
import static barch.mc_extended.Armor.RubyArmorMaterial.RUBY_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.NAMESPACE;
import static barch.mc_extended.Minerals.Sapphire.SAPPHIRE;

public class SapphireArmorMaterial implements ArmorMaterial {

    public static final SapphireArmorMaterial INSTANCE = new SapphireArmorMaterial();

    private static final int[] BASE_DURABILITY = new int[] {11,16,15,13};
    private static final int[] PROTECTION_VALUES = new int[] {3,8,6,3};

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * 33;
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
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(SAPPHIRE);
    }

    @Override
    public String getName() {
        return "sapphire";
    }

    @Override
    public float getToughness() {
        return 2f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0f;
    }

    public static final Item SAPPHIRE_HELMET = new ArmorItem(INSTANCE, ArmorItem.Type.HELMET, new FabricItemSettings());
    public static final Item SAPPHIRE_CHESTPLATE = new ArmorItem(INSTANCE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings());
    public static final Item SAPPHIRE_LEGGINGS = new ArmorItem(INSTANCE, ArmorItem.Type.LEGGINGS, new FabricItemSettings());
    public static final Item SAPPHIRE_BOOTS = new ArmorItem(INSTANCE, ArmorItem.Type.BOOTS, new FabricItemSettings());
    public static final Item SAPPHIRE_HORSE_ARMOR = new HorseArmorItem(5, "sapphire", new FabricItemSettings().maxCount(1));

    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "sapphire_helmet"), SAPPHIRE_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "sapphire_chestplate"), SAPPHIRE_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "sapphire_leggings"), SAPPHIRE_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "sapphire_boots"), SAPPHIRE_BOOTS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "sapphire_horse_armor"), SAPPHIRE_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        ItemGrouper.GroupItem(SAPPHIRE_HELMET, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, RUBY_BOOTS)});
        ItemGrouper.GroupItem(SAPPHIRE_CHESTPLATE, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SAPPHIRE_HELMET)});
        ItemGrouper.GroupItem(SAPPHIRE_LEGGINGS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SAPPHIRE_CHESTPLATE)});
        ItemGrouper.GroupItem(SAPPHIRE_BOOTS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SAPPHIRE_LEGGINGS)});
        ItemGrouper.GroupItem(SAPPHIRE_HORSE_ARMOR, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, RUBY_HORSE_ARMOR)});

    
    }

}