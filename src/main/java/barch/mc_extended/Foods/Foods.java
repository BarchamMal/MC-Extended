package barch.mc_extended.Foods;


public class Foods {

    public static void RegisterAll() {

        Mushrooms.RegisterItems();
        Mushrooms.GroupItems();

        Tomato.RegisterAll();
        Tomato.GroupItems();

        Onion.RegisterAll();
        Onion.GroupItems();

        Spinach.RegisterAll();
        Spinach.GroupItems();

        Cheese.RegisterAll();
        Cheese.GroupItems();

        Meats.RegisterAll();
        Meats.GroupItems();

        Specialty.RegisterAll();


    }

}
