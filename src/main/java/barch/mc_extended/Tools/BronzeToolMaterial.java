package barch.mc_extended.Tools;

import barch.mc_extended.Minerals.Bronze;
import barch.mc_extended.Minerals.Tin;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.*;

public class BronzeToolMaterial implements ToolMaterial {

    public static final BronzeToolMaterial INSTANCE = new BronzeToolMaterial();


    // bronze sword
    public static ToolItem BRONZE_SWORD = new SwordItem(BronzeToolMaterial.INSTANCE, 0, -2.4f, new Item.Settings());
    // bronze axe
    public static ToolItem BRONZE_AXE = new AxeItem(BronzeToolMaterial.INSTANCE, 2f, -3.1f, new Item.Settings());

    // bronze hoe
    public static ToolItem BRONZE_HOE = new HoeItem(BronzeToolMaterial.INSTANCE, -5, 1, new Item.Settings());

    // bronze shovel
    public static ToolItem BRONZE_SHOVEL = new ShovelItem(BronzeToolMaterial.INSTANCE, 1.5f, -3f, new Item.Settings());

    // bronze pickaxe
    public static ToolItem BRONZE_PICKAXE = new PickaxeItem(BronzeToolMaterial.INSTANCE, -2, -2.5f, new Item.Settings());





    @Override
    public int getDurability() {
        return 230;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6f;
    }

    @Override
    public float getAttackDamage() {
        return 5;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 2;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Bronze.BRONZE_INGOT);
    }

    public static void RegisterTools() {


        // bronze sword
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bronze_sword"), BRONZE_SWORD);
        // bronze axe
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bronze_axe"), BRONZE_AXE);
        // bronze hoe
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bronze_hoe"), BRONZE_HOE);
        // bronze shovel
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bronze_shovel"), BRONZE_SHOVEL);
        // bronze pickaxe
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "bronze_pickaxe"), BRONZE_PICKAXE);

    }

    public static void GroupTools() {

        // bronze sword
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(BRONZE_SWORD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.IRON_SWORD, BRONZE_SWORD);
        });
        // bronze shovel
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(BRONZE_SHOVEL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.IRON_HOE, BRONZE_SHOVEL);
        });
        // bronze pickaxe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(BRONZE_PICKAXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(BRONZE_SHOVEL, BRONZE_PICKAXE);
        });
        // bronze axe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(BRONZE_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.IRON_AXE, BRONZE_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(BRONZE_PICKAXE, BRONZE_AXE);
        });
        // bronze hoe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(BRONZE_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(BRONZE_AXE, BRONZE_HOE);
        });

    }
}
