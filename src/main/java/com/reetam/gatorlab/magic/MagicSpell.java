package com.reetam.gatorlab.magic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract class MagicSpell {
    BlockPos castPos;
    World castWorld;
    PlayerEntity caster;

    public MagicSpell(BlockPos castPos, World castWorld, @Nullable PlayerEntity caster) {
        this.castPos = castPos;
        this.castWorld = castWorld;
        this.caster = caster;
    }

    public abstract void trigger();
}
