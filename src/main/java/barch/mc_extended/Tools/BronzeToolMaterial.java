package barch.mc_extended.Tools;

import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import barch.mc_extended.Minerals.Bronze;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.*;
import static barch.mc_extended.Tools.MCEToolMaterials.*;

public class BronzeToolMaterial implements ToolMaterial {

    public static final BronzeToolMaterial INSTANCE = new BronzeToolMaterial();

    public static final Item BRONZE_SWORD = registerSword("bronze", 0, -2.4f, INSTANCE, new Item.Settings());
    public static final Item BRONZE_AXE = registerAxe("bronze", 2, -3.1f, INSTANCE, new Item.Settings());
    public static final Item BRONZE_HOE = registerHoe("bronze", -5, 1, INSTANCE, new Item.Settings());
    public static final Item BRONZE_SHOVEL = registerShovel("bronze", 1.5f, -3, INSTANCE, new Item.Settings());
    public static final Item BRONZE_PICKAXE = registerPickaxe("bronze", -2, -2.5f, INSTANCE, new Item.Settings());

    @Override
    public int getDurability() {
        return 230;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6f;
    }

    @Override
    public float getAttackDamage() {
        return 5;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return BlockTags.INCORRECT_FOR_IRON_TOOL;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Bronze.BRONZE_INGOT);
    }

    public static void GroupTools() {

        MCE_ITEM_GROUPER.GroupItem(BRONZE_SWORD, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, Items.IRON_SWORD)});
        MCE_ITEM_GROUPER.GroupItem(BRONZE_SHOVEL, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, Items.IRON_HOE)});
        MCE_ITEM_GROUPER.GroupItem(BRONZE_PICKAXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, BRONZE_SHOVEL)});
        MCE_ITEM_GROUPER.GroupItem(BRONZE_AXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, BRONZE_PICKAXE), new ItemGroupItem(ItemGroups.COMBAT, Items.IRON_AXE)});
        MCE_ITEM_GROUPER.GroupItem(BRONZE_HOE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, BRONZE_HOE)});

    }
}
