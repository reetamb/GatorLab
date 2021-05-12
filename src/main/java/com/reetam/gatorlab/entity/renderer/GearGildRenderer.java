package com.reetam.gatorlab.entity.renderer;

import com.reetam.gatorlab.GatorLab;
import com.reetam.gatorlab.entity.GearGildEntity;
import com.reetam.gatorlab.entity.model.GearGildModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GearGildRenderer extends MobRenderer<GearGildEntity, GearGildModel<GearGildEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(GatorLab.MODID, "textures/entity/gear_gild.png");

    public GearGildRenderer(EntityRendererManager manager) {
        super(manager, new GearGildModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(GearGildEntity entity) {
        return TEXTURE;
    }
}
