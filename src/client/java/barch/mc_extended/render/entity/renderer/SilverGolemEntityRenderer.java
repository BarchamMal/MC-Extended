package barch.mc_extended.render.entity.renderer;

import barch.mc_extended.Entities.SilverGolemEntity;
import barch.mc_extended.render.entity.featurerenderer.SilverGolemCrackFeatureRenderer;
import barch.mc_extended.render.entity.featurerenderer.SilverGolemFlowerFeatureRenderer;
import barch.mc_extended.render.entity.model.SilverGolemEntityModel;
import barch.mc_extended.render.entity.renderstate.SilverGolemEntityRenderState;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

import static barch.mc_extended.Entities.SilverGolem.MODEL_SILVER_GOLEM_LAYER;
import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class SilverGolemEntityRenderer extends MobEntityRenderer<SilverGolemEntity, SilverGolemEntityRenderState, SilverGolemEntityModel> {
    private static final Identifier TEXTURE = Identifier.of(MC_EXTENDED, "textures/entity/golem/silver_golem.png");

    public SilverGolemEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SilverGolemEntityModel(context.getPart(MODEL_SILVER_GOLEM_LAYER)), 0.7F);
        this.addFeature(new SilverGolemCrackFeatureRenderer(this));
        this.addFeature(new SilverGolemFlowerFeatureRenderer(this, context.getBlockRenderManager()));
    }

    @Override
    public Identifier getTexture(SilverGolemEntityRenderState state) {
        return TEXTURE;
    }

    public SilverGolemEntityRenderState createRenderState() {
        return new SilverGolemEntityRenderState();
    }

    public void updateRenderState(SilverGolemEntity silverGolemEntity, SilverGolemEntityRenderState silverGolemEntityRenderState, float f) {
        super.updateRenderState(silverGolemEntity, silverGolemEntityRenderState, f);
        silverGolemEntityRenderState.attackTicksLeft = (float)silverGolemEntity.getAttackTicksLeft() > 0.0F ? (float)silverGolemEntity.getAttackTicksLeft() - f : 0.0F;
        silverGolemEntityRenderState.lookingAtVillagerTicks = silverGolemEntity.getLookingAtVillagerTicks();
        silverGolemEntityRenderState.crackLevel = silverGolemEntity.getCrackLevel();
    }

    protected void setupTransforms(SilverGolemEntityRenderState silverGolemEntityRenderState, MatrixStack matrixStack, float f, float g) {
        super.setupTransforms(silverGolemEntityRenderState, matrixStack, f, g);
        if (!((double) silverGolemEntityRenderState.limbSwingAmplitude < 0.01)) {
            float h = 13.0F;
            float i = silverGolemEntityRenderState.limbSwingAnimationProgress + 6.0F;
            float j = (Math.abs(i % 13.0F - 6.5F) - 3.25F) / 3.25F;
            matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(6.5F * j));
        }
    }
}