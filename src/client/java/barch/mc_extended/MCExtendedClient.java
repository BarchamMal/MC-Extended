package barch.mc_extended;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static barch.mc_extended.Foods.Onion.ONION_CROP_BLOCK;
import static barch.mc_extended.Foods.Onion.WILD_ONION;
import static barch.mc_extended.Foods.Tomato.TOMATO_CROP_BLOCK;
import static barch.mc_extended.Foods.Mushrooms.WHITE_MUSHROOM;

public class MCExtendedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.

        // for the transparent blocks such as mushrooms or crops
        // tomato crop
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), TOMATO_CROP_BLOCK);
        // white mushroom
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), WHITE_MUSHROOM);
        // wild onion
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), WILD_ONION);
        // tomato crop
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ONION_CROP_BLOCK);


    }
}