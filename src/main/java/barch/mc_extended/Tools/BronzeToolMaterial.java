package barch.mc_extended.Tools;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
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

        ItemGrouper.GroupItem(BRONZE_SWORD, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.IRON_SWORD)});
        ItemGrouper.GroupItem(BRONZE_SHOVEL, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, Items.IRON_HOE)});
        ItemGrouper.GroupItem(BRONZE_PICKAXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, BRONZE_SHOVEL)});
        ItemGrouper.GroupItem(BRONZE_AXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, BRONZE_PICKAXE), new ItemGrouped(ItemGroups.COMBAT, Items.IRON_AXE)});
        ItemGrouper.GroupItem(BRONZE_HOE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, BRONZE_HOE)});

    }
}
