package barch.mc_extended.render.entity.renderer;

import barch.mc_extended.Entities.TroutFishEntity;
import barch.mc_extended.render.entity.model.TroutFishEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED;
import static barch.mc_extended.Entities.TroutFish.MODEL_TROUT_FISH_LAYER;

public class TroutFishEntityRenderer extends MobEntityRenderer<TroutFishEntity, TroutFishEntityModel<TroutFishEntity>> {
    private static final Identifier TEXTURE = Identifier.of(MC_EXTENDED,"textures/entity/fish/trout_fish.png");

    public TroutFishEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new TroutFishEntityModel(context.getPart(MODEL_TROUT_FISH_LAYER)), 0.4F);
    }

    public Identifier getTexture(TroutFishEntity TroutFishEntity) {
        return TEXTURE;
    }

//    protected void setupTransforms(TroutFishEntity TroutFishEntity, MatrixStack matrixStack, float f, float g, float h) {
//        super.setupTransforms(TroutFishEntity, matrixStack, f, g, h);
//        float i = 1.0F;
//        float j = 1.0F;
//        if (!TroutFishEntity.isTouchingWater()) {
//            i = 1.3F;
//            j = 1.7F;
//        }
//
//        float k = i * 4.3F * MathHelper.sin(j * 0.6F * f);
//        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(k));
//        matrixStack.translate(0.0F, 0.0F, -0.4F);
//        if (!TroutFishEntity.isTouchingWater()) {
//            matrixStack.translate(0.2F, 0.1F, 0.0F);
//            matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
//        }
//
//    }
}