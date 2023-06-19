package barch.mc_extended.Foods;

import barch.mc_extended.Glue.BlockBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;

public class Mushrooms {

    public static final Mushrooms INSTANCE = new Mushrooms();

    // white mushroom feature config
    public static final Feature<HugeMushroomFeatureConfig> HUGE_WHITE_MUSHROOM = new HugeWhiteMushroomFeature(HugeMushroomFeatureConfig.CODEC);

    // white mushroom configured feature
    public static final RegistryKey<ConfiguredFeature<?, ?>> HUGE_WHITE_MUSHROOM_CONFIG = ConfiguredFeatures.of("mc-extended:huge_white_mushroom");

    // white mushroom block
    public static final Block WHITE_MUSHROOM_BLOCK = new MushroomBlock(BlockBuilder.CloneBlock(Blocks.BROWN_MUSHROOM_BLOCK).mapColor(DyeColor.WHITE));



    // white mushroom
    public static final Block WHITE_MUSHROOM = new MushroomPlantBlock(BlockBuilder.CloneBlock(Blocks.BROWN_MUSHROOM).mapColor(DyeColor.WHITE), HUGE_WHITE_MUSHROOM_CONFIG);


    public static void RegisterItems() {
        


        // white mushroom plant block
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "white_mushroom"), WHITE_MUSHROOM);

        // white mushroom block block
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "white_mushroom_block"), WHITE_MUSHROOM_BLOCK);

        // white mushroom plant item
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "white_mushroom"), new BlockItem(WHITE_MUSHROOM, new FabricItemSettings()));

        // white mushroom block item
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "white_mushroom_block"), new BlockItem(WHITE_MUSHROOM_BLOCK, new FabricItemSettings()));

        // register the white mushroom feature
        Registry.register(Registries.FEATURE, new Identifier("mc-extended", "white_mushroom_feature"), HUGE_WHITE_MUSHROOM);

    }

    public static void GroupItems() {

        // white mushroom
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(WHITE_MUSHROOM);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.RED_MUSHROOM, WHITE_MUSHROOM);
        });

        // white mushroom block
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(WHITE_MUSHROOM_BLOCK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.RED_MUSHROOM_BLOCK, WHITE_MUSHROOM_BLOCK);
        });


    }

}
