package tomasd.deeperanddarker.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class WailingPotShort extends Block{
	private static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
	private static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
	private static final VoxelShape BLOCK_BODY_SHAPE = Block.createCuboidShape(2.0,0.0,2.0,14.0,12.0,14.0);
	private static final VoxelShape BLOCK_TOP_SHAPE = Block.createCuboidShape(4.0,12.0,4.0,12.0,15.0,12.0);
	private static final VoxelShape BLOCK_SHAPE_FINAL = VoxelShapes.union(BLOCK_BODY_SHAPE, BLOCK_TOP_SHAPE);

	public WailingPotShort(Settings settings) {
		super(settings);
		this.setDefaultState(
			this.stateManager.getDefaultState()
				.with(FACING, Direction.NORTH)
				.with(WATERLOGGED, Boolean.valueOf(false))
		);
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
		return this.getDefaultState()
			.with(FACING, ctx.getPlayerFacing())
			.with(WATERLOGGED, Boolean.valueOf(fluidState.getFluid() == Fluids.WATER));
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return BLOCK_SHAPE_FINAL;
	}

//	@Nullable
//	@Override
//	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
//		return new DecoratedPotBlockEntity(pos, state);
//	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public void onBroken(WorldAccess world, BlockPos pos, BlockState state){

	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {

	}
}
