package com.reetam.gatorlab.registry;

import com.reetam.gatorlab.GatorLab;
import com.reetam.gatorlab.block.LEDBlock;
import com.reetam.gatorlab.block.RedlightRune;
import com.reetam.gatorlab.block.WeatherDetectorBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class LabBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GatorLab.MODID);

    public static final RegistryObject<Block> BRANCHES = blockItem("branches", () -> new Block(AbstractBlock.Properties.copy(Blocks.COBWEB).sound(SoundType.HARD_CROP).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> SCUTE_BLOCK = blockItem("alligator_scute_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.TERRACOTTA)));
    public static final RegistryObject<Block> WEATHER_DETECTOR = blockItem("weather_detector", () -> new WeatherDetectorBlock(AbstractBlock.Properties.copy(Blocks.DAYLIGHT_DETECTOR)));
    public static final RegistryObject<Block> LED_BLOCK = blockItem("led_block", () -> new LEDBlock(AbstractBlock.Properties.copy(Blocks.GLASS).lightLevel(
            (p_235421_1_) -> {
                return p_235421_1_.getValue(LEDBlock.POWER);
            }
    )));
    public static final RegistryObject<Block> REDLIGHT_RUNE = blockItem("redlight_rune", () -> new RedlightRune(AbstractBlock.Properties.copy(Blocks.REDSTONE_WIRE).lightLevel(
            (p_235421_1_) -> {
                return p_235421_1_.getValue(RedlightRune.POWERED) ? 7 : 0;
            }
    )));
    private static <T extends Block> RegistryObject<T> blockItem(String name, Supplier<? extends T> block) {
        RegistryObject<T> registerBlock = BLOCKS.register(name, block);
        LabItems.ITEMS.register(name, () -> new BlockItem(registerBlock.get(), new Item.Properties().tab(LabItems.blockGroup)));
        return registerBlock;
    }
}
