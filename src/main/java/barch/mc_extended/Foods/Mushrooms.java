package barch.mc_extended.Foods;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;

public class Mushrooms {

    public static final Mushrooms INSTANCE = new Mushrooms();


    // white mushroom block
    public static final Block WHITE_MUSHROOM_BLOCK = new MushroomBlock(FabricBlockSettings.of(Blocks.RED_MUSHROOM.getDefaultState().getMaterial())
            .strength(Blocks.RED_MUSHROOM.getHardness())
            .resistance(Blocks.RED_MUSHROOM.getBlastResistance())
    );



    // white mushroom
    public static final Block WHITE_MUSHROOM = new Block(FabricBlockSettings.of(Material.PLANT)
            .breakInstantly()
            .noCollision()
            .nonOpaque());




    public static void RegisterItems() {
        


        // white mushroom item block
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "white_mushroom"), WHITE_MUSHROOM);

        // white mushroom block block
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "white_mushroom_block"), WHITE_MUSHROOM_BLOCK);

        // white mushroom item item
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "white_mushroom"), new BlockItem(WHITE_MUSHROOM, new FabricItemSettings()));

        // white mushroom block item
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "white_mushroom_block"), new BlockItem(WHITE_MUSHROOM_BLOCK, new FabricItemSettings()));



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
