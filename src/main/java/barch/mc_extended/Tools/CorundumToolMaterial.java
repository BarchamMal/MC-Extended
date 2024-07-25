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

import static barch.mc_extended.MCExtended.NAMESPACE;

public class CorundumToolMaterial implements ToolMaterial {

    public static final CorundumToolMaterial INSTANCE = new CorundumToolMaterial();

    public static final ToolItem CORUNDUM_SWORD = new SwordItem(CorundumToolMaterial.INSTANCE, new Item.Settings());
    public static final ToolItem CORUNDUM_AXE = new AxeItem(CorundumToolMaterial.INSTANCE, new Item.Settings());
    public static final ToolItem CORUNDUM_HOE = new HoeItem(CorundumToolMaterial.INSTANCE, new Item.Settings());
    public static final ToolItem CORUNDUM_SHOVEL = new ShovelItem(CorundumToolMaterial.INSTANCE, new Item.Settings());
    public static final ToolItem CORUNDUM_PICKAXE = new PickaxeItem(CorundumToolMaterial.INSTANCE, new Item.Settings());

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

    public static void RegisterTools() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "corundum_sword"), CORUNDUM_SWORD);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "corundum_axe"), CORUNDUM_AXE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "corundum_hoe"), CORUNDUM_HOE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "corundum_shovel"), CORUNDUM_SHOVEL);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "corundum_pickaxe"), CORUNDUM_PICKAXE);

    }

    public static void GroupTools() {

        ItemGrouper.GroupItem(CORUNDUM_SWORD, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.NETHERITE_SWORD)});
        ItemGrouper.GroupItem(CORUNDUM_SHOVEL, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, Items.NETHERITE_HOE)});
        ItemGrouper.GroupItem(CORUNDUM_PICKAXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, CORUNDUM_SHOVEL)});
        ItemGrouper.GroupItem(CORUNDUM_AXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, CORUNDUM_PICKAXE), new ItemGrouped(ItemGroups.COMBAT, Items.NETHERITE_AXE)});
        ItemGrouper.GroupItem(CORUNDUM_HOE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, CORUNDUM_HOE)});

    }
}
