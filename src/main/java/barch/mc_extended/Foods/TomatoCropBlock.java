package barch.mc_extended.Foods;

import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import static barch.mc_extended.Foods.Tomato.TOMATO_SEEDS;

public class TomatoCropBlock extends CropBlock {


    private static Item Seeds = TOMATO_SEEDS;

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0d,0.0d,0.0d,16.0d,2.0d,16.0),
            Block.createCuboidShape(0.0d,0.0d,0.0d,16.0d,3.0d,16.0),
            Block.createCuboidShape(0.0d,0.0d,0.0d,16.0d,4.0d,16.0),
            Block.createCuboidShape(0.0d,0.0d,0.0d,16.0d,5.0d,16.0),
            Block.createCuboidShape(0.0d,0.0d,0.0d,16.0d,6.0d,16.0),
            Block.createCuboidShape(0.0d,0.0d,0.0d,16.0d,7.0d,16.0),
            Block.createCuboidShape(0.0d,0.0d,0.0d,16.0d,8.0d,16.0),
            Block.createCuboidShape(0.0d,0.0d,0.0d,16.0d,9.0d,16.0),

    };

    public TomatoCropBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    public ItemConvertible getSeedsItem() {
        return this.Seeds;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return  AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }


}
