package com.reetam.gatorlab.setup;

import com.reetam.gatorlab.registry.LabItems;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Direction;

public class LabCommon {

    private static final DefaultDispenseItemBehavior eggBehavior = new DefaultDispenseItemBehavior() {
        public ItemStack execute(IBlockSource source, ItemStack stack) {
            Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
            EntityType<?> type = ((SpawnEggItem)stack.getItem()).getType(stack.getTag());
            type.spawn(source.getLevel(), stack, null, source.getPos().relative(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
            stack.shrink(1);
            return stack;
        }
    };

    public static void register() {
        registerDispenserBehavior();
    }

    private static void registerDispenserBehavior() {
        DispenserBlock.registerBehavior(LabItems.ALLIGATOR_SPAWN_EGG.get(), eggBehavior);
    }
}
