package barch.mc_extended.Blocks;

import net.minecraft.block.CropBlock;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import static barch.mc_extended.MCExtended.LOGGER;

public class ModdedCropBlock extends CropBlock {

    String seedItem;

    public ModdedCropBlock(Settings settings, @NotNull String seed) {
        super(settings);
        this.seedItem = seed;
    }

    public Item getSeedsItem() {
        return Registries.ITEM.get(Identifier.tryParse(seedItem));
    }
}
