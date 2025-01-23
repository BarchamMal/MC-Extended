package barch.mc_extended;

import barch.mc_extended.Entities.EnderCube;
import barch.mc_extended.Entities.Lost;
import barch.mc_extended.Entities.SilverGolem;
import barch.mc_extended.Entities.TroutFish;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;

public class EntitiesClient {


    public static void registerClient() {

        Lost.registerClient();
        TroutFish.registerClient();
        SilverGolem.registerClient();
        EnderCube.registerClient();

    }

}
