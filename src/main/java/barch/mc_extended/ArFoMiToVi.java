package barch.mc_extended;

import barch.mc_extended.Armor.ArmorMaterials;
import barch.mc_extended.Entities.Entities;
import barch.mc_extended.Foods.Foods;
import barch.mc_extended.Minerals.Minerals;
import barch.mc_extended.Misc.Misc;
import barch.mc_extended.Tools.ToolMaterials;
import barch.mc_extended.Villagers.Villagers;

public class ArFoMiToVi {

    public static final ArFoMiToVi INSTANCE = new ArFoMiToVi();


    public static final Minerals MINERALS = new Minerals();
    public static final Foods FOODS = new Foods();
    public static final Misc MISC = new Misc();
    public static final ArmorMaterials ARMOR_MATERIALS = new ArmorMaterials();
    public static final ToolMaterials TOOL_MATERIALS = new ToolMaterials();
    public static final Villagers VILLAGERS = new Villagers();
    public static final Entities ENTITIES = new Entities();


    public static void RegisterAll() {

        MINERALS.RegisterAll();
        FOODS.RegisterAll();
        MISC.RegisterAll();

        ARMOR_MATERIALS.RegisterAll();
        TOOL_MATERIALS.RegisterAll();

        VILLAGERS.RegisterAll();
        ENTITIES.RegisterAll();

    };

}
