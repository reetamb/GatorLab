package com.reetam.gatorlab.datagen;

import com.reetam.gatorlab.datagen.provider.LabItemProvider;
import com.reetam.gatorlab.registry.LabBlocks;
import com.reetam.gatorlab.registry.LabItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class LabItemData extends LabItemProvider {

    public LabItemData(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper);
    }

    @Override
    public String getName() {
        return "Lab Item Models";
    }

    @Override
    protected void registerModels() {
        itemBlockFlat(LabBlocks.BRANCHES);
        itemBlock(LabBlocks.SCUTE_BLOCK);
        itemBlock(LabBlocks.WEATHER_DETECTOR);
        itemBlockFlat(LabBlocks.REDLIGHT_RUNE);
        normalItem(LabItems.BLAST_BOMB);
        egg(LabItems.ALLIGATOR_SPAWN_EGG);
    }
}
