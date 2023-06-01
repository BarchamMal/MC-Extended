package barch.mc_extended.Tools;

import barch.mc_extended.Minerals.Tin;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;

public class TinToolMaterial implements ToolMaterial {

    public static final TinToolMaterial INSTANCE = new TinToolMaterial();


    // tin sword
    public static ToolItem TIN_SWORD = new SwordItem(TinToolMaterial.INSTANCE, 0, -2.4f, new Item.Settings());
    // tin axe
    public static ToolItem TIN_AXE = new AxeItem(TinToolMaterial.INSTANCE, 2f, -3.1f, new Item.Settings());

    // tin hoe
    public static ToolItem TIN_HOE = new HoeItem(TinToolMaterial.INSTANCE, -5, -1, new Item.Settings());

    // tin shovel
    public static ToolItem TIN_SHOVEL = new ShovelItem(TinToolMaterial.INSTANCE, -1.5f, -3f, new Item.Settings());

    // tin pickaxe
    public static ToolItem TIN_PICKAXE = new PickaxeItem(TinToolMaterial.INSTANCE, -2, -2.5f, new Item.Settings());





    @Override
    public int getDurability() {
        return 150;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5f;
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
        return 1;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Tin.TIN_INGOT);
    }

    public static void RegisterTools() {


        // tin sword
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "tin_sword"), TIN_SWORD);
        // tin axe
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "tin_axe"), TIN_AXE);
        // tin hoe
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "tin_hoe"), TIN_HOE);
        // tin shovel
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "tin_shovel"), TIN_SHOVEL);
        // tin pickaxe
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "tin_pickaxe"), TIN_PICKAXE);

    }

    public static void GroupTools() {

        // tin sword
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TIN_SWORD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.IRON_SWORD, TIN_SWORD);
        });
        // tin shovel
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TIN_SHOVEL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.IRON_HOE, TIN_SHOVEL);
        });
        // tin pickaxe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TIN_PICKAXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(TIN_SHOVEL, TIN_PICKAXE);
        });
        // tin axe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TIN_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.IRON_AXE, TIN_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(TIN_PICKAXE, TIN_AXE);
        });
        // tin hoe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TIN_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(TIN_AXE, TIN_HOE);
        });

    }
}
