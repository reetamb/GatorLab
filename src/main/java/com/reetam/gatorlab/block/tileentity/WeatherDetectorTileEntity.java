package com.reetam.gatorlab.block.tileentity;

import com.reetam.gatorlab.block.WeatherDetectorBlock;
import com.reetam.gatorlab.registry.LabTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class WeatherDetectorTileEntity extends TileEntity implements ITickableTileEntity {
    public WeatherDetectorTileEntity() {
        super(LabTileEntities.WEATHER_DETECTOR.get());
    }

    public void tick() {
        if (this.level != null && !this.level.isClientSide && this.level.getGameTime() % 20L == 0L) {
            BlockState blockstate = this.getBlockState();
            Block block = blockstate.getBlock();
            if (block instanceof WeatherDetectorBlock) {
                WeatherDetectorBlock.updateSignalStrength(blockstate, this.level, this.worldPosition);
            }
        }

    }
}
