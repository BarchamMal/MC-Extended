package barch.mc_extended.Tools;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Minerals.Corundum;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.NAMESPACE;

public class CorundumToolMaterial implements ToolMaterial {

    public static final CorundumToolMaterial INSTANCE = new CorundumToolMaterial();

    public static final ToolItem CORUNDUM_SWORD = new SwordItem(CorundumToolMaterial.INSTANCE, 4, -2f, new FabricItemSettings());
    public static final ToolItem CORUNDUM_AXE = new AxeItem(CorundumToolMaterial.INSTANCE, 5f, -3f, new FabricItemSettings());
    public static final ToolItem CORUNDUM_HOE = new HoeItem(CorundumToolMaterial.INSTANCE, -5, 0, new FabricItemSettings());
    public static final ToolItem CORUNDUM_SHOVEL = new ShovelItem(CorundumToolMaterial.INSTANCE, 1.5f, -3f, new FabricItemSettings());
    public static final ToolItem CORUNDUM_PICKAXE = new PickaxeItem(CorundumToolMaterial.INSTANCE, 0, -2f, new FabricItemSettings());

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
    public int getMiningLevel() {
        return 6;
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

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_sword"), CORUNDUM_SWORD);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_axe"), CORUNDUM_AXE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_hoe"), CORUNDUM_HOE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_shovel"), CORUNDUM_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_pickaxe"), CORUNDUM_PICKAXE);

    }

    public static void GroupTools() {

        ItemGrouper.GroupItem(CORUNDUM_SWORD, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.NETHERITE_SWORD)});
        ItemGrouper.GroupItem(CORUNDUM_SHOVEL, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, Items.NETHERITE_HOE)});
        ItemGrouper.GroupItem(CORUNDUM_PICKAXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, CORUNDUM_SHOVEL)});
        ItemGrouper.GroupItem(CORUNDUM_AXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, CORUNDUM_PICKAXE), new ItemGrouped(ItemGroups.COMBAT, Items.NETHERITE_AXE)});
        ItemGrouper.GroupItem(CORUNDUM_HOE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, CORUNDUM_HOE)});

    }
}
