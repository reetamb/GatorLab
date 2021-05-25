package com.reetam.gatorlab.world.biome.util;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public class LabNetherMasterLayer implements IAreaTransformer0 {

    private final Registry<Biome> dynamicRegistry;

    public LabNetherMasterLayer(long seed, Registry<Biome> dynamicRegistry){
        this.dynamicRegistry = dynamicRegistry;
    }

    @Override
    public int applyPixel(INoiseRandom context, int x, int y) {
        return LabNetherBiomeCollector.getRandomNetherBiomes(context);
    }
}
