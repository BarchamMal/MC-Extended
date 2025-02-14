package barch.mc_extended.Registry;

import barch.mc_extended.Items.MCExtendedSmithingTemplates;

public class MCExtendedRegistry {

    public static void RegisterAll() {

        ModItems.GroupAll();
        ModBlocks.doNothing();
        ModEntities.doSomething();
        MCExtendedSmithingTemplates.doNothing();
        ModProfessions.registerProfessions();

    };

}
