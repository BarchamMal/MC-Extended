package barch.mc_extended.Armor;


public class ArmorMaterials {

        public static final RubyArmorMaterial RUBY_ARMOR_MATERIAL = new RubyArmorMaterial();
        public static final SapphireArmorMaterial SAPPHIRE_ARMOR_MATERIAL = new SapphireArmorMaterial();
        public static final SilverArmorMaterial SILVER_ARMOR_MATERIAL = new SilverArmorMaterial();
        public static final BronzeArmorMaterial BRONZE_ARMOR_MATERIAL = new BronzeArmorMaterial();
        public static final CopperArmorMaterial COPPER_ARMOR_MATERIAL = new CopperArmorMaterial();
        public static final TinArmorMaterial TIN_ARMOR_MATERIAL = new TinArmorMaterial();
        public static final CorundumArmorMaterial CORUNDUM_ARMOR_MATERIAL = new CorundumArmorMaterial();
        public static void RegisterAll() {

            RUBY_ARMOR_MATERIAL.RegisterArmor();
            RUBY_ARMOR_MATERIAL.GroupArmor();
            SAPPHIRE_ARMOR_MATERIAL.RegisterArmor();
            SAPPHIRE_ARMOR_MATERIAL.GroupArmor();
            SILVER_ARMOR_MATERIAL.RegisterArmor();
            SILVER_ARMOR_MATERIAL.GroupArmor();
            BRONZE_ARMOR_MATERIAL.RegisterArmor();
            BRONZE_ARMOR_MATERIAL.GroupArmor();
            COPPER_ARMOR_MATERIAL.RegisterArmor();
            COPPER_ARMOR_MATERIAL.GroupArmor();
            TIN_ARMOR_MATERIAL.RegisterArmor();
            TIN_ARMOR_MATERIAL.GroupArmor();
            CORUNDUM_ARMOR_MATERIAL.RegisterArmor();
            CORUNDUM_ARMOR_MATERIAL.GroupArmor();


        };
}
