package barch.mc_extended.Tools;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class MCEToolMaterials {


    public static Item registerSword(String id, int baseAttackDamage, float attackSpeed, ToolMaterial material, Item.Settings settings) {
        return Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, id+"_sword"), new SwordItem(material, settings.attributeModifiers(SwordItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed))));
    }
    public static Item registerAxe(String id, float baseAttackDamage, float attackSpeed, ToolMaterial material, Item.Settings settings) {
        return Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, id+"_axe"), new AxeItem(material, settings.attributeModifiers(AxeItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed))));
    }
    public static Item registerHoe(String id, float baseAttackDamage, float attackSpeed, ToolMaterial material, Item.Settings settings) {
        return Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, id+"_hoe"), new HoeItem(material, settings.attributeModifiers(HoeItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed))));
    }
    public static Item registerShovel(String id, float baseAttackDamage, float attackSpeed, ToolMaterial material, Item.Settings settings) {
        return Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, id+"_shovel"), new ShovelItem(material, settings.attributeModifiers(ShovelItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed))));
    }
    public static Item registerPickaxe(String id, float baseAttackDamage, float attackSpeed, ToolMaterial material, Item.Settings settings) {
        return Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, id+"_pickaxe"), new PickaxeItem(material, settings.attributeModifiers(PickaxeItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed))));
    }

    public static void RegisterAll() {

        RubyToolMaterial.GroupTools();
        SapphireToolMaterial.GroupTools();
        SilverToolMaterial.GroupTools();
        BronzeToolMaterial.GroupTools();
        CopperToolMaterial.GroupTools();
        TinToolMaterial.GroupTools();
        CorundumToolMaterial.GroupTools();

    }

}
