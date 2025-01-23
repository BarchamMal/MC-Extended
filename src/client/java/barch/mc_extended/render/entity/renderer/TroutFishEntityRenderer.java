package barch.mc_extended.render.entity.renderer;

import barch.mc_extended.Entities.TroutFishEntity;
import barch.mc_extended.render.entity.model.TroutFishEntityModel;
import barch.mc_extended.render.entity.renderstate.TroutFishEntityRenderState;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

import static barch.mc_extended.Entities.TroutFish.*;
import static barch.mc_extended.MCExtended.MC_EXTENDED;


@Environment(EnvType.CLIENT)
public class TroutFishEntityRenderer extends MobEntityRenderer<TroutFishEntity, TroutFishEntityRenderState, TroutFishEntityModel> {
    private static final Identifier TEXTURE = Identifier.of(MC_EXTENDED,"textures/entity/fish/trout_fish.png");
    private final TroutFishEntityModel smallModel;
    private final TroutFishEntityModel mediumModel;
    private final TroutFishEntityModel largeModel;

    public TroutFishEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new TroutFishEntityModel(context.getPart(MODEL_TROUT_FISH_LAYER)), 0.4F);
        this.smallModel = new TroutFishEntityModel(context.getPart(MODEL_TROUT_FISH_SMALL_LAYER));
        this.mediumModel = new TroutFishEntityModel(context.getPart(MODEL_TROUT_FISH_LAYER));
        this.largeModel = new TroutFishEntityModel(context.getPart(MODEL_TROUT_FISH_LARGE_LAYER));
    }

    public void updateRenderState(TroutFishEntity troutFishEntity, TroutFishEntityRenderState troutFishEntityRenderState, float f) {
        super.updateRenderState(troutFishEntity, troutFishEntityRenderState, f);
        troutFishEntityRenderState.variant = troutFishEntity.getVariant();
    }

    public Identifier getTexture(TroutFishEntityRenderState state) {
        return TEXTURE;
    }

    public TroutFishEntityRenderState createRenderState() {
        return new TroutFishEntityRenderState();
    }

    protected void setupTransforms(TroutFishEntityRenderState troutFishEntityRenderState, MatrixStack matrixStack, float f, float g) {
        super.setupTransforms(troutFishEntityRenderState, matrixStack, f, g);
        float h = 1.0F;
        float i = 1.0F;
        if (!troutFishEntityRenderState.touchingWater) {
            h = 1.3F;
            i = 1.7F;
        }

        float j = h * 4.3F * MathHelper.sin(i * 0.6F * troutFishEntityRenderState.age);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(j));
        if (!troutFishEntityRenderState.touchingWater) {
            matrixStack.translate(0.2F, 0.1F, 0.0F);
            matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
        }

    }

    public void render(TroutFishEntityRenderState troutFishEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (troutFishEntityRenderState.variant == TroutFishEntity.Variant.SMALL) {
            this.model = this.smallModel;
        } else if (troutFishEntityRenderState.variant == TroutFishEntity.Variant.LARGE) {
            this.model = this.largeModel;
        } else {
            this.model = this.mediumModel;
        }

        super.render(troutFishEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }
}
