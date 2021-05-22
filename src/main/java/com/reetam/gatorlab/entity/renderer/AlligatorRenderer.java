package com.reetam.gatorlab.entity.renderer;

import com.reetam.gatorlab.GatorLab;
import com.reetam.gatorlab.entity.AlligatorEntity;
import com.reetam.gatorlab.entity.model.AlligatorModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AlligatorRenderer extends MobRenderer<AlligatorEntity, AlligatorModel<AlligatorEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(GatorLab.MODID, "textures/entity/alligator.png");

    public AlligatorRenderer(EntityRendererManager manager) {
        super(manager, new AlligatorModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(AlligatorEntity entity) {
        return TEXTURE;
    }
}
