package barch.mc_extended.Foods;

import barch.mc_extended.Glue.BlockBuilder;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Glue.ItemGrouped;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
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

    public static final RegistryKey<PlacedFeature> HUGE_WHITE_MUSHROOM = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(NAMESPACE, "huge_white_mushroom"));
    public static final RegistryKey<ConfiguredFeature<?, ?>> HUGE_WHITE_MUSHROOM_CONFIG = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(NAMESPACE, "huge_white_mushroom"));

    public static final Block WHITE_MUSHROOM_BLOCK = new MushroomBlock(BlockBuilder.CloneBlock(Blocks.BROWN_MUSHROOM_BLOCK).mapColor(DyeColor.WHITE));
    public static final Block WHITE_MUSHROOM = new MushroomPlantBlock(BlockBuilder.CloneBlock(Blocks.BROWN_MUSHROOM).mapColor(DyeColor.WHITE), HUGE_WHITE_MUSHROOM_CONFIG);


    public static void RegisterItems() {

        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "white_mushroom"), WHITE_MUSHROOM);
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "white_mushroom_block"), WHITE_MUSHROOM_BLOCK);

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "white_mushroom"), new BlockItem(WHITE_MUSHROOM, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "white_mushroom_block"), new BlockItem(WHITE_MUSHROOM_BLOCK, new FabricItemSettings()));

    }

    public static void GroupItems() {

        ItemGrouper.GroupItem(WHITE_MUSHROOM.asItem(), new ItemGrouped[]{new ItemGrouped(ItemGroups.NATURAL, Blocks.RED_MUSHROOM)});
        ItemGrouper.GroupItem(WHITE_MUSHROOM_BLOCK.asItem(), new ItemGrouped[]{new ItemGrouped(ItemGroups.NATURAL, Blocks.RED_MUSHROOM_BLOCK)});

    }

}
