package barch.mc_extended.Foods;


public class Foods {

    public static final Foods INSTANCE = new Foods();


    public static final Mushrooms MUSHROOMS = new Mushrooms();
    public static final Cheese CHEESE = new Cheese();
    public static final Tomato TOMATO = new Tomato();


    public static void RegisterAll() {


        // register the mushrooms
        MUSHROOMS.RegisterItems();
        MUSHROOMS.GroupItems();

        // register the tomato stuff
        TOMATO.RegisterAll();
        TOMATO.GroupItems();

        // register cheese
        CHEESE.RegisterAll();
        CHEESE.GroupItems();

    }

}
