package barch.mc_extended.render.entity.renderstate;

import barch.mc_extended.Entities.TroutFishEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;

@Environment(EnvType.CLIENT)
public class TroutFishEntityRenderState extends LivingEntityRenderState {
    public TroutFishEntity.Variant variant;

    public TroutFishEntityRenderState() {
        this.variant = TroutFishEntity.Variant.MEDIUM;
    }
}
