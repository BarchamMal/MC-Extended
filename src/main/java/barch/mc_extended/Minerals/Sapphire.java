package barch.mc_extended.Minerals;

import net.barch.barch_lib.Blocks.BlockBuilder;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.barch.barch_lib.Items.ItemGroupItem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static barch.mc_extended.MCExtended.MC_EXTENDED;
import static barch.mc_extended.Minerals.Ruby.*;

public class Sapphire {

    public static final Block SAPPHIRE_ORE = new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), BlockBuilder.CloneBlock(Blocks.DIAMOND_ORE).mapColor(DyeColor.LIGHT_GRAY).requiresTool().strength(3,3));
    public static final Block DEEPSLATE_SAPPHIRE_ORE = new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), BlockBuilder.CloneBlock(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(DyeColor.GRAY).requiresTool().strength(5,6));
    public static final Block SAPPHIRE_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.DIAMOND_BLOCK).mapColor(DyeColor.RED).requiresTool().strength(5,6));

    public static final Item SAPPHIRE = new Item(new Item.Settings());

    public static void RegisterAll() {

        Sapphire.RegisterBlocks();
        Sapphire.RegisterBlockItems();
        Sapphire.RegisterItems();
        Sapphire.GroupItems();

    }

    public static void RegisterBlocks() {

        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "sapphire_ore"), SAPPHIRE_ORE);
        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "deepslate_sapphire_ore"), DEEPSLATE_SAPPHIRE_ORE);
        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "sapphire_block"), SAPPHIRE_BLOCK);

    }

    public static void RegisterBlockItems() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "deepslate_sapphire_ore"), new BlockItem(DEEPSLATE_SAPPHIRE_ORE, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "sapphire_ore"), new BlockItem(SAPPHIRE_ORE, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "sapphire_block"), new BlockItem(SAPPHIRE_BLOCK, new Item.Settings()));

    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "sapphire"), SAPPHIRE);

    }

    public static void GroupItems() {

        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, RUBY)});
        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_ORE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.NATURAL, DEEPSLATE_RUBY_ORE)});
        MCE_ITEM_GROUPER.GroupItem(DEEPSLATE_SAPPHIRE_ORE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.NATURAL, SAPPHIRE_ORE)});
        MCE_ITEM_GROUPER.GroupItem(SAPPHIRE_BLOCK, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.BUILDING_BLOCKS, RUBY_BLOCK)});

    }
}