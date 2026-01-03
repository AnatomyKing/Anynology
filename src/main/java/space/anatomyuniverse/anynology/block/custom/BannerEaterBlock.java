package space.anatomyuniverse.anynology.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;

public class BannerEaterBlock extends Block {

    public static final Property<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final EnumProperty<EaterState> EATER_STATE =
            EnumProperty.create("eater_state", EaterState.class);

    public BannerEaterBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(EATER_STATE, EaterState.CLOSED));
    }

    public enum EaterState implements StringRepresentable {
        CLOSED("closed"),
        OPEN("open");

        private final String name;

        EaterState(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return name;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, EATER_STATE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState()
                .setValue(FACING, ctx.getHorizontalDirection().getOpposite())
                .setValue(EATER_STATE, EaterState.CLOSED);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        level.setBlock(pos, state.cycle(EATER_STATE), Block.UPDATE_ALL);
        return InteractionResult.CONSUME;
    }


    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        // Avoid deprecated state.rotate(...) — compute the new facing directly.
        Direction dir = state.getValue(FACING);
        Rotation rot = mirror.getRotation(dir);
        return state.setValue(FACING, rot.rotate(dir));
    }
}
