package barch.mc_extended.render.entity.renderstate;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.passive.Cracks;

@Environment(EnvType.CLIENT)
public class SilverGolemEntityRenderState extends LivingEntityRenderState {
    public Cracks.CrackLevel crackLevel;
    public float attackTicksLeft;
    public int lookingAtVillagerTicks;

    public SilverGolemEntityRenderState() {
        this.crackLevel = Cracks.CrackLevel.NONE;
    }
}
