package barch.mc_extended.Tools;

import barch.mc_extended.Tags;
import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import barch.mc_extended.Minerals.Bronze;
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

public class BronzeTool {

    public static final ToolMaterial BRONZE_TOOL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            230,
            6f,
            5,
            15,
            Tags.ItemTags.BRONZE_REPAIRS
    );

    public static final Item BRONZE_SWORD = registerTool("bronze", new SwordItem(BRONZE_TOOL, 0, -2.4f, new Item.Settings()));
    public static final Item BRONZE_AXE = registerTool("bronze", new AxeItem(BRONZE_TOOL, 2, -3.1f, new Item.Settings()));
    public static final Item BRONZE_HOE = registerTool("bronze", new HoeItem(BRONZE_TOOL, -5, 1, new Item.Settings()));
    public static final Item BRONZE_SHOVEL = registerTool("bronze", new ShovelItem(BRONZE_TOOL, 1.5f, -3, new Item.Settings()));
    public static final Item BRONZE_PICKAXE = registerTool("bronze", new PickaxeItem(BRONZE_TOOL, -2, -2.5f, new Item.Settings()));

    public static void GroupTools() {

        MCE_ITEM_GROUPER.GroupItem(BRONZE_SWORD, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, Items.IRON_SWORD)});
        MCE_ITEM_GROUPER.GroupItem(BRONZE_SHOVEL, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, Items.IRON_HOE)});
        MCE_ITEM_GROUPER.GroupItem(BRONZE_PICKAXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, BRONZE_SHOVEL)});
        MCE_ITEM_GROUPER.GroupItem(BRONZE_AXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, BRONZE_PICKAXE), new ItemGroupItem(ItemGroups.COMBAT, Items.IRON_AXE)});
        MCE_ITEM_GROUPER.GroupItem(BRONZE_HOE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, BRONZE_HOE)});
    }
}