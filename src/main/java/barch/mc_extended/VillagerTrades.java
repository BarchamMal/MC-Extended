package barch.mc_extended;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

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

    }

}
