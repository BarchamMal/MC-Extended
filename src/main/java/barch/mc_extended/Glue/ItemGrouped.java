package barch.mc_extended.Glue;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;

public class ItemGrouped {

    public RegistryKey<ItemGroup> group = null;
    public Item item = null;
    public Block block = null;

    public ItemGrouped(RegistryKey<ItemGroup> group, Item item) {
        this.group = group;
        this.item = item;
    }

    public ItemGrouped(RegistryKey<ItemGroup> group, Block block) {
        this.group = group;
        this.block = block;
    }

    public Item getItem() {
        if (this.item != null) {
            return this.item;
        }
        return block.asItem();
    }

}
