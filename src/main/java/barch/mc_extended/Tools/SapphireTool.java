package barch.mc_extended.Tools;

import barch.mc_extended.Tags;
import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;

import static barch.mc_extended.Tools.MCEToolMaterials.registerTool;
import static barch.mc_extended.Tools.RubyTool.*;

public class SapphireTool {

    public static final ToolMaterial SAPPHIRE_TOOL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1561,
            8f,
            3,
            15,
            Tags.ItemTags.SAPPHIRE_REPAIRS
    );

    public static final Item SAPPHIRE_SWORD = registerTool("sapphire", new SwordItem(SAPPHIRE_TOOL, 3, -2, new Item.Settings()));
    public static final Item SAPPHIRE_AXE = registerTool("sapphire", new AxeItem(SAPPHIRE_TOOL, 5, -3, new Item.Settings()));
    public static final Item SAPPHIRE_HOE = registerTool("sapphire", new HoeItem(SAPPHIRE_TOOL, -3, 0, new Item.Settings()));
    public static final Item SAPPHIRE_SHOVEL = registerTool("sapphire", new ShovelItem(SAPPHIRE_TOOL, 1.5f, -3, new Item.Settings()));
    public static final Item SAPPHIRE_PICKAXE = registerTool("sapphire", new PickaxeItem(SAPPHIRE_TOOL, 0, -2.8f, new Item.Settings()));

    public static void GroupTools() {
        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_SWORD, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, RUBY_SWORD)});
        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_SHOVEL, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, RUBY_HOE)});
        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_PICKAXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, SAPPHIRE_SHOVEL)});
        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_AXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, SAPPHIRE_PICKAXE), new ItemGroupItem(ItemGroups.COMBAT, RUBY_AXE)});
        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_HOE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, SAPPHIRE_HOE)});
    }
}