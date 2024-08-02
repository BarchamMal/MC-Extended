package barch.mc_extended.Foods;

import barch.mc_extended.Foods.blocks.TomatoBlock;
import net.barch.barch_lib.Blocks.BlockBuilder;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.barch.barch_lib.Items.ItemGroupItem;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.minecraft.block.*;
import net.minecraft.component.type.FoodComponent;
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

    public static final FoodComponent TOMATO_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(4).saturationModifier(4f).build();
    public static final FoodComponent ROAST_TOMATO_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(6).saturationModifier(6f).build();
    public static final FoodComponent TOMATO_SAUCE_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(9).saturationModifier(8f).build();

    public static final Item TOMATO_SEEDS = new AliasedBlockItem(TOMATO_CROP_BLOCK, new Item.Settings());
    public static final Item TOMATO = new AliasedBlockItem(TOMATO_BLOCK, new Item.Settings().food(TOMATO_FOOD_COMPONANT));
    public static final Item ROAST_TOMATO = new Item(new Item.Settings().food(ROAST_TOMATO_FOOD_COMPONANT));
    public static final Item TOMATO_SAUCE = new ContainedFood(new Item.Settings().food(TOMATO_SAUCE_FOOD_COMPONANT), Items.BOWL);

    public static final RegistryKey<PlacedFeature> TOMATO_PATCH_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MC_EXTENDED, "patch_tomato"));


    public static void RegisterAll() {

        TOMATO_CROP_BLOCK.setSeedsItem(TOMATO_SEEDS);

        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "tomato_crop"), TOMATO_CROP_BLOCK);
        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "tomato_block"), TOMATO_BLOCK);

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "tomato_seeds"), TOMATO_SEEDS);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "tomato"), TOMATO);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "roast_tomato"), ROAST_TOMATO);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "tomato_sauce"), TOMATO_SAUCE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, TOMATO_PATCH_PLACED_KEY);

        VillagerInteractionRegistries.registerCollectable(TOMATO);
        VillagerInteractionRegistries.registerCollectable(TOMATO_SEEDS);
        VillagerInteractionRegistries.registerFood(TOMATO, 3);
        CompostingChanceRegistry.INSTANCE.add(TOMATO, .3f);
        CompostingChanceRegistry.INSTANCE.add(TOMATO_SEEDS, .15f);

    }

    public static void GroupItems() {

        MCE_ITEM_GROUPER.GroupItem(TOMATO_SEEDS, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.NATURAL, Items.BEETROOT_SEEDS)});
        MCE_ITEM_GROUPER.GroupItem(TOMATO, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, Items.BEETROOT), new ItemGroupItem(ItemGroups.NATURAL, Blocks.PUMPKIN)});
        MCE_ITEM_GROUPER.GroupItem(ROAST_TOMATO, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, TOMATO)});
        MCE_ITEM_GROUPER.GroupItem(TOMATO_SAUCE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, Items.BEETROOT_SOUP)});

    }

}
