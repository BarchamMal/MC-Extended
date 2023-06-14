package barch.mc_extended.Minerals;


public class Minerals {

    public static final Minerals INSTANCE = new Minerals();

    public static final Ruby RUBY = new Ruby();
    public static final Silver SILVER = new Silver();
    public static final Bronze BRONZE = new Bronze();
    public static final Tin TIN = new Tin();

    public static void RegisterAll() {

        RUBY.RegisterAll();
        SILVER.RegisterAll();
        BRONZE.RegisterAll();
        TIN.RegisterAll();


    };

}
