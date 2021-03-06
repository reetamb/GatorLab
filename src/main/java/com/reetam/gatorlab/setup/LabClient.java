package com.reetam.gatorlab.setup;

import com.reetam.gatorlab.entity.renderer.AlligatorRenderer;
import com.reetam.gatorlab.registry.LabBlocks;
import com.reetam.gatorlab.registry.LabEntities;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = "gatorlab", value = Dist.CLIENT)
public class LabClient {

    public static void register() {
        registerBlockRenderers();
        registerEntityRenderers();
    }

    private static void render(Supplier<? extends Block> block, RenderType render) {
        RenderTypeLookup.setRenderLayer(block.get(), render);
    }

    private static void registerBlockRenderers() {
        RenderType cutout = RenderType.cutout();

        render(LabBlocks.BRANCHES, cutout);
        render(LabBlocks.REDLIGHT_RUNE, cutout);
    }

    private static void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(LabEntities.ALLIGATOR.get(), AlligatorRenderer::new);
    }
}