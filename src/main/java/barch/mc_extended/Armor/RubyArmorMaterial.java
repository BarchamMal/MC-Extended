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

import static barch.mc_extended.MCExtended.*;
import static barch.mc_extended.Minerals.Ruby.*;

public class RubyArmorMaterial implements ArmorMaterial {

    public static final RubyArmorMaterial INSTANCE = new RubyArmorMaterial();

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
        return Ingredient.ofItems(RUBY);
    }

    @Override
    public String getName() {
        return "ruby";
    }

    @Override
    public float getToughness() {
        return 2f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0f;
    }

    public static final Item RUBY_HELMET = new ArmorItem(INSTANCE, ArmorItem.Type.HELMET, new FabricItemSettings());
    public static final Item RUBY_CHESTPLATE = new ArmorItem(INSTANCE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings());
    public static final Item RUBY_LEGGINGS = new ArmorItem(INSTANCE, ArmorItem.Type.LEGGINGS, new FabricItemSettings());
    public static final Item RUBY_BOOTS = new ArmorItem(INSTANCE, ArmorItem.Type.BOOTS, new FabricItemSettings());
    public static final Item RUBY_HORSE_ARMOR = new HorseArmorItem(5, "ruby", new FabricItemSettings().maxCount(1));

    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby_helmet"), RUBY_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby_chestplate"), RUBY_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby_leggings"), RUBY_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby_boots"), RUBY_BOOTS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby_horse_armor"), RUBY_HORSE_ARMOR);
        
    }

    public static void GroupArmor() {

        ItemGrouper.GroupItem(RUBY_HELMET, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.DIAMOND_BOOTS)});
        ItemGrouper.GroupItem(RUBY_CHESTPLATE, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, RUBY_HELMET)});
        ItemGrouper.GroupItem(RUBY_LEGGINGS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, RUBY_CHESTPLATE)});
        ItemGrouper.GroupItem(RUBY_BOOTS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, RUBY_LEGGINGS)});
        ItemGrouper.GroupItem(RUBY_HORSE_ARMOR, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.DIAMOND_HORSE_ARMOR)});

    }

}