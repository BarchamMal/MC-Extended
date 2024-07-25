package barch.mc_extended.Foods;

import barch.mc_extended.Glue.BlockBuilder;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Glue.ItemGrouped;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import static barch.mc_extended.Foods.Tomato.*;
import static barch.mc_extended.MCExtended.NAMESPACE;

public class Spinach {

    public static final GenericCropBlock SPINACH_CROP_BLOCK = new GenericCropBlock(
            BlockBuilder.CloneBlock(Blocks.WHEAT).nonOpaque().noCollision().ticksRandomly().breakInstantly()
    );
    public static final FlowerBlock WILD_SPINACH = new FlowerBlock(
            StatusEffects.STRENGTH,
            20,
            BlockBuilder.CloneBlock(Blocks.SHORT_GRASS).nonOpaque().noCollision().breakInstantly().burnable()
    );

    public static final FoodComponent SPINACH_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(1).saturationModifier(3f).build();
    public static final FoodComponent COOKED_SPINACH_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(3).saturationModifier(4f).build();
    public static final FoodComponent SAAG_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(9).saturationModifier(8f).build();

    public static final Item SPINACH_SEEDS = new AliasedBlockItem(SPINACH_CROP_BLOCK, new Item.Settings());
    public static final Item SPINACH = new Item(new Item.Settings().food(SPINACH_FOOD_COMPONANT));
    public static final Item COOKED_SPINACH = new Item(new Item.Settings().food(COOKED_SPINACH_FOOD_COMPONANT));
    public static final Item SAAG = new ContainedFood(new Item.Settings().food(SAAG_FOOD_COMPONANT), Items.BOWL);

    public static final RegistryKey<PlacedFeature> SPINACH_PATCH_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(NAMESPACE, "patch_spinach"));

    public static void RegisterAll() {

        SPINACH_CROP_BLOCK.setSeedsItem(SPINACH_SEEDS);

        Registry.register(Registries.BLOCK, Identifier.of(NAMESPACE, "spinach_crop"), SPINACH_CROP_BLOCK);
        Registry.register(Registries.BLOCK, Identifier.of(NAMESPACE, "wild_spinach"), WILD_SPINACH);

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "spinach_seeds"), SPINACH_SEEDS);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "spinach"), SPINACH);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "cooked_spinach"), COOKED_SPINACH);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "saag"), SAAG);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "wild_spinach"), new BlockItem(WILD_SPINACH, new Item.Settings()));

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, SPINACH_PATCH_PLACED_KEY);

        VillagerInteractionRegistries.registerCollectable(SPINACH);
        VillagerInteractionRegistries.registerCollectable(SPINACH_SEEDS);
        VillagerInteractionRegistries.registerFood(SPINACH, 2);
        CompostingChanceRegistry.INSTANCE.add(SPINACH, .3f);
        CompostingChanceRegistry.INSTANCE.add(SPINACH_SEEDS, .15f);

    }

    public static void GroupItems() {

        ItemGrouper.GroupItem(SPINACH_SEEDS, new ItemGrouped[]{new ItemGrouped(ItemGroups.NATURAL, Items.WHEAT_SEEDS)});
        ItemGrouper.GroupItem(SPINACH, new ItemGrouped[]{new ItemGrouped(ItemGroups.FOOD_AND_DRINK, TOMATO)});
        ItemGrouper.GroupItem(COOKED_SPINACH, new ItemGrouped[]{new ItemGrouped(ItemGroups.FOOD_AND_DRINK, ROAST_TOMATO)});
        ItemGrouper.GroupItem(SAAG, new ItemGrouped[]{new ItemGrouped(ItemGroups.FOOD_AND_DRINK, TOMATO_SAUCE)});

    }

}
