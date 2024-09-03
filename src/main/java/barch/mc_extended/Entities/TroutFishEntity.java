package barch.mc_extended.Entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.SalmonEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

import static barch.mc_extended.Misc.FishBuckets.TROUT_BUCKET;


public class TroutFishEntity extends SchoolingFishEntity {
    public TroutFishEntity(EntityType<? extends TroutFishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public int getMaxGroupSize() {
        return 500;
    }

    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(TROUT_BUCKET);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SALMON_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SALMON_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SALMON_HURT;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_SALMON_FLOP;
    }
}