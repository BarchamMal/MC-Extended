package barch.mc_extended.Tools;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Objects;

import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class MCEToolMaterials {


    public static Item registerTool(String id, Item item) {

        String tool_name = "";
        if (item instanceof SwordItem) {
            tool_name = "sword";
        } else if (item instanceof AxeItem) {
            tool_name = "axe";
        } else if (item instanceof HoeItem) {
            tool_name = "hoe";
        } else if (item instanceof ShovelItem) {
            tool_name = "shovel";
        } else if (item instanceof PickaxeItem) {
            tool_name = "pickaxe";
        }

        return Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, id + "_" + tool_name), item);
    }

    public static void RegisterAll() {

        RubyTool.GroupTools();
        SapphireTool.GroupTools();
        SilverTool.GroupTools();
        BronzeTool.GroupTools();
        CopperTool.GroupTools();
        TinTool.GroupTools();
        CorundumTool.GroupTools();

    }

}
