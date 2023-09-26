package barch.mc_extended.Tools;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Minerals.Bronze;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.*;

public class BronzeToolMaterial implements ToolMaterial {

    public static final BronzeToolMaterial INSTANCE = new BronzeToolMaterial();

    public static final ToolItem BRONZE_SWORD = new SwordItem(BronzeToolMaterial.INSTANCE, 0, -2.4f, new FabricItemSettings());
    public static final ToolItem BRONZE_AXE = new AxeItem(BronzeToolMaterial.INSTANCE, 2f, -3.1f, new FabricItemSettings());
    public static final ToolItem BRONZE_HOE = new HoeItem(BronzeToolMaterial.INSTANCE, -5, 1, new FabricItemSettings());
    public static final ToolItem BRONZE_SHOVEL = new ShovelItem(BronzeToolMaterial.INSTANCE, 1.5f, -3f, new FabricItemSettings());
    public static final ToolItem BRONZE_PICKAXE = new PickaxeItem(BronzeToolMaterial.INSTANCE, -2, -2.5f, new FabricItemSettings());

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
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Bronze.BRONZE_INGOT);
    }

    public static void RegisterTools() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bronze_sword"), BRONZE_SWORD);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bronze_axe"), BRONZE_AXE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bronze_hoe"), BRONZE_HOE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bronze_shovel"), BRONZE_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bronze_pickaxe"), BRONZE_PICKAXE);

    }

    public static void GroupTools() {

        ItemGrouper.GroupItem(BRONZE_SWORD, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.IRON_SWORD)});
        ItemGrouper.GroupItem(BRONZE_SHOVEL, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, Items.IRON_HOE)});
        ItemGrouper.GroupItem(BRONZE_PICKAXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, BRONZE_SHOVEL)});
        ItemGrouper.GroupItem(BRONZE_AXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, BRONZE_PICKAXE), new ItemGrouped(ItemGroups.COMBAT, Items.IRON_AXE)});
        ItemGrouper.GroupItem(BRONZE_HOE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, BRONZE_HOE)});

    }
}
