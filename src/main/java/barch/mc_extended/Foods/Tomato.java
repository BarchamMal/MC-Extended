package barch.mc_extended.Foods;

import barch.mc_extended.Glue.BlockBuilder;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import static barch.mc_extended.MCExtended.*;

public class Tomato {

    public static final Tomato INSTANCE = new Tomato();

    // initialize the blocks

    // tomato crop
    public static final CropBlock TOMATO_CROP_BLOCK = new TomatoCropBlock(
            BlockBuilder.CloneBlock(Blocks.WHEAT)
    );

    // tomato grass
    public static Block TOMATO_BLOCK = new TomatoBlock(
            BlockBuilder.CloneBlock(Blocks.PUMPKIN)
                            .nonOpaque()
                    .mapColor(DyeColor.RED)
    );


    // initialize the items

    // food componants

    // tomato
    public static final FoodComponent TOMATO_FOOD_COMPONANT = new FoodComponent
            .Builder()
            .hunger(4)
            .saturationModifier(4f)
            .build();

    // roast tomato
    public static final FoodComponent ROAST_TOMATO_FOOD_COMPONANT = new FoodComponent
            .Builder()
            .hunger(6)
            .saturationModifier(6f)
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
    public static final Item TOMATO = new AliasedBlockItem(TOMATO_BLOCK, new FabricItemSettings().food(TOMATO_FOOD_COMPONANT));

    // roast tomato
    public static final Item ROAST_TOMATO = new Item(new FabricItemSettings().food(ROAST_TOMATO_FOOD_COMPONANT));

    // tomato sauce
    public static final Item TOMATO_SAUCE = new StewItem(new FabricItemSettings().food(TOMATO_SAUCE_FOOD_COMPONANT).maxCount(1));


    // tomato feature
    public static final RegistryKey<PlacedFeature> TOMATO_PATCH_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(NAMESPACE, "patch_tomato"));


    public static void RegisterAll() {
        // tomato crop
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "tomato_crop"), TOMATO_CROP_BLOCK);
        // tomato block
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "tomato_block"), TOMATO_BLOCK);

        // tomato seeds
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tomato_seeds"), TOMATO_SEEDS);
        // tomato
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tomato"), TOMATO);
        // roast tomato
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "roast_tomato"), ROAST_TOMATO);
        // tomato sauce
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tomato_sauce"), TOMATO_SAUCE);

        // tomato patch
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, TOMATO_PATCH_PLACED_KEY);

        // tomatoes are villager collectable
        VillagerInteractionRegistries.registerCollectable(TOMATO);
        // tomato seeds are villager collectable
        VillagerInteractionRegistries.registerCollectable(TOMATO_SEEDS);

        // tomatoes are villager food
        VillagerInteractionRegistries.registerFood(TOMATO, 3);

        // tomatoes can be composted
        CompostingChanceRegistry.INSTANCE.add(TOMATO, .3f);

        // tomato seeds can be composted
        CompostingChanceRegistry.INSTANCE.add(TOMATO_SEEDS, .15f);



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
        // roast tomato
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(ROAST_TOMATO);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(TOMATO, ROAST_TOMATO);
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
