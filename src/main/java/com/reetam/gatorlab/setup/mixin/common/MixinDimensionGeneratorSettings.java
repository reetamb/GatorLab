package com.reetam.gatorlab.setup.mixin.common;

import com.reetam.gatorlab.world.SeedHolder;

import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(DimensionGeneratorSettings.class)
public class MixinDimensionGeneratorSettings {
    /**
     * World seed for worldgen when not specified by JSON by Haven King
     * https://github.com/Hephaestus-Dev/seedy-behavior/blob/master/src/main/java/dev/hephaestus/seedy/mixin/world/gen/GeneratorOptionsMixin.java
     */

    @Inject(method = "<init>(JZZLnet/minecraft/util/registry/SimpleRegistry;Ljava/util/Optional;)V",
            at = @At(value = "RETURN"))
    private void gatorlabRequestRandomSeed(long seed, boolean generateFeatures, boolean bonusChest, SimpleRegistry<Dimension> registry, Optional<String> s, CallbackInfo ci) {
        SeedHolder.setSeed(seed);
    }
}
