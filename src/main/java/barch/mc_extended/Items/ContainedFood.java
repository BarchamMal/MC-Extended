package barch.mc_extended.Items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainedFood extends Item {
    private final Item giveBack;

    public ContainedFood(Settings settings, Item giveBack) {
        super(settings);
        this.giveBack = giveBack;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        if (user instanceof PlayerEntity && ((PlayerEntity)user).getAbilities().creativeMode) {
            return itemStack;
        }


        if (itemStack.getCount() < 1) {
            return new ItemStack(this.giveBack);
        }

        if (user instanceof PlayerEntity player && !player.getInventory().insertStack(this.giveBack.getDefaultStack())) {
            player.dropItem(this.giveBack.getDefaultStack(), false);
        }

        return itemStack;
    }
}
