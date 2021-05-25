package com.reetam.gatorlab.world.biome.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.reetam.gatorlab.GatorLab;
import com.reetam.gatorlab.world.SeedHolder;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.ZoomLayer;

import javax.annotation.Nonnull;
import java.util.function.LongFunction;

public class LabNetherBiomeProvider extends BiomeProvider {

    public static void registerBiomeProvider() {
        Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(GatorLab.MODID, "biome_provider"), MOD_NETHER_CODEC);
    }

    public static final Codec<LabNetherBiomeProvider> MOD_NETHER_CODEC =
            RecordCodecBuilder.create((instance) -> instance.group(
                    Codec.LONG.fieldOf("seed").orElseGet(SeedHolder::getSeed).forGetter((biomeSource) -> biomeSource.seed),
                    RegistryLookupCodec.create(Registry.BIOME_REGISTRY).forGetter((biomeProvider) -> biomeProvider.biomeRegistry),
                    Codec.intRange(1, 20).fieldOf("biome_size").orElse(1).forGetter((biomeSource) -> biomeSource.biomeSize))
                    .apply(instance, LabNetherBiomeProvider::new) );

    public final long seed;
    private final int biomeSize;
    private final Layer biomeLayer;
    protected final Registry<Biome> biomeRegistry;

    public LabNetherBiomeProvider(long seed, Registry<Biome> biomeRegistry, int size) {
        super(LabNetherBiomeCollector.netherBiomeCollection(biomeRegistry).stream().map((registryKey) -> () -> (Biome)biomeRegistry.get(registryKey)));

        this.seed = seed;
        this.biomeLayer = buildWorldProcedure(seed, size, biomeRegistry);
        this.biomeRegistry = biomeRegistry;
        this.biomeSize = size;
    }

    public static Layer buildWorldProcedure(long seed, int biomeSize, Registry<Biome> biomeRegistry) {
        IAreaFactory<LazyArea> layerFactory = build((salt) -> new LazyAreaLayerContext(25, seed, salt),
                biomeSize,
                seed,
                biomeRegistry);
        return new Layer(layerFactory);
    }

    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> build(LongFunction<C> contextFactory, int biomeSize, long seed, Registry<Biome> biomeRegistry) {
        IAreaFactory<T> layerFactory = (new LabNetherMasterLayer(seed, biomeRegistry)).run(contextFactory.apply(200L));

        for (int currentExtraZoom = 0; currentExtraZoom < biomeSize; currentExtraZoom++) {
            if ((currentExtraZoom + 2) % 3 != 0) {
                layerFactory = ZoomLayer.NORMAL.run(contextFactory.apply(2001L + currentExtraZoom), layerFactory);
            } else {
                layerFactory = ZoomLayer.FUZZY.run(contextFactory.apply(2000L + (currentExtraZoom * 31)), layerFactory);
            }
        }

        return layerFactory;
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        int k = (this.biomeLayer).area.get(x, z);
        Biome biome = this.biomeRegistry.byId(k);
        if (biome == null) {
            //fallback to builtin registry if dynamic registry doesnt have biome
            if (SharedConstants.IS_RUNNING_IN_IDE) {
                throw Util.pauseInIde(new IllegalStateException("Unknown biome id: " + k));
            } else {
                return this.biomeRegistry.get(BiomeRegistry.byId(0));
            }
        } else {
            return biome;
        }
    }

    @Nonnull
    @Override
    protected Codec<? extends BiomeProvider> codec() {
        return MOD_NETHER_CODEC;
    }

    @Nonnull
    @Override
    public BiomeProvider withSeed(long seed) {
        return new LabNetherBiomeProvider(seed, this.biomeRegistry, this.biomeSize);
    }
}
