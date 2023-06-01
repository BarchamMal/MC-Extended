package barch.mc_extended.Minerals;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.DEEPSLATE_RUBY_ORE;
import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;

public class Bronze {

    public static final Bronze INSTANCE = new Bronze();


    // Initialize the blocks

    // bronze block
    public static final Block BRONZE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.5f).resistance(15.0f).requiresTool());
    // raw bronze block
    public static final Block RAW_BRONZE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.5f).resistance(15.0f).requiresTool());



    // Initialize the items
    // bronze ingot
    public static final Item BRONZE_INGOT = new Item(new FabricItemSettings());

    // bronze nugget
    public static final Item BRONZE_NUGGET = new Item(new FabricItemSettings());

    // raw bronze
    public static final Item RAW_BRONZE = new Item(new FabricItemSettings());


    public static void RegisterAll() {

        Bronze.RegisterBlocks();
        Bronze.RegisterBlockItems();
        Bronze.RegisterItems();
        Bronze.GroupItems();

    }

    public static void RegisterBlocks() {

        // bronze block
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "bronze_block"), BRONZE_BLOCK);
        // raw bronze block
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "raw_bronze_block"), RAW_BRONZE_BLOCK);


    }

    public static void RegisterBlockItems() {

        // bronze block
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "bronze_block"), new BlockItem(BRONZE_BLOCK, new FabricItemSettings()));
        // raw bronze block
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "raw_bronze_block"), new BlockItem(RAW_BRONZE_BLOCK, new FabricItemSettings()));


    }

    public static void RegisterItems() {

        // bronze ingot
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "bronze_ingot"), BRONZE_INGOT);
        // bronze nugget
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "bronze_nugget"), BRONZE_NUGGET);
        // raw bronze
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "raw_bronze"), RAW_BRONZE);

    }

    public static void GroupItems() {



        // bronze ingot
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(BRONZE_INGOT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.GOLD_INGOT, BRONZE_INGOT);
        });

        // bronze nugget
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(BRONZE_NUGGET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.GOLD_NUGGET, BRONZE_NUGGET);
        });

        // raw bronze
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RAW_BRONZE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.RAW_GOLD, RAW_BRONZE);
        });

        // raw bronze block
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RAW_BRONZE_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.RAW_GOLD_BLOCK, RAW_BRONZE_BLOCK);
        });

        // bronze block
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(BRONZE_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.GOLD_BLOCK, BRONZE_BLOCK);
        });


    }
}