package barch.mc_extended;

import barch.mc_extended.Armor.ArmorMaterials;
import barch.mc_extended.Foods.Foods;
import barch.mc_extended.Minerals.Minerals;
import barch.mc_extended.Tools.ToolMaterials;
import barch.mc_extended.Villagers.Villagers;

public class ArFoMiToVi {

    public static final ArFoMiToVi INSTANCE = new ArFoMiToVi();


    public static final Minerals MINERALS = new Minerals();
    public static final Foods FOODS = new Foods();

    public static final ArmorMaterials ARMOR_MATERIALS = new ArmorMaterials();
    public static final ToolMaterials TOOL_MATERIALS = new ToolMaterials();

    public static final Villagers VILLAGERS = new Villagers();

    public static void RegisterAll() {

        MINERALS.RegisterAll();
        FOODS.RegisterAll();

        ARMOR_MATERIALS.RegisterAll();
        TOOL_MATERIALS.RegisterAll();

        VILLAGERS.RegisterAll();

    };

}
