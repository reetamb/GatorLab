package com.reetam.gatorlab.world.biome.biomes;

import com.reetam.gatorlab.registry.LabBiomes;
import com.reetam.gatorlab.world.biome.LabBiome;
import com.reetam.gatorlab.world.biome.util.LabBiomeHelper;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

public class PerniciousGardensBiome extends LabBiome {
    @Override
    protected Biome.Category configureCategory() {
        return Biome.Category.NETHER;
    }

    @Override
    protected float configureDepth() {
        return 0.1F;
    }

    @Override
    protected float configureScale() {
        return 0.5F;
    }

    @Override
    protected void configureAmbience(BiomeAmbience.Builder ambience) {
        ambience
                .waterColor(13408563)
                .waterFogColor(10053120)
                .fogColor(29165680)
                .skyColor(LabBiomeHelper.calcSkyColor(2.0f))
                .ambientParticle(new ParticleEffectAmbience(ParticleTypes.PORTAL, 0.118093334F))
                .ambientLoopSound(SoundEvents.AMBIENT_CAVE)
                .ambientParticle(new ParticleEffectAmbience(ParticleTypes.PORTAL, 0.005F));
    }

    @Override
    protected Biome.Climate configureClimate() {
        return new Biome.Climate(Biome.RainType.RAIN, 2.0f, Biome.TemperatureModifier.NONE, 0.0f);
    }

    @Override
    protected ConfiguredSurfaceBuilder<?> configureSurfaceBuilder() {
        return LabBiomeHelper.newConfiguredSurfaceBuilder("pernicious_gardens", new ConfiguredSurfaceBuilder(LabBiomes.PERNICIOUS_GARDENS_SURFACE_BUILDER, LabBiomes.PERNICIOUS_GARDENS_CONFIG));
    }

    @Override
    protected void configureGeneration(BiomeGenerationSettings.Builder generation) {
        generation.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.CRIMSON_FOREST_VEGETATION);
    }

    @Override
    protected void configureSpawns(MobSpawnInfo.Builder spawns) {
        spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.ENDERMITE, 60, 1, 2));
    }
}
