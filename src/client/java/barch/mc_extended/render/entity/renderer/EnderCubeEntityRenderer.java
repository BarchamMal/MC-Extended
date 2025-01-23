package barch.mc_extended.render.entity.renderer;

import barch.mc_extended.Entities.EnderCubeEntity;
import barch.mc_extended.render.entity.model.EnderCubeEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.MagmaCubeEntityModel;
import net.minecraft.client.render.entity.state.SlimeEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

import static barch.mc_extended.Entities.EnderCube.MODEL_ENDER_CUBE_LAYER;
import static barch.mc_extended.MCExtended.MC_EXTENDED;

@Environment(EnvType.CLIENT)
public class EnderCubeEntityRenderer extends MobEntityRenderer<EnderCubeEntity, SlimeEntityRenderState, EnderCubeEntityModel> {
    private static final Identifier TEXTURE = Identifier.of(MC_EXTENDED,"textures/entity/slimes/ender_cube.png");

    public EnderCubeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new EnderCubeEntityModel(context.getPart(MODEL_ENDER_CUBE_LAYER)), 0.25F);
    }

    protected int getBlockLight(EnderCubeEntity enderCubeEntity, BlockPos blockPos) {
        return 15;
    }

    @Override
    public Identifier getTexture(SlimeEntityRenderState state) {
        return TEXTURE;
    }

    public SlimeEntityRenderState createRenderState() {
        return new SlimeEntityRenderState();
    }

    public void updateRenderState(EnderCubeEntity enderCubeEntity, SlimeEntityRenderState slimeEntityRenderState, float f) {
        super.updateRenderState(enderCubeEntity, slimeEntityRenderState, f);
        slimeEntityRenderState.stretch = MathHelper.lerp(f, enderCubeEntity.lastStretch, enderCubeEntity.stretch);
        slimeEntityRenderState.size = enderCubeEntity.getSize();
    }

    protected float getShadowRadius(SlimeEntityRenderState slimeEntityRenderState) {
        return (float)slimeEntityRenderState.size * 0.25F;
    }

    protected void scale(SlimeEntityRenderState slimeEntityRenderState, MatrixStack matrixStack) {
        int i = slimeEntityRenderState.size;
        float f = slimeEntityRenderState.stretch / ((float)i * 0.5F + 1.0F);
        float g = 1.0F / (f + 1.0F);
        matrixStack.scale(g * (float)i, 1.0F / g * (float)i, g * (float)i);
    }
}