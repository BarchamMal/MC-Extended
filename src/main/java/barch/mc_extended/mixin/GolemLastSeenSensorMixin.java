package barch.mc_extended.mixin;

import barch.mc_extended.Registry.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.GolemLastSeenSensor;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;
import java.util.Optional;



@Mixin(GolemLastSeenSensor.class)
public abstract class GolemLastSeenSensorMixin {


   /**
    * @author BarchamMal
    * @reason To stop villagers from spawning virtually infinity/2 silver golems.
    */
   @Overwrite
   public void sense(ServerWorld world, LivingEntity entity) {
       senseSilverGolem(entity);
       senseIronGolem(entity);
   }

   @Shadow
   public static void senseIronGolem(LivingEntity entity) {
       GolemLastSeenSensor.senseIronGolem(entity);
   }

   @Shadow
   public static void rememberIronGolem(LivingEntity entity) {
       GolemLastSeenSensor.rememberIronGolem(entity);
   }


   private static void senseSilverGolem(LivingEntity entity) {
       Optional<List<LivingEntity>> optional = entity.getBrain().getOptionalRegisteredMemory(MemoryModuleType.MOBS);
       if (!optional.isEmpty()) {
           boolean bl = ((List)optional.get()).stream().anyMatch((seenEntity) -> {
               return ((Entity) seenEntity).getType().equals(ModEntities.SILVER_GOLEM);
           });
           if (bl) {
               rememberIronGolem(entity);
           }

       }
   }
}
