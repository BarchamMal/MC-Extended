package barch.mc_extended.Tools;

import barch.mc_extended.Minerals.Corundum;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;
import static barch.mc_extended.MCExtended.NAMESPACE;

public class CorundumToolMaterial implements ToolMaterial {

    public static final CorundumToolMaterial INSTANCE = new CorundumToolMaterial();


    // corundum sword
    public static ToolItem CORUNDUM_SWORD = new SwordItem(CorundumToolMaterial.INSTANCE, 4, -2f, new Item.Settings());
    // corundum axe
    public static ToolItem CORUNDUM_AXE = new AxeItem(CorundumToolMaterial.INSTANCE, 5f, -3f, new Item.Settings());

    // corundum hoe
    public static ToolItem CORUNDUM_HOE = new HoeItem(CorundumToolMaterial.INSTANCE, -5, 0, new Item.Settings());

    // corundum shovel
    public static ToolItem CORUNDUM_SHOVEL = new ShovelItem(CorundumToolMaterial.INSTANCE, 1.5f, -3f, new Item.Settings());

    // corundum pickaxe
    public static ToolItem CORUNDUM_PICKAXE = new PickaxeItem(CorundumToolMaterial.INSTANCE, 0, -2f, new Item.Settings());





    @Override
    public int getDurability() {
        return 2800;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 13f;
    }

    @Override
    public float getAttackDamage() {
        return 5;
    }

    @Override
    public int getMiningLevel() {
        return 6;
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Corundum.CORUNDUM);
    }

    public static void RegisterTools() {


        // corundum sword
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_sword"), CORUNDUM_SWORD);
        // corundum axe
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_axe"), CORUNDUM_AXE);
        // corundum hoe
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_hoe"), CORUNDUM_HOE);
        // corundum shovel
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_shovel"), CORUNDUM_SHOVEL);
        // corundum pickaxe
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_pickaxe"), CORUNDUM_PICKAXE);

    }

    public static void GroupTools() {

        // corundum sword
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(CORUNDUM_SWORD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.NETHERITE_SWORD, CORUNDUM_SWORD);
        });
        // corundum shovel
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(CORUNDUM_SHOVEL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.NETHERITE_HOE, CORUNDUM_SHOVEL);
        });
        // corundum pickaxe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(CORUNDUM_PICKAXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(CORUNDUM_SHOVEL, CORUNDUM_PICKAXE);
        });
        // corundum axe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(CORUNDUM_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.NETHERITE_AXE, CORUNDUM_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(CORUNDUM_PICKAXE, CORUNDUM_AXE);
        });
        // corundum hoe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(CORUNDUM_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(CORUNDUM_AXE, CORUNDUM_HOE);
        });

    }
}
