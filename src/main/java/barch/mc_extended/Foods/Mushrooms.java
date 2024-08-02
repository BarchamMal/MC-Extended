package barch.mc_extended.Foods;

import net.barch.barch_lib.Blocks.BlockBuilder;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.barch.barch_lib.Items.ItemGroupItem;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import static barch.mc_extended.MCExtended.*;

public class Mushrooms {

    public static final RegistryKey<PlacedFeature> HUGE_WHITE_MUSHROOM = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MC_EXTENDED, "huge_white_mushroom"));
    public static final RegistryKey<ConfiguredFeature<?, ?>> HUGE_WHITE_MUSHROOM_CONFIG = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MC_EXTENDED, "huge_white_mushroom"));

    public static final Block WHITE_MUSHROOM_BLOCK = new MushroomBlock(BlockBuilder.CloneBlock(Blocks.BROWN_MUSHROOM_BLOCK).mapColor(DyeColor.WHITE));
    public static final Block WHITE_MUSHROOM = new MushroomPlantBlock(HUGE_WHITE_MUSHROOM_CONFIG, BlockBuilder.CloneBlock(Blocks.BROWN_MUSHROOM).mapColor(DyeColor.WHITE));


    public static void RegisterItems() {

        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "white_mushroom"), WHITE_MUSHROOM);
        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "white_mushroom_block"), WHITE_MUSHROOM_BLOCK);

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "white_mushroom"), new BlockItem(WHITE_MUSHROOM, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "white_mushroom_block"), new BlockItem(WHITE_MUSHROOM_BLOCK, new Item.Settings()));

    }

    public static void GroupItems() {

        MCE_ITEM_GROUPER.GroupItem(WHITE_MUSHROOM.asItem(), new ItemGroupItem[]{new ItemGroupItem(ItemGroups.NATURAL, Blocks.RED_MUSHROOM)});
        MCE_ITEM_GROUPER.GroupItem(WHITE_MUSHROOM_BLOCK.asItem(), new ItemGroupItem[]{new ItemGroupItem(ItemGroups.NATURAL, Blocks.RED_MUSHROOM_BLOCK)});

    }

}
