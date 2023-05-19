package barch.mc_extended;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RubyToolMaterial implements ToolMaterial {

    public static final RubyToolMaterial INSTANCE = new RubyToolMaterial();


    @Override
    public int getDurability() {
        return 2800;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 13f;
    }

    @Override
    public float getAttackDamage() {
        return 5;
    }

    @Override
    public int getMiningLevel() {
        return 6;
    }

    @Override
    public int getEnchantability() {
        return 2;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(MCExtended.RUBY);
    }
}
