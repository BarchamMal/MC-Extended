package barch.mc_extended.Items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Consumer;

import static barch.mc_extended.Registry.ModComponents.FLOWER_COMPONENT_TYPE;

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

        BlockState blockState1 = readNbt(itemStack);

        // it can only replace short grass
        if (world.getBlockState(blockPos).isOf(Blocks.SHORT_GRASS) && world.getBlockState(blockPos.down()).isIn(BlockTags.DIRT)) {

            // make sure the tag is a small flower.
            if (blockState1.isIn(BlockTags.SMALL_FLOWERS)) {
                // set the flower, swing hand, damage the itemstack
                context.getWorld().setBlockState(blockPos, blockState1);

                playerEntity.swingHand(context.getHand());

                itemStack.damage(1, playerEntity, EquipmentSlot.MAINHAND);

                return ActionResult.CONSUME;
            }
            return ActionResult.FAIL;
        }

        if (blockState.isIn(BlockTags.SMALL_FLOWERS) && !blockState1.isIn(BlockTags.SMALL_FLOWERS)) {
            writeNbt(blockState, itemStack);

            return ActionResult.SUCCESS;
        }

        return ActionResult.FAIL;

    }

    private ItemStack writeNbt(BlockState blockState, ItemStack itemStack) {
        itemStack.set(FLOWER_COMPONENT_TYPE, Registries.BLOCK.getId(blockState.getBlock()).toString());
        return itemStack;
    }

    private BlockState readNbt(ItemStack itemStack) {
        if (itemStack.get(FLOWER_COMPONENT_TYPE) != null) {
            String flowerName = itemStack.get(FLOWER_COMPONENT_TYPE);
            return Registries.BLOCK.get(Identifier.tryParse((flowerName))).getDefaultState();
        }
        return Blocks.AIR.getDefaultState();
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        if (stack.get(FLOWER_COMPONENT_TYPE) != null) {
            String flowerName = stack.get(FLOWER_COMPONENT_TYPE);

            String string = "block." + Identifier.tryParse(flowerName).toTranslationKey();

            // The tooltip is the flower's translated name
            // Check if the name is not empty before adding the tooltip
            if (!string.contentEquals("block.minecraft.")) {
                textConsumer.accept(Text.translatable(string, new Object[]{string}).formatted(Formatting.GREEN));
            }

        }
    }
}
