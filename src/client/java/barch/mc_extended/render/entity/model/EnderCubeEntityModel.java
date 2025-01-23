package barch.mc_extended.render.entity.model;

import java.util.Arrays;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.SlimeEntityRenderState;

@Environment(EnvType.CLIENT)
public class EnderCubeEntityModel extends EntityModel<SlimeEntityRenderState> {
    private static final int SLICES_COUNT = 8;
    private final ModelPart[] slices = new ModelPart[SLICES_COUNT];

    public EnderCubeEntityModel(ModelPart modelPart) {
        super(modelPart);
        Arrays.setAll(this.slices, (index) -> {
            return root.getChild(getSliceName(index));
        });
    }

    private static String getSliceName(int index) {
        return "cube" + index;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        for(int i = 0; i < SLICES_COUNT; ++i) {
            int j = 0;
            int k = 0;
            if (i > 0 && i < 4) {
                k += 9 * i;
            } else if (i > 3) {
                j = 32;
                k += 9 * i - 36;
            }

            modelPartData.addChild(getSliceName(i), ModelPartBuilder.create().uv(j, k).cuboid(-4.0F, (float)(16 + i), -4.0F, 8.0F, 1.0F, 8.0F), ModelTransform.NONE);
        }

        modelPartData.addChild("inside_cube", ModelPartBuilder.create().uv(24, 40).cuboid(-2.0F, 18.0F, -2.0F, 4.0F, 4.0F, 4.0F), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 64, 64);
    }


    public void setAngles(SlimeEntityRenderState slimeEntityRenderState) {
        super.setAngles(slimeEntityRenderState);
        float f = Math.max(0.0F, slimeEntityRenderState.stretch);

        for(int i = 0; i < this.slices.length; ++i) {
            this.slices[i].pivotY = (float)(-(4 - i)) * f * 1.7F;
        }

    }
}
