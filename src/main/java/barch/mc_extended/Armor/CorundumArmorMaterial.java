package barch.mc_extended.Armor;

import barch.mc_extended.Minerals.Corundum;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static barch.mc_extended.Armor.RubyArmorMaterial.RUBY_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;
import static barch.mc_extended.MCExtended.NAMESPACE;

public class CorundumArmorMaterial implements ArmorMaterial {



    public static final CorundumArmorMaterial INSTANCE = new CorundumArmorMaterial();

    private static final int[] BASE_DURABILITY = new int[] {49,73,67,65};
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
        return 14;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Corundum.CORUNDUM);
    }

    @Override
    public String getName() {
        return "corundum";
    }

    @Override
    public float getToughness() {
        return 4f;
    }

    @Override
    public float getKnockbackResistance() {
        return 1.5f;
    }




    // corundum helmet
    public static final Item CORUNDUM_HELMET = new ArmorItem(INSTANCE, ArmorItem.Type.HELMET, new Item.Settings());

    // corundum chestplate
    public static final Item CORUNDUM_CHESTPLATE = new ArmorItem(INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings());

    // corundum leggings
    public static final Item CORUNDUM_LEGGINGS = new ArmorItem(INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings());

    // corundum boots
    public static final Item CORUNDUM_BOOTS = new ArmorItem(INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings());

    public static final Item CORUNDUM_HORSE_ARMOR = new HorseArmorItem(2, "corundum", new Item.Settings().maxCount(1));

    public static void RegisterArmor() {

        // corundum helmet
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_helmet"), CORUNDUM_HELMET);
        // corundum chestplate
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_chestplate"), CORUNDUM_CHESTPLATE);
        // corundum leggings
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_leggings"), CORUNDUM_LEGGINGS);
        // corundum boots
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_boots"), CORUNDUM_BOOTS);
        // corundum horse armor
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_horse_armor"), CORUNDUM_HORSE_ARMOR);
    }

    public static void GroupArmor() {

        // corundum helmet
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(CORUNDUM_HELMET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.NETHERITE_BOOTS, CORUNDUM_HELMET);
        });
        // corundum chestplate
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(CORUNDUM_CHESTPLATE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(CORUNDUM_HELMET, CORUNDUM_CHESTPLATE);
        });
        // corundum leggings
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(CORUNDUM_LEGGINGS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(CORUNDUM_CHESTPLATE, CORUNDUM_LEGGINGS);
        });
        // corundum boots
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(CORUNDUM_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(CORUNDUM_LEGGINGS, CORUNDUM_BOOTS);
        });
        // corundum horse armor
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(CORUNDUM_HORSE_ARMOR);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(RUBY_HORSE_ARMOR, CORUNDUM_HORSE_ARMOR);
        });
    }

}
