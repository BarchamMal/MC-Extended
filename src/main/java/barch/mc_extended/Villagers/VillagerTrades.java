package barch.mc_extended.Villagers;

import barch.mc_extended.Registry.ModProfessions;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

import static barch.mc_extended.MCExtended.MC_EXTENDED;
import static barch.mc_extended.Registry.ModBlocks.*;
import static barch.mc_extended.Registry.ModItems.*;

public class VillagerTrades {

    public static final RegistryKey<VillagerProfession> GEM_DEALER = of("gem_dealer");
    public static final RegistryKey<VillagerProfession> BOTANIST = of("botanist");
    public static final RegistryKey<VillagerProfession> MINER = of("miner");

    public static void RegisterTrades() {

        RegisterGemDealerTrades();
        RegisterMinerTrades();
        RegisterFarmerTrades();
        RegisterBotanistTrades();

    }
    public static void RegisterGemDealerTrades() {

        // novice
        TradeOfferHelper.registerVillagerOffers(GEM_DEALER, 1, factories -> {
            factories.add(new TradeOffers.SellItemFactory(Items.AMETHYST_SHARD, 1, 4, 1));
            factories.add(new TradeOffers.BuyItemFactory(Items.LAPIS_LAZULI, 4, 16, 1));
            factories.add(new ExplicitTradeFactory(Items.DIAMOND_ORE, 1, Items.COPPER_INGOT, 8, Items.DIAMOND, 3, 16, 2, 0));
            factories.add(new ExplicitTradeFactory(Items.LAPIS_ORE, 1, Items.COPPER_INGOT, 4, Items.LAPIS_LAZULI, 9, 16, 1, 0));
            factories.add(new ExplicitTradeFactory(Items.GLASS, 4,Items.GOLD_NUGGET, 1, Items.EMERALD, 1, 16, 3, 0));

        });
        // apprentice
        TradeOfferHelper.registerVillagerOffers(GEM_DEALER, 2, factories -> {
            factories.add(new ExplicitTradeFactory(Items.DEEPSLATE_DIAMOND_ORE, 1, SILVER_INGOT, 6, Items.DIAMOND, 3, 16, 3, 0));
            factories.add(new ExplicitTradeFactory(Items.DEEPSLATE_LAPIS_ORE, 1, SILVER_INGOT, 3, Items.LAPIS_LAZULI, 9, 16, 2, 0));
            factories.add(new TradeOffers.BuyItemFactory(Items.GOLD_INGOT, 3, 16, 2));
            factories.add(new TradeOffers.BuyItemFactory(Items.COPPER_INGOT, 8, 24, 1));
            factories.add(new TradeOffers.BuyItemFactory(SILVER_INGOT, 3, 16, 2));
            factories.add(new ExplicitTradeFactory(Items.NETHER_QUARTZ_ORE, 1, Items.COPPER_INGOT, 2, Items.QUARTZ, 3, 16, 2, 0));
        }) ;
        // journeyman
        TradeOfferHelper.registerVillagerOffers(GEM_DEALER, 3, factories -> {
            factories.add(new TradeOffers.SellItemFactory(Items.ECHO_SHARD, 12, 1, 10));
            factories.add(new ExplicitTradeFactory(Items.QUARTZ_BLOCK, 1, Items.COPPER_INGOT, 1, Items.QUARTZ, 4, 16, 3, 0));
            factories.add(new ExplicitTradeFactory(Items.CRYING_OBSIDIAN, 1, Items.EMERALD, 1, Items.GHAST_TEAR, 1, 16, 4, 0));
            factories.add(new ExplicitTradeFactory(Items.OBSIDIAN, 1, Items.EMERALD, 16, Items.CRYING_OBSIDIAN, 1, 16, 5, 0));
            factories.add(new TradeOffers.BuyItemFactory(Items.CRYING_OBSIDIAN, 1, 16, 3,3));
            factories.add(new TradeOffers.SellItemFactory(Items.OBSIDIAN, 3, 1, 16,3));
        });
        // expert
        TradeOfferHelper.registerVillagerOffers(GEM_DEALER, 4, factories -> {
            factories.add(new ExplicitTradeFactory(Items.RAW_COPPER, 1, Items.EMERALD, 1, Items.COPPER_INGOT, 2, 16, 4, 0));
            factories.add(new ExplicitTradeFactory(RAW_SILVER, 1, Items.GOLD_NUGGET, 2, SILVER_INGOT, 2, 16, 4, 0));
            factories.add(new ExplicitTradeFactory(Items.RAW_GOLD, 1, SILVER_NUGGET, 4, Items.GOLD_INGOT, 2, 16, 5, 0));
            factories.add(new ExplicitTradeFactory(RUBY_ORE, 1, Items.GOLD_INGOT, 1, RUBY, 3, 16, 6, 0));
            factories.add(new ExplicitTradeFactory(SAPPHIRE_ORE, 1, SILVER_INGOT, 1, SAPPHIRE, 3, 16, 6, 0));
            factories.add(new ExplicitTradeFactory(Items.EMERALD_ORE, 1, Items.COPPER_INGOT, 1, Items.EMERALD, 4, 16, 4, 0));
        });
        // master
        TradeOfferHelper.registerVillagerOffers(GEM_DEALER, 5, factories -> {
            factories.add(new ExplicitTradeFactory(RUBY, 1, null, 0, Items.EMERALD, 15, 16, 5, 0));
            factories.add(new ExplicitTradeFactory(SAPPHIRE, 1, null, 0, Items.EMERALD, 15, 16, 5, 0));
            factories.add(new ExplicitTradeFactory(Items.RAW_COPPER_BLOCK, 1, Items.EMERALD, 1, Items.COPPER_INGOT, 13, 16, 5, 0));
            factories.add(new ExplicitTradeFactory(RAW_SILVER_BLOCK, 1, SILVER_NUGGET, 1, SILVER_INGOT, 11, 16, 5, 0));
            factories.add(new ExplicitTradeFactory(Items.RAW_GOLD_BLOCK, 1, Items.GOLD_NUGGET, 1, Items.GOLD_INGOT, 11, 16, 5, 0));
            factories.add(new ExplicitTradeFactory(DEEPSLATE_RUBY_ORE, 1, Items.GOLD_INGOT, 1, RUBY, 3, 16, 8, 0));
            factories.add(new ExplicitTradeFactory(DEEPSLATE_SAPPHIRE_ORE, 1, SILVER_INGOT, 1, SAPPHIRE, 3, 16, 8, 0));
        });

        // gift
        VillagerInteractionRegistries.registerGiftLootTable(GEM_DEALER, RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("mc-extended", "gem_dealer")));

    }

    public static void  RegisterBotanistTrades() {

        // novice
        TradeOfferHelper.registerVillagerOffers(BOTANIST, 1, factories -> {
            factories.add(new TradeOffers.BuyItemFactory(Blocks.CHERRY_SAPLING, 6, 16, 3));
            factories.add(new TradeOffers.BuyItemFactory(Blocks.MANGROVE_PROPAGULE, 6, 16, 3));
            factories.add(new TradeOffers.SellItemFactory(Blocks.PINK_PETALS, 2, 12,16 ,4));
            factories.add(new TradeOffers.SellItemFactory(Blocks.RED_TULIP, 1, 8, 16, 4));
            factories.add(new TradeOffers.ProcessItemFactory(Blocks.LILY_OF_THE_VALLEY, 1, 1, Items.WHITE_DYE, 2, 16, 3, 0));

        });
        // apprentice
        TradeOfferHelper.registerVillagerOffers(BOTANIST, 2, factories -> {
            factories.add(new TradeOffers.BuyItemFactory(Blocks.SPRUCE_SAPLING, 4, 16, 3));
            factories.add(new TradeOffers.BuyItemFactory(Blocks.JUNGLE_SAPLING, 4, 16, 3));
            factories.add(new TradeOffers.BuyItemFactory(Blocks.ACACIA_SAPLING, 4, 16, 3));
            factories.add(new TradeOffers.BuyItemFactory(Blocks.BIRCH_SAPLING, 4, 16, 3));
            factories.add(new TradeOffers.BuyItemFactory(Blocks.CHERRY_SAPLING, 4, 16, 3));
            factories.add(new TradeOffers.BuyItemFactory(Blocks.BAMBOO, 64, 16, 3));
            factories.add(new TradeOffers.SellItemFactory(Blocks.BIRCH_LOG, 1, 2, 16, 4));
            factories.add(new TradeOffers.SellItemFactory(Blocks.ACACIA_LOG, 1, 2, 16, 4));

        }) ;
        // journeyman
        TradeOfferHelper.registerVillagerOffers(BOTANIST, 3, factories -> {
            factories.add(new TradeOffers.SellItemFactory(Items.SEAGRASS, 1, 8, 16,5));
            factories.add(new TradeOffers.SellItemFactory(Items.KELP, 1, 16, 16,5));
            factories.add(new TradeOffers.SellItemFactory(Items.SEA_PICKLE, 1, 4, 16,5));
            factories.add(new TradeOffers.BuyItemFactory(Blocks.BRAIN_CORAL_BLOCK, 4, 16, 5));
            factories.add(new TradeOffers.BuyItemFactory(Blocks.BUBBLE_CORAL_BLOCK, 4, 16, 5));
            factories.add(new TradeOffers.BuyItemFactory(Blocks.FIRE_CORAL_BLOCK, 4, 16, 5));
            factories.add(new TradeOffers.BuyItemFactory(Blocks.HORN_CORAL_BLOCK, 4, 16, 5));
            factories.add(new TradeOffers.BuyItemFactory(Blocks.TUBE_CORAL_BLOCK, 4, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(Blocks.BRAIN_CORAL_FAN, 2, 1, 16, 4));
            factories.add(new TradeOffers.SellItemFactory(Blocks.BUBBLE_CORAL_FAN, 2, 1, 16, 4));
            factories.add(new TradeOffers.SellItemFactory(Blocks.FIRE_CORAL_FAN, 2, 1, 16, 4));
            factories.add(new TradeOffers.SellItemFactory(Blocks.HORN_CORAL_FAN, 2, 1, 16, 4));
            factories.add(new TradeOffers.SellItemFactory(Blocks.TUBE_CORAL_FAN, 2, 1, 16, 4));
            factories.add(new TradeOffers.SellItemFactory(Blocks.BRAIN_CORAL, 2, 1, 16, 4));
            factories.add(new TradeOffers.SellItemFactory(Blocks.BUBBLE_CORAL, 2, 1, 16, 4));
            factories.add(new TradeOffers.SellItemFactory(Blocks.FIRE_CORAL, 2, 1, 16, 4));
            factories.add(new TradeOffers.SellItemFactory(Blocks.HORN_CORAL, 2, 1, 16, 4));
            factories.add(new TradeOffers.SellItemFactory(Blocks.TUBE_CORAL, 2, 1, 16, 4));

        });
        // expert
        TradeOfferHelper.registerVillagerOffers(BOTANIST, 4, factories -> {
            factories.add(new TradeOffers.BuyItemFactory(Items.BEETROOT_SEEDS, 48, 16, 4));
            factories.add(new TradeOffers.BuyItemFactory(TOMATO_SEEDS, 48, 16, 4));
            factories.add(new TradeOffers.BuyItemFactory(Items.MELON_SEEDS, 18, 16, 5));
            factories.add(new TradeOffers.BuyItemFactory(Items.PUMPKIN_SEEDS, 24, 16, 5));
            factories.add(new TradeOffers.BuyItemFactory(Items.WHEAT_SEEDS, 48, 16, 5));
            factories.add(new TradeOffers.BuyItemFactory(Items.TORCHFLOWER, 2, 16, 7));
            factories.add(new TradeOffers.BuyItemFactory(Items.PITCHER_PLANT, 3, 16, 7));
            factories.add(new TradeOffers.BuyItemFactory(Items.SWEET_BERRIES, 24, 16, 4));
            factories.add(new TradeOffers.SellItemFactory(Blocks.GLOW_LICHEN, 1, 1, 16, 6));
            factories.add(new TradeOffers.SellItemFactory(Blocks.HANGING_ROOTS, 1, 1, 16, 6));
            factories.add(new TradeOffers.SellItemFactory(Blocks.VINE, 1, 1, 16, 6));
            factories.add(new TradeOffers.SellItemFactory(Blocks.TALL_GRASS, 1, 1, 16, 6));
        });
        // master
        TradeOfferHelper.registerVillagerOffers(BOTANIST, 5, factories -> {
            factories.add(new TradeOffers.SellItemFactory(Items.MOSS_BLOCK, 1, 12, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.CLAY_BALL, 1, 8, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.FLOWERING_AZALEA, 1, 8, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.BIG_DRIPLEAF, 1, 4, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.SMALL_DRIPLEAF, 1, 4, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.GLOW_BERRIES, 1, 12, 16, 5));
        });

    }

    public static void RegisterFarmerTrades() {

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add(new TradeOffers.BuyItemFactory(TOMATO, 15, 16, 2));
            factories.add(new TradeOffers.BuyItemFactory(ONION, 24, 16, 2));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> {
            factories.add(new TradeOffers.SellItemFactory(ONION_TOMATO_SAUCE, 1, 4, 2));
        });

    }

    public static void RegisterMinerTrades() {

        // novice
        TradeOfferHelper.registerVillagerOffers(MINER, 1, factories -> {
            factories.add(new TradeOffers.BuyItemFactory(Items.COBBLESTONE, 16, 16, 1));
            factories.add(new TradeOffers.BuyItemFactory(Items.IRON_PICKAXE, 1, 16, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.COAL, 1, 8, 8, 1));
            factories.add(new TradeOffers.SellItemFactory(RAW_TIN, 1, 4, 8, 2));
            factories.add(new TradeOffers.ProcessItemFactory(Items.GRAVEL, 10, 1, Items.FLINT, 10,16,1, 0));

        });
        // apprentice
        TradeOfferHelper.registerVillagerOffers(MINER, 2, factories -> {
            factories.add(new TradeOffers.BuyItemFactory(Items.STONE_SHOVEL, 1, 8, 4));
            factories.add(new TradeOffers.BuyItemFactory(Items.COAL, 16, 16, 2));
            factories.add(new TradeOffers.SellItemFactory(Items.DIORITE, 1, 16, 16, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.GRANITE, 1, 16, 16, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.ANDESITE, 1, 16, 16, 3));

        }) ;
        // journeyman
        TradeOfferHelper.registerVillagerOffers(MINER, 3, factories -> {
            factories.add(new TradeOffers.SellItemFactory(Items.DEEPSLATE, 1, 32, 16, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.POINTED_DRIPSTONE, 1, 12, 8, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.TUFF, 1, 24, 16, 4));
            factories.add(new TradeOffers.SellItemFactory(Items.CALCITE, 1, 16, 16, 4));
            factories.add(new TradeOffers.BuyItemFactory(Items.DIAMOND_PICKAXE, 1, 1, 5));

        });
        // expert
        TradeOfferHelper.registerVillagerOffers(MINER, 4, factories -> {
            factories.add(new TradeOffers.BuyItemFactory(Items.SHEARS, 1, 12, 4));
            factories.add(new TradeOffers.BuyItemFactory(Items.DIAMOND_SHOVEL, 1, 8, 7, 4));
            factories.add(new TradeOffers.BuyItemFactory(Items.DIAMOND_HOE, 1, 8, 7, 8));
            factories.add(new TradeOffers.SellItemFactory(Items.RAW_GOLD, 1, 3, 8, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.OBSIDIAN, 2, 1, 12, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.LAPIS_LAZULI, 1, 3, 12, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.REDSTONE, 1, 16, 12, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.RAW_IRON, 1, 4, 12, 5));


        });
        // master
        TradeOfferHelper.registerVillagerOffers(MINER, 5, factories -> {
            factories.add(new TradeOffers.BuyItemFactory(Items.OAK_LOG, 4, 24, 4));
            factories.add(new TradeOffers.SellItemFactory(Items.DIAMOND, 3, 1, 8, 5));
            factories.add(new TradeOffers.SellItemFactory(RUBY, 24, 1, 6, 7));
            factories.add(new TradeOffers.SellItemFactory(Items.RAW_COPPER_BLOCK, 2, 1, 12, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.AMETHYST_SHARD, 2, 3, 8, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.BONE, 1, 6, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.STRING, 1, 6, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.SMOOTH_BASALT, 1, 12, 14, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.GUNPOWDER, 1, 3, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.ROTTEN_FLESH, 1, 14, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(RAW_SILVER, 1, 2, 12, 5));
        });
        // this will not be possible but by commands.
        // maybe when I am more competent I can add a level.

        // overboard
        TradeOfferHelper.registerVillagerOffers(MINER, 6, factories -> {
            factories.add(new TradeOffers.BuyItemFactory(Items.DIAMOND_SWORD, 1, 12, 4));
            factories.add(new TradeOffers.SellItemFactory(Items.GLOW_INK_SAC, 3, 5, 10, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.SCULK, 4, 1, 6, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.SOUL_TORCH, 2, 4, 16, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.GRAY_WOOL, 1, 12, 32, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.REDSTONE_LAMP, 1, 1, 12, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.POLISHED_DEEPSLATE, 1, 8, 16, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.CANDLE, 2, 6, 16, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.SOUL_LANTERN, 2, 1, 8, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.EXPERIENCE_BOTTLE, 3, 1, 8, 3));
        });

        // gift
        VillagerInteractionRegistries.registerGiftLootTable(GEM_DEALER, RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("mc-extended", "miner")));

    }

    public static class ExplicitTradeFactory implements TradeOffers.Factory {
        private final TradedItem inputOne;
        private final Optional<TradedItem> inputTwo;
        private final ItemStack output;
        private final int maxUses;
        private final int experience;
        private final float priceMultiplier;

        public ExplicitTradeFactory(ItemConvertible itemOne, int countOne, ItemConvertible itemThree, int countThree, int maxUses, int experience, float priceMultiplier) {
            this(itemOne, countOne, null, 0, itemThree, countThree, maxUses, experience, priceMultiplier);
        }

        public ExplicitTradeFactory(ItemConvertible itemOne, int countOne, @Nullable ItemConvertible itemTwo, int countTwo, ItemConvertible itemThree, int countThree, int maxUses, int experience, float priceMultiplier) {
            this.inputOne = new TradedItem(itemOne, countOne);
            this.inputTwo = itemTwo != null ? Optional.of(new TradedItem(itemTwo, countTwo)) : Optional.empty();
            this.output = new ItemStack(itemThree, countThree);
            this.maxUses = maxUses;
            this.experience = experience;
            this.priceMultiplier = priceMultiplier;
        }

        @Nullable
        @Override
        public TradeOffer create(Entity entity, Random random) {
            ItemStack outputStack = this.output.copy();

            return new TradeOffer(
                    inputOne,
                    inputTwo,
                    outputStack,
                    0, // Special price adjustment
                    this.maxUses,
                    this.experience,
                    this.priceMultiplier
            );
        }
    }
    private static RegistryKey<VillagerProfession> of(String id) {
        return RegistryKey.of(RegistryKeys.VILLAGER_PROFESSION, Identifier.of(MC_EXTENDED, id));
    }

}
