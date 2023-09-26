package barch.mc_extended.Foods;

import barch.mc_extended.Foods.blocks.TomatoBlock;
import barch.mc_extended.Glue.BlockBuilder;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Glue.ItemGrouped;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import static barch.mc_extended.MCExtended.*;

public class Tomato {

    public static final GenericCropBlock TOMATO_CROP_BLOCK = new GenericCropBlock(BlockBuilder.CloneBlock(Blocks.WHEAT).nonOpaque().noCollision().ticksRandomly().breakInstantly());
    public static final Block TOMATO_BLOCK = new TomatoBlock(BlockBuilder.CloneBlock(Blocks.PUMPKIN).nonOpaque().mapColor(DyeColor.RED));

    public static final FoodComponent TOMATO_FOOD_COMPONANT = new FoodComponent.Builder().hunger(4).saturationModifier(4f).build();
    public static final FoodComponent ROAST_TOMATO_FOOD_COMPONANT = new FoodComponent.Builder().hunger(6).saturationModifier(6f).build();
    public static final FoodComponent TOMATO_SAUCE_FOOD_COMPONANT = new FoodComponent.Builder().hunger(9).saturationModifier(8f).build();

    public static final Item TOMATO_SEEDS = new AliasedBlockItem(TOMATO_CROP_BLOCK, new Item.Settings());
    public static final Item TOMATO = new AliasedBlockItem(TOMATO_BLOCK, new FabricItemSettings().food(TOMATO_FOOD_COMPONANT));
    public static final Item ROAST_TOMATO = new Item(new FabricItemSettings().food(ROAST_TOMATO_FOOD_COMPONANT));
    public static final Item TOMATO_SAUCE = new ContainedFood(new FabricItemSettings().food(TOMATO_SAUCE_FOOD_COMPONANT), Items.BOWL);

    public static final RegistryKey<PlacedFeature> TOMATO_PATCH_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(NAMESPACE, "patch_tomato"));


    public static void RegisterAll() {

        TOMATO_CROP_BLOCK.setSeedsItem(TOMATO_SEEDS);

        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "tomato_crop"), TOMATO_CROP_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "tomato_block"), TOMATO_BLOCK);

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tomato_seeds"), TOMATO_SEEDS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tomato"), TOMATO);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "roast_tomato"), ROAST_TOMATO);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tomato_sauce"), TOMATO_SAUCE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, TOMATO_PATCH_PLACED_KEY);

        VillagerInteractionRegistries.registerCollectable(TOMATO);
        VillagerInteractionRegistries.registerCollectable(TOMATO_SEEDS);
        VillagerInteractionRegistries.registerFood(TOMATO, 3);
        CompostingChanceRegistry.INSTANCE.add(TOMATO, .3f);
        CompostingChanceRegistry.INSTANCE.add(TOMATO_SEEDS, .15f);

    }

    public static void GroupItems() {

        ItemGrouper.GroupItem(TOMATO_SEEDS, new ItemGrouped[]{new ItemGrouped(ItemGroups.NATURAL, Items.BEETROOT_SEEDS)});
        ItemGrouper.GroupItem(TOMATO, new ItemGrouped[]{new ItemGrouped(ItemGroups.FOOD_AND_DRINK, Items.BEETROOT), new ItemGrouped(ItemGroups.NATURAL, Blocks.PUMPKIN)});
        ItemGrouper.GroupItem(ROAST_TOMATO, new ItemGrouped[]{new ItemGrouped(ItemGroups.FOOD_AND_DRINK, TOMATO)});
        ItemGrouper.GroupItem(TOMATO_SAUCE, new ItemGrouped[]{new ItemGrouped(ItemGroups.FOOD_AND_DRINK, Items.BEETROOT_SOUP)});

    }

}
