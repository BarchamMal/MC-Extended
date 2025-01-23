package barch.mc_extended.Misc;

import net.barch.barch_lib.Items.ItemGroupItem;
import static barch.mc_extended.MCExtended.MCE_ITEM_GROUPER;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

import static barch.mc_extended.MCExtended.MC_EXTENDED;

public class MCExtendedSmithingTemplates {

    public static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = Identifier.of("item/empty_armor_slot_helmet");
    public static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = Identifier.of("item/empty_armor_slot_chestplate");
    public static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = Identifier.of("item/empty_armor_slot_leggings");
    public static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = Identifier.of("item/empty_armor_slot_boots");
    public static final Identifier EMPTY_SLOT_HOE_TEXTURE = Identifier.of("item/empty_slot_hoe");
    public static final Identifier EMPTY_SLOT_AXE_TEXTURE = Identifier.of("item/empty_slot_axe");
    public static final Identifier EMPTY_SLOT_SWORD_TEXTURE = Identifier.of("item/empty_slot_sword");
    public static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = Identifier.of("item/empty_slot_shovel");
    public static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = Identifier.of("item/empty_slot_pickaxe");
    public static final Identifier EMPTY_SLOT_INGOT_TEXTURE = Identifier.of("item/empty_slot_ingot");


    private static final Formatting TITLE_FORMATTING = Formatting.GRAY;
    private static final Formatting DESCRIPTION_FORMATTING = Formatting.BLUE;


//    private static final Text CORUNDUM_UPGRADE_TEXT = Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(MC_EXTENDED,"corundum_upgrade"))).formatted(TITLE_FORMATTING);
    private static final Text CORUNDUM_UPGRADE_APPLIES_TO_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(MC_EXTENDED,"smithing_template.corundum_upgrade.applies_to"))).formatted(DESCRIPTION_FORMATTING);
    private static final Text CORUNDUM_UPGRADE_INGREDIENTS_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(MC_EXTENDED,"smithing_template.corundum_upgrade.ingredients"))).formatted(DESCRIPTION_FORMATTING);
    private static final Text CORUNDUM_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(MC_EXTENDED,"smithing_template.corundum_upgrade.base_slot_description")));
    private static final Text CORUNDUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(MC_EXTENDED,"smithing_template.corundum_upgrade.additions_slot_description")));

    private static List<Identifier> getCorundumUpgradeEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
    }

    private static List<Identifier> getCorundumUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE);
    }




    public static final SmithingTemplateItem CORUNDUM_UPGRADE_SMITHING_TEMPLATE = new SmithingTemplateItem(
            CORUNDUM_UPGRADE_APPLIES_TO_TEXT,
            CORUNDUM_UPGRADE_INGREDIENTS_TEXT,
            CORUNDUM_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
            CORUNDUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
            getCorundumUpgradeEmptyBaseSlotTextures(),
            getCorundumUpgradeEmptyAdditionsSlotTextures(),
            new Item.Settings());

    public static void RegisterAll() {

        RegisterItems();
        GroupItems();

    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, Identifier.of(MC_EXTENDED, "corundum_upgrade_smithing_template"), CORUNDUM_UPGRADE_SMITHING_TEMPLATE);

    }

    public static void GroupItems() {

        MCE_ITEM_GROUPER.GroupItem(CORUNDUM_UPGRADE_SMITHING_TEMPLATE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)});

    }


}
