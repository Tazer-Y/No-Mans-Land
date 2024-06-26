package com.farcr.nomansland.core.content.block;

import com.farcr.nomansland.core.content.blockentity.NMLSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class WallSignBlock extends net.minecraft.world.level.block.WallSignBlock {
    public WallSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState){
        return new NMLSignBlockEntity(pPos, pState);
    }
}
