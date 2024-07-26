package barch.mc_extended;

import barch.mc_extended.Armor.MCEArmorMaterials;
import barch.mc_extended.Entities.Entities;
import barch.mc_extended.Foods.Foods;
import barch.mc_extended.Minerals.Minerals;
import barch.mc_extended.Misc.Misc;
import barch.mc_extended.Tools.MCEToolMaterials;
import barch.mc_extended.Villagers.Villagers;

// (AR)mor (FO)od (MI)nerals (TO)ols (VI)llagers
public class ArFoMiToVi {

    public static void RegisterAll() {

        Minerals.RegisterAll();
        Foods.RegisterAll();
        Misc.RegisterAll();

        MCEArmorMaterials.RegisterAll();
        MCEToolMaterials.RegisterAll();

        Villagers.RegisterAll();
        Entities.RegisterAll();

    };

}
