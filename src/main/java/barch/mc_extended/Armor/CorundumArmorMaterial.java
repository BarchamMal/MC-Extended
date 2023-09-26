package barch.mc_extended.Armor;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Minerals.Corundum;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static barch.mc_extended.Armor.SapphireArmorMaterial.SAPPHIRE_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.NAMESPACE;

public class CorundumArmorMaterial implements ArmorMaterial {

    public static final CorundumArmorMaterial INSTANCE = new CorundumArmorMaterial();

    private static final int[] BASE_DURABILITY = new int[] {49,73,67,65};
    private static final int[] PROTECTION_VALUES = new int[] {4,8,10,4};

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * 10;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return PROTECTION_VALUES[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Corundum.CORUNDUM);
    }

    @Override
    public String getName() {
        return "corundum";
    }

    @Override
    public float getToughness() {
        return 4f;
    }

    @Override
    public float getKnockbackResistance() {
        return 1.5f;
    }

    public static final Item CORUNDUM_HELMET = new ArmorItem(INSTANCE, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof());
    public static final Item CORUNDUM_CHESTPLATE = new ArmorItem(INSTANCE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof());
    public static final Item CORUNDUM_LEGGINGS = new ArmorItem(INSTANCE, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof());
    public static final Item CORUNDUM_BOOTS = new ArmorItem(INSTANCE, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof());
    public static final Item CORUNDUM_HORSE_ARMOR = new HorseArmorItem(2, "corundum", new FabricItemSettings().maxCount(1).fireproof());

    public static void RegisterArmor() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_helmet"), CORUNDUM_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_chestplate"), CORUNDUM_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_leggings"), CORUNDUM_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_boots"), CORUNDUM_BOOTS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "corundum_horse_armor"), CORUNDUM_HORSE_ARMOR);

    }

    public static void GroupArmor() {

        ItemGrouper.GroupItem(CORUNDUM_HELMET, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.NETHERITE_BOOTS)});
        ItemGrouper.GroupItem(CORUNDUM_CHESTPLATE, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, CORUNDUM_HELMET)});
        ItemGrouper.GroupItem(CORUNDUM_LEGGINGS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, CORUNDUM_CHESTPLATE)});
        ItemGrouper.GroupItem(CORUNDUM_BOOTS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, CORUNDUM_LEGGINGS)});
        ItemGrouper.GroupItem(CORUNDUM_HORSE_ARMOR, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SAPPHIRE_HORSE_ARMOR)});

    }

}
