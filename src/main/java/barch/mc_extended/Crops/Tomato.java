package barch.mc_extended.Crops;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;

public class Tomato {

    public static final Tomato INSTANCE = new Tomato();

    // initialize the crops
    // tomato
    public static final CropBlock TOMATO_CROP_BLOCK = new TomatoCropBlock(
            AbstractBlock.Settings.of(Material.PLANT)
            .nonOpaque()
            .noCollision()
            .ticksRandomly()
            .breakInstantly()
            .sounds(BlockSoundGroup.CROP)
    );


    // initialize the items

    // food componants

    // tomato
    public static final FoodComponent TOMATO_FOOD_COMPONANT = new FoodComponent
            .Builder()
            .hunger(4)
            .saturationModifier(4f)
            .build();

    // tomato sauce
    public static final FoodComponent TOMATO_SAUCE_FOOD_COMPONANT = new FoodComponent
            .Builder()
            .hunger(9)
            .saturationModifier(8f)
            .build();

    // tomato seeds
    public static final Item TOMATO_SEEDS = new AliasedBlockItem(TOMATO_CROP_BLOCK, new Item.Settings());

    // tomato
    public static final Item TOMATO = new Item(new FabricItemSettings().food(TOMATO_FOOD_COMPONANT));

    // tomato
    public static final Item TOMATO_SAUCE = new StewItem(new FabricItemSettings().food(TOMATO_SAUCE_FOOD_COMPONANT));

    public static void RegisterCrops() {
        // tomato crop
        Registry.register(Registries.BLOCK, new Identifier("mc-extended", "tomato_crop"), TOMATO_CROP_BLOCK);
        // tomato seeds
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "tomato_seeds"), TOMATO_SEEDS);
        // tomato
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "tomato"), TOMATO);
        // tomato
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "tomato_sauce"), TOMATO_SAUCE);
    }

    public static void GroupItems() {

        // tomato seeds
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TOMATO_SEEDS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.BEETROOT_SEEDS, TOMATO_SEEDS);
        });
        // tomato
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TOMATO);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.BEETROOT, TOMATO);
        });
        // tomato sauce
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TOMATO_SAUCE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.BEETROOT_SOUP, TOMATO_SAUCE);
        });
    }

}
