package com.reetam.gatorlab.registry;

import com.reetam.gatorlab.GatorLab;
import com.reetam.gatorlab.item.BlastBombItem;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LabItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GatorLab.MODID);

    public static final RegistryObject<Item> BLAST_BOMB = ITEMS.register("blastbomb", () -> new BlastBombItem(new Item.Properties()));

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
}
