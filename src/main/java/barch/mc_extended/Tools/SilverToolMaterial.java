package barch.mc_extended.Tools;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Minerals.Silver;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.*;

public class SilverToolMaterial implements ToolMaterial {

    public static final SilverToolMaterial INSTANCE = new SilverToolMaterial();

    public static final ToolItem SILVER_SWORD = new SwordItem(SilverToolMaterial.INSTANCE, 4, -2f, new FabricItemSettings());
    public static final ToolItem SILVER_AXE = new AxeItem(SilverToolMaterial.INSTANCE, 5f, -3f, new FabricItemSettings());
    public static final ToolItem SILVER_HOE = new HoeItem(SilverToolMaterial.INSTANCE, -5, 0, new FabricItemSettings());
    public static final ToolItem SILVER_SHOVEL = new ShovelItem(SilverToolMaterial.INSTANCE, 1.5f, -3f, new FabricItemSettings());
    public static final ToolItem SILVER_PICKAXE = new PickaxeItem(SilverToolMaterial.INSTANCE, 0, -2f, new FabricItemSettings());

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
    public int getMiningLevel() {
        return 6;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Silver.SILVER_INGOT);
    }

    public static void RegisterTools() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_sword"), SILVER_SWORD);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_axe"), SILVER_AXE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_hoe"), SILVER_HOE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_shovel"), SILVER_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_pickaxe"), SILVER_PICKAXE);

    }

    public static void GroupTools() {

        ItemGrouper.GroupItem(SILVER_SWORD, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.GOLDEN_SWORD)});
        ItemGrouper.GroupItem(SILVER_SHOVEL, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, Items.GOLDEN_HOE)});
        ItemGrouper.GroupItem(SILVER_PICKAXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, SILVER_SHOVEL)});
        ItemGrouper.GroupItem(SILVER_AXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, SILVER_PICKAXE), new ItemGrouped(ItemGroups.COMBAT, Items.GOLDEN_AXE)});
        ItemGrouper.GroupItem(SILVER_HOE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, SILVER_HOE)});

    }
}
