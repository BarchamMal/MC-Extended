package barch.mc_extended.Registry;

import barch.mc_extended.Items.ContainedFood;
import barch.mc_extended.Items.PlantSpecimenItem;
import barch.mc_extended.Items.Tools;
import barch.mc_extended.MCExtended;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.minecraft.block.Block;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Function;

import static barch.mc_extended.Items.Armor.*;
import static barch.mc_extended.Items.MCExtendedSmithingTemplates.*;
import static barch.mc_extended.MCExtended.MC_EXTENDED;
import static barch.mc_extended.Registry.ModBlocks.*;
import static barch.mc_extended.Registry.ModComponents.*;
import static barch.mc_extended.Registry.ModEntities.*;
import static barch.mc_extended.Registry.ModItems.AnimalArmorItem.Type.EQUESTRIAN;

public class ModItems {

    public static final Item BRONZE_HELMET         = registerArmor(BRONZE_AD, EquipmentType.HELMET);
    public static final Item BRONZE_CHESTPLATE     = registerArmor(BRONZE_AD, EquipmentType.CHESTPLATE);
    public static final Item BRONZE_LEGGINGS       = registerArmor(BRONZE_AD, EquipmentType.LEGGINGS);
    public static final Item BRONZE_BOOTS          = registerArmor(BRONZE_AD, EquipmentType.BOOTS);
    public static final Item BRONZE_HORSE_ARMOR    = registerArmor(BRONZE_AD, EQUESTRIAN);
    public static final Item COPPER_HELMET         = registerArmor(COPPER_AD, EquipmentType.HELMET);
    public static final Item COPPER_CHESTPLATE     = registerArmor(COPPER_AD, EquipmentType.CHESTPLATE);
    public static final Item COPPER_LEGGINGS       = registerArmor(COPPER_AD, EquipmentType.LEGGINGS);
    public static final Item COPPER_BOOTS          = registerArmor(COPPER_AD, EquipmentType.BOOTS);
    public static final Item COPPER_HORSE_ARMOR    = registerArmor(COPPER_AD, EQUESTRIAN);
    public static final Item CORUNDUM_HELMET       = registerArmor(CORUNDUM_AD, EquipmentType.HELMET);
    public static final Item CORUNDUM_CHESTPLATE   = registerArmor(CORUNDUM_AD, EquipmentType.CHESTPLATE);
    public static final Item CORUNDUM_LEGGINGS     = registerArmor(CORUNDUM_AD, EquipmentType.LEGGINGS);
    public static final Item CORUNDUM_BOOTS        = registerArmor(CORUNDUM_AD, EquipmentType.BOOTS);
    public static final Item CORUNDUM_HORSE_ARMOR  = registerArmor(CORUNDUM_AD, EQUESTRIAN);
    public static final Item RUBY_HELMET           = registerArmor(RUBY_AD, EquipmentType.HELMET);
    public static final Item RUBY_CHESTPLATE       = registerArmor(RUBY_AD, EquipmentType.CHESTPLATE);
    public static final Item RUBY_LEGGINGS         = registerArmor(RUBY_AD, EquipmentType.LEGGINGS);
    public static final Item RUBY_BOOTS            = registerArmor(RUBY_AD, EquipmentType.BOOTS);
    public static final Item RUBY_HORSE_ARMOR      = registerArmor(RUBY_AD, EQUESTRIAN);
    public static final Item SAPPHIRE_HELMET       = registerArmor(SAPPHIRE_AD, EquipmentType.HELMET);
    public static final Item SAPPHIRE_CHESTPLATE   = registerArmor(SAPPHIRE_AD, EquipmentType.CHESTPLATE);
    public static final Item SAPPHIRE_LEGGINGS     = registerArmor(SAPPHIRE_AD, EquipmentType.LEGGINGS);
    public static final Item SAPPHIRE_BOOTS        = registerArmor(SAPPHIRE_AD, EquipmentType.BOOTS);
    public static final Item SAPPHIRE_HORSE_ARMOR  = registerArmor(SAPPHIRE_AD, EQUESTRIAN);
    public static final Item SILVER_HELMET         = registerArmor(SILVER_AD, EquipmentType.HELMET);
    public static final Item SILVER_CHESTPLATE     = registerArmor(SILVER_AD, EquipmentType.CHESTPLATE);
    public static final Item SILVER_LEGGINGS       = registerArmor(SILVER_AD, EquipmentType.LEGGINGS);
    public static final Item SILVER_BOOTS          = registerArmor(SILVER_AD, EquipmentType.BOOTS);
    public static final Item SILVER_HORSE_ARMOR    = registerArmor(SILVER_AD, EQUESTRIAN);
    public static final Item TIN_HELMET            = registerArmor(TIN_AD, EquipmentType.HELMET);
    public static final Item TIN_CHESTPLATE        = registerArmor(TIN_AD, EquipmentType.CHESTPLATE);
    public static final Item TIN_LEGGINGS          = registerArmor(TIN_AD, EquipmentType.LEGGINGS);
    public static final Item TIN_BOOTS             = registerArmor(TIN_AD, EquipmentType.BOOTS);
    public static final Item TIN_HORSE_ARMOR       = registerArmor(TIN_AD, EQUESTRIAN);

