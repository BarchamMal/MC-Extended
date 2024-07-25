package barch.mc_extended.render.entity.renderer;

import barch.mc_extended.Entities.EnderCubeEntity;
import barch.mc_extended.render.entity.model.EnderCubeEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

import static barch.mc_extended.Entities.EnderCube.MODEL_ENDER_CUBE_LAYER;
import static barch.mc_extended.MCExtended.NAMESPACE;

@Environment(EnvType.CLIENT)
public class EnderCubeEntityRenderer extends MobEntityRenderer<EnderCubeEntity, EnderCubeEntityModel<EnderCubeEntity>> {
    private static final Identifier TEXTURE = Identifier.of(NAMESPACE,"textures/entity/slimes/ender_cube.png");

    public EnderCubeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new EnderCubeEntityModel(context.getPart(MODEL_ENDER_CUBE_LAYER)), 0.25F);
    }

    protected int getBlockLight(EnderCubeEntity enderCubeEntity, BlockPos blockPos) {
        return 15;
    }

    public Identifier getTexture(EnderCubeEntity enderCubeEntity) {
        return TEXTURE;
    }

    public void render(EnderCubeEntity enderCubeEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        this.shadowRadius = 0.25F * (float)enderCubeEntity.getSize();
        super.render(enderCubeEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    protected void scale(EnderCubeEntity enderCubeEntity, MatrixStack matrixStack, float f) {
        int i = enderCubeEntity.getSize();
        float g = MathHelper.lerp(f, enderCubeEntity.lastStretch, enderCubeEntity.stretch) / ((float)i * 0.5F + 1.0F);
        float h = 1.0F / (g + 1.0F);
        matrixStack.scale(h * (float)i, 1.0F / h * (float)i, h * (float)i);
    }
}
