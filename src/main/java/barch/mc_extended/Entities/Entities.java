package barch.mc_extended.Entities;

import barch.mc_extended.Tags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


import static barch.mc_extended.MCExtended.*;

public class Entities {

    public static final Entities INSTANCE = new Entities();

    // lost entity and spawn egg
    public static final EntityType<LostEntity> LOST = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "lost"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LostEntity::new).dimensions(EntityDimensions.fixed(0.6f,1.99f)).build()
    );
    public static final Item LOST_SPAWN_EGG = new SpawnEggItem(LOST, 0x839f7D, 0x9f9f9f,  new FabricItemSettings());

    // trout_fish entity and spawn egg
    public static final EntityType<TroutFishEntity> TROUT_FISH = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "trout_fish"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TroutFishEntity::new).dimensions(EntityDimensions.fixed(.4f, .7f)).trackRangeBlocks(10).build()
    );
    public static final Item TROUT_FISH_SPAWN_EGG = new SpawnEggItem(TROUT_FISH, 0x835e50, 0xeac17c, new FabricItemSettings());

    public static void RegisterAll() {

        // lost entity
        FabricDefaultAttributeRegistry.register(LOST, LostEntity.createAbstractSkeletonAttributes());
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "lost_spawn_egg"), LOST_SPAWN_EGG);
        BiomeModifications.addSpawn(BiomeSelectors.tag(Tags.BiomeTags.LOSTS_SPAWN_IN), SpawnGroup.MONSTER, LOST, 80, 1, 4);

        // trout_fish entity
        FabricDefaultAttributeRegistry.register(TROUT_FISH, TroutFishEntity.createFishAttributes());
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "trout_fish_spawn_egg"), TROUT_FISH_SPAWN_EGG);
        BiomeModifications.addSpawn(BiomeSelectors.spawnsOneOf(EntityType.SALMON), SpawnGroup.WATER_AMBIENT, TROUT_FISH, 5, 1, 5);

        GroupAll();

    }

    public static void GroupAll() {


        // lost spawn egg
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(LOST_SPAWN_EGG);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> {
            content.addAfter(Items.STRAY_SPAWN_EGG, LOST_SPAWN_EGG);
        });

        // trout fish spawn egg
        ItemGroupEvents.modifyEntriesEvent(MC_EXTENDED_GROUP).register(content -> {
            content.add(TROUT_FISH_SPAWN_EGG);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> {
            content.addAfter(Items.SALMON_SPAWN_EGG, TROUT_FISH_SPAWN_EGG);
        });

    }
}
