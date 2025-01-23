package barch.mc_extended.render.entity.featurerenderer;

import barch.mc_extended.render.entity.model.SilverGolemEntityModel;
import barch.mc_extended.render.entity.renderstate.SilverGolemEntityRenderState;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.Cracks;
import net.minecraft.util.Identifier;

import java.util.Map;

import static barch.mc_extended.MCExtended.MC_EXTENDED;


@Environment(EnvType.CLIENT)
public class SilverGolemCrackFeatureRenderer extends FeatureRenderer<SilverGolemEntityRenderState, SilverGolemEntityModel> {
    private static final Map<Cracks.CrackLevel, Identifier> CRACK_TEXTURES;

    public SilverGolemCrackFeatureRenderer(FeatureRendererContext<SilverGolemEntityRenderState, SilverGolemEntityModel> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, SilverGolemEntityRenderState silverGolemEntityRenderState, float limbAngle, float limbDistance) {
        if (!silverGolemEntityRenderState.invisible) {
            Cracks.CrackLevel crackLevel = silverGolemEntityRenderState.crackLevel;
            if (crackLevel != Cracks.CrackLevel.NONE) {
                Identifier identifier = (Identifier) CRACK_TEXTURES.get(crackLevel);
                renderModel(this.getContextModel(), identifier, matrixStack, vertexConsumerProvider, light, silverGolemEntityRenderState, -1);
            }
        }
    }

    static {
        CRACK_TEXTURES = ImmutableMap.of(
                Cracks.CrackLevel.LOW, Identifier.of(MC_EXTENDED, "textures/entity/silver_golem/silver_golem_crackiness_low.png"),
                Cracks.CrackLevel.MEDIUM, Identifier.of(MC_EXTENDED, "textures/entity/silver_golem/silver_golem_crackiness_medium.png"),
                Cracks.CrackLevel.HIGH, Identifier.of(MC_EXTENDED, "textures/entity/silver_golem/silver_golem_crackiness_high.png")
        );
    }
}
