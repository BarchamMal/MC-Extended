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

import static barch.mc_extended.MCExtended.*;
import static barch.mc_extended.Tools.SilverToolMaterial.*;

public class CopperToolMaterial implements ToolMaterial {

    public static final CopperToolMaterial INSTANCE = new CopperToolMaterial();

    public static final ToolItem COPPER_SWORD = new SwordItem(CopperToolMaterial.INSTANCE, new Item.Settings());
    public static final ToolItem COPPER_AXE = new AxeItem(CopperToolMaterial.INSTANCE, new Item.Settings());
    public static final ToolItem COPPER_HOE = new HoeItem(CopperToolMaterial.INSTANCE, new Item.Settings());
    public static final ToolItem COPPER_SHOVEL = new ShovelItem(CopperToolMaterial.INSTANCE, new Item.Settings());
    public static final ToolItem COPPER_PICKAXE = new PickaxeItem(CopperToolMaterial.INSTANCE, new Item.Settings());

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

    public static void RegisterTools() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "copper_sword"), COPPER_SWORD);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "copper_axe"), COPPER_AXE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "copper_hoe"), COPPER_HOE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "copper_shovel"), COPPER_SHOVEL);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "copper_pickaxe"), COPPER_PICKAXE);

    }

    public static void GroupTools() {

        ItemGrouper.GroupItem(COPPER_SWORD, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SILVER_SWORD)});
        ItemGrouper.GroupItem(COPPER_SHOVEL, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, SILVER_HOE)});
        ItemGrouper.GroupItem(COPPER_PICKAXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, COPPER_SHOVEL)});
        ItemGrouper.GroupItem(COPPER_AXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, COPPER_PICKAXE), new ItemGrouped(ItemGroups.COMBAT, SILVER_AXE)});
        ItemGrouper.GroupItem(COPPER_HOE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, COPPER_HOE)});

    }
}
