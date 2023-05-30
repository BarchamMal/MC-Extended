package barch.mc_extended;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED_GROUP;

public class SilverToolMaterial implements ToolMaterial {

    public static final SilverToolMaterial INSTANCE = new SilverToolMaterial();


    // silver sword
    public static ToolItem SILVER_SWORD = new SwordItem(SilverToolMaterial.INSTANCE, 4, -2f, new Item.Settings());
    // silver axe
    public static ToolItem SILVER_AXE = new AxeItem(SilverToolMaterial.INSTANCE, 5f, -3f, new Item.Settings());

    // silver hoe
    public static ToolItem SILVER_HOE = new HoeItem(SilverToolMaterial.INSTANCE, -5, 0, new Item.Settings());

    // silver shovel
    public static ToolItem SILVER_SHOVEL = new ShovelItem(SilverToolMaterial.INSTANCE, 1.5f, -3f, new Item.Settings());

    // silver pickaxe
    public static ToolItem SILVER_PICKAXE = new PickaxeItem(SilverToolMaterial.INSTANCE, 0, -2f, new Item.Settings());





    @Override
    public int getDurability() {
        return 56;
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
        return 2;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(MCExtended.SILVER_INGOT);
    }

    public static void RegisterTools() {


        // silver sword
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "silver_sword"), SILVER_SWORD);
        // silver axe
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "silver_axe"), SILVER_AXE);
        // silver hoe
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "silver_hoe"), SILVER_HOE);
        // silver shovel
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "silver_shovel"), SILVER_SHOVEL);
        // silver pickaxe
        Registry.register(Registries.ITEM, new Identifier("mc-extended", "silver_pickaxe"), SILVER_PICKAXE);

    }

    public static void GroupTools() {

        // silver sword
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_SWORD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.GOLDEN_SWORD, SILVER_SWORD);
        });
        // silver shovel
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_SHOVEL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.GOLDEN_HOE, SILVER_SHOVEL);
        });
        // silver pickaxe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_PICKAXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(SILVER_SHOVEL, SILVER_PICKAXE);
        });
        // silver axe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.GOLDEN_AXE, SILVER_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(SILVER_PICKAXE, SILVER_AXE);
        });
        // silver hoe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(SILVER_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(SILVER_AXE, SILVER_HOE);
        });

    }
}
