package barch.mc_extended.Tools;

public class ToolMaterials {

    public static final ToolMaterials INSTANCE = new ToolMaterials();

    public static final RubyToolMaterial RUBY_TOOL_MATERIAL = new RubyToolMaterial();
    public static final SapphireToolMaterial SAPPHIRE_TOOL_MATERIAL = new SapphireToolMaterial();
    public static final SilverToolMaterial SILVER_TOOL_MATERIAL = new SilverToolMaterial();
    public static final BronzeToolMaterial BRONZE_TOOL_MATERIAL = new BronzeToolMaterial();
    public static final CopperToolMaterial COPPER_TOOL_MATERIAL = new CopperToolMaterial();
    public static final TinToolMaterial TIN_TOOL_MATERIAL = new TinToolMaterial();
    public static final CorundumToolMaterial CORUNDUM_TOOL_MATERIAL = new CorundumToolMaterial();

    public static void RegisterAll() {

        RUBY_TOOL_MATERIAL.RegisterTools();
        RUBY_TOOL_MATERIAL.GroupTools();
        SAPPHIRE_TOOL_MATERIAL.RegisterTools();
        SAPPHIRE_TOOL_MATERIAL.GroupTools();
        SILVER_TOOL_MATERIAL.RegisterTools();
        SILVER_TOOL_MATERIAL.GroupTools();
        BRONZE_TOOL_MATERIAL.RegisterTools();
        BRONZE_TOOL_MATERIAL.GroupTools();
        COPPER_TOOL_MATERIAL.RegisterTools();
        COPPER_TOOL_MATERIAL.GroupTools();
        TIN_TOOL_MATERIAL.RegisterTools();
        TIN_TOOL_MATERIAL.GroupTools();
        CORUNDUM_TOOL_MATERIAL.RegisterTools();
        CORUNDUM_TOOL_MATERIAL.GroupTools();

    };

}