    public static final Item BRONZE_AXE = registerTool(Tools.BRONZE_TD, Tools.TlType.AXE, -3.15f, 8f);
    public static final Item BRONZE_HOE = registerTool(Tools.BRONZE_TD, Tools.TlType.HOE, -1.2f, 0f);
    public static final Item BRONZE_PICKAXE = registerTool(Tools.BRONZE_TD, Tools.TlType.PICKAXE, -2.8f, 2.7f);
    public static final Item BRONZE_SHOVEL = registerTool(Tools.BRONZE_TD, Tools.TlType.SHOVEL, -3, 3.1f);
    public static final Item BRONZE_SWORD = registerTool(Tools.BRONZE_TD, Tools.TlType.SWORD, -2.4f, 4.8f);
    public static final Item COPPER_AXE = registerTool(Tools.COPPER_TD, Tools.TlType.AXE, -3.2f, 8);
    public static final Item COPPER_HOE = registerTool(Tools.COPPER_TD, Tools.TlType.HOE, -1.7f, 0);
    public static final Item COPPER_PICKAXE = registerTool(Tools.COPPER_TD, Tools.TlType.PICKAXE, -2.8f, 2.2f);
    public static final Item COPPER_SHOVEL = registerTool(Tools.COPPER_TD, Tools.TlType.SHOVEL, -3, 2.8f);
    public static final Item COPPER_SWORD = registerTool(Tools.COPPER_TD, Tools.TlType.SWORD, -2.4f, 4.4f);
    public static final Item CORUNDUM_AXE = registerTool(Tools.CORUNDUM_TD, Tools.TlType.AXE, -2.9f, 10);
    public static final Item CORUNDUM_HOE = registerTool(Tools.CORUNDUM_TD, Tools.TlType.HOE, 0.5f, 0);
    public static final Item CORUNDUM_PICKAXE = registerTool(Tools.CORUNDUM_TD, Tools.TlType.PICKAXE, -2.6f, 0.4f);
    public static final Item CORUNDUM_SHOVEL = registerTool(Tools.CORUNDUM_TD, Tools.TlType.SHOVEL, -3, 6);
    public static final Item CORUNDUM_SWORD = registerTool(Tools.CORUNDUM_TD, Tools.TlType.SWORD, -2.4f, 9);
    public static final Item RUBY_AXE = registerTool(Tools.RUBY_TD, Tools.TlType.AXE, -3, 8);
    public static final Item RUBY_HOE = registerTool(Tools.RUBY_TD, Tools.TlType.HOE, 0, 0);
    public static final Item RUBY_PICKAXE = registerTool(Tools.RUBY_TD, Tools.TlType.PICKAXE, -2.8f, 4);
    public static final Item RUBY_SHOVEL = registerTool(Tools.RUBY_TD, Tools.TlType.SHOVEL, -3f, 4.5f);
    public static final Item RUBY_SWORD = registerTool(Tools.RUBY_TD, Tools.TlType.SWORD, -2.4f, 6);
    public static final Item SAPPHIRE_AXE = registerTool(Tools.SAPPHIRE_TD, Tools.TlType.AXE, -3, 8);
    public static final Item SAPPHIRE_HOE = registerTool(Tools.SAPPHIRE_TD, Tools.TlType.HOE, 0, 0);
    public static final Item SAPPHIRE_PICKAXE = registerTool(Tools.SAPPHIRE_TD, Tools.TlType.PICKAXE, -2.8f, 4);
    public static final Item SAPPHIRE_SHOVEL = registerTool(Tools.SAPPHIRE_TD, Tools.TlType.SHOVEL, -3f, 4.5f);
    public static final Item SAPPHIRE_SWORD = registerTool(Tools.SAPPHIRE_TD, Tools.TlType.SWORD, -2.4f, 6);
    public static final Item SILVER_AXE = registerTool(Tools.SILVER_TD, Tools.TlType.AXE, -2.9f, 10);
    public static final Item SILVER_HOE = registerTool(Tools.SILVER_TD, Tools.TlType.HOE, 0.5f, 0);
    public static final Item SILVER_PICKAXE = registerTool(Tools.SILVER_TD, Tools.TlType.PICKAXE, -2.6f, 0.4f);
    public static final Item SILVER_SHOVEL = registerTool(Tools.SILVER_TD, Tools.TlType.SHOVEL, -3, 6);
    public static final Item SILVER_SWORD = registerTool(Tools.SILVER_TD, Tools.TlType.SWORD, -2.4f, 8);
    public static final Item TIN_AXE = registerTool(Tools.TIN_TD, Tools.TlType.AXE, -3.2f, 8);
    public static final Item TIN_HOE = registerTool(Tools.TIN_TD, Tools.TlType.HOE, -1.7f, 0);
    public static final Item TIN_PICKAXE = registerTool(Tools.TIN_TD, Tools.TlType.PICKAXE, -2.8f, 2.2f);
    public static final Item TIN_SHOVEL = registerTool(Tools.TIN_TD, Tools.TlType.SHOVEL, -3, 2.8f);
    public static final Item TIN_SWORD = registerTool(Tools.TIN_TD, Tools.TlType.SWORD,  -2.4f, 4.4f);

    public static final Item BRONZE_INGOT = register("bronze_ingot", new Item.Settings());
    public static final Item BRONZE_NUGGET = register("bronze_nugget", new Item.Settings());
    public static final Item RAW_BRONZE = register("raw_bronze", new Item.Settings());
    public static final Item BRONZE_BLOCK_ITEM = register(BRONZE_BLOCK, new Item.Settings());
    public static final Item RAW_BRONZE_BLOCK_ITEM = register(RAW_BRONZE_BLOCK, new Item.Settings());
    public static final Item CORUNDUM = register("corundum", new Item.Settings());
    public static final Item CORUNDUM_BLOCK_ITEM = register(CORUNDUM_BLOCK, new Item.Settings());
    public static final Item RUBY = register("ruby", new Item.Settings());
    public static final Item RUBY_BLOCK_ITEM = register(RUBY_BLOCK, new Item.Settings());
    public static final Item RUBY_ORE_BLOCK_ITEM = register(RUBY_ORE, new Item.Settings());
    public static final Item DEEPSLATE_RUBY_ORE_BLOCK_ITEM = register(DEEPSLATE_RUBY_ORE, new Item.Settings());
    public static final Item SAPPHIRE = register("sapphire", new Item.Settings());
    public static final Item SAPPHIRE_BLOCK_ITEM = register(SAPPHIRE_BLOCK, new Item.Settings());
    public static final Item SAPPHIRE_ORE_BLOCK_ITEM = register(SAPPHIRE_ORE, new Item.Settings());
    public static final Item DEEPSLATE_SAPPHIRE_ORE_BLOCK_ITEM = register(DEEPSLATE_SAPPHIRE_ORE, new Item.Settings());
    public static final Item SILVER_INGOT = register("silver_ingot", new Item.Settings());
    public static final Item SILVER_NUGGET = register("silver_nugget", new Item.Settings());
    public static final Item RAW_SILVER = register("raw_silver", new Item.Settings());
    public static final Item SILVER_BLOCK_ITEM = register(SILVER_BLOCK, new Item.Settings());
    public static final Item RAW_SILVER_BLOCK_ITEM = register(RAW_SILVER_BLOCK, new Item.Settings());
    public static final Item SILVER_ORE_BLOCK_ITEM = register(SILVER_ORE, new Item.Settings());
    public static final Item DEEPSLATE_SILVER_ORE_BLOCK_ITEM = register(DEEPSLATE_SILVER_ORE, new Item.Settings());
    public static final Item TIN_INGOT = register("tin_ingot", new Item.Settings());
    public static final Item TIN_NUGGET = register("tin_nugget", new Item.Settings());
    public static final Item RAW_TIN = register("raw_tin", new Item.Settings());
    public static final Item TIN_BLOCK_ITEM = register(TIN_BLOCK, new Item.Settings());
    public static final Item RAW_TIN_BLOCK_ITEM = register(RAW_TIN_BLOCK, new Item.Settings());
    public static final Item TIN_ORE_BLOCK_ITEM = register(TIN_ORE, new Item.Settings());
    public static final Item DEEPSLATE_TIN_ORE_BLOCK_ITEM = register(DEEPSLATE_TIN_ORE, new Item.Settings());

    public static final Item TOMATO_SEEDS = register(TOMATO_CROP_BLOCK, "tomato_seeds", new Item.Settings());
    public static final Item TOMATO = register(TOMATO_BLOCK, new Item.Settings().food(TOMATO_FOOD_COMPONANT), "tomato");
    public static final Item ROAST_TOMATO = register("roast_tomato", new Item.Settings().food(ROAST_TOMATO_FOOD_COMPONANT));
    public static final Item TOMATO_SAUCE = registerContainedFood("tomato_sauce", new Item.Settings().food(TOMATO_SAUCE_FOOD_COMPONANT), Items.BOWL);
    public static final Item ONION_TOMATO_SAUCE = registerContainedFood("onion_tomato_sauce", new Item.Settings().food(ONION_SAUCE_FOOD_COMPONANT), Items.BOWL);
    public static final Item WILD_ONION_ITEM = register(WILD_ONION, new Item.Settings());
    public static final Item ONION = register(ONION_CROP_BLOCK, "onion", new Item.Settings().food(ONION_FOOD_COMPONENT));
    public static final Item FRIED_ONION = register("fried_onion", new Item.Settings().food(FRIED_ONION_FOOD_COMPONENT));
    public static final Item WILD_SPINACH_ITEM = register(WILD_SPINACH, new Item.Settings());
    public static final Item SPINACH_SEEDS = register(SPINACH_CROP_BLOCK, "spinach_seeds", new Item.Settings());
    public static final Item SPINACH = register("spinach", new Item.Settings().food(SPINACH_FOOD_COMPONANT));
    public static final Item COOKED_SPINACH = register("cooked_spinach", new Item.Settings().food(COOKED_SPINACH_FOOD_COMPONANT));
    public static final Item SAAG = registerContainedFood("saag", new Item.Settings().food(SAAG_FOOD_COMPONANT), Items.BOWL);
    public static final Item WHITE_MUSHROOM_BLOCK_ITEM = register(WHITE_MUSHROOM_BLOCK, new Item.Settings());
    public static final Item WHITE_MUSHROOM_ITEM = register(WHITE_MUSHROOM, new Item.Settings());
    public static final Item BACON_AND_MUSHROOMS = registerContainedFood("bacon_and_mushrooms", new Item.Settings().food(BACON_AND_MUSHROOMS_FOOD_COMPONENT), Items.BOWL);
    public static final Item CHEESY_SAAG = registerContainedFood("cheesy_saag", new Item.Settings().food(CHEESY_SAAG_FOOD_COMPONENT), Items.BOWL);
    public static final Item CHEESE_ITEM = register(CHEESE_BLOCK, new Item.Settings());
    public static final Item TROUT = register("trout", new Item.Settings().food(FoodComponents.SALMON));
    public static final Item COOKED_TROUT = register("cooked_trout", new Item.Settings().food(FoodComponents.COOKED_SALMON));

    public static final Item GEM_TABLE_ITEM = register(GEM_TABLE, new Item.Settings());
    public static final Item BOTANY_TABLE_ITEM = register(BOTANY_TABLE, new Item.Settings());


    public static final Item LOST_SPAWN_EGG = registerSpawnEgg("lost_spawn_egg", LOST, new Item.Settings());
    public static final Item TROUT_FISH_SPAWN_EGG = registerSpawnEgg("trout_fish_spawn_egg", TROUT_FISH, new Item.Settings());
    public static final Item SILVER_GOLEM_SPAWN_EGG = registerSpawnEgg("silver_golem_spawn_egg", SILVER_GOLEM, new Item.Settings());
    public static final Item ENDER_CUBE_SPAWN_EGG = registerSpawnEgg("ender_cube_spawn_egg", ENDER_CUBE, new Item.Settings());

    public static final Item TROUT_BUCKET = registerFishBucket("trout_bucket", TROUT_FISH, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings());
    public static final Item PLANT_SPECIMEN = registerWildCard("plant_specimen", PlantSpecimenItem::new, new Item.Settings().maxDamage(36));
    public static final Item ENDER_CREAM = register("ender_cream", new Item.Settings());

    public static final Item CORUNDUM_UPGRADE_SMITHING_TEMPLATE = registerSmithingTemplate(
            "corundum_upgrade_smithing_template",
            CORUNDUM_UPGRADE_APPLIES_TO_TEXT,
            CORUNDUM_UPGRADE_INGREDIENTS_TEXT,
            CORUNDUM_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
            CORUNDUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
            getCorundumUpgradeEmptyBaseSlotTextures(),
            getCorundumUpgradeEmptyAdditionsSlotTextures(),
            new Item.Settings());

