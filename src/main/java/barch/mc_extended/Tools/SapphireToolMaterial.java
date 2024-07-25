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

import static barch.mc_extended.MCExtended.NAMESPACE;
import static barch.mc_extended.Minerals.Sapphire.SAPPHIRE;
import static barch.mc_extended.Tools.RubyToolMaterial.*;

public class SapphireToolMaterial implements ToolMaterial {

    public static final SapphireToolMaterial INSTANCE = new SapphireToolMaterial();

    public static final ToolItem SAPPHIRE_SWORD = new SwordItem(SapphireToolMaterial.INSTANCE, new Item.Settings());
    public static final ToolItem SAPPHIRE_AXE = new AxeItem(SapphireToolMaterial.INSTANCE, new Item.Settings());
    public static final ToolItem SAPPHIRE_HOE = new HoeItem(SapphireToolMaterial.INSTANCE, new Item.Settings());
    public static final ToolItem SAPPHIRE_SHOVEL = new ShovelItem(SapphireToolMaterial.INSTANCE, new Item.Settings());
    public static final ToolItem SAPPHIRE_PICKAXE = new PickaxeItem(SapphireToolMaterial.INSTANCE, new Item.Settings());

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
        return Ingredient.ofItems(SAPPHIRE);
    }

    public static void RegisterTools() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sapphire_sword"), SAPPHIRE_SWORD);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sapphire_axe"), SAPPHIRE_AXE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sapphire_hoe"), SAPPHIRE_HOE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sapphire_shovel"), SAPPHIRE_SHOVEL);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sapphire_pickaxe"), SAPPHIRE_PICKAXE);

    }

    public static void GroupTools() {

        ItemGrouper.GroupItem(SAPPHIRE_SWORD, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, RUBY_SWORD)});
        ItemGrouper.GroupItem(SAPPHIRE_SHOVEL, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, RUBY_HOE)});
        ItemGrouper.GroupItem(SAPPHIRE_PICKAXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, SAPPHIRE_SHOVEL)});
        ItemGrouper.GroupItem(SAPPHIRE_AXE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, SAPPHIRE_PICKAXE), new ItemGrouped(ItemGroups.COMBAT, RUBY_AXE)});
        ItemGrouper.GroupItem(SAPPHIRE_HOE, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, SAPPHIRE_HOE)});

    }
}
