package barch.mc_extended.Items;

import barch.mc_extended.MCExtended;
import barch.mc_extended.Tags;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class Tools {

    public static class EnumToolMaterial {
        
        public ToolMaterial toolMaterial;
        public MCExtended.Type type;

        public EnumToolMaterial(TagKey<Block> tagKey, int durability, float speed, float attack_damage, int enchantment_value, TagKey<Item> tagKey2, MCExtended.Type type) {
            this.toolMaterial = new ToolMaterial(tagKey, durability, speed, attack_damage, enchantment_value, tagKey2);
            this.type = type;
        }
    }

    public static final EnumToolMaterial BRONZE_TD = new EnumToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            230,
            5.5f,
            0,
            15,
            Tags.ItemTags.BRONZE_REPAIRS,
            MCExtended.Type.BRONZE
    );

    public static final EnumToolMaterial COPPER_TD = new EnumToolMaterial(
            BlockTags.INCORRECT_FOR_STONE_TOOL,
            150,
            5.0f,
            0,
            15,
            Tags.ItemTags.COPPER_REPAIRS,
            MCExtended.Type.COPPER
    );

    public static final EnumToolMaterial CORUNDUM_TD = new EnumToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2800,
            11.5f,
            0,
            5,
            Tags.ItemTags.CORUNDUM_REPAIRS,
            MCExtended.Type.CORUNDUM
    );

    public static final EnumToolMaterial RUBY_TD = new EnumToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1561,
            8.0f,
            0,
            15,
            Tags.ItemTags.RUBY_REPAIRS,
            MCExtended.Type.RUBY
    );

    public static final EnumToolMaterial SAPPHIRE_TD = new EnumToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1561,
            8.0f,
            0,
            15,
            Tags.ItemTags.SAPPHIRE_REPAIRS,
            MCExtended.Type.SAPPHIRE
    );
    
    public static final EnumToolMaterial SILVER_TD = new EnumToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            56,
            11.5f,
            0,
            20,
            Tags.ItemTags.SILVER_REPAIRS,
            MCExtended.Type.SILVER
    );

    public static final EnumToolMaterial TIN_TD = new EnumToolMaterial(
            BlockTags.INCORRECT_FOR_STONE_TOOL,
            150,
            5.0f,
            0,
            5,
            Tags.ItemTags.TIN_REPAIRS,
            MCExtended.Type.TIN
    );

    public enum TlType {
        AXE,
        HOE,
        PICKAXE,
        SHOVEL,
        SWORD
    }
    
}
