package com.reetam.gatorlab.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class RuneBlock extends Block {

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public RuneBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, false));
    }
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> container) {
        container.add(POWERED);
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        world.setBlock(pos, state.cycle(POWERED), 19);
        return ActionResultType.SUCCESS;
    }
}
