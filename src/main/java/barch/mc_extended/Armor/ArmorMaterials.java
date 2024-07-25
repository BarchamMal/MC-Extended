package barch.mc_extended.Armor;


import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.net.Proxy;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static barch.mc_extended.MCExtended.NAMESPACE;

public class ArmorMaterials {

        public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defencePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
                List<ArmorMaterial.Layer> layers = List.of(
                        new ArmorMaterial.Layer(Identifier.of(NAMESPACE, id), "", dyeable)
                );

                EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);
                ArmorItem.Type[] var9 = ArmorItem.Type.values();
                int var10 = var9.length;

                for(int var11 = 0; var11 < var10; ++var11) {
                    ArmorItem.Type type = var9[var11];
                    enumMap.put(type, (Integer)defencePoints.get(type));
                }

                return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.ofVanilla(id), new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance));

        }
        public static void RegisterAll() {

            RubyArmorData.RegisterArmor();
            RubyArmorData.GroupArmor();
            SapphireArmorData.RegisterArmor();
            SapphireArmorData.GroupArmor();
            SilverArmorData.RegisterArmor();
            SilverArmorData.GroupArmor();
            BronzeArmorData.RegisterArmor();
            BronzeArmorData.GroupArmor();
            CopperArmorData.RegisterArmor();
            CopperArmorData.GroupArmor();
            TinArmorData.RegisterArmor();
            TinArmorData.GroupArmor();
            CorundumArmorData.RegisterArmor();
            CorundumArmorData.GroupArmor();


        };
}
