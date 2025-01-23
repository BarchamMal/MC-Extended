package barch.mc_extended.render.entity.renderer;



import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.AbstractSkeletonEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.client.render.entity.feature.SkeletonOverlayFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.state.SkeletonEntityRenderState;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.StrayEntity;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED;

@Environment(EnvType.CLIENT)
public class LostEntityRenderer extends AbstractSkeletonEntityRenderer<SkeletonEntity, SkeletonEntityRenderState> {
    private static final Identifier TEXTURE = Identifier.of(MC_EXTENDED,"textures/entity/skeleton/lost.png");
    private static final Identifier LOST_OVERLAY = Identifier.of(MC_EXTENDED, "textures/entity/skeleton/lost_overlay.png");

    public LostEntityRenderer(EntityRendererFactory.Context context) {
        super(context, EntityModelLayers.STRAY, EntityModelLayers.STRAY_INNER_ARMOR, EntityModelLayers.STRAY_OUTER_ARMOR);
        this.addFeature(new SkeletonOverlayFeatureRenderer(this, context.getEntityModels(), EntityModelLayers.STRAY_OUTER, LOST_OVERLAY));
    }

    public Identifier getTexture(SkeletonEntityRenderState skeletonEntityRenderState) {
        return TEXTURE;
    }

    public SkeletonEntityRenderState createRenderState() {
        return new SkeletonEntityRenderState();
    }
}
