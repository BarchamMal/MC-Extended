package barch.mc_extended.Registry;

import barch.mc_extended.Blocks.TomatoBlock;
import net.barch.barch_lib.Blocks.BlockBuilder;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.function.Function;

import static barch.mc_extended.MCExtended.MC_EXTENDED;
import static barch.mc_extended.Registry.Features.HUGE_WHITE_MUSHROOM_CONFIG;

public class ModBlocks {

    public static final Block BRONZE_BLOCK = register("bronze_block", true, Blocks.IRON_BLOCK);
    public static final Block RAW_BRONZE_BLOCK = register("raw_bronze_block", true, Blocks.RAW_IRON_BLOCK);
    public static final Block CORUNDUM_BLOCK = register("corundum_block", true, Blocks.NETHERITE_BLOCK);
    public static final Block RUBY_BLOCK = register("ruby_block", true, Blocks.DIAMOND_BLOCK);
    public static final Block RUBY_ORE = registerXpBlock("ruby_ore", true, Blocks.DIAMOND_ORE, UniformIntProvider.create(3,7));
    public static final Block DEEPSLATE_RUBY_ORE = registerXpBlock("deepslate_ruby_ore", true, Blocks.DEEPSLATE_DIAMOND_ORE, UniformIntProvider.create(3, 7));
    public static final Block SAPPHIRE_BLOCK = register("sapphire_block", true, Blocks.DIAMOND_BLOCK);
    public static final Block SAPPHIRE_ORE = registerXpBlock("sapphire_ore", true, Blocks.DIAMOND_ORE, UniformIntProvider.create(3,7));
    public static final Block DEEPSLATE_SAPPHIRE_ORE = registerXpBlock("deepslate_sapphire_ore", true, Blocks.DEEPSLATE_DIAMOND_ORE, UniformIntProvider.create(3, 7));
    public static final Block SILVER_BLOCK = register("silver_block", true, Blocks.GOLD_BLOCK);
    public static final Block RAW_SILVER_BLOCK = register("raw_silver_block", true, Blocks.RAW_GOLD_BLOCK);
    public static final Block SILVER_ORE = registerXpBlock("silver_ore", true, Blocks.GOLD_ORE, UniformIntProvider.create(3,5));
    public static final Block DEEPSLATE_SILVER_ORE = registerXpBlock("deepslate_silver_ore", true, Blocks.DEEPSLATE_GOLD_ORE, UniformIntProvider.create(3, 5));
    public static final Block TIN_BLOCK = register("tin_block", true, Blocks.COPPER_BLOCK);
    public static final Block RAW_TIN_BLOCK = register("raw_tin_block", true, Blocks.RAW_COPPER_BLOCK);
    public static final Block TIN_ORE = registerXpBlock("tin_ore", true, Blocks.IRON_ORE, UniformIntProvider.create(2,5));
    public static final Block DEEPSLATE_TIN_ORE = registerXpBlock("deepslate_tin_ore", true, Blocks.DEEPSLATE_IRON_ORE, UniformIntProvider.create(2, 5));

