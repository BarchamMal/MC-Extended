package barch.mc_extended.Tools;

import barch.mc_extended.Tags;
import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import barch.mc_extended.Minerals.Tin;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;

import static barch.mc_extended.MCExtended.*;
import static barch.mc_extended.Tools.MCEToolMaterials.*;

public class TinTool {

    public static final ToolMaterial TIN_TOOL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_STONE_TOOL,
            150,
            4f,
            5,
            5,
            Tags.ItemTags.TIN_REPAIRS
    );

    public static final Item TIN_SWORD = registerTool("tin", new SwordItem(TIN_TOOL, 0, -2.4f, new Item.Settings()));
    public static final Item TIN_AXE = registerTool("tin", new AxeItem(TIN_TOOL, 2, -3.1f, new Item.Settings()));
    public static final Item TIN_HOE = registerTool("tin", new HoeItem(TIN_TOOL, -5, -1, new Item.Settings()));
    public static final Item TIN_SHOVEL = registerTool("tin", new ShovelItem(TIN_TOOL, 1.5f, -3, new Item.Settings()));
    public static final Item TIN_PICKAXE = registerTool("tin", new PickaxeItem(TIN_TOOL, 2, -2.5f, new Item.Settings()));

    public static void GroupTools() {
        MCE_ITEM_GROUPER.GroupItem(TIN_SWORD, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, TIN_SWORD)});
        MCE_ITEM_GROUPER.GroupItem(TIN_SHOVEL, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, TIN_HOE)});
        MCE_ITEM_GROUPER.GroupItem(TIN_PICKAXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, TIN_SHOVEL)});
        MCE_ITEM_GROUPER.GroupItem(TIN_AXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, TIN_PICKAXE), new ItemGroupItem(ItemGroups.COMBAT, TIN_AXE)});
        MCE_ITEM_GROUPER.GroupItem(TIN_HOE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, TIN_HOE)});
    }
}