Stream.of(
Block.box(0, 3, 7, 2, 7, 9),
Block.box(2, 0, 2, 14, 10, 14),
Block.box(4, 10, 4, 12, 12, 12),
Block.box(14, 3, 7, 16, 7, 9)
).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();