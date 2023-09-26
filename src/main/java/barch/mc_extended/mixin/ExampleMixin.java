package barch.mc_extended.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MinecraftServer.class)
public class ExampleMixin {
//	@Inject(at = @At("HEAD"), method = "loadWorld")
//	private void init(CallbackInfo info) {
//		// This code is injected into the start of MinecraftServer.loadWorld()V
//	}
}