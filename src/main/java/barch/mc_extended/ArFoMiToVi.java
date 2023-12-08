package barch.mc_extended;

import barch.mc_extended.Armor.ArmorMaterials;
import barch.mc_extended.Entities.Entities;
import barch.mc_extended.Foods.Foods;
import barch.mc_extended.Minerals.Minerals;
import barch.mc_extended.Misc.Misc;
import barch.mc_extended.Tools.ToolMaterials;
import barch.mc_extended.Villagers.Villagers;

public class ArFoMiToVi {

    public static void RegisterAll() {

        Minerals.RegisterAll();
        Foods.RegisterAll();
        Misc.RegisterAll();

        ArmorMaterials.RegisterAll();
        ToolMaterials.RegisterAll();

        Villagers.RegisterAll();
        Entities.RegisterAll();

    };

}
