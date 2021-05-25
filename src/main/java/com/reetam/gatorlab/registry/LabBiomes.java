package com.reetam.gatorlab.registry;

import com.reetam.gatorlab.GatorLab;
import com.reetam.gatorlab.world.biome.biomes.PerniciousGardensBiome;
import com.reetam.gatorlab.world.biome.surfacebuilders.PerniciousGardensSurfaceBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LabBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, GatorLab.MODID);

    public static final RegistryObject<Biome> PERNICIOUS_GARDENS = BIOMES.register("pernicious_gardens", () -> new PerniciousGardensBiome().build());

    //public static class LabSurfaceBuilders {
        public static final SurfaceBuilder<SurfaceBuilderConfig> PERNICIOUS_GARDENS_SURFACE_BUILDER = surfaceBuilder("pernicious_gardens", new PerniciousGardensSurfaceBuilder(SurfaceBuilderConfig.CODEC));

        public static final SurfaceBuilderConfig PERNICIOUS_GARDENS_CONFIG = new SurfaceBuilderConfig(
                Blocks.PURPLE_CONCRETE_POWDER.defaultBlockState(),
                Blocks.CRYING_OBSIDIAN.defaultBlockState(),
                Blocks.OBSIDIAN.defaultBlockState()
        );

        public static SurfaceBuilder<SurfaceBuilderConfig> surfaceBuilder(String name, SurfaceBuilder<SurfaceBuilderConfig> builder) {
            builder.setRegistryName(new ResourceLocation(GatorLab.MODID, name));
            ForgeRegistries.SURFACE_BUILDERS.register(builder);
            return builder;
        }
    //}
}