    public static final Block TOMATO_BLOCK = registerWildCard("tomato_block", false, TomatoBlock::new, BlockBuilder.CloneBlock(Blocks.PUMPKIN).nonOpaque().mapColor(DyeColor.RED));
    public static final Block TOMATO_CROP_BLOCK = registerWildCard("tomato_crop", false,  CropBlock::new, cropSettings().mapColor((state) -> {
        return state.get(CropBlock.AGE) >= 6 ? MapColor.PALE_GREEN : MapColor.DULL_RED;}));
    public static final Block WILD_SPINACH = registerFlower("wild_spinach", StatusEffects.STRENGTH, 20, Blocks.SHORT_GRASS);
    public static final Block SPINACH_CROP_BLOCK = registerWildCard("spinach_crop", false,  CropBlock::new, cropSettings().mapColor((state) -> {
        return state.get(CropBlock.AGE) >= 6 ? MapColor.PALE_GREEN : MapColor.DARK_GREEN;}));
    public static final Block WILD_ONION = registerFlower("wild_onion", StatusEffects.STRENGTH, 20, Blocks.SHORT_GRASS);
    public static final Block ONION_CROP_BLOCK = registerWildCard("onion_crop", false,  CropBlock::new, cropSettings().mapColor((state) -> {
        return state.get(CropBlock.AGE) >= 6 ? MapColor.GREEN : MapColor.PALE_YELLOW;}));
    public static final Block WHITE_MUSHROOM_BLOCK = registerWildCard("white_mushroom_block", false, Blocks.RED_MUSHROOM_BLOCK, MushroomBlock::new);
    public static final Block WHITE_MUSHROOM = registerMushroomPlant("white_mushroom", HUGE_WHITE_MUSHROOM_CONFIG);
    public static final Block CHEESE_BLOCK = registerWildCard("cheese", false, Blocks.CAKE, CakeBlock::new);

    public static final Block GEM_TABLE = register("gem_table", false, Blocks.FLETCHING_TABLE);
    public static final Block BOTANY_TABLE = register("botany_table", false, Blocks.FLETCHING_TABLE);


    public static Block register(String name, boolean tool, Block cloneBlock) {
        Identifier id = Identifier.of(MC_EXTENDED, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);

        AbstractBlock.Settings settings = BlockBuilder.CloneBlock(cloneBlock);
        if (tool) settings.requiresTool();

        return Registry.register(
                Registries.BLOCK,
                key,
                new Block(settings.registryKey(key))
        );
    }

    public static Block registerMushroomPlant(String name, RegistryKey<ConfiguredFeature<?, ?>> key1) {
        Identifier id = Identifier.of(MC_EXTENDED, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);

        AbstractBlock.Settings settings = BlockBuilder.CloneBlock(Blocks.RED_MUSHROOM);

        return Registry.register(
                Registries.BLOCK,
                key,
                new MushroomPlantBlock(key1, settings.registryKey(key))
        );
    }

    public static Block registerFlower(String name, RegistryEntry<StatusEffect> statusEffect, int length, Block cloneBlock) {
        Identifier id = Identifier.of(MC_EXTENDED, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);

        AbstractBlock.Settings settings = BlockBuilder.CloneBlock(cloneBlock);

        return Registry.register(
                Registries.BLOCK,
                key,
                new FlowerBlock(statusEffect, length, settings.registryKey(key).nonOpaque().noCollision().breakInstantly().burnable())
        );

    }

    public static Block registerXpBlock(String name, boolean tool, Block cloneBlock, UniformIntProvider uIntP) {
        Identifier id = Identifier.of(MC_EXTENDED, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);

        AbstractBlock.Settings settings = BlockBuilder.CloneBlock(cloneBlock);
        if (tool) settings.requiresTool();

        return Registry.register(
                Registries.BLOCK,
                key,
                new ExperienceDroppingBlock(uIntP,settings.registryKey(key))
        );
    }

    public static Block registerWildCard(String name, boolean tool, Block cloneBlock, Function<AbstractBlock.Settings, Block> factory) {
        Identifier id = Identifier.of(MC_EXTENDED, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);

        AbstractBlock.Settings settings = BlockBuilder.CloneBlock(cloneBlock);
        if (tool) settings.requiresTool();

        return Registry.register(
                Registries.BLOCK,
                key,
                factory.apply(settings.registryKey(key))
        );
    }

    public static Block registerWildCard(String name, boolean tool, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(MC_EXTENDED, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);

        if (tool) settings.requiresTool();

        return Registry.register(
                Registries.BLOCK,
                key,
                factory.apply(settings.registryKey(key))
        );
    }

    public static AbstractBlock.Settings cropSettings() {
        return AbstractBlock.Settings.create().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY);
    }

    public static void doNothing() {}

}
