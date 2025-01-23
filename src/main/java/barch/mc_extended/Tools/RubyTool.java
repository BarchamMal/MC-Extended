package barch.mc_extended.Tools;

import barch.mc_extended.Tags;
import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static barch.mc_extended.Minerals.Ruby.*;
import static barch.mc_extended.MCExtended.*;
import static barch.mc_extended.Tools.MCEToolMaterials.*;

public class RubyTool {

    public static final ToolMaterial RUBY_TOOL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1561,
            8f,
            3,
            15,
            Tags.ItemTags.RUBY_REPAIRS
    );

    public static final Item RUBY_SWORD = registerTool("ruby", new SwordItem(RUBY_TOOL, 3, -2, new Item.Settings()));
    public static final Item RUBY_AXE = registerTool("ruby", new AxeItem(RUBY_TOOL, 5, -3, new Item.Settings()));
    public static final Item RUBY_HOE = registerTool("ruby", new HoeItem(RUBY_TOOL, -3, 0, new Item.Settings()));
    public static final Item RUBY_SHOVEL = registerTool("ruby", new ShovelItem(RUBY_TOOL, 1.5f, -3, new Item.Settings()));
    public static final Item RUBY_PICKAXE = registerTool("ruby", new PickaxeItem(RUBY_TOOL, 0, -2.8f, new Item.Settings()));

    public static void GroupTools() {

        MCE_ITEM_GROUPER.GroupItem(RUBY_SWORD, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.COMBAT, Items.DIAMOND_SWORD)});
        MCE_ITEM_GROUPER.GroupItem(RUBY_SHOVEL, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, Items.DIAMOND_HOE)});
        MCE_ITEM_GROUPER.GroupItem(RUBY_PICKAXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, RUBY_SHOVEL)});
        MCE_ITEM_GROUPER.GroupItem(RUBY_AXE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, RUBY_PICKAXE), new ItemGroupItem(ItemGroups.COMBAT, Items.DIAMOND_AXE)});
        MCE_ITEM_GROUPER.GroupItem(RUBY_HOE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, RUBY_HOE)});
    }
}