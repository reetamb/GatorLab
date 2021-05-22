package com.reetam.gatorlab.registry;

import com.reetam.gatorlab.GatorLab;
import com.reetam.gatorlab.item.BlastBombItem;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LabItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GatorLab.MODID);

    public static final ItemGroup itemGroup = new ItemGroup("lab_items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.STICK);
        }
    };
    public static final ItemGroup blockGroup = new ItemGroup("lab_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Blocks.STONE);
        }
    };
    public static final Item.Properties baseProperties = new Item.Properties().tab(itemGroup);

    public static final RegistryObject<Item> BLAST_BOMB = ITEMS.register("blastbomb", () -> new BlastBombItem(baseProperties));
    public static final RegistryObject<Item> ALLIGATOR_SPAWN_EGG = ITEMS.register("alligator_spawn_egg", () -> new SpawnEggItem(LabEntities.ALLIGATOR_TYPE, 0x00FF00, 0x008800, baseProperties));
}
