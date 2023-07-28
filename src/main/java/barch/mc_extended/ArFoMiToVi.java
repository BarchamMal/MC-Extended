package barch.mc_extended;

import barch.mc_extended.Armor.ArmorMaterials;
import barch.mc_extended.Entities.Entities;
import barch.mc_extended.Foods.Foods;
import barch.mc_extended.Minerals.Minerals;
import barch.mc_extended.Tools.ToolMaterials;
import barch.mc_extended.Villagers.Villagers;

public class ArFoMiToVi {

    public static final ArFoMiToVi INSTANCE = new ArFoMiToVi();


    public static final Minerals MINERALS = Minerals.INSTANCE;

    public static final Foods FOODS = Foods.INSTANCE;

    public static final ArmorMaterials ARMOR_MATERIALS = ArmorMaterials.INSTANCE;

    public static final ToolMaterials TOOL_MATERIALS = ToolMaterials.INSTANCE;

    public static final Villagers VILLAGERS = Villagers.INSTANCE;

    public static final Entities ENTITIES = Entities.INSTANCE;


    public static void RegisterAll() {

        MINERALS.RegisterAll();
        FOODS.RegisterAll();

        ARMOR_MATERIALS.RegisterAll();
        TOOL_MATERIALS.RegisterAll();

        VILLAGERS.RegisterAll();
        ENTITIES.RegisterAll();

    };

}
