package barch.mc_extended.Glue;

import net.minecraft.block.Block;

public class BlockBuilder {


    private static Block.Settings Settings;


    public static Block.Settings CloneBlock(Block block) {

        Settings = Block.Settings.create()
                .sounds(block.getDefaultState().getSoundGroup())
                .strength(block.getHardness())
                .resistance(block.getBlastResistance())
                .mapColor(block.getDefaultMapColor())
                .slipperiness(block.getSlipperiness());

        return Settings;

    };

}
