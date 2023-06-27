package barch.mc_extended.Foods;

import barch.mc_extended.Glue.BlockBuilder;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.GrassBlock;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;
import static barch.mc_extended.MCExtended.NAMESPACE;

public class Onion {

    public static final Onion INSTANCE = new Onion();

    // initialize the blocks

    // onion crop
    public static final GenericCropBlock ONION_CROP_BLOCK = new GenericCropBlock(
            BlockBuilder.CloneBlock(Blocks.WHEAT).nonOpaque().noCollision().ticksRandomly().breakInstantly()
    );

    public static final FlowerBlock WILD_ONION = new FlowerBlock(
            StatusEffects.LUCK,
            60,
            BlockBuilder.CloneBlock(Blocks.GRASS).nonOpaque().noCollision().breakInstantly().burnable()
    );


    // initialize the items

    // food componants

    // onion
    public static final FoodComponent ONION_FOOD_COMPONANT = new FoodComponent
            .Builder()
            .hunger(3)
            .saturationModifier(3f)
            .build();

    // fried onion
    public static final FoodComponent FRIED_ONION_FOOD_COMPONANT = new FoodComponent
            .Builder()
            .hunger(7)
            .saturationModifier(7f)
            .build();

    // onion sauce
    public static final FoodComponent ONION_SAUCE_FOOD_COMPONANT = new FoodComponent
            .Builder()
            .hunger(9)
            .saturationModifier(8f)
            .build();



    // onion
    public static final Item ONION = new AliasedBlockItem(ONION_CROP_BLOCK,new FabricItemSettings().food(ONION_FOOD_COMPONANT));
    public static final Item O_JUNK = ONION_CROP_BLOCK.setSeedsItem(ONION);

    // fried onion
    public static final Item FRIED_ONION = new Item(new FabricItemSettings().food(FRIED_ONION_FOOD_COMPONANT));

    // onion sauce
    public static final Item ONION_TOMATO_SAUCE = new StewItem(new FabricItemSettings().food(ONION_SAUCE_FOOD_COMPONANT).maxCount(1));


    // onion feature
    public static final RegistryKey<PlacedFeature> ONION_PATCH_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(NAMESPACE, "patch_onion"));


    public static void RegisterAll() {
        // onion crop
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "onion_crop"), ONION_CROP_BLOCK);
        // wild onion
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "wild_onion"), WILD_ONION);

        // onion
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "onion"), ONION);
        // fried onion
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "fried_onion"), FRIED_ONION);
        // onion sauce
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "onion_tomato_sauce"), ONION_TOMATO_SAUCE);

        // wild onion
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "wild_onion"), new BlockItem(WILD_ONION, new FabricItemSettings()));

        // onion patch
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, ONION_PATCH_PLACED_KEY);

        // onions are villager collectable
        VillagerInteractionRegistries.registerCollectable(ONION);

        // onions are villager food
        VillagerInteractionRegistries.registerFood(ONION, 3);

        // onions can be composted
        CompostingChanceRegistry.INSTANCE.add(ONION, .3f);




    }

    public static void GroupItems() {


        // onion
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(ONION);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.POTATO, ONION);
        });
        // fried onion
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(FRIED_ONION);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(ONION, FRIED_ONION);
        });
        // onion tomato sauce
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(ONION_TOMATO_SAUCE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.BEETROOT_SOUP, ONION_TOMATO_SAUCE);
        });
    }

}
