package barch.mc_extended.Foods;

import barch.mc_extended.Glue.BlockBuilder;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
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

public class Spinach {

    public static final Spinach INSTANCE = new Spinach();

    // initialize the blocks

    // spinach crop
    public static final GenericCropBlock SPINACH_CROP_BLOCK = new GenericCropBlock(
            BlockBuilder.CloneBlock(Blocks.WHEAT).nonOpaque().noCollision().ticksRandomly().breakInstantly()
    );

    // wild spinach
    public static final FlowerBlock WILD_SPINACH = new FlowerBlock(
            StatusEffects.STRENGTH,
            20,
            BlockBuilder.CloneBlock(Blocks.GRASS).nonOpaque().noCollision().breakInstantly().burnable()
    );


    // initialize the items

    // food componants
    public static final FoodComponent SPINACH_FOOD_COMPONANT = new FoodComponent.Builder().hunger(1).saturationModifier(3f).build();
    public static final FoodComponent COOOKED_SPINACH_FOOD_COMPONANT = new FoodComponent.Builder().hunger(3).saturationModifier(4f).build();
    public static final FoodComponent SAAG_FOOD_COMPONANT = new FoodComponent.Builder().hunger(9).saturationModifier(8f).build();


    public static final Item SPINACH_SEEDS = new AliasedBlockItem(SPINACH_CROP_BLOCK, new FabricItemSettings());
    public static final Item S_S_JUNK = SPINACH_CROP_BLOCK.setSeedsItem(SPINACH_SEEDS);

    // spinach
    public static final Item SPINACH = new Item(new FabricItemSettings().food(SPINACH_FOOD_COMPONANT));

    // cooked spinach
    public static final Item COOOKED_SPINACH = new Item(new FabricItemSettings().food(COOOKED_SPINACH_FOOD_COMPONANT));

    // saag
    public static final Item SAAG = new ContainedFood(new FabricItemSettings().food(SAAG_FOOD_COMPONANT), Items.BOWL);


    // spinach feature
    public static final RegistryKey<PlacedFeature> SPINACH_PATCH_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(NAMESPACE, "patch_spinach"));


    public static void RegisterAll() {
        // spinach crop
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "spinach_crop"), SPINACH_CROP_BLOCK);
        // wild spinach
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "wild_spinach"), WILD_SPINACH);

        // spinach seeds
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "spinach_seeds"), SPINACH_SEEDS);
        // spinach
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "spinach"), SPINACH);
        // cooked spinach
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "cooked_spinach"), COOOKED_SPINACH);
        // saag
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "saag"), SAAG);
        // wild onion
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "wild_spinach"), new BlockItem(WILD_SPINACH, new FabricItemSettings()));


        // spinach patch
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, SPINACH_PATCH_PLACED_KEY);

        // spinaches are villager collectable
        VillagerInteractionRegistries.registerCollectable(SPINACH);
        // spinach seeds are villager collectable
        VillagerInteractionRegistries.registerCollectable(SPINACH_SEEDS);

        // spinaches are villager food
        VillagerInteractionRegistries.registerFood(SPINACH, 2);

        // spinaches can be composted
        CompostingChanceRegistry.INSTANCE.add(SPINACH, .3f);

        // spinach seeds can be composted
        CompostingChanceRegistry.INSTANCE.add(SPINACH_SEEDS, .15f);



    }

    public static void GroupItems() {

        // spinach seeds
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SPINACH_SEEDS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.BEETROOT_SEEDS, SPINACH_SEEDS);
        });
        // spinach
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SPINACH);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.BEETROOT, SPINACH);
        });
        // cooked spinach
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(COOOKED_SPINACH);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(SPINACH, COOOKED_SPINACH);
        });
        // saag
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SAAG);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.BEETROOT_SOUP, SAAG);
        });
    }

}
