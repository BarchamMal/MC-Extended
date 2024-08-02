package barch.mc_extended.Tools;

import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import barch.mc_extended.Minerals.Tin;
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

public class TinToolMaterial implements ToolMaterial {

    public static final TinToolMaterial INSTANCE = new TinToolMaterial();

    public static final Item TIN_SWORD = registerSword("tin", 0, -2.4f, INSTANCE, new Item.Settings());
    public static final Item TIN_AXE = registerAxe("tin", 2, -3.1f, INSTANCE, new Item.Settings());
    public static final Item TIN_HOE = registerHoe("tin", -5, -1, INSTANCE, new Item.Settings());
    public static final Item TIN_SHOVEL = registerShovel("tin", 1.5f, -3, INSTANCE, new Item.Settings());
    public static final Item TIN_PICKAXE = registerPickaxe("tin", 2, -2.5f, INSTANCE, new Item.Settings());
    
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
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Tin.TIN_INGOT);
    }

    public static void GroupTools() {

        MCE_ITEM_GROUPER.GroupItem(TIN_SWORD, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, TIN_SWORD)});
        MCE_ITEM_GROUPER.GroupItem(TIN_SHOVEL, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, TIN_HOE)});
        MCE_ITEM_GROUPER.GroupItem(TIN_PICKAXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, TIN_SHOVEL)});
        MCE_ITEM_GROUPER.GroupItem(TIN_AXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, TIN_PICKAXE), new ItemGroupItem(ItemGroups.COMBAT, TIN_AXE)});
        MCE_ITEM_GROUPER.GroupItem(TIN_HOE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, TIN_HOE)});

    }
}
