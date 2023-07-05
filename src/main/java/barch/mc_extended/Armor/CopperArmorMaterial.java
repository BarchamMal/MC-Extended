package barch.mc_extended.Armor;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;

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
        return 5;
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



    // copper helmet
    public static final Item COPPER_HELMET = new ArmorItem(INSTANCE, ArmorItem.Type.HELMET, new Item.Settings());

    // copper chestplate
    public static final Item COPPER_CHESTPLATE = new ArmorItem(INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings());

    // copper leggings
    public static final Item COPPER_LEGGINGS = new ArmorItem(INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings());

    // copper boots
    public static final Item COPPER_BOOTS = new ArmorItem(INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings());

    public static final Item COPPER_HORSE_ARMOR = new HorseArmorItem(2, "copper", new Item.Settings().maxCount(1));

    public static void RegisterArmor() {

        // copper helmet
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "copper_helmet"), COPPER_HELMET);
        // copper chestplate
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "copper_chestplate"), COPPER_CHESTPLATE);
        // copper leggings
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "copper_leggings"), COPPER_LEGGINGS);
        // copper boots
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "copper_boots"), COPPER_BOOTS);
        // copper horse armor
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "copper_horse_armor"), COPPER_HORSE_ARMOR);
    }

    public static void GroupArmor() {

        // copper helmet
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(COPPER_HELMET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.LEATHER_BOOTS, COPPER_HELMET);
        });
        // copper chestplate
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(COPPER_CHESTPLATE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(COPPER_HELMET, COPPER_CHESTPLATE);
        });
        // copper leggings
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(COPPER_LEGGINGS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(COPPER_CHESTPLATE, COPPER_LEGGINGS);
        });
        // copper boots
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(COPPER_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(COPPER_LEGGINGS, COPPER_BOOTS);
        });
        // copper horse armor
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(COPPER_HORSE_ARMOR);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.LEATHER_HORSE_ARMOR, COPPER_HORSE_ARMOR);
        });
    }

}
