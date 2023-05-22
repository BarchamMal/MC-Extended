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

public class RubyArmorMaterial implements ArmorMaterial {



    public static final RubyArmorMaterial INSTANCE = new RubyArmorMaterial();

    private static final int[] BASE_DURABILITY = new int[] {49,73,67,55};
    private static final int[] PROTECTION_VALUES = new int[] {4,8,10,4};

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
        return Ingredient.ofItems(MCExtended.RUBY);
    }

    @Override
    public String getName() {
        return "ruby";
    }

    @Override
    public float getToughness() {
        return .5f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.5f;
    }



    // ruby helmet
    public static final Item RUBY_HELMET = new ArmorItem(INSTANCE, ArmorItem.Type.HELMET, new Item.Settings());

    // ruby chestplate
    public static final Item RUBY_CHESTPLATE = new ArmorItem(INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings());

    // ruby leggings
    public static final Item RUBY_LEGGINGS = new ArmorItem(INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings());

    // ruby boots
    public static final Item RUBY_BOOTS = new ArmorItem(INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings());

    public static void RegisterArmor() {

        // ruby helmet
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_helmet"), RUBY_HELMET);
        // ruby chestplate
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_chestplate"), RUBY_CHESTPLATE);
        // ruby leggings
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_leggings"), RUBY_LEGGINGS);
        // ruby boots
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "ruby_boots"), RUBY_BOOTS);
    }

    public static void GroupArmor() {

        // ruby helmet
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_HELMET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.DIAMOND_BOOTS, RUBY_HELMET);
        });
        // ruby chestplate
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_CHESTPLATE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(RUBY_HELMET, RUBY_CHESTPLATE);
        });
        // ruby leggings
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_LEGGINGS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(RUBY_CHESTPLATE, RUBY_LEGGINGS);
        });
        // ruby boots
        ItemGroupEvents.modifyEntriesEvent(MCExtended.MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(RUBY_LEGGINGS, RUBY_BOOTS);
        });
    }

}
