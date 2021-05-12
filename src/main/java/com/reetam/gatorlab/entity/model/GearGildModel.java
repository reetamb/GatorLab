package com.reetam.gatorlab.entity.model;
// Made with Blockbench 3.7.0
// Exported for Minecraft version 1.15

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.reetam.gatorlab.entity.GearGildEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GearGildModel<T extends GearGildEntity> extends EntityModel<T> {
	private final ModelRenderer teeth1;
	private final ModelRenderer teeth2;
	private final ModelRenderer head;

	public GearGildModel() {
		texWidth = 64;
		texHeight = 32;

		teeth1 = new ModelRenderer(this);
		teeth1.setPos(0.0F, 24.0F, 0.0F);
		teeth1.texOffs(24, 16).addBox(-2.0F, 5.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		teeth1.texOffs(0, 16).addBox(-13.0F, -2.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
		teeth1.texOffs(24, 16).addBox(-2.0F, -13.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		teeth1.texOffs(0, 16).addBox(5.0F, -2.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);

		teeth2 = new ModelRenderer(this);
		teeth2.setPos(0.0F, 24.0F, 0.0F);
		setRotationAngle(teeth2, 0.0F, 0.0F, 0.7854F);
		teeth2.texOffs(32, 0).addBox(-12.1213F, -2.0503F, -1.0F, 6.0F, 4.0F, 2.0F, 0.0F, false);
		teeth2.texOffs(48, 0).addBox(-2.1213F, -12.0503F, -1.0F, 4.0F, 6.0F, 2.0F, 0.0F, false);
		teeth2.texOffs(48, 0).addBox(-2.1213F, 5.9497F, 0.0F, 4.0F, 6.0F, 2.0F, 0.0F, false);
		teeth2.texOffs(32, 0).addBox(5.8787F, -2.0503F, 0.0F, 6.0F, 4.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setPos(0.0F, 24.0F, 0.0F);
		head.texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float age, float headYaw, float headPitch) {
		this.teeth1.zRot += Math.PI/64;
		this.teeth2.zRot += Math.PI/64;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		teeth1.render(matrixStack, buffer, packedLight, packedOverlay);
		teeth2.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}