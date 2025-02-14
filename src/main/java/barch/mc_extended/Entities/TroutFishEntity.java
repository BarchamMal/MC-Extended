package barch.mc_extended.Entities;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.function.ValueLists;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;

import static barch.mc_extended.Registry.ModItems.TROUT_BUCKET;


public class TroutFishEntity extends SchoolingFishEntity implements VariantHolder<TroutFishEntity.Variant> {

    private static final String TYPE_KEY = "type";
    private static final TrackedData<Integer> VARIANT;
    public TroutFishEntity(EntityType<? extends TroutFishEntity> entityType, World world) {
        super(entityType, world);
        this.calculateDimensions();
    }
    
    public int getMaxGroupSize() {
        return 5;
    }
    public ItemStack getBucketItem() {
        return new ItemStack(TROUT_BUCKET);
    }
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SALMON_AMBIENT;
    }
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SALMON_DEATH;
    }
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SALMON_HURT;
    }
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_SALMON_FLOP;
    }
    
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(VARIANT, Variant.MEDIUM.getIndex());
    }

    public void onTrackedDataSet(TrackedData<?> data) {
        super.onTrackedDataSet(data);
        if (VARIANT.equals(data)) {
            this.calculateDimensions();
        }

    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putString("type", this.getVariant().asString());
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setVariant(Variant.byId(nbt.getString("type")));
    }

    public void copyDataToStack(ItemStack stack) {
        Bucketable.copyDataToStack(this, stack);
        NbtComponent.set(DataComponentTypes.BUCKET_ENTITY_DATA, stack, (nbt) -> {
            nbt.putString("type", this.getVariant().asString());
        });
    }

    public void copyDataFromNbt(NbtCompound nbt) {
        Bucketable.copyDataFromNbt(this, nbt);
        this.setVariant(Variant.byId(nbt.getString("type")));
    }

    public void setVariant(Variant variant) {
        this.dataTracker.set(VARIANT, variant.index);
    }

    public Variant getVariant() {
        return (Variant) Variant.FROM_INDEX.apply((Integer)this.dataTracker.get(VARIANT));
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        DataPool.Builder<Variant> builder = DataPool.builder();
        builder.add(Variant.SMALL, 30);
        builder.add(Variant.MEDIUM, 50);
        builder.add(Variant.LARGE, 15);
        builder.build().getDataOrEmpty(this.random).ifPresent(this::setVariant);
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    public float getVariantScale() {
        return this.getVariant().scale;
    }

    protected EntityDimensions getBaseDimensions(EntityPose pose) {
        return super.getBaseDimensions(pose).scaled(this.getVariantScale());
    }

    static {
        VARIANT = DataTracker.registerData(TroutFishEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }

    public static enum Variant implements StringIdentifiable {
        SMALL("small", 0, 0.5F),
        MEDIUM("medium", 1, 1.0F),
        LARGE("large", 2, 1.5F);

        public static final StringIdentifiable.EnumCodec<Variant> CODEC = StringIdentifiable.createCodec(Variant::values);
        static final IntFunction<Variant> FROM_INDEX = ValueLists.createIdToValueFunction(Variant::getIndex, values(), ValueLists.OutOfBoundsHandling.CLAMP);
        private final String id;
        final int index;
        final float scale;

        private Variant(final String id, final int index, final float scale) {
            this.id = id;
            this.index = index;
            this.scale = scale;
        }

        public String asString() {
            return this.id;
        }

        int getIndex() {
            return this.index;
        }

        static Variant byId(String id) {
            return (Variant)CODEC.byId(id, MEDIUM);
        }
    }
}
