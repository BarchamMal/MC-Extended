package barch.mc_extended;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;

public class SilverArmorMaterial implements ArmorMaterial {



    public static final SilverArmorMaterial INSTANCE = new SilverArmorMaterial();

    private static final int[] BASE_DURABILITY = new int[] {2,2,2,2};
    private static final int[] PROTECTION_VALUES = new int[] {2,5,6,2};

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
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(MCExtended.SILVER_INGOT);
    }

    @Override
    public String getName() {
        return "silver";
    }

    @Override
    public float getToughness() {
        return .5f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.5f;
    }



    // silver helmet
    public static final Item SILVER_HELMET = new ArmorItem(INSTANCE, ArmorItem.Type.HELMET, new Item.Settings());

    // silver chestplate
    public static final Item SILVER_CHESTPLATE = new ArmorItem(INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings());

    // silver leggings
    public static final Item SILVER_LEGGINGS = new ArmorItem(INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings());

    // silver boots
    public static final Item SILVER_BOOTS = new ArmorItem(INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings());

    public static final Item SILVER_HORSE_ARMOR = new HorseArmorItem(5, "silver", new Item.Settings().maxCount(1));

    public static void RegisterArmor() {

        // silver helmet
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "silver_helmet"), SILVER_HELMET);
        // silver chestplate
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "silver_chestplate"), SILVER_CHESTPLATE);
        // silver leggings
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "silver_leggings"), SILVER_LEGGINGS);
        // silver boots
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "silver_boots"), SILVER_BOOTS);
        // silver horse armor
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "silver_horse_armor"), SILVER_HORSE_ARMOR);
    }

    public static void GroupArmor() {

        // silver helmet
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_HELMET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.GOLDEN_BOOTS, SILVER_HELMET);
        });
        // silver chestplate
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_CHESTPLATE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(SILVER_HELMET, SILVER_CHESTPLATE);
        });
        // silver leggings
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_LEGGINGS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(SILVER_CHESTPLATE, SILVER_LEGGINGS);
        });
        // silver boots
        ItemGroupEvents.modifyEntriesEvent(MCExtended.MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(SILVER_LEGGINGS, SILVER_BOOTS);
        });
        // silver horse armor
        ItemGroupEvents.modifyEntriesEvent(MCExtended.MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_HORSE_ARMOR);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.GOLDEN_HORSE_ARMOR, SILVER_HORSE_ARMOR);
        });
    }

}
