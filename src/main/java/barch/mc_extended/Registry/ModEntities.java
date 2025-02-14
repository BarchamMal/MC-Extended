package barch.mc_extended.Registry;

import barch.mc_extended.Entities.EnderCubeEntity;
import barch.mc_extended.Entities.LostEntity;
import barch.mc_extended.Entities.SilverGolemEntity;
import barch.mc_extended.Entities.TroutFishEntity;
import barch.mc_extended.Tags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.entity.EntityType.Builder;

import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class ModEntities {

    public static final EntityType LOST = register("lost", EntityType.Builder.create(LostEntity::new, SpawnGroup.MONSTER).dimensions(.6f, 1.99f));
    public static final EntityType<TroutFishEntity> TROUT_FISH = register("trout_fish", EntityType.Builder.create(TroutFishEntity::new, SpawnGroup.CREATURE).dimensions(.7f, .4f).eyeHeight(.26f).maxTrackingRange(4));
    public static final EntityType<SilverGolemEntity> SILVER_GOLEM = register("silver_golem", EntityType.Builder.create(SilverGolemEntity::new, SpawnGroup.CREATURE).dimensions(1.5f, 1.8f).maxTrackingRange(10));
    public static final EntityType<EnderCubeEntity> ENDER_CUBE = register("ender_cube", EntityType.Builder.create(EnderCubeEntity::new, SpawnGroup.MONSTER).dimensions(.5f,.5f).maxTrackingRange(10));

    public static <M extends Entity> EntityType<M> register(String name, Builder<M> type) {
        Identifier id = Identifier.of(MC_EXTENDED, name);
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, id);

        return Registry.register(Registries.ENTITY_TYPE, key, type.build(key));
    }

    public static void doSomething() {

        FabricDefaultAttributeRegistry.register(LOST, LostEntity.createAbstractSkeletonAttributes());
        FabricDefaultAttributeRegistry.register(TROUT_FISH, TroutFishEntity.createFishAttributes());
        FabricDefaultAttributeRegistry.register(SILVER_GOLEM, SilverGolemEntity.createSilverGolemAttributes());
        FabricDefaultAttributeRegistry.register(ENDER_CUBE, EnderCubeEntity.createEnderCubeAttributes());

        BiomeModifications.addSpawn(BiomeSelectors.foundInTheEnd(), SpawnGroup.MONSTER, ENDER_CUBE, 10, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.tag(Tags.BiomeTags.LOSTS_SPAWN_IN), SpawnGroup.MONSTER, LOST, 80, 1, 4);

    }

}
