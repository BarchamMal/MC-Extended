package barch.mc_extended.Tools;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Minerals.Corundum;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED;
import static barch.mc_extended.Tools.MCEToolMaterials.*;

public class CorundumToolMaterial implements ToolMaterial {

    public static final CorundumToolMaterial INSTANCE = new CorundumToolMaterial();

    public static final Item CORUNDUM_SWORD = registerSword("corundum", 4, -2, INSTANCE, new Item.Settings());
    public static final Item CORUNDUM_AXE = registerAxe("corundum", 5, -3, INSTANCE, new Item.Settings());
    public static final Item CORUNDUM_HOE = registerHoe("corundum", -5, 0, INSTANCE, new Item.Settings());
    public static final Item CORUNDUM_SHOVEL = registerShovel("corundum", 1.5f, -3, INSTANCE, new Item.Settings());
    public static final Item CORUNDUM_PICKAXE = registerPickaxe("corundum", 0, -2, INSTANCE, new Item.Settings());

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
    public TagKey<Block> getInverseTag() {
        return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Corundum.CORUNDUM);
    }

    public static void GroupTools() {

        ItemGrouper.GroupItem(CORUNDUM_SWORD, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.NETHERITE_SWORD)});
        ItemGrouper.GroupItem(CORUNDUM_SHOVEL, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, Items.NETHERITE_HOE)});
        ItemGrouper.GroupItem(CORUNDUM_PICKAXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, CORUNDUM_SHOVEL)});
        ItemGrouper.GroupItem(CORUNDUM_AXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, CORUNDUM_PICKAXE), new ItemGrouped(ItemGroups.COMBAT, Items.NETHERITE_AXE)});
        ItemGrouper.GroupItem(CORUNDUM_HOE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, CORUNDUM_HOE)});

    }
}
