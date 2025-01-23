package barch.mc_extended;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.render.RenderLayer;

import static barch.mc_extended.Foods.Onion.ONION_CROP_BLOCK;
import static barch.mc_extended.Foods.Onion.WILD_ONION;
import static barch.mc_extended.Foods.Spinach.SPINACH_CROP_BLOCK;
import static barch.mc_extended.Foods.Spinach.WILD_SPINACH;
import static barch.mc_extended.Foods.Tomato.TOMATO_CROP_BLOCK;
import static barch.mc_extended.Foods.Mushrooms.WHITE_MUSHROOM;
import static barch.mc_extended.Villagers.WorkStations.BOTANY_TABLE;

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
        // onion crop
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ONION_CROP_BLOCK);
        // wild spinach
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), WILD_SPINACH);
        // spinach crop
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), SPINACH_CROP_BLOCK);
        // botany_table crop
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), BOTANY_TABLE);

        // for the entities

        // lost
        EntitiesClient.registerClient();

        // eggs

//        ItemModelGenerator.registerSpawnEgg(LOST, 0x839f7D, 0x9f9f9f);
//        ItemModelGenerator.registerSpawnEgg(TROUT_FISH, 0x835e50, 0xeac17c);
//        ItemModelGenerator.registerSpawnEgg(SILVER_GOLEM, 0xd0d0fa, 0x7c7da2);
//        ItemModelGenerator.registerSpawnEgg(ENDER_CUBE, 0x3b2754, 0xf6fabd);

    }
}