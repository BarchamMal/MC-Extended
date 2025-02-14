package barch.mc_extended.Entities;


import barch.mc_extended.render.entity.model.SilverGolemEntityModel;
import barch.mc_extended.render.entity.renderer.SilverGolemEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import static barch.mc_extended.MCExtended.MC_EXTENDED;
import static barch.mc_extended.Registry.ModEntities.SILVER_GOLEM;

public class SilverGolem {

    public static final EntityModelLayer MODEL_SILVER_GOLEM_LAYER = new EntityModelLayer(Identifier.of(MC_EXTENDED, "silver_golem"), "main");

    public static void registerClient() {

        EntityRendererRegistry.register(SILVER_GOLEM, SilverGolemEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_SILVER_GOLEM_LAYER, SilverGolemEntityModel::getTexturedModelData);

    }

}