package barch.mc_extended;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

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
}
