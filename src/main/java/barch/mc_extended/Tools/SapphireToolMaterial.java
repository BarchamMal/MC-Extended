package barch.mc_extended.Tools;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED;
import static barch.mc_extended.Minerals.Sapphire.SAPPHIRE;
import static barch.mc_extended.Tools.MCEToolMaterials.*;
import static barch.mc_extended.Tools.RubyToolMaterial.*;

public class SapphireToolMaterial implements ToolMaterial {

    public static final SapphireToolMaterial INSTANCE = new SapphireToolMaterial();

    public static final Item SAPPHIRE_SWORD = registerSword("sapphire", 3, -2, INSTANCE, new Item.Settings());
    public static final Item SAPPHIRE_AXE = registerAxe("sapphire", 5, -3, INSTANCE, new Item.Settings());
    public static final Item SAPPHIRE_HOE = registerHoe("sapphire", -3, 0, INSTANCE, new Item.Settings());
    public static final Item SAPPHIRE_SHOVEL = registerShovel("sapphire", 1.5f, -3, INSTANCE, new Item.Settings());
    public static final Item SAPPHIRE_PICKAXE = registerPickaxe("sapphire", 0, -2.8f, INSTANCE, new Item.Settings());

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
        return Ingredient.ofItems(SAPPHIRE);
    }

    public static void GroupTools() {

        ItemGrouper.GroupItem(SAPPHIRE_SWORD, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, RUBY_SWORD)});
        ItemGrouper.GroupItem(SAPPHIRE_SHOVEL, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, RUBY_HOE)});
        ItemGrouper.GroupItem(SAPPHIRE_PICKAXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, SAPPHIRE_SHOVEL)});
        ItemGrouper.GroupItem(SAPPHIRE_AXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, SAPPHIRE_PICKAXE), new ItemGrouped(ItemGroups.COMBAT, RUBY_AXE)});
        ItemGrouper.GroupItem(SAPPHIRE_HOE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, SAPPHIRE_HOE)});

    }
}
