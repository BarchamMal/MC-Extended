package barch.mc_extended.Armor;

import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Minerals.Corundum;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static barch.mc_extended.Armor.ArmorMaterials.registerMaterial;
import static barch.mc_extended.Armor.SapphireArmorData.SAPPHIRE_HORSE_ARMOR;
import static barch.mc_extended.MCExtended.NAMESPACE;

public class CorundumArmorData {

    public static final RegistryEntry<ArmorMaterial> CORUNDUM = registerMaterial(
            "corundum",
            Map.of(
                    ArmorItem.Type.HELMET, 4,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 10,
                    ArmorItem.Type.BOOTS, 4,
                    ArmorItem.Type.BODY, 13
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.ofItems(Corundum.CORUNDUM),
            4.0F,
            1.5F,
            true);


    public static final Item CORUNDUM_HELMET = new ArmorItem(CORUNDUM, ArmorItem.Type.HELMET, new Item.Settings().fireproof());
    public static final Item CORUNDUM_CHESTPLATE = new ArmorItem(CORUNDUM, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof());
    public static final Item CORUNDUM_LEGGINGS = new ArmorItem(CORUNDUM, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof());
    public static final Item CORUNDUM_BOOTS = new ArmorItem(CORUNDUM, ArmorItem.Type.BOOTS, new Item.Settings().fireproof());

    public static final Item CORUNDUM_HORSE_ARMOR = new AnimalArmorItem(CORUNDUM, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1).fireproof());

    public static void RegisterArmor() {
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "corundum_helmet"), CORUNDUM_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "corundum_chestplate"), CORUNDUM_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "corundum_leggings"), CORUNDUM_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "corundum_boots"), CORUNDUM_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "corundum_horse_armor"), CORUNDUM_HORSE_ARMOR);
    }

    public static void GroupArmor() {
        ItemGrouper.GroupItem(CORUNDUM_HELMET, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, Items.NETHERITE_BOOTS)});
        ItemGrouper.GroupItem(CORUNDUM_CHESTPLATE, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, CORUNDUM_HELMET)});
        ItemGrouper.GroupItem(CORUNDUM_LEGGINGS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, CORUNDUM_CHESTPLATE)});
        ItemGrouper.GroupItem(CORUNDUM_BOOTS, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, CORUNDUM_LEGGINGS)});
        ItemGrouper.GroupItem(CORUNDUM_HORSE_ARMOR, new ItemGrouped[]{new ItemGrouped(ItemGroups.COMBAT, SAPPHIRE_HORSE_ARMOR)});
    }
}