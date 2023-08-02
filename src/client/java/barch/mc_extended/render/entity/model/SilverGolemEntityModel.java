package barch.mc_extended.render.entity.model;

import barch.mc_extended.Entities.SilverGolemEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.IronGolemEntityModel;
import net.minecraft.util.math.MathHelper;

public class SilverGolemEntityModel<T extends SilverGolemEntity> extends IronGolemEntityModel<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;

    public SilverGolemEntityModel(ModelPart root) {
        super(root);
        this.root = root;
        this.head = root.getChild("head");
        this.rightArm = root.getChild("right_arm");
        this.leftArm = root.getChild("left_arm");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        // head
        modelPartData.addChild("head", ModelPartBuilder.create()
                 .uv(0,20)
                 .cuboid(-5,-11,-5,10,11,10) // head
                 .uv(0,0)
                 .cuboid(-1,-3,-7,2,4,2), // nose
                ModelTransform.pivot(0,5,0));

        // body
        modelPartData.addChild("body", ModelPartBuilder.create()
                 .uv(0,0)
                .cuboid(-8,5,-5,16,10,10) // body
                .uv(0,41)
                .cuboid(-10,2,0,2,10,6) // support 1
                .uv(16,41)
                .cuboid(8,2,0,2,10,6) // support 0
                .uv(44,54)
                .cuboid(-2,5,4,4,6,3), // lump
                ModelTransform.pivot(0,0,0));

        // right_arm
        modelPartData.addChild("right_arm", ModelPartBuilder.create()
                .uv(32,45)
                .cuboid(0f,0,-3,3,15,3),
                ModelTransform.pivot(8.0f,5,-2));

        // left_arm
        modelPartData.addChild("left_arm", ModelPartBuilder.create()
                .uv(32,45)
                .cuboid(-3f,0,-3,3,15,3),
                ModelTransform.pivot(-8.0f,5,-2));

        // right_leg
        modelPartData.addChild("right_leg", ModelPartBuilder.create()
                .uv(30,20)
                .cuboid(-3,-1,-3,6,4,6) // leg
                .uv(44,46)
                .cuboid(-2,3,-2,4,4,4), // foot
                ModelTransform.pivot(4,16,0));

        // left_leg
        modelPartData.addChild("left_leg", ModelPartBuilder.create()
                        .uv(34,35)
                        .cuboid(-3,-1,-3,6,4,6) // leg
                        .uv(42,0)
                        .cuboid(-2,3,-2,4,4,4), // foot
                ModelTransform.pivot(-4,16,0));




        return TexturedModelData.of(modelData, 66,63);
    }
    @Override
    public ModelPart getPart() {
        return this.root;
    }

    @Override
    public void setAngles(T silverGolemEntity, float f, float g, float h, float i, float j) {
        this.head.yaw = i * 0.017453292F;
        this.head.pitch = j * 0.017453292F;
        this.rightLeg.pitch = -1.5F * MathHelper.wrap(f, 13.0F) * g;
        this.leftLeg.pitch = 1.5F * MathHelper.wrap(f, 13.0F) * g;
        this.rightLeg.yaw = 0.0F;
        this.leftLeg.yaw = 0.0F;
    }

    public ModelPart getRightArm() {
        return this.rightArm;
    }
}