    public static Item registerSmithingTemplate(String name, Text appliesToText, Text ingredientsText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures, Item.Settings settings) {
        Identifier id = Identifier.of(MC_EXTENDED, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        return Registry.register(
                Registries.ITEM,
                key,
                new SmithingTemplateItem(
                        appliesToText,
                        ingredientsText,
                        baseSlotDescriptionText,
                        additionsSlotDescriptionText,
                        emptyBaseSlotTextures,
                        emptyAdditionsSlotTextures,
                        settings.registryKey(key))
        );
    }

    public static Item registerFishBucket(String name, EntityType<? extends MobEntity> entityType, FlowableFluid fluid, SoundEvent soundEvent, Item.Settings settings) {
        Identifier id = Identifier.of(MC_EXTENDED, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        return Registry.register(
                Registries.ITEM,
                key,
                new EntityBucketItem(entityType, fluid, soundEvent, settings.registryKey(key))
        );
    }

    public static Item registerSpawnEgg(String name, EntityType<? extends MobEntity> entity, Item.Settings settings) {
        Identifier id = Identifier.of(MC_EXTENDED, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        return Registry.register(
                Registries.ITEM,
                key,
                new SpawnEggItem(entity, settings.registryKey(key))
        );
        
    }
    
    public static Item registerArmor(EnumArmorMaterial armorType, EquipmentType equipmentType) {
        Identifier id = Identifier.of(MC_EXTENDED, (armorType.type + "_" + equipmentType).toLowerCase());
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = new Item(new Item.Settings().registryKey(key).maxCount(1).armor(armorType.armorMaterial, equipmentType));

        return Registry.register(
                Registries.ITEM,
                key,
                item
        );
    }

    public static Item registerArmor(EnumArmorMaterial armorType, AnimalArmorItem.Type equipmentType) {
        String eq = null;

        switch (equipmentType){
            case EQUESTRIAN -> eq = "horse_armor";
            case CANINE -> eq = "wolf_armor";
        }

        Identifier id = Identifier.of(MC_EXTENDED, (armorType.type + "_" + eq).toLowerCase());
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        Item item;
        if (equipmentType == EQUESTRIAN) {
            item = new Item(new Item.Settings().registryKey(key).maxCount(1).horseArmor(armorType.armorMaterial));
        }
        else {
            item = new Item(new Item.Settings().registryKey(key).maxCount(1).wolfArmor(armorType.armorMaterial));
        }

        return Registry.register(
                Registries.ITEM,
                key,
                item
        );
    }

    public static Item registerTool(Tools.EnumToolMaterial tlMat, Tools.TlType tlType, float aSpeed, float aDamage) {

        Identifier id = Identifier.of(MC_EXTENDED, (tlMat.type + "_" + tlType).toLowerCase());
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = switch (tlType) {
            case AXE ->
                    new AxeItem(tlMat.toolMaterial, aDamage, aSpeed, new Item.Settings().registryKey(key).maxCount(1));
            case HOE ->
                    new HoeItem(tlMat.toolMaterial, aDamage, aSpeed, new Item.Settings().registryKey(key).maxCount(1));
            case PICKAXE ->
                    new Item(new Item.Settings().registryKey(key).maxCount(1).pickaxe(tlMat.toolMaterial, aDamage, aSpeed));
            case SHOVEL ->
                    new ShovelItem(tlMat.toolMaterial, aDamage, aSpeed, new Item.Settings().registryKey(key).maxCount(1));
            case SWORD ->
                    new Item(new Item.Settings().registryKey(key).maxCount(1).sword(tlMat.toolMaterial, aDamage, aSpeed));
        };


        return Registry.register(
                Registries.ITEM,
                key,
                item
        );
    }

    public static Item register(String name, Item.Settings settings) {
        Identifier id = Identifier.of(MC_EXTENDED, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        return Registry.register(
                Registries.ITEM,
                key,
                new Item(settings.registryKey(key))
        );
    }

    public static Item registerContainedFood(String name, Item.Settings settings, Item container) {
        Identifier id = Identifier.of(MC_EXTENDED, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        return Registry.register(
                Registries.ITEM,
                key,
                new ContainedFood(settings.registryKey(key), container)
        );
    }

    public static Item register(Block block, Item.Settings settings) {
        Identifier id = Registries.BLOCK.getId(block);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        return Registry.register(
                Registries.ITEM,
                key,
                new BlockItem(block, settings.registryKey(key).useBlockPrefixedTranslationKey())
        );
    }

    public static Item register(Block block, Item.Settings settings, String name) {
        Identifier id = Identifier.of(MC_EXTENDED, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        return Registry.register(
                Registries.ITEM,
                key,
                new BlockItem(block, settings.registryKey(key))
        );
    }
    public static Item register(Block block, String name, Item.Settings settings) {
        Identifier id = Identifier.of(MC_EXTENDED, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        return Registry.register(
                Registries.ITEM,
                key,
                new BlockItem(block, settings.registryKey(key))
        );
    }

    public static Item registerWildCard(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(MC_EXTENDED, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        return Registry.register(
                Registries.ITEM,
                key,
                factory.apply(settings.registryKey(key))
        );
    }

    public static void GroupAll() {


        ItemGroupEvents.modifyEntriesEvent(MCExtended.MC_EXTENDED_GROUP)
                .register((itemGroup) -> itemGroup.addAfter(Items.AIR,
                        BRONZE_HELMET, BRONZE_CHESTPLATE, BRONZE_LEGGINGS,
                        BRONZE_BOOTS, BRONZE_HORSE_ARMOR, COPPER_HELMET,
                        COPPER_CHESTPLATE, COPPER_LEGGINGS, COPPER_BOOTS,
                        COPPER_HORSE_ARMOR, CORUNDUM_HELMET, CORUNDUM_CHESTPLATE,
                        CORUNDUM_LEGGINGS, CORUNDUM_BOOTS, CORUNDUM_HORSE_ARMOR,
                        COPPER_HORSE_ARMOR, RUBY_HELMET, RUBY_CHESTPLATE,
                        RUBY_LEGGINGS, RUBY_BOOTS, RUBY_HORSE_ARMOR,
                        SAPPHIRE_HELMET, SAPPHIRE_CHESTPLATE, SAPPHIRE_LEGGINGS,
                        SAPPHIRE_BOOTS, SAPPHIRE_HORSE_ARMOR,
                        SILVER_HELMET, SILVER_CHESTPLATE, SILVER_LEGGINGS,
                        SILVER_BOOTS, SILVER_HORSE_ARMOR, TIN_HELMET,
                        TIN_CHESTPLATE, TIN_LEGGINGS, TIN_BOOTS,
                        TIN_HORSE_ARMOR, BRONZE_AXE, BRONZE_HOE,
                        BRONZE_PICKAXE, BRONZE_SHOVEL, BRONZE_SWORD,
                        COPPER_AXE, COPPER_HOE, COPPER_PICKAXE, COPPER_SHOVEL,
                        COPPER_SWORD, CORUNDUM_AXE, CORUNDUM_HOE,
                        CORUNDUM_PICKAXE, CORUNDUM_SHOVEL, CORUNDUM_SWORD,
                        RUBY_AXE, RUBY_HOE, RUBY_PICKAXE, RUBY_SHOVEL,
                        RUBY_SWORD, SAPPHIRE_AXE, SAPPHIRE_HOE,
                        SAPPHIRE_PICKAXE, SAPPHIRE_SHOVEL, SAPPHIRE_SWORD,
                        SILVER_AXE, SILVER_HOE, SILVER_PICKAXE, SILVER_SHOVEL,
                        SILVER_SWORD, TIN_AXE, TIN_HOE, TIN_PICKAXE,
                        TIN_SHOVEL, TIN_SWORD,  BRONZE_INGOT, BRONZE_NUGGET,
                        BRONZE_BLOCK_ITEM, RAW_BRONZE_BLOCK_ITEM,
                        CORUNDUM, CORUNDUM_BLOCK_ITEM, RUBY,
                        RUBY_BLOCK_ITEM, RUBY_ORE_BLOCK_ITEM,
                        DEEPSLATE_RUBY_ORE_BLOCK_ITEM, SAPPHIRE,
                        SAPPHIRE_BLOCK_ITEM, SAPPHIRE_ORE_BLOCK_ITEM,
                        DEEPSLATE_SAPPHIRE_ORE_BLOCK_ITEM, SILVER_INGOT,
                        SILVER_NUGGET, RAW_SILVER, SILVER_BLOCK_ITEM,
                        RAW_SILVER_BLOCK_ITEM, SILVER_ORE_BLOCK_ITEM,
                        DEEPSLATE_SILVER_ORE_BLOCK_ITEM, TIN_INGOT,
                        TIN_NUGGET, RAW_TIN, TIN_BLOCK_ITEM,
                        RAW_TIN_BLOCK_ITEM, TIN_ORE_BLOCK_ITEM,
                        DEEPSLATE_TIN_ORE_BLOCK_ITEM, TOMATO_SEEDS,
                        TOMATO, ROAST_TOMATO, TOMATO_SAUCE,
                        ONION_TOMATO_SAUCE, WILD_ONION_ITEM, ONION,
                        FRIED_ONION, WILD_SPINACH_ITEM, SPINACH_SEEDS,
                        SPINACH, COOKED_SPINACH, SAAG,
                        WHITE_MUSHROOM_BLOCK_ITEM, WHITE_MUSHROOM_ITEM,
                        BACON_AND_MUSHROOMS, CHEESY_SAAG, CHEESE_ITEM,
                        TROUT, COOKED_TROUT, GEM_TABLE_ITEM,
                        BOTANY_TABLE_ITEM, LOST_SPAWN_EGG,
                        TROUT_FISH_SPAWN_EGG, SILVER_GOLEM_SPAWN_EGG,
                        ENDER_CUBE_SPAWN_EGG, TROUT_BUCKET,
                        CORUNDUM_UPGRADE_SMITHING_TEMPLATE, PLANT_SPECIMEN,
                        ENDER_CREAM
                ));

        // tin and bronze armor
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.CHAINMAIL_BOOTS,
                        TIN_HELMET, TIN_CHESTPLATE, TIN_LEGGINGS, TIN_BOOTS,
                        BRONZE_HELMET, BRONZE_CHESTPLATE, BRONZE_LEGGINGS, BRONZE_BOOTS));
        // copper and silver armor
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.IRON_BOOTS,
                        COPPER_HELMET, COPPER_CHESTPLATE, COPPER_LEGGINGS, COPPER_BOOTS,
                        SILVER_HELMET, SILVER_CHESTPLATE, SILVER_LEGGINGS, SILVER_BOOTS));
        // ruby and sapphire
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.DIAMOND_BOOTS,
                        RUBY_HELMET, RUBY_CHESTPLATE, RUBY_LEGGINGS, RUBY_BOOTS,
                        SAPPHIRE_HELMET, SAPPHIRE_CHESTPLATE, SAPPHIRE_LEGGINGS, SAPPHIRE_BOOTS));
        // corundum
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.NETHERITE_BOOTS,
                        CORUNDUM_HELMET, CORUNDUM_CHESTPLATE, CORUNDUM_LEGGINGS, CORUNDUM_BOOTS));
        // horse armors
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.DIAMOND_HORSE_ARMOR,
                        BRONZE_HORSE_ARMOR, TIN_HORSE_ARMOR, SILVER_HORSE_ARMOR, COPPER_HORSE_ARMOR,
                        RUBY_HORSE_ARMOR, SAPPHIRE_HORSE_ARMOR, CORUNDUM_HORSE_ARMOR));

        // tin and bronze swords
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.STONE_SWORD,
                        TIN_SWORD, BRONZE_SWORD));
        // copper and silver swords
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.IRON_SWORD,
                        COPPER_SWORD, SILVER_SWORD));
        // ruby and sapphire
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.DIAMOND_SWORD,
                        RUBY_SWORD, SAPPHIRE_SWORD));
        // corundum
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.NETHERITE_SWORD,
                        CORUNDUM_SWORD));

        // tin and bronze axes
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.STONE_AXE,
                        TIN_AXE, BRONZE_AXE));
        // copper and silver axes
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.IRON_AXE,
                        COPPER_AXE, SILVER_AXE));
        // ruby and sapphire
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.DIAMOND_AXE,
                        RUBY_AXE, SAPPHIRE_AXE));
        // corundum
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.NETHERITE_AXE,
                        CORUNDUM_AXE));

        // tin and bronze tools
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.addAfter(Items.STONE_HOE,
                        TIN_SHOVEL, TIN_PICKAXE, TIN_AXE, TIN_HOE,
                        BRONZE_SHOVEL, BRONZE_PICKAXE, BRONZE_AXE, BRONZE_HOE));
        // copper and silver tools
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.addAfter(Items.IRON_HOE,
                        COPPER_SHOVEL, COPPER_PICKAXE, COPPER_AXE, COPPER_HOE,
                        SILVER_SHOVEL, SILVER_PICKAXE, SILVER_AXE, SILVER_HOE));
        // ruby and sapphire
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.addAfter(Items.DIAMOND_HOE,
                        RUBY_SHOVEL, RUBY_PICKAXE, RUBY_AXE, RUBY_HOE,
                        SAPPHIRE_SHOVEL, SAPPHIRE_PICKAXE, SAPPHIRE_AXE, SAPPHIRE_HOE));
        // corundum
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.addAfter(Items.NETHERITE_HOE,
                        CORUNDUM_SHOVEL, CORUNDUM_PICKAXE, CORUNDUM_AXE, CORUNDUM_HOE));

        // raw tin and bronze
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.addAfter(Items.CHARCOAL,
                        RAW_TIN, RAW_BRONZE));
        // raw silver
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.addAfter(Items.RAW_COPPER,
                        RAW_SILVER));
        // ruby and sapphire
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.addAfter(Items.DIAMOND,
                        RUBY, SAPPHIRE, CORUNDUM));
        // tin, bronze, and silver nuggets
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.addAfter(Items.AMETHYST_SHARD,
                        TIN_NUGGET, BRONZE_NUGGET, SILVER_NUGGET));
        // tin and bronze ingots
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.addAfter(Items.GOLD_INGOT,
                        TIN_INGOT, BRONZE_INGOT));
        // silver ingot
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.addAfter(Items.COPPER_INGOT,
                        SILVER_INGOT));
        // tin and bronze blocks
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.addAfter(Items.COAL_BLOCK,
                        TIN_BLOCK_ITEM, BRONZE_BLOCK_ITEM));
        // silver block
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.addAfter(Items.CHAIN,
                        SILVER_BLOCK_ITEM));
        // ruby and sapphire blocks
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.addAfter(Items.DIAMOND_BLOCK,
                        RUBY_BLOCK_ITEM, SAPPHIRE_BLOCK_ITEM));
        // corundum block
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> itemGroup.addAfter(Items.NETHERITE_BLOCK,
                        CORUNDUM_BLOCK_ITEM));
        // tin ores
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> itemGroup.addAfter(Items.DEEPSLATE_COAL_ORE,
                        TIN_ORE_BLOCK_ITEM, DEEPSLATE_TIN_ORE_BLOCK_ITEM));
        // silver ores
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> itemGroup.addAfter(Items.DEEPSLATE_COPPER_ORE,
                        SILVER_ORE_BLOCK_ITEM, DEEPSLATE_SILVER_ORE_BLOCK_ITEM));
        // ruby and sapphire ores
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> itemGroup.addAfter(Items.DEEPSLATE_DIAMOND_ORE,
                        RUBY_ORE_BLOCK_ITEM, DEEPSLATE_RUBY_ORE_BLOCK_ITEM,
                        SAPPHIRE_ORE_BLOCK_ITEM, DEEPSLATE_SAPPHIRE_ORE_BLOCK_ITEM));
        // raw tin and bronze block
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> itemGroup.addAfter(Items.ANCIENT_DEBRIS,
                        RAW_TIN_BLOCK_ITEM, RAW_BRONZE_BLOCK_ITEM));
        // raw silver block
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> itemGroup.addAfter(Items.COPPER_ORE,
                        RAW_SILVER_BLOCK_ITEM));


        // trout
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.addAfter(Items.COOKED_SALMON,
                        TROUT, COOKED_TROUT));

        // bucket
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.addAfter(Items.SALMON_BUCKET,
                        TROUT_BUCKET));


        // corundum upgrade smithing template
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.addAfter(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE,
                        CORUNDUM_UPGRADE_SMITHING_TEMPLATE));


        // plant specimen
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.addAfter(Items.FLINT_AND_STEEL,
                        PLANT_SPECIMEN));

        // ender cream
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.addAfter(Items.SLIME_BALL,
                        ENDER_CREAM));

        // spawn eggs

        // trout fish
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
                .register((itemGroup) -> itemGroup.addAfter(Items.TROPICAL_FISH_SPAWN_EGG,
                        TROUT_FISH_SPAWN_EGG));

        // lost
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
                .register((itemGroup) -> itemGroup.addAfter(Items.LLAMA_SPAWN_EGG,
                        LOST_SPAWN_EGG));

        // silver golem
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
                .register((itemGroup) -> itemGroup.addAfter(Items.SILVERFISH_SPAWN_EGG,
                        SILVER_GOLEM_SPAWN_EGG));

        // ender cube
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
                .register((itemGroup) -> itemGroup.addAfter(Items.ELDER_GUARDIAN_SPAWN_EGG,
                        ENDER_CUBE_SPAWN_EGG));




        VillagerInteractionRegistries.registerCollectable(TOMATO);
        VillagerInteractionRegistries.registerCollectable(TOMATO_SEEDS);
        VillagerInteractionRegistries.registerFood(TOMATO, 3);
        CompostingChanceRegistry.INSTANCE.add(TOMATO, .3f);
        CompostingChanceRegistry.INSTANCE.add(TOMATO_SEEDS, .15f);

        VillagerInteractionRegistries.registerCollectable(SPINACH);
        VillagerInteractionRegistries.registerCollectable(SPINACH_SEEDS);
        VillagerInteractionRegistries.registerFood(SPINACH, 2);
        CompostingChanceRegistry.INSTANCE.add(SPINACH, .3f);
        CompostingChanceRegistry.INSTANCE.add(SPINACH_SEEDS, .15f);

        VillagerInteractionRegistries.registerCollectable(ONION);
        VillagerInteractionRegistries.registerFood(ONION, 3);
        CompostingChanceRegistry.INSTANCE.add(ONION, .3f);

    }

    public static class AnimalArmorItem {
        public static enum Type {
            CANINE,
            EQUESTRIAN,
        }
    }

}
