package com.reetam.gatorlab.datagen;

import com.reetam.gatorlab.datagen.provider.LabBlockProvider;
import com.reetam.gatorlab.registry.LabBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class LabBlockData extends LabBlockProvider {

    public LabBlockData(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper);
    }

    @Override
    public String getName() {
        return "Lab Block States and Models";
    }

    @Override
    protected void registerStatesAndModels() {
        crossBlock(LabBlocks.BRANCHES);
        block(LabBlocks.SCUTE_BLOCK);
        powerableCarpetBlock(LabBlocks.REDLIGHT_RUNE);
    }
}
