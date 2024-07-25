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

import static barch.mc_extended.MCExtended.NAMESPACE;

public class Onion {

    public static final GenericCropBlock ONION_CROP_BLOCK = new GenericCropBlock(BlockBuilder.CloneBlock(Blocks.WHEAT).nonOpaque().noCollision().ticksRandomly().breakInstantly());
    public static final FlowerBlock WILD_ONION = new FlowerBlock(StatusEffects.LUCK, 60, BlockBuilder.CloneBlock(Blocks.SHORT_GRASS).nonOpaque().noCollision().breakInstantly().burnable());

    public static final FoodComponent ONION_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(3).saturationModifier(3f).build();
    public static final FoodComponent FRIED_ONION_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(7).saturationModifier(7f).build();

    public static final Item ONION = new AliasedBlockItem(ONION_CROP_BLOCK,new Item.Settings().food(ONION_FOOD_COMPONANT));
    public static final Item FRIED_ONION = new Item(new Item.Settings().food(FRIED_ONION_FOOD_COMPONANT));

    public static final RegistryKey<PlacedFeature> ONION_PATCH_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(NAMESPACE, "patch_onion"));

    public static void RegisterAll() {

        ONION_CROP_BLOCK.setSeedsItem(ONION);

        Registry.register(Registries.BLOCK, Identifier.of(NAMESPACE, "onion_crop"), ONION_CROP_BLOCK);
        Registry.register(Registries.BLOCK, Identifier.of(NAMESPACE, "wild_onion"), WILD_ONION);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "onion"), ONION);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "fried_onion"), FRIED_ONION);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "wild_onion"), new BlockItem(WILD_ONION, new Item.Settings()));

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, ONION_PATCH_PLACED_KEY);

        VillagerInteractionRegistries.registerCollectable(ONION);
        VillagerInteractionRegistries.registerFood(ONION, 3);
        CompostingChanceRegistry.INSTANCE.add(ONION, .3f);

    }

    public static void GroupItems() {

        ItemGrouper.GroupItem(ONION, new ItemGrouped[]{new ItemGrouped(ItemGroups.FOOD_AND_DRINK, Items.BAKED_POTATO)});
        ItemGrouper.GroupItem(FRIED_ONION, new ItemGrouped[]{new ItemGrouped(ItemGroups.FOOD_AND_DRINK, ONION)});

    }

}
