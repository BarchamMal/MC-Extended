package barch.mc_extended.Entities;

import barch.mc_extended.render.entity.model.LostEntityModel;
import barch.mc_extended.render.entity.renderer.LostEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED;
import static barch.mc_extended.Registry.ModEntities.*;

public class Lost {

    public static final EntityModelLayer MODEL_LOST_LAYER = new EntityModelLayer(Identifier.of(MC_EXTENDED, "lost"), "main");

    public static void registerClient() {

        EntityRendererRegistry.register(LOST, LostEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_LOST_LAYER, LostEntityModel::getTexturedModelData);

    }

}
