package barch.mc_extended.Misc;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static barch.mc_extended.MCExtended.LOGGER;

public class PlantSpecimenItem extends Item {
    public PlantSpecimenItem(Settings settings) {
        super(settings);
    }

    private NbtCompound nbtCompound;


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        PlayerEntity playerEntity = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        ItemStack itemStack = context.getStack();

        nbtCompound = itemStack.getOrCreateNbt();

        BlockState blockState1 = readNbt(itemStack, nbtCompound);

        // it can only replace short grass
        if (world.getBlockState(blockPos).isOf(Blocks.SHORT_GRASS) && world.getBlockState(blockPos.down()).isIn(BlockTags.DIRT)) {

            // make sure the tag is a small flower.
            if (blockState1.isIn(BlockTags.SMALL_FLOWERS)) {
                // set the flower, swing hand, damage the itemstack
                context.getWorld().setBlockState(blockPos, blockState1);

                playerEntity.swingHand(context.getHand());

                itemStack.damage(1, playerEntity, (p) -> {
                    p.sendToolBreakStatus(context.getHand());
                });

                return ActionResult.CONSUME;
            }
            return ActionResult.FAIL;
        }

        if (blockState.isIn(BlockTags.SMALL_FLOWERS) && !blockState1.isIn(BlockTags.SMALL_FLOWERS)) {
            writeNbt(blockState, nbtCompound);

            return ActionResult.SUCCESS;
        }

        return ActionResult.FAIL;

    }

    private void writeNbt(BlockState blockState, NbtCompound nbt) {
        nbt.put("FlowerType", NbtHelper.fromBlockState(blockState));
    }

    private BlockState readNbt(ItemStack itemStack, NbtCompound nbt) {
        NbtCompound nbt1 = itemStack.getNbt();
        try {
            NbtCompound nbt2 = nbt.getCompound("FlowerType");
            return (Registries.BLOCK.get(Identifier.tryParse((nbt2.getString("Name")))).getDefaultState());
        }
        catch (CrashException var3) {
            return null;
        }
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.hasNbt()) {
            NbtCompound nbtCompound = stack.getNbt().getCompound("FlowerType");

            String string = nbtCompound.getString("Name");
            String string1 = "block." + Identifier.tryParse(string).toTranslationKey();

            // The tootip is the flower's translated name
            // Check if the name is empty
            if (!string1.contentEquals("block.minecraft.")) {
                tooltip.add(Text.translatable(string1, new Object[]{string}).formatted(Formatting.GREEN));
            }

        }

    }

}
