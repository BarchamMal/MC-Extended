package barch.mc_extended.Tools;

import barch.mc_extended.Tags;
import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import static barch.mc_extended.Tools.MCEToolMaterials.*;
import static barch.mc_extended.Tools.SilverTool.*;

public class CopperTool {

    public static final ToolMaterial COPPER_TOOL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_STONE_TOOL,
            150,
            4f,
            5,
            15,
            Tags.ItemTags.COPPER_REPAIRS
    );

    public static final Item COPPER_SWORD = registerTool("copper", new SwordItem(COPPER_TOOL, 0, -2.4f, new Item.Settings()));
    public static final Item COPPER_AXE = registerTool("copper", new AxeItem(COPPER_TOOL, 2, -3.1f, new Item.Settings()));
    public static final Item COPPER_HOE = registerTool("copper", new HoeItem(COPPER_TOOL, -5, -1, new Item.Settings()));
    public static final Item COPPER_SHOVEL = registerTool("copper", new ShovelItem(COPPER_TOOL, 1.5f, -3, new Item.Settings()));
    public static final Item COPPER_PICKAXE = registerTool("copper", new PickaxeItem(COPPER_TOOL, -2, -2.5f, new Item.Settings()));

    public static void GroupTools() {

        MCE_ITEM_GROUPER.GroupItem(COPPER_SWORD, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, SILVER_SWORD)});
        MCE_ITEM_GROUPER.GroupItem(COPPER_SHOVEL, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, SILVER_HOE)});
        MCE_ITEM_GROUPER.GroupItem(COPPER_PICKAXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, COPPER_SHOVEL)});
        MCE_ITEM_GROUPER.GroupItem(COPPER_AXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, COPPER_PICKAXE), new ItemGroupItem(ItemGroups.COMBAT, SILVER_AXE)});
        MCE_ITEM_GROUPER.GroupItem(COPPER_HOE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, COPPER_HOE)});
    }
}