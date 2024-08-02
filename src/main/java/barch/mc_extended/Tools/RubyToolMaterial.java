package barch.mc_extended.Tools;

import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static barch.mc_extended.Minerals.Ruby.*;
import static barch.mc_extended.MCExtended.*;
import static barch.mc_extended.Tools.MCEToolMaterials.*;

public class RubyToolMaterial implements ToolMaterial {

    public static final RubyToolMaterial INSTANCE = new RubyToolMaterial();

    public static final Item RUBY_SWORD = registerSword("ruby", 3, -2, INSTANCE, new Item.Settings());
    public static final Item RUBY_AXE = registerAxe("ruby", 5, -3, INSTANCE, new Item.Settings());
    public static final Item RUBY_HOE = registerHoe("ruby", -3, 0, INSTANCE, new Item.Settings());
    public static final Item RUBY_SHOVEL = registerShovel("ruby", 1.5f, -3, INSTANCE, new Item.Settings());
    public static final Item RUBY_PICKAXE = registerPickaxe("ruby", 0, -2.8f, INSTANCE, new Item.Settings());

    @Override
    public int getDurability() {
        return 1561;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8f;
    }

    @Override
    public float getAttackDamage() {
        return 3;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RUBY);
    }

    public static void GroupTools() {

        MCE_ITEM_GROUPER.GroupItem(RUBY_SWORD, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, Items.DIAMOND_SWORD)});
        MCE_ITEM_GROUPER.GroupItem(RUBY_SHOVEL, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, Items.DIAMOND_HOE)});
        MCE_ITEM_GROUPER.GroupItem(RUBY_PICKAXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, RUBY_SHOVEL)});
        MCE_ITEM_GROUPER.GroupItem(RUBY_AXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, RUBY_PICKAXE), new ItemGroupItem(ItemGroups.COMBAT, Items.DIAMOND_AXE)});
        MCE_ITEM_GROUPER.GroupItem(RUBY_HOE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, RUBY_HOE)});

    }
}
