package barch.mc_extended.Minerals;



public class Minerals {

    public static final Minerals INSTANCE = new Minerals();
    public static final Ruby RUBY = new Ruby();
    public static final Sapphire SAPPHIRE = new Sapphire();
    public static final Silver SILVER = new Silver();
    public static final Bronze BRONZE = new Bronze();
    public static final Tin TIN = new Tin();
    public static final Corundum CORUNDUM = new Corundum();

    public static void RegisterAll() {

        RUBY.RegisterAll();
        SAPPHIRE.RegisterAll();
        SILVER.RegisterAll();
        BRONZE.RegisterAll();
        TIN.RegisterAll();
        CORUNDUM.RegisterAll();

    };

}
