package barch.mc_extended.Villagers;

import barch.mc_extended.MCExtended;
import barch.mc_extended.Minerals.*;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

public class VillagerTrades {

    public static void RegisterTrades() {

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
            factories.add(new TradeOffers.ProcessItemFactory(Silver.RAW_SILVER, 1, Silver.SILVER_INGOT, 1, 12, 5));
        });
        // master
        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.GEM_DEALER, 5, factories -> {
            factories.add(new TradeOffers.ProcessItemFactory(Items.OBSIDIAN, 3, Items.CRYING_OBSIDIAN, 2, 24, 1));
            factories.add(new TradeOffers.ProcessItemFactory(MCExtended.RUBY, 1, Items.EMERALD, 5, 12, 3));
            factories.add(new TradeOffers.ProcessItemFactory(MCExtended.RUBY_ORE, 1, MCExtended.RUBY, 2, 12, 5));
            factories.add(new TradeOffers.ProcessItemFactory(Silver.RAW_SILVER_BLOCK, 1, Silver.SILVER_INGOT, 10, 12, 5));
            factories.add(new TradeOffers.ProcessItemFactory(Items.RAW_COPPER_BLOCK, 1, Items.COPPER_INGOT, 10, 12, 5));
            factories.add(new TradeOffers.ProcessItemFactory(Items.RAW_GOLD_BLOCK, 1, Items.GOLD_INGOT, 10, 12, 5));
        });
        // gift
        VillagerInteractionRegistries.registerGiftLootTable(VillagerProfessions.GEM_DEALER, new Identifier("minecraft", "gem_dealer"));

    }

}
