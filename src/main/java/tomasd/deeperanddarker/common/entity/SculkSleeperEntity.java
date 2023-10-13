package tomasd.deeperanddarker.common.entity;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class SculkSleeperEntity extends HostileEntity {
	private static final int EVENT_LISTENER_RANGE = 16;
	private static final TrackedData<Boolean> IS_AWAKE = DataTracker.registerData(SculkSleeperEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	private static final TrackedData<Integer> WAKE_TIMER = DataTracker.registerData(SculkSleeperEntity.class, TrackedDataHandlerRegistry.INTEGER);
	private static final TrackedData<Integer> ANGER = DataTracker.registerData(SculkSleeperEntity.class, TrackedDataHandlerRegistry.INTEGER);
	protected SculkSleeperEntity(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initEquipment(RandomGenerator random, LocalDifficulty difficulty) {
		super.initEquipment(random, difficulty);
		if (random.nextFloat() < (this.world.getDifficulty() == Difficulty.HARD ? 0.05F : 0.01F)) {
			int i = random.nextInt(3);
			if (i == 0) {
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
			} else {
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
			}
		}
	}

	public static DefaultAttributeContainer.Builder createSleeperAttributes(){
		return HostileEntity.createHostileAttributes()
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1f)
			.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1f)
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32f)
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
			.add(EntityAttributes.GENERIC_ATTACK_SPEED, 1f);
	}

	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityTag){
		initEquipment(this.random, difficulty);

		return super.initialize(world, difficulty, spawnReason, entityData, entityTag);
	}

	@Override
	protected void initDataTracker(){
		super.initDataTracker();

		this.dataTracker.startTracking(IS_AWAKE, false);
		this.dataTracker.startTracking(WAKE_TIMER, 0);
	}
}
