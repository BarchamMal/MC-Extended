package barch.mc_extended.Foods;


public class Foods {

    public static final Foods INSTANCE = new Foods();


    public static final Mushrooms MUSHROOMS = Mushrooms.INSTANCE;
    public static final Cheese CHEESE = Cheese.INSTANCE;
    public static final Tomato TOMATO = Tomato.INSTANCE;
    public static final Onion ONION = Onion.INSTANCE;
    public static final Meats MEATS = Meats.INSTANCE;
    public static final Spinach SPINACH = Spinach.INSTANCE;
    public static final Specialty SPECIALTY = Specialty.INSTANCE;


    public static void RegisterAll() {


        // register the mushrooms
        MUSHROOMS.RegisterItems();
        MUSHROOMS.GroupItems();

        // register the tomato stuff
        TOMATO.RegisterAll();
        TOMATO.GroupItems();

        // register the onion stuff
        ONION.RegisterAll();
        ONION.GroupItems();

        // register the spinach stuff
        SPINACH.RegisterAll();
        SPINACH.GroupItems();

        // register cheese
        CHEESE.RegisterAll();
        CHEESE.GroupItems();

        // register meats
        MEATS.RegisterAll();
        MEATS.GroupItems();

        // register specialty
        SPECIALTY.RegisterAll();


    }

}
