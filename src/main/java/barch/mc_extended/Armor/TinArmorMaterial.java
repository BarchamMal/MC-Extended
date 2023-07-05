package barch.mc_extended.Armor;

import barch.mc_extended.Minerals.Tin;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;

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
        return 1;
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



    // tin helmet
    public static final Item TIN_HELMET = new ArmorItem(INSTANCE, ArmorItem.Type.HELMET, new Item.Settings());

    // tin chestplate
    public static final Item TIN_CHESTPLATE = new ArmorItem(INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings());

    // tin leggings
    public static final Item TIN_LEGGINGS = new ArmorItem(INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings());

    // tin boots
    public static final Item TIN_BOOTS = new ArmorItem(INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings());

    public static final Item TIN_HORSE_ARMOR = new HorseArmorItem(2, "tin", new Item.Settings().maxCount(1));

    public static void RegisterArmor() {

        // tin helmet
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "tin_helmet"), TIN_HELMET);
        // tin chestplate
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "tin_chestplate"), TIN_CHESTPLATE);
        // tin leggings
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "tin_leggings"), TIN_LEGGINGS);
        // tin boots
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "tin_boots"), TIN_BOOTS);
        // tin horse armor
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "tin_horse_armor"), TIN_HORSE_ARMOR);
    }

    public static void GroupArmor() {

        // tin helmet
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TIN_HELMET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.GOLDEN_BOOTS, TIN_HELMET);
        });
        // tin chestplate
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TIN_CHESTPLATE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(TIN_HELMET, TIN_CHESTPLATE);
        });
        // tin leggings
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TIN_LEGGINGS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(TIN_CHESTPLATE, TIN_LEGGINGS);
        });
        // tin boots
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TIN_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(TIN_LEGGINGS, TIN_BOOTS);
        });
        // tin horse armor
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TIN_HORSE_ARMOR);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.GOLDEN_HORSE_ARMOR, TIN_HORSE_ARMOR);
        });
    }

}
