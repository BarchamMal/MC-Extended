package barch.mc_extended.Tools;

import barch.mc_extended.Tags;
import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import barch.mc_extended.Minerals.Silver;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.*;
import static barch.mc_extended.Tools.MCEToolMaterials.*;

public class SilverTool {

    public static final ToolMaterial SILVER_TOOL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 56, 13, 5, 20, Tags.ItemTags.SILVER_REPAIRS);

    public static final Item SILVER_SWORD = registerTool("silver", new SwordItem(SILVER_TOOL, 4, -2, new Item.Settings()));
    public static final Item SILVER_AXE = registerTool("silver", new AxeItem(SILVER_TOOL, 5, -3, new Item.Settings()));
    public static final Item SILVER_HOE = registerTool("silver", new HoeItem(SILVER_TOOL, -5, 0, new Item.Settings()));
    public static final Item SILVER_SHOVEL = registerTool("silver", new ShovelItem(SILVER_TOOL, 1.5f, -3, new Item.Settings()));
    public static final Item SILVER_PICKAXE = registerTool("silver", new PickaxeItem(SILVER_TOOL, 0, -2, new Item.Settings()));

    public static void GroupTools() {

        MCE_ITEM_GROUPER.GroupItem(SILVER_SWORD, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, Items.GOLDEN_SWORD)});
        MCE_ITEM_GROUPER.GroupItem(SILVER_SHOVEL, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, Items.GOLDEN_HOE)});
        MCE_ITEM_GROUPER.GroupItem(SILVER_PICKAXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, SILVER_SHOVEL)});
        MCE_ITEM_GROUPER.GroupItem(SILVER_AXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, SILVER_PICKAXE), new ItemGroupItem(ItemGroups.COMBAT, Items.GOLDEN_AXE)});
        MCE_ITEM_GROUPER.GroupItem(SILVER_HOE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, SILVER_HOE)});

    }
}
