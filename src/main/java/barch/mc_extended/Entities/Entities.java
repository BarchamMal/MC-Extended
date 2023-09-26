package barch.mc_extended.Entities;

import barch.mc_extended.Glue.ItemGrouper;
import barch.mc_extended.Glue.ItemGrouped;
import barch.mc_extended.Tags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
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

    public static final EntityType<LostEntity> LOST = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "lost"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LostEntity::new).dimensions(EntityDimensions.fixed(0.6f,1.99f)).build()
    );
    public static final EntityType<TroutFishEntity> TROUT_FISH = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "trout_fish"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TroutFishEntity::new).dimensions(EntityDimensions.fixed(.7f, .4f)).trackRangeBlocks(10).build()
    );
    public static final EntityType<SilverGolemEntity> SILVER_GOLEM = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "silver_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SilverGolemEntity::new).dimensions(EntityDimensions.fixed(1.5f, 1.8f)).trackRangeBlocks(10).build()
    );
    public static final EntityType<EnderCubeEntity> ENDER_CUBE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "ender_cube"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EnderCubeEntity::new).dimensions(EntityDimensions.changing(2.04f,2.04f)).trackRangeBlocks(10).build()
    );

    public static final Item LOST_SPAWN_EGG = new SpawnEggItem(LOST, 0x839f7D, 0x9f9f9f,  new FabricItemSettings());
    public static final Item TROUT_FISH_SPAWN_EGG = new SpawnEggItem(TROUT_FISH, 0x835e50, 0xeac17c, new FabricItemSettings());
    public static final Item SILVER_GOLEM_SPAWN_EGG = new SpawnEggItem(SILVER_GOLEM, 0xd0d0fa, 0x7c7da2, new FabricItemSettings());
    public static final Item ENDER_CUBE_SPAWN_EGG = new SpawnEggItem(ENDER_CUBE, 0x3b2754, 0xf6fabd, new FabricItemSettings());

    public static void RegisterAll() {

        FabricDefaultAttributeRegistry.register(LOST, LostEntity.createAbstractSkeletonAttributes());
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "lost_spawn_egg"), LOST_SPAWN_EGG);
        BiomeModifications.addSpawn(BiomeSelectors.tag(Tags.BiomeTags.LOSTS_SPAWN_IN), SpawnGroup.MONSTER, LOST, 80, 1, 4);

        FabricDefaultAttributeRegistry.register(TROUT_FISH, TroutFishEntity.createFishAttributes());
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "trout_fish_spawn_egg"), TROUT_FISH_SPAWN_EGG);
        BiomeModifications.addSpawn(BiomeSelectors.spawnsOneOf(EntityType.SALMON), SpawnGroup.WATER_AMBIENT, TROUT_FISH, 1, 1, 5);

        FabricDefaultAttributeRegistry.register(SILVER_GOLEM, SilverGolemEntity.createSilverGolemAttributes());
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "silver_golem_spawn_egg"), SILVER_GOLEM_SPAWN_EGG);

        FabricDefaultAttributeRegistry.register(ENDER_CUBE, SilverGolemEntity.createSilverGolemAttributes());
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ender_cube_spawn_egg"), ENDER_CUBE_SPAWN_EGG);
        BiomeModifications.addSpawn(BiomeSelectors.foundInTheEnd(), SpawnGroup.MONSTER, ENDER_CUBE, 10, 1, 3);

        GroupAll();

    }

    public static void GroupAll() {

        ItemGrouper.GroupItem(ENDER_CUBE_SPAWN_EGG, new ItemGrouped[]{new ItemGrouped(ItemGroups.SPAWN_EGGS, Items.ELDER_GUARDIAN_SPAWN_EGG)});
        ItemGrouper.GroupItem(LOST_SPAWN_EGG, new ItemGrouped[]{new ItemGrouped(ItemGroups.SPAWN_EGGS, Items.LLAMA_SPAWN_EGG)});
        ItemGrouper.GroupItem(SILVER_GOLEM_SPAWN_EGG, new ItemGrouped[]{new ItemGrouped(ItemGroups.SPAWN_EGGS, Items.SILVERFISH_SPAWN_EGG)});
        ItemGrouper.GroupItem(TROUT_FISH_SPAWN_EGG, new ItemGrouped[]{new ItemGrouped(ItemGroups.SPAWN_EGGS, Items.TROPICAL_FISH_SPAWN_EGG)});

    }
}
