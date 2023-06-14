package barch.mc_extended.Villagers;

import barch.mc_extended.MCExtended;
import barch.mc_extended.Minerals.*;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffers;

import static barch.mc_extended.Minerals.Ruby.*;
import static barch.mc_extended.Minerals.Silver.RAW_SILVER;
import static barch.mc_extended.Minerals.Tin.RAW_TIN;

public class VillagerTrades {


    public static void RegisterTrades() {

        RegisterGemDealerTrades();
        RegisterMinerTrades();

    }
    public static void RegisterGemDealerTrades() {

        // novice
        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.GEM_DEALER, 1, factories -> {
            factories.add(new TradeOffers.SellItemFactory(Items.AMETHYST_SHARD, 2, 5, 1));
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.LAPIS_LAZULI, 3, 16, 1));
            factories.add(new TradeOffers.ProcessItemFactory(Items.DIAMOND_ORE, 1, Items.DIAMOND, 2, 16, 3));
            factories.add(new TradeOffers.ProcessItemFactory(Items.LAPIS_ORE, 1, Items.LAPIS_LAZULI, 4, 16, 2));
        });
        // apprentice
        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.GEM_DEALER, 2, factories -> {
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.GOLD_INGOT, 2, 16, 8));
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.COPPER_INGOT, 8, 24, 2));
            factories.add(new TradeOffers.SellItemFactory(Items.IRON_INGOT, 2, 6, 4));
            factories.add(new TradeOffers.ProcessItemFactory(Items.NETHER_QUARTZ_ORE, 1, Items.QUARTZ, 8, 16, 3));
        }) ;
        // journeyman
        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.GEM_DEALER, 3, factories -> {
            factories.add(new TradeOffers.SellItemFactory(Items.ECHO_SHARD, 10, 1, 10));
            factories.add(new TradeOffers.ProcessItemFactory(Items.QUARTZ_BLOCK, 1, Items.QUARTZ, 3, 10, 4));
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.GLASS, 3, 4, 3));
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.CRYING_OBSIDIAN, 1, 8, 10));
            factories.add(new TradeOffers.SellItemFactory(Items.OBSIDIAN, 3, 1, 6));
        });
        // expert
        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.GEM_DEALER, 4, factories -> {
            factories.add(new TradeOffers.ProcessItemFactory(Items.RAW_COPPER, 1, Items.COPPER_INGOT, 1, 24, 1));
            factories.add(new TradeOffers.ProcessItemFactory(Items.RAW_GOLD, 2, Items.GOLD_NUGGET, 16, 12, 3));
            factories.add(new TradeOffers.ProcessItemFactory(RAW_SILVER, 1, Silver.SILVER_INGOT, 1, 12, 5));
        });
        // master
        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.GEM_DEALER, 5, factories -> {
            factories.add(new TradeOffers.ProcessItemFactory(Items.OBSIDIAN, 3, Items.CRYING_OBSIDIAN, 2, 24, 1));
            factories.add(new TradeOffers.ProcessItemFactory(RUBY, 1, Items.EMERALD, 5, 12, 3));
            factories.add(new TradeOffers.ProcessItemFactory(RUBY_ORE, 1, RUBY, 2, 12, 5));
            factories.add(new TradeOffers.ProcessItemFactory(Silver.RAW_SILVER_BLOCK, 1, Silver.SILVER_INGOT, 10, 12, 5));
            factories.add(new TradeOffers.ProcessItemFactory(Items.RAW_COPPER_BLOCK, 1, Items.COPPER_INGOT, 10, 12, 5));
            factories.add(new TradeOffers.ProcessItemFactory(Items.RAW_GOLD_BLOCK, 1, Items.GOLD_INGOT, 10, 12, 5));
        });

        // gift
        VillagerInteractionRegistries.registerGiftLootTable(VillagerProfessions.GEM_DEALER, new Identifier("minecraft", "gem_dealer"));

    }

    public static void RegisterMinerTrades() {

        // novice
        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.MINER, 1, factories -> {
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.COBBLESTONE, 16, 8, 1));
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.IRON_PICKAXE, 1, 16, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.COAL, 1, 8, 8, 1));
            factories.add(new TradeOffers.SellItemFactory(RAW_TIN, 1, 4, 6, 2));
            factories.add(new TradeOffers.ProcessItemFactory(Items.GRAVEL, 10, Items.FLINT, 10,12,1));

        });
        // apprentice
        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.MINER, 2, factories -> {
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.STONE_SHOVEL, 1, 8, 4));
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 16, 16, 2));
            factories.add(new TradeOffers.SellItemFactory(Items.DIORITE, 1, 16, 8, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.GRANITE, 1, 16, 6, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.ANDESITE, 1, 16, 6, 3));

        }) ;
        // journeyman
        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.MINER, 3, factories -> {
            factories.add(new TradeOffers.SellItemFactory(Items.DEEPSLATE, 1, 32, 16, 3));
            factories.add(new TradeOffers.SellItemFactory(Items.POINTED_DRIPSTONE, 1, 12, 8, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.TUFF, 1, 24, 16, 4));
            factories.add(new TradeOffers.SellItemFactory(Items.CALCITE, 1, 16, 16, 4));
            factories.add(new TradeOffers.ProcessItemFactory(Items.DIAMOND_PICKAXE, 1, Items.EMERALD, 6, 8, 6));

        });
        // expert
        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.MINER, 4, factories -> {
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.SHEARS, 1, 12, 4));
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.DIAMOND_SHOVEL, 1, 8, 7));
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.DIAMOND_HOE, 1, 8, 7));
            factories.add(new TradeOffers.SellItemFactory(Items.MOSS_BLOCK, 1, 12, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.CLAY_BALL, 1, 8, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.FLOWERING_AZALEA, 1, 8, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.BIG_DRIPLEAF, 1, 4, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.GLOW_BERRIES, 1, 12, 16, 5));


        });
        // master
        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.MINER, 5, factories -> {
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.OAK_LOG, 4, 24, 4));
            factories.add(new TradeOffers.SellItemFactory(Items.DIAMOND, 3, 1, 8, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.OBSIDIAN, 3, 2, 12, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.LAPIS_LAZULI, 1, 8, 12, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.RAW_GOLD, 1, 3, 8, 5));
            factories.add(new TradeOffers.SellItemFactory(RUBY, 24, 1, 6, 7));
            factories.add(new TradeOffers.SellItemFactory(Items.REDSTONE, 1, 16, 12, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.RAW_IRON, 1, 4, 12, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.RAW_COPPER_BLOCK, 2, 1, 12, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.AMETHYST_SHARD, 2, 3, 8, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.BONE, 1, 6, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.SMOOTH_BASALT, 1, 12, 14, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.GUNPOWDER, 1, 3, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(Items.ROTTEN_FLESH, 1, 14, 16, 5));
            factories.add(new TradeOffers.SellItemFactory(RAW_SILVER, 1, 2, 12, 5));
        });
        // this will not be possible but by commands.
        // maybe when i am more competent i can add a level.

        // overboard
        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.MINER, 6, factories -> {
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.DIAMOND_SWORD, 1, 12, 4));
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
        VillagerInteractionRegistries.registerGiftLootTable(VillagerProfessions.MINER, new Identifier("minecraft", "miner"));

    }

}
