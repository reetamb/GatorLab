package com.reetam.gatorlab.world.biome.nether;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

public abstract class LabBiome {

    protected abstract Biome.Category configureCategory();

    protected abstract float configureDepth();

    protected abstract float configureScale();

    protected abstract void configureAmbience(BiomeAmbience.Builder ambience);

    protected abstract Biome.Climate configureClimate();

    protected abstract ConfiguredSurfaceBuilder<?> configureSurfaceBuilder();

    protected abstract void configureGeneration(BiomeGenerationSettings.Builder generation);

    protected abstract void configureSpawns(MobSpawnInfo.Builder spawns);

    public final Biome build() {

        Biome.Builder builder = new Biome.Builder();

        builder.biomeCategory(this.configureCategory());
        builder.depth(this.configureDepth());
        builder.scale(this.configureScale());

        // Configure biome ambience
        BiomeAmbience.Builder ambience = new BiomeAmbience.Builder();
        this.configureAmbience(ambience);
        builder.specialEffects(ambience.build());

        // Configure biome climate
        Biome.Climate climate = configureClimate();
        builder.precipitation(climate.precipitation);
        builder.temperature(climate.temperature);
        builder.temperatureAdjustment(climate.temperatureModifier);
        builder.downfall(climate.downfall);

        // Configure biome generation settings
        BiomeGenerationSettings.Builder generation = new BiomeGenerationSettings.Builder();
        this.configureGeneration(generation);
        generation.surfaceBuilder(this.configureSurfaceBuilder());
        builder.generationSettings(generation.build());

        // Configure biome mob spawn settings
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder();
        this.configureSpawns(spawns);
        builder.mobSpawnSettings(spawns.build());

        return builder.build();
    }
}