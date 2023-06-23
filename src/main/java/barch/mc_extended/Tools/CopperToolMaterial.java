package barch.mc_extended.Tools;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.*;

public class CopperToolMaterial implements ToolMaterial {

    public static final CopperToolMaterial INSTANCE = new CopperToolMaterial();


    // copper sword
    public static ToolItem COPPER_SWORD = new SwordItem(CopperToolMaterial.INSTANCE, 0, -2.4f, new Item.Settings());
    // copper axe
    public static ToolItem COPPER_AXE = new AxeItem(CopperToolMaterial.INSTANCE, 2f, -3.1f, new Item.Settings());

    // copper hoe
    public static ToolItem COPPER_HOE = new HoeItem(CopperToolMaterial.INSTANCE, -5, -1, new Item.Settings());

    // copper shovel
    public static ToolItem COPPER_SHOVEL = new ShovelItem(CopperToolMaterial.INSTANCE, -1.5f, -3f, new Item.Settings());

    // copper pickaxe
    public static ToolItem COPPER_PICKAXE = new PickaxeItem(CopperToolMaterial.INSTANCE, -2, -2.5f, new Item.Settings());





    @Override
    public int getDurability() {
        return 150;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4f;
    }

    @Override
    public float getAttackDamage() {
        return 5;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 1;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }

    public static void RegisterTools() {


        // copper sword
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "copper_sword"), COPPER_SWORD);
        // copper axe
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "copper_axe"), COPPER_AXE);
        // copper hoe
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "copper_hoe"), COPPER_HOE);
        // copper shovel
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "copper_shovel"), COPPER_SHOVEL);
        // copper pickaxe
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "copper_pickaxe"), COPPER_PICKAXE);

    }

    public static void GroupTools() {

        // copper sword
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(COPPER_SWORD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.IRON_SWORD, COPPER_SWORD);
        });
        // copper shovel
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(COPPER_SHOVEL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.IRON_HOE, COPPER_SHOVEL);
        });
        // copper pickaxe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(COPPER_PICKAXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(COPPER_SHOVEL, COPPER_PICKAXE);
        });
        // copper axe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(COPPER_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.IRON_AXE, COPPER_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(COPPER_PICKAXE, COPPER_AXE);
        });
        // copper hoe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(COPPER_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(COPPER_AXE, COPPER_HOE);
        });

    }
}
