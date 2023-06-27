package barch.mc_extended.Glue;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

public class BlockBuilder {


    private static FabricBlockSettings Settings;


    public static FabricBlockSettings CloneBlock(Block block) {

        Settings = FabricBlockSettings.of(block.getDefaultState().getMaterial())
                .sounds(block.getSoundGroup(block.getDefaultState()))
                .mapColor(block.getDefaultMapColor())
                .slipperiness(block.getSlipperiness());

        return Settings;

    };

}