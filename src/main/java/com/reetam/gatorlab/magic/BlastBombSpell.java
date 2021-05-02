package com.reetam.gatorlab.magic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlastBombSpell extends MagicSpell {

    public BlastBombSpell(BlockPos castPos, World castWorld, @Nullable PlayerEntity player) {
        super(castPos, castWorld, player);
    }

    @Override
    public void trigger() {
        if (!castWorld.isClientSide()) {
            this.castWorld.explode(this.caster, DamageSource.MAGIC, null, this.castPos.getX(), this.castPos.getY(), this.castPos.getZ(), 2.0F, false, Explosion.Mode.DESTROY);
        }
    }
}
