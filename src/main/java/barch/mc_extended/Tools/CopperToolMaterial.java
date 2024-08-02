package barch.mc_extended.Tools;

import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import static barch.mc_extended.Tools.MCEToolMaterials.*;
import static barch.mc_extended.Tools.SilverToolMaterial.*;

public class CopperToolMaterial implements ToolMaterial {

    public static final CopperToolMaterial INSTANCE = new CopperToolMaterial();

    public static final Item COPPER_SWORD = registerSword("copper", 0, -2.4f, INSTANCE, new Item.Settings());
    public static final Item COPPER_AXE = registerAxe("copper", 2, -3.1f, INSTANCE, new Item.Settings());
    public static final Item COPPER_HOE = registerHoe("copper", -5, -1, INSTANCE, new Item.Settings());
    public static final Item COPPER_SHOVEL = registerShovel("copper", 1.5f, -3, INSTANCE, new Item.Settings());
    public static final Item COPPER_PICKAXE = registerPickaxe("copper", -2, -2.5f, INSTANCE, new Item.Settings());

    @Override
    public int getDurability() {
        return 150;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4f;
    }

    @Override
    public float getAttackDamage() {
        return 5;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return BlockTags.INCORRECT_FOR_STONE_TOOL;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }

    public static void GroupTools() {

        MCE_ITEM_GROUPER.GroupItem(COPPER_SWORD, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, SILVER_SWORD)});
        MCE_ITEM_GROUPER.GroupItem(COPPER_SHOVEL, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, SILVER_HOE)});
        MCE_ITEM_GROUPER.GroupItem(COPPER_PICKAXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, COPPER_SHOVEL)});
        MCE_ITEM_GROUPER.GroupItem(COPPER_AXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, COPPER_PICKAXE), new ItemGroupItem(ItemGroups.COMBAT, SILVER_AXE)});
        MCE_ITEM_GROUPER.GroupItem(COPPER_HOE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, COPPER_HOE)});

    }
}
