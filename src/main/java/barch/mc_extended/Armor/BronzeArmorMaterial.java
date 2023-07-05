package barch.mc_extended.Armor;

import barch.mc_extended.Minerals.Bronze;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;

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
        return 1;
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



    // bronze helmet
    public static final Item BRONZE_HELMET = new ArmorItem(INSTANCE, ArmorItem.Type.HELMET, new Item.Settings());

    // bronze chestplate
    public static final Item BRONZE_CHESTPLATE = new ArmorItem(INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings());

    // bronze leggings
    public static final Item BRONZE_LEGGINGS = new ArmorItem(INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings());

    // bronze boots
    public static final Item BRONZE_BOOTS = new ArmorItem(INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings());

    public static final Item BRONZE_HORSE_ARMOR = new HorseArmorItem(2, "bronze", new Item.Settings().maxCount(1));

    public static void RegisterArmor() {

        // bronze helmet
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "bronze_helmet"), BRONZE_HELMET);
        // bronze chestplate
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "bronze_chestplate"), BRONZE_CHESTPLATE);
        // bronze leggings
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "bronze_leggings"), BRONZE_LEGGINGS);
        // bronze boots
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "bronze_boots"), BRONZE_BOOTS);
        // bronze horse armor
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "bronze_horse_armor"), BRONZE_HORSE_ARMOR);
    }

    public static void GroupArmor() {

        // bronze helmet
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(BRONZE_HELMET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.GOLDEN_BOOTS, BRONZE_HELMET);
        });
        // bronze chestplate
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(BRONZE_CHESTPLATE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(BRONZE_HELMET, BRONZE_CHESTPLATE);
        });
        // bronze leggings
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(BRONZE_LEGGINGS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(BRONZE_CHESTPLATE, BRONZE_LEGGINGS);
        });
        // bronze boots
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(BRONZE_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(BRONZE_LEGGINGS, BRONZE_BOOTS);
        });
        // bronze horse armor
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(BRONZE_HORSE_ARMOR);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.GOLDEN_HORSE_ARMOR, BRONZE_HORSE_ARMOR);
        });
    }

}
