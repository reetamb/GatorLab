package com.reetam.gatorlab.world.biome.surfacebuilders;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockStateProvider;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.OctavesNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class PerniciousGardensSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    private static final BlockState AIR = Blocks.CAVE_AIR.defaultBlockState();
    protected long seed;
    private OctavesNoiseGenerator decorationNoise;

    public PerniciousGardensSurfaceBuilder(Codec<SurfaceBuilderConfig> p_i232131_1_) {
        super(p_i232131_1_);
    }

    public void apply(Random rand, IChunk chunk, Biome biome, int x, int z, int terrainHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        int x1 = x & 15;
        int z1 = z & 15;
        int middleBlockExtraDepth = (int)(noise / 3.0D + 3.0D + rand.nextDouble() * 0.25D); // this is random
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        int depth = -1;
        BlockState soil = config.getUnderMaterial();
        BlockState stone = config.getUnderwaterMaterial();

        for(int y = 127; y >= 0; --y) {
            blockpos$mutable.set(x1, y, z1); // move block down
            BlockState grassOrFluid = config.getTopMaterial();
            BlockState detectedBlock = chunk.getBlockState(blockpos$mutable);
            if (detectedBlock.isAir()) { // depth = -1 when the last check showed air
                depth = -1;
            } else if (detectedBlock.is(defaultBlock.getBlock())) { // touching solid block
                chunk.setBlockState(blockpos$mutable, stone, false); // before anything is checked, put stone
                if (depth == -1) { // transitioning from air to solid block
                    boolean willPlaceFluid = false;
                    if (middleBlockExtraDepth <= 0) {  // if this is true, then we are going to place a fluid
                        willPlaceFluid = true;
                        soil = config.getUnderMaterial();
                    }

                    if (y < seaLevel && willPlaceFluid) { // if under sea level and plan to place a solid block, switch to a fluid instead
                        grassOrFluid = defaultFluid;
                    }

                    depth = middleBlockExtraDepth;
                    if (y >= seaLevel - 1) { // puts grass because at top layer
                        chunk.setBlockState(blockpos$mutable, grassOrFluid, false);
                    } else { // put stone under sea level
                        chunk.setBlockState(blockpos$mutable, stone, false);
                    }
                } else if (depth > 0) { // underneath top layer so put soil
                    --depth;
                    chunk.setBlockState(blockpos$mutable, soil, false);
                }
            }
        }

    }

    public void initNoise(long p_205548_1_) {
        if (this.seed != p_205548_1_ || this.decorationNoise == null) {
            this.decorationNoise = new OctavesNoiseGenerator(new SharedSeedRandom(p_205548_1_), ImmutableList.of(0));
        }

        this.seed = p_205548_1_;
    }
}