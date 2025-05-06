package barch.mc_extended.render.entity.model;

import barch.mc_extended.render.entity.renderstate.TroutFishEntityRenderState;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelTransformer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class TroutFishEntityModel extends EntityModel<TroutFishEntityRenderState> {

    public static final ModelTransformer SMALL_TRANSFORMER = ModelTransformer.scaling(0.5F);
    public static final ModelTransformer LARGE_TRANSFORMER = ModelTransformer.scaling(1.5F);
    private static final String BODY_FRONT = "body_front";
    private static final String BODY_BACK = "body_back";

    private final ModelPart tail;

    public TroutFishEntityModel(ModelPart modelPart) {
        super(modelPart);
        this.tail = modelPart.getChild("body_back");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("body_front", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -2.5F, 0.0F, 3.0F, 5.0F, 8.0F), ModelTransform.origin(0.0F, 20.0F, -7.2F));
        ModelPartData modelPartData3 = modelPartData.addChild("body_back", ModelPartBuilder.create().uv(0, 13).cuboid(-1.5F, -2.5F, 0.0F, 3.0F, 5.0F, 8.0F), ModelTransform.origin(0.0F, 20.0F, 0.8F));
        modelPartData.addChild("head", ModelPartBuilder.create().uv(22, 0).cuboid(-1.0F, -2.0F, -3.0F, 2.0F, 4.0F, 3.0F), ModelTransform.origin(0.0F, 20.0F, -7.2F));
        modelPartData3.addChild("back_fin", ModelPartBuilder.create().uv(20, 10).cuboid(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 6.0F), ModelTransform.origin(0.0F, 0.0F, 8.0F));
        modelPartData2.addChild("top_front_fin", ModelPartBuilder.create().uv(2, 1).cuboid(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F), ModelTransform.origin(0.0F, -4.5F, 5.0F));
        modelPartData3.addChild("top_back_fin", ModelPartBuilder.create().uv(0, 2).cuboid(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 4.0F), ModelTransform.origin(0.0F, -4.5F, -1.0F));
        modelPartData.addChild("right_fin", ModelPartBuilder.create().uv(-4, 0).cuboid(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F), ModelTransform.of(-1.5F, 21.5F, -7.2F, 0.0F, 0.0F, -0.7853982F));
        modelPartData.addChild("left_fin", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F), ModelTransform.of(1.5F, 21.5F, -7.2F, 0.0F, 0.0F, 0.7853982F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    public void setAngles(TroutFishEntityRenderState troutFishEntityRenderState) {
        super.setAngles(troutFishEntityRenderState);
        float f = 1.0F;
        float g = 1.0F;
        if (!troutFishEntityRenderState .touchingWater) {
            f = 1.3F;
            g = 1.7F;
        }

        this.tail.yaw = -f * 0.25F * MathHelper.sin(g * 0.6F * troutFishEntityRenderState.age);
    }

}