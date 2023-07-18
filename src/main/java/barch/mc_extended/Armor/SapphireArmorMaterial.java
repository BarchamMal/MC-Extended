package barch.mc_extended.Armor;

import barch.mc_extended.MCExtended;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;
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
        return 10;
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



    // sapphire helmet
    public static final Item SAPPHIRE_HELMET = new ArmorItem(INSTANCE, ArmorItem.Type.HELMET, new Item.Settings());

    // sapphire chestplate
    public static final Item SAPPHIRE_CHESTPLATE = new ArmorItem(INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings());

    // sapphire leggings
    public static final Item SAPPHIRE_LEGGINGS = new ArmorItem(INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings());

    // sapphire boots
    public static final Item SAPPHIRE_BOOTS = new ArmorItem(INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings());

    public static final Item SAPPHIRE_HORSE_ARMOR = new HorseArmorItem(5, "sapphire", new Item.Settings().maxCount(1));

    public static void RegisterArmor() {

        // sapphire helmet
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "sapphire_helmet"), SAPPHIRE_HELMET);
        // sapphire chestplate
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "sapphire_chestplate"), SAPPHIRE_CHESTPLATE);
        // sapphire leggings
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "sapphire_leggings"), SAPPHIRE_LEGGINGS);
        // sapphire boots
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "sapphire_boots"), SAPPHIRE_BOOTS);
        // sapphire horse armor
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "sapphire_horse_armor"), SAPPHIRE_HORSE_ARMOR);
    }

    public static void GroupArmor() {

        // sapphire helmet
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SAPPHIRE_HELMET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.DIAMOND_BOOTS, SAPPHIRE_HELMET);
        });
        // sapphire chestplate
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SAPPHIRE_CHESTPLATE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(SAPPHIRE_HELMET, SAPPHIRE_CHESTPLATE);
        });
        // sapphire leggings
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SAPPHIRE_LEGGINGS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(SAPPHIRE_CHESTPLATE, SAPPHIRE_LEGGINGS);
        });
        // sapphire boots
        ItemGroupEvents.modifyEntriesEvent(MCExtended.MC_EXTENDED_GROUP).register(content -> {
            content.add(SAPPHIRE_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(SAPPHIRE_LEGGINGS, SAPPHIRE_BOOTS);
        });
        // sapphire horse armor
        ItemGroupEvents.modifyEntriesEvent(MCExtended.MC_EXTENDED_GROUP).register(content -> {
            content.add(SAPPHIRE_HORSE_ARMOR);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.DIAMOND_HORSE_ARMOR, SAPPHIRE_HORSE_ARMOR);
        });
    }

}
