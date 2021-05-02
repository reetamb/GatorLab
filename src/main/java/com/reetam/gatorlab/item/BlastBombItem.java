package com.reetam.gatorlab.item;

import com.reetam.gatorlab.magic.BlastBombSpell;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlastBombItem extends Item {

    public BlastBombItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClientSide()) {
            BlastBombSpell spell = new BlastBombSpell(new BlockPos(player.position()), world, player);
            spell.trigger();
            return ActionResult.consume(player.getItemInHand(hand));
        }
        return ActionResult.fail(player.getItemInHand(hand));
    }
}
