package barch.mc_extended.Registry;

import com.mojang.serialization.Codec;
import net.minecraft.component.Component;
import net.minecraft.component.ComponentType;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class ModComponents {

    public static final FoodComponent ONION_FOOD_COMPONENT = new FoodComponent.Builder().nutrition(3).saturationModifier(3f).build();
    public static final FoodComponent FRIED_ONION_FOOD_COMPONENT = new FoodComponent.Builder().nutrition(7).saturationModifier(7f).build();
    public static final FoodComponent ONION_SAUCE_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(9).saturationModifier(8f).build();
    public static final FoodComponent BACON_AND_MUSHROOMS_FOOD_COMPONENT = new FoodComponent.Builder().nutrition(12).saturationModifier(12).build();
    public static final FoodComponent CHEESY_SAAG_FOOD_COMPONENT = new FoodComponent.Builder().nutrition(18).saturationModifier(20).build();
    public static final FoodComponent SPINACH_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(1).saturationModifier(3f).build();
    public static final FoodComponent COOKED_SPINACH_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(3).saturationModifier(4f).build();
    public static final FoodComponent SAAG_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(9).saturationModifier(8f).build();
    public static final FoodComponent TOMATO_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(4).saturationModifier(4f).build();
    public static final FoodComponent ROAST_TOMATO_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(6).saturationModifier(6f).build();
    public static final FoodComponent TOMATO_SAUCE_FOOD_COMPONANT = new FoodComponent.Builder().nutrition(9).saturationModifier(8f).build();    public static final ComponentType<String> FLOWER_COMPONENT_TYPE = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(MC_EXTENDED, "flower_component_type"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );
}
