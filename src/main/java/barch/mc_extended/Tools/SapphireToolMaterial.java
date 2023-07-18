package barch.mc_extended.Tools;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;
import static barch.mc_extended.MCExtended.NAMESPACE;
import static barch.mc_extended.Minerals.Sapphire.SAPPHIRE;

public class SapphireToolMaterial implements ToolMaterial {

    public static final SapphireToolMaterial INSTANCE = new SapphireToolMaterial();


    // sapphire sword
    public static ToolItem SAPPHIRE_SWORD = new SwordItem(SapphireToolMaterial.INSTANCE, 3, -2.4f, new Item.Settings());
    // sapphire axe
    public static ToolItem SAPPHIRE_AXE = new AxeItem(SapphireToolMaterial.INSTANCE, 5f, -3f, new Item.Settings());

    // sapphire hoe
    public static ToolItem SAPPHIRE_HOE = new HoeItem(SapphireToolMaterial.INSTANCE, -3, 0, new Item.Settings());

    // sapphire shovel
    public static ToolItem SAPPHIRE_SHOVEL = new ShovelItem(SapphireToolMaterial.INSTANCE, 1.5f, -3f, new Item.Settings());

    // sapphire pickaxe
    public static ToolItem SAPPHIRE_PICKAXE = new PickaxeItem(SapphireToolMaterial.INSTANCE, 1, -2.8f, new Item.Settings());





    @Override
    public int getDurability() {
        return 1561;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8f;
    }

    @Override
    public float getAttackDamage() {
        return 3;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(SAPPHIRE);
    }

    public static void RegisterTools() {


        // sapphire sword
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "sapphire_sword"), SAPPHIRE_SWORD);
        // sapphire axe
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "sapphire_axe"), SAPPHIRE_AXE);
        // sapphire hoe
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "sapphire_hoe"), SAPPHIRE_HOE);
        // sapphire shovel
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "sapphire_shovel"), SAPPHIRE_SHOVEL);
        // sapphire pickaxe
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "sapphire_pickaxe"), SAPPHIRE_PICKAXE);

    }

    public static void GroupTools() {

        // sapphire sword
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SAPPHIRE_SWORD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.DIAMOND_SWORD, SAPPHIRE_SWORD);
        });
        // sapphire shovel
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SAPPHIRE_SHOVEL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.DIAMOND_HOE, SAPPHIRE_SHOVEL);
        });
        // sapphire pickaxe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SAPPHIRE_PICKAXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(SAPPHIRE_SHOVEL, SAPPHIRE_PICKAXE);
        });
        // sapphire axe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SAPPHIRE_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.DIAMOND_AXE, SAPPHIRE_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(SAPPHIRE_PICKAXE, SAPPHIRE_AXE);
        });
        // sapphire hoe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SAPPHIRE_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(SAPPHIRE_AXE, SAPPHIRE_HOE);
        });

    }
}
