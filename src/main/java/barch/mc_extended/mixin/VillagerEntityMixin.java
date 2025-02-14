package barch.mc_extended.mixin;


import barch.mc_extended.Registry.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LargeEntitySpawnHelper;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.brain.sensor.GolemLastSeenSensor;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(VillagerEntity.class)
public abstract class VillagerEntityMixin extends Entity {


    public VillagerEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    // Shadow the target methods from VillagerEntity (or its superclass)
    @Shadow
    protected abstract boolean canSummonGolem(long time);


    /**
     * @author
     * @reason
     */
    @Overwrite
    public void summonGolem(ServerWorld world, long time, int requiredCount) {
        if (this.canSummonGolem(time)) {
            Box box = this.getBoundingBox().expand(10.0, 10.0, 10.0);
            List<VillagerEntity> list = world.getNonSpectatingEntities(VillagerEntity.class, box);
            List<VillagerEntity> list2 = list.stream().filter((villager) -> {
                return villager.canSummonGolem(time);
            }).limit(5L).toList();
            if (list2.size() >= requiredCount) {
                EntityType entity = ModEntities.SILVER_GOLEM;
                if (world.random.nextBetween(0,1) == 1) {
                    entity = EntityType.IRON_GOLEM;
                }

                if (!LargeEntitySpawnHelper.trySpawnAt(entity, SpawnReason.MOB_SUMMONED, world, this.getBlockPos(), 10, 8, 6, LargeEntitySpawnHelper.Requirements.IRON_GOLEM, false).isEmpty()) {
                    list.forEach(GolemLastSeenSensor::rememberIronGolem);
                }
            }
        }
    }

}
