package barch.mc_extended.Tools;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Minerals.Tin;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.*;

public class TinToolMaterial implements ToolMaterial {

    public static final TinToolMaterial INSTANCE = new TinToolMaterial();

    public static final ToolItem TIN_SWORD = new SwordItem(TinToolMaterial.INSTANCE, 0, -2.4f, new FabricItemSettings());
    public static final ToolItem TIN_AXE = new AxeItem(TinToolMaterial.INSTANCE, 2f, -3.1f, new FabricItemSettings());
    public static final ToolItem TIN_HOE = new HoeItem(TinToolMaterial.INSTANCE, -5, -1, new FabricItemSettings());
    public static final ToolItem TIN_SHOVEL = new ShovelItem(TinToolMaterial.INSTANCE, -1.5f, -3f, new FabricItemSettings());
    public static final ToolItem TIN_PICKAXE = new PickaxeItem(TinToolMaterial.INSTANCE, -2, -2.5f, new FabricItemSettings());
    
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
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Tin.TIN_INGOT);
    }

    public static void RegisterTools() {
        
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_sword"), TIN_SWORD);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_axe"), TIN_AXE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_hoe"), TIN_HOE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_shovel"), TIN_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_pickaxe"), TIN_PICKAXE);

    }

    public static void GroupTools() {

        ItemGrouper.GroupItem(TIN_SWORD, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, TIN_SWORD)});
        ItemGrouper.GroupItem(TIN_SHOVEL, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, TIN_HOE)});
        ItemGrouper.GroupItem(TIN_PICKAXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, TIN_SHOVEL)});
        ItemGrouper.GroupItem(TIN_AXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, TIN_PICKAXE), new ItemGrouped(ItemGroups.COMBAT, TIN_AXE)});
        ItemGrouper.GroupItem(TIN_HOE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, TIN_HOE)});

    }
}
