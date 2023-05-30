package barch.mc_extended;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.entity.ai.brain.task.GiveGiftsToHeroTask;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import net.minecraft.village.VillagerType;
import net.minecraft.world.gen.feature.GeodeFeature;
import net.minecraft.world.gen.structure.MineshaftStructure;

public class VillagerTrades {

    public static void RegisterTrades() {

        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.GEM_DEALER, 1, factories -> {
            factories.add(new TradeOffers.SellItemFactory(Items.AMETHYST_SHARD, 2, 5, 1));
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.LAPIS_LAZULI, 3, 16, 1));
            factories.add(new TradeOffers.ProcessItemFactory(Items.DIAMOND_ORE, 1, Items.DIAMOND, 2, 16, 3));
            factories.add(new TradeOffers.ProcessItemFactory(Items.LAPIS_ORE, 1, Items.LAPIS_LAZULI, 4, 16, 2));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.GEM_DEALER, 2, factories -> {
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.GOLD_INGOT, 2, 16, 8));
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.COPPER_INGOT, 8, 24, 2));
            factories.add(new TradeOffers.SellItemFactory(Items.IRON_INGOT, 2, 6, 4));
            factories.add(new TradeOffers.ProcessItemFactory(Items.NETHER_QUARTZ_ORE, 1, Items.QUARTZ, 8, 16, 3));
        }) ;

        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.GEM_DEALER, 3, factories -> {
            factories.add(new TradeOffers.SellItemFactory(Items.ECHO_SHARD, 10, 1, 10));
            factories.add(new TradeOffers.ProcessItemFactory(Items.QUARTZ_BLOCK, 1, Items.QUARTZ, 3, 10, 4));
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.GLASS, 3, 4, 3));
            factories.add(new TradeOffers.BuyForOneEmeraldFactory(Items.CRYING_OBSIDIAN, 1, 8, 10));
            factories.add(new TradeOffers.SellItemFactory(Items.OBSIDIAN, 3, 1, 6));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfessions.GEM_DEALER, 4, factories -> {
            factories.add(new TradeOffers.ProcessItemFactory(Items.RAW_COPPER, 1, Items.COPPER_INGOT, 1, 24, 1));
            factories.add(new TradeOffers.ProcessItemFactory(Items.RAW_GOLD, 2, Items.GOLD_NUGGET, 16, 12, 3));
            factories.add(new TradeOffers.ProcessItemFactory(MCExtended.RAW_SILVER, 1, MCExtended.SILVER_INGOT, 1, 12, 5));
        });

    }

}
