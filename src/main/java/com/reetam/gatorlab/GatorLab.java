package com.reetam.gatorlab;

import com.reetam.gatorlab.datagen.LabBlockData;
import com.reetam.gatorlab.datagen.LabItemData;
import com.reetam.gatorlab.datagen.LabLang;
import com.reetam.gatorlab.registry.LabBlocks;
import com.reetam.gatorlab.registry.LabEntities;
import com.reetam.gatorlab.registry.LabItems;
import com.reetam.gatorlab.registry.LabTileEntities;
import com.reetam.gatorlab.setup.LabClient;
import com.reetam.gatorlab.setup.LabCommon;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("gatorlab")
public class GatorLab {

    public static final String MODID = "gatorlab";

    public GatorLab() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::gatherData);

        LabBlocks.BLOCKS.register(bus);
        LabEntities.ENTITIES.register(bus);
        LabItems.ITEMS.register(bus);
        LabTileEntities.TILE_ENTITIES.register(bus);
    }

    public void commonSetup(FMLCommonSetupEvent event) {
        LabCommon.register();
    }

    public void clientSetup(FMLClientSetupEvent event) {
        LabClient.register();
    }

    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeClient()) {
            generator.addProvider(new LabBlockData(generator, helper));
            generator.addProvider(new LabItemData(generator, helper));
            generator.addProvider(new LabLang(generator));
        }
    }
}
