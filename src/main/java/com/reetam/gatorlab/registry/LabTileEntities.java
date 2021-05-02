package com.reetam.gatorlab.registry;

import com.google.common.collect.Sets;
import com.reetam.gatorlab.GatorLab;
import com.reetam.gatorlab.block.tileentity.WeatherDetectorTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LabTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, GatorLab.MODID);

    public static final RegistryObject<TileEntityType<WeatherDetectorTileEntity>> WEATHER_DETECTOR = TILE_ENTITIES.register("weather_detector", () ->
            new TileEntityType<>(WeatherDetectorTileEntity::new, Sets.newHashSet(LabBlocks.WEATHER_DETECTOR.get()), null));
}
