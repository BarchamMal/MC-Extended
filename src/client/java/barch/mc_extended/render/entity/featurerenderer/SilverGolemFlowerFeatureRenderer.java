package barch.mc_extended.render.entity.featurerenderer;

import barch.mc_extended.render.entity.model.SilverGolemEntityModel;
import barch.mc_extended.render.entity.renderstate.SilverGolemEntityRenderState;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Blocks;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class SilverGolemFlowerFeatureRenderer extends FeatureRenderer<SilverGolemEntityRenderState, SilverGolemEntityModel> {
    private final BlockRenderManager blockRenderManager;

    public SilverGolemFlowerFeatureRenderer(FeatureRendererContext<SilverGolemEntityRenderState, SilverGolemEntityModel> context, BlockRenderManager blockRenderManager) {
        super(context);
        this.blockRenderManager = blockRenderManager;
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, SilverGolemEntityRenderState silverGolemEntityRenderState, float f, float g) {
        if (silverGolemEntityRenderState.lookingAtVillagerTicks != 0) {
            matrixStack.push();
            ModelPart modelPart = ((SilverGolemEntityModel) this.getContextModel()).getRightArm();
            modelPart.rotate(matrixStack);
            matrixStack.translate(-0.4125F, 0.3313F, -0.9F);
            matrixStack.translate(0.5F, 0.5F, 0.5F);
            float h = 0.5F;
            matrixStack.scale(0.5F, 0.5F, 0.5F);
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90.0F));
            matrixStack.translate(-0.5F, -0.5F, -0.5F);
            this.blockRenderManager.renderBlockAsEntity(Blocks.CORNFLOWER.getDefaultState(), matrixStack, vertexConsumerProvider, i, OverlayTexture.DEFAULT_UV);
            matrixStack.pop();
        }
    }
}
