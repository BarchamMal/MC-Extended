package barch.mc_extended.Tools;

import barch.mc_extended.MCExtended;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.Minerals.Ruby.*;
import static barch.mc_extended.MCExtended.*;

public class RubyToolMaterial implements ToolMaterial {

    public static final RubyToolMaterial INSTANCE = new RubyToolMaterial();


    // ruby sword
    public static ToolItem RUBY_SWORD = new SwordItem(RubyToolMaterial.INSTANCE, 3, -2.4f, new Item.Settings());
    // ruby axe
    public static ToolItem RUBY_AXE = new AxeItem(RubyToolMaterial.INSTANCE, 5f, -3f, new Item.Settings());

    // ruby hoe
    public static ToolItem RUBY_HOE = new HoeItem(RubyToolMaterial.INSTANCE, -3, 0, new Item.Settings());

    // ruby shovel
    public static ToolItem RUBY_SHOVEL = new ShovelItem(RubyToolMaterial.INSTANCE, 1.5f, -3f, new Item.Settings());

    // ruby pickaxe
    public static ToolItem RUBY_PICKAXE = new PickaxeItem(RubyToolMaterial.INSTANCE, 1, -2.8f, new Item.Settings());





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
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RUBY);
    }

    public static void RegisterTools() {


        // ruby sword
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby_sword"), RUBY_SWORD);
        // ruby axe
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby_axe"), RUBY_AXE);
        // ruby hoe
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby_hoe"), RUBY_HOE);
        // ruby shovel
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby_shovel"), RUBY_SHOVEL);
        // ruby pickaxe
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ruby_pickaxe"), RUBY_PICKAXE);

    }

    public static void GroupTools() {

        // ruby sword
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_SWORD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.DIAMOND_SWORD, RUBY_SWORD);
        });
        // ruby shovel
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_SHOVEL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.DIAMOND_HOE, RUBY_SHOVEL);
        });
        // ruby pickaxe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_PICKAXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(RUBY_SHOVEL, RUBY_PICKAXE);
        });
        // ruby axe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.DIAMOND_AXE, RUBY_AXE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(RUBY_PICKAXE, RUBY_AXE);
        });
        // ruby hoe
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(RUBY_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(RUBY_AXE, RUBY_HOE);
        });

    }
}
