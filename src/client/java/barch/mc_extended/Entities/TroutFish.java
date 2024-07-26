package barch.mc_extended.Entities;

import barch.mc_extended.render.entity.model.TroutFishEntityModel;
import barch.mc_extended.render.entity.renderer.TroutFishEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import static barch.mc_extended.Entities.Entities.TROUT_FISH;
import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class TroutFish {


    public static final EntityModelLayer MODEL_TROUT_FISH_LAYER = new EntityModelLayer(Identifier.of(MC_EXTENDED, "trout_fish"), "main");

    public static void registerClient() {

        EntityRendererRegistry.register(TROUT_FISH, TroutFishEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_TROUT_FISH_LAYER, TroutFishEntityModel::getTexturedModelData);

    }
    
}
