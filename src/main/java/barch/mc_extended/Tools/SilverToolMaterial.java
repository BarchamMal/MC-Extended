package barch.mc_extended.Tools;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Minerals.Silver;
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

public class SilverToolMaterial implements ToolMaterial {

    public static final SilverToolMaterial INSTANCE = new SilverToolMaterial();

    public static final Item SILVER_SWORD = registerSword("silver", 4, -2, INSTANCE, new Item.Settings());
    public static final Item SILVER_AXE = registerAxe("silver", 5, -3, INSTANCE, new Item.Settings());
    public static final Item SILVER_HOE = registerHoe("silver", -5, 0, INSTANCE, new Item.Settings());
    public static final Item SILVER_SHOVEL = registerShovel("silver", 1.5f, -3, INSTANCE, new Item.Settings());
    public static final Item SILVER_PICKAXE = registerPickaxe("silver", 0, -2, INSTANCE, new Item.Settings());

    @Override
    public int getDurability() {
        return 56;
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
    public TagKey<Block> getInverseTag() {
        return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Silver.SILVER_INGOT);
    }

    public static void GroupTools() {

        ItemGrouper.GroupItem(SILVER_SWORD, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.GOLDEN_SWORD)});
        ItemGrouper.GroupItem(SILVER_SHOVEL, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, Items.GOLDEN_HOE)});
        ItemGrouper.GroupItem(SILVER_PICKAXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, SILVER_SHOVEL)});
        ItemGrouper.GroupItem(SILVER_AXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, SILVER_PICKAXE), new ItemGrouped(ItemGroups.COMBAT, Items.GOLDEN_AXE)});
        ItemGrouper.GroupItem(SILVER_HOE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, SILVER_HOE)});

    }
}
