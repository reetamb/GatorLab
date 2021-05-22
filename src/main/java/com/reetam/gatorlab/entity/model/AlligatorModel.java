package com.reetam.gatorlab.entity.model;
// Made with Blockbench 3.7.0
// Exported for Minecraft version 1.15

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.reetam.gatorlab.entity.AlligatorEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;


public class AlligatorModel<T extends AlligatorEntity> extends EntityModel<T> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer tail;
	private final ModelRenderer lbleg;
	private final ModelRenderer rbleg;
	private final ModelRenderer lfleg;
	private final ModelRenderer rfleg;

	public AlligatorModel() {
		texWidth = 128;
		texHeight = 128;

		head = new ModelRenderer(this);
		head.setPos(0.0F, 12.0F, -11.25F);
		setRotationAngle(head, -0.2618F, 0.0F, 0.0F);
		head.texOffs(0, 32).addBox(-4.0F, -1.7956F, -12.0529F, 8.0F, 4.0F, 12.0F, 0.0F, false);
		head.texOffs(80, 41).addBox(-3.0F, -3.75F, -5.0F, 6.0F, 2.0F, 5.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setPos(0.0F, 14.0F, 0.0F);
		body.texOffs(40, 33).addBox(-4.0F, 1.0F, -24.0F, 8.0F, 3.0F, 12.0F, 0.0F, false);
		body.texOffs(0, 0).addBox(-5.0F, -4.0F, -12.0F, 10.0F, 8.0F, 24.0F, 0.0F, true);
		body.texOffs(68, 6).addBox(0.0F, -8.0F, -10.0F, 0.0F, 4.0F, 22.0F, 0.0F, false);
		body.texOffs(102, 36).addBox(-3.0F, -4.0F, -18.0F, 0.0F, 6.0F, 6.0F, 0.0F, false);
		body.texOffs(102, 36).addBox(3.0F, -4.0F, -18.0F, 0.0F, 6.0F, 6.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setPos(0.0F, 14.75F, 11.0F);
		tail.texOffs(0, 64).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 6.0F, 16.0F, 0.0F, false);
		tail.texOffs(44, 70).addBox(-1.5F, -1.0F, 15.0F, 3.0F, 4.0F, 12.0F, 0.0F, false);
		tail.texOffs(74, 56).addBox(0.0F, -5.0F, 1.0F, 0.0F, 4.0F, 26.0F, 0.0F, false);

		lbleg = new ModelRenderer(this);
		lbleg.setPos(6.0F, 16.0F, 6.0F);
		setRotationAngle(lbleg, 0.0F, 0.0F, -0.0873F);
		lbleg.texOffs(18, 48).addBox(-1.4733F, -2.0643F, -3.0F, 3.0F, 10.0F, 6.0F, 0.0F, false);

		rbleg = new ModelRenderer(this);
		rbleg.setPos(-6.0F, 16.0F, 6.0F);
		setRotationAngle(rbleg, 0.0F, 0.0F, 0.0873F);
		rbleg.texOffs(18, 48).addBox(-1.5267F, -2.0643F, -3.0F, 3.0F, 10.0F, 6.0F, 0.0F, false);

		lfleg = new ModelRenderer(this);
		lfleg.setPos(6.0F, 16.0F, -6.0F);
		setRotationAngle(lfleg, 0.0F, 0.0F, -0.0873F);
		lfleg.texOffs(0, 48).addBox(-1.4733F, -2.0643F, -3.0F, 3.0F, 10.0F, 6.0F, 0.0F, false);

		rfleg = new ModelRenderer(this);
		rfleg.setPos(-6.0F, 16.0F, -6.0F);
		setRotationAngle(rfleg, 0.0F, 0.0F, 0.0873F);
		rfleg.texOffs(0, 48).addBox(-1.5267F, -2.0643F, -3.0F, 3.0F, 10.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.lfleg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.rfleg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.lbleg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rbleg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		lbleg.render(matrixStack, buffer, packedLight, packedOverlay);
		rbleg.render(matrixStack, buffer, packedLight, packedOverlay);
		lfleg.render(matrixStack, buffer, packedLight, packedOverlay);
		rfleg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}