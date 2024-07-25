package barch.mc_extended.render.entity.renderer;

import barch.mc_extended.Entities.SilverGolemEntity;
import barch.mc_extended.render.entity.model.SilverGolemEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

import static barch.mc_extended.Entities.SilverGolem.MODEL_SILVER_GOLEM_LAYER;
import static barch.mc_extended.MCExtended.NAMESPACE;

public class SilverGolemEntityRenderer extends MobEntityRenderer<SilverGolemEntity, SilverGolemEntityModel<SilverGolemEntity>> {
    private static final Identifier TEXTURE = Identifier.of(NAMESPACE,"textures/entity/golems/silver_golem.png");

    public SilverGolemEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SilverGolemEntityModel<>(context.getPart(MODEL_SILVER_GOLEM_LAYER)), 0.7F);
//        this.addFeature(new IronGolemCrackFeatureRenderer(this));
//        this.addFeature(new IronGolemFlowerFeatureRenderer(this, context.getBlockRenderManager()));
    }

    @Override
    public Identifier getTexture(SilverGolemEntity entity) {
        return TEXTURE;
    }

//    protected void setupTransforms(SilverGolemEntity silverGolemEntity, MatrixStack matrixStack, float f, float g, float h) {
//        super.setupTransforms(silverGolemEntity, matrixStack, f, g, h);
//        if (!((double)silverGolemEntity.limbAnimator.getSpeed() < 0.01)) {
//            float i = 13.0F;
//            float j = silverGolemEntity.limbAnimator.getPos(h) + 6.0F;
//            float k = (Math.abs(j % 13.0F - 6.5F) - 3.25F) / 3.25F;
//            matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(6.5F * k));
//        }
//    }
}
