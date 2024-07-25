package barch.mc_extended.Tools;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
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

public class RubyToolMaterial implements ToolMaterial {

    public static final RubyToolMaterial INSTANCE = new RubyToolMaterial();

    public static final ToolItem RUBY_SWORD = new SwordItem(RubyToolMaterial.INSTANCE, new Item.Settings());
    public static final ToolItem RUBY_AXE = new AxeItem(RubyToolMaterial.INSTANCE, new Item.Settings());

    public static final ToolItem RUBY_HOE = new HoeItem(RubyToolMaterial.INSTANCE, new Item.Settings());

    public static final ToolItem RUBY_SHOVEL = new ShovelItem(RubyToolMaterial.INSTANCE,new Item.Settings());

    public static final ToolItem RUBY_PICKAXE = new PickaxeItem(RubyToolMaterial.INSTANCE,new Item.Settings());

    @Override
    public int getDurability() {
        return 1561;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8f;
    }

    @Override
    public float getAttackDamage() {
        return 3;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RUBY);
    }

    public static void RegisterTools() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "ruby_sword"), RUBY_SWORD);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "ruby_axe"), RUBY_AXE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "ruby_hoe"), RUBY_HOE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "ruby_shovel"), RUBY_SHOVEL);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "ruby_pickaxe"), RUBY_PICKAXE);

    }

    public static void GroupTools() {

        ItemGrouper.GroupItem(RUBY_SWORD, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.DIAMOND_SWORD)});
        ItemGrouper.GroupItem(RUBY_SHOVEL, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, Items.DIAMOND_HOE)});
        ItemGrouper.GroupItem(RUBY_PICKAXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, RUBY_SHOVEL)});
        ItemGrouper.GroupItem(RUBY_AXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, RUBY_PICKAXE), new ItemGrouped(ItemGroups.COMBAT, Items.DIAMOND_AXE)});
        ItemGrouper.GroupItem(RUBY_HOE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, RUBY_HOE)});

    }
}
