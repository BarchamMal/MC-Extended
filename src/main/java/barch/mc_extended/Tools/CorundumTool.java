package barch.mc_extended.Tools;

import barch.mc_extended.Tags;
import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
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

public class CorundumTool {

    public static final ToolMaterial CORUNDUM_TOOL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2800,
            13f,
            5,
            5,
            Tags.ItemTags.CORUNDUM_REPAIRS
    );

    public static final Item CORUNDUM_SWORD = registerTool("corundum", new SwordItem(CORUNDUM_TOOL, 4, -2, new Item.Settings()));
    public static final Item CORUNDUM_AXE = registerTool("corundum", new AxeItem(CORUNDUM_TOOL, 5, -3, new Item.Settings()));
    public static final Item CORUNDUM_HOE = registerTool("corundum", new HoeItem(CORUNDUM_TOOL, -5, 0, new Item.Settings()));
    public static final Item CORUNDUM_SHOVEL = registerTool("corundum", new ShovelItem(CORUNDUM_TOOL, 1.5f, -3, new Item.Settings()));
    public static final Item CORUNDUM_PICKAXE = registerTool("corundum", new PickaxeItem(CORUNDUM_TOOL, 0, -2, new Item.Settings()));

    public static void GroupTools() {

        MCE_ITEM_GROUPER.GroupItem(CORUNDUM_SWORD, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, Items.NETHERITE_SWORD)});
        MCE_ITEM_GROUPER.GroupItem(CORUNDUM_SHOVEL, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, Items.NETHERITE_HOE)});
        MCE_ITEM_GROUPER.GroupItem(CORUNDUM_PICKAXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, CORUNDUM_SHOVEL)});
        MCE_ITEM_GROUPER.GroupItem(CORUNDUM_AXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, CORUNDUM_PICKAXE), new ItemGroupItem(ItemGroups.COMBAT, Items.NETHERITE_AXE)});
        MCE_ITEM_GROUPER.GroupItem(CORUNDUM_HOE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, CORUNDUM_HOE)});
    }
}