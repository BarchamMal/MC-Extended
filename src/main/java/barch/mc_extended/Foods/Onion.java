package barch.mc_extended.Foods;

import net.barch.barch_lib.Blocks.BlockBuilder;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;
import net.barch.barch_lib.Items.ItemGroupItem;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.minecraft.block.*;
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

import java.util.function.Function;

import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class Onion {

    public static final CropBlock ONION_CROP_BLOCK = Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "onion_crop"), new CropBlock(BlockBuilder.CloneBlock(Blocks.WHEAT).nonOpaque().noCollision().ticksRandomly().breakInstantly().mapColor(MapColor.YELLOW)));

    public static final FlowerBlock WILD_ONION = new FlowerBlock(StatusEffects.LUCK, 60, BlockBuilder.CloneBlock(Blocks.SHORT_GRASS).nonOpaque().noCollision().breakInstantly().burnable());

    public static final FoodComponent ONION_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(3).saturationModifier(3f).build();
    public static final FoodComponent FRIED_ONION_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(7).saturationModifier(7f).build();

    public static final Item ONION = Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "onion"), new BlockItem(ONION_CROP_BLOCK, new Item.Settings().useItemPrefixedTranslationKey().food(ONION_FOOD_COMPONANT)));

    private static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
        return (settings) -> {
            return new BlockItem(block, settings.useItemPrefixedTranslationKey());
        };
    }
    public static final Item FRIED_ONION = new Item(new Item.Settings().food(FRIED_ONION_FOOD_COMPONANT));

    public static final RegistryKey<PlacedFeature> ONION_PATCH_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MC_EXTENDED, "patch_onion"));

    public static void RegisterAll() {

        Registry.register(Registries.BLOCK, Identifier.of(MC_EXTENDED, "wild_onion"), WILD_ONION);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "fried_onion"), FRIED_ONION);
        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "wild_onion"), new BlockItem(WILD_ONION, new Item.Settings()));

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, ONION_PATCH_PLACED_KEY);

        VillagerInteractionRegistries.registerCollectable(ONION);
        VillagerInteractionRegistries.registerFood(ONION, 3);
        CompostingChanceRegistry.INSTANCE.add(ONION, .3f);

    }

    public static void GroupItems() {

        MCE_ITEM_GROUPER.GroupItem(ONION, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, Items.BAKED_POTATO)});
        MCE_ITEM_GROUPER.GroupItem(FRIED_ONION, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, ONION)});

    }

}
