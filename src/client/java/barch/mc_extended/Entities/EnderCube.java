package barch.mc_extended.Entities;

import barch.mc_extended.render.entity.model.EnderCubeEntityModel;
import barch.mc_extended.render.entity.renderer.EnderCubeEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import static barch.mc_extended.Entities.Entities.ENDER_CUBE;
import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class EnderCube {

    public static final EntityModelLayer MODEL_ENDER_CUBE_LAYER = new EntityModelLayer(Identifier.of(MC_EXTENDED, "ender_cube"), "main");

    public static void registerClient() {

        EntityRendererRegistry.register(ENDER_CUBE, EnderCubeEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_ENDER_CUBE_LAYER, EnderCubeEntityModel::getTexturedModelData);

    }

}
