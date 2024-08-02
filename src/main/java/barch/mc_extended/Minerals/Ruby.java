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
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static barch.mc_extended.MCExtended.*;

public class Ruby {

    public static final Block RUBY_ORE = new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), BlockBuilder.CloneBlock(Blocks.DIAMOND_ORE).mapColor(DyeColor.LIGHT_GRAY).requiresTool().strength(3,3));
    public static final Block DEEPSLATE_RUBY_ORE = new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), BlockBuilder.CloneBlock(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(DyeColor.GRAY).requiresTool().strength(5, 6));
    public static final Block RUBY_BLOCK = new Block(BlockBuilder.CloneBlock(Blocks.DIAMOND_BLOCK).mapColor(DyeColor.RED).requiresTool().strength(5,6));

     public static final Item RUBY = new Item(new Item.Settings());

    public static void RegisterAll() {

        Ruby.RegisterBlocks();
        Ruby.RegisterBlockItems();
        Ruby.RegisterItems();
        Ruby.GroupItems();

    }

    public static void RegisterBlocks() {

        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "ruby_ore"), RUBY_ORE);
        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "deepslate_ruby_ore"), DEEPSLATE_RUBY_ORE);
        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "ruby_block"), RUBY_BLOCK);

    }

    public static void RegisterBlockItems() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "deepslate_ruby_ore"), new BlockItem(DEEPSLATE_RUBY_ORE, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "ruby_ore"), new BlockItem(RUBY_ORE, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "ruby_block"), new BlockItem(RUBY_BLOCK, new Item.Settings()));


    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "ruby"), RUBY);

    }

    public static void GroupItems() {

        MCE_ITEM_GROUPER.GroupItem(RUBY, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, Items.DIAMOND)});
        MCE_ITEM_GROUPER.GroupItem(RUBY_ORE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.NATURAL, Blocks.DEEPSLATE_DIAMOND_ORE)});
        MCE_ITEM_GROUPER.GroupItem(DEEPSLATE_RUBY_ORE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.NATURAL, RUBY_ORE)});
        MCE_ITEM_GROUPER.GroupItem(RUBY_BLOCK, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.BUILDING_BLOCKS, Blocks.DIAMOND_BLOCK)});

    }
}