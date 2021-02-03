import exceptions.RestaurantException;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {


        //TODO: Create an instance of the RestaurantAdministration class
        Administration admin = new Administration();

        //TODO: Add the waiter Jan Joyful, with a salary of 2200. He is certified
        //TODO: Add the waiter Ruud Ridiculous, with a salary of 1800. He is not certified.
        //TODO: Add the cook Bram Buffalo, with a salary of 2800, to the system.

        //TODO: Add the cook Faisan Fish, with a salary of 2900

        try{
            admin.addWaiter("Jan", 2200,true);
            admin.addWaiter("ruud",1800,false);
            admin.addCook("Faisan",2900);
            admin.addCook("Bram",2800);
        } catch (RestaurantException e) {
            System.out.println(e);
        }


        /**
         * TODO: Add the following dishes to cook Bram Buffalo
         * The dish Cheese Burger XXL, with a price of 13.95 and the category Burgers (mind the capital letter)
         * The dish Steak, with a price of 10.95 and the category Meat
         *
         */
        try{
            admin.addDishForCook("Bram","Cheese Burger XXL",13.95, "Burgers");
            admin.addDishForCook("Bram","Steak",10.95,"Meat");
        } catch (RestaurantException e) {
            System.out.println(e);
        }


        //TODO: Read the dishes for Faisan from the file dishes_faisan.json
        try {
            admin.loadFile("dishes_faisan.json");
        } catch (RestaurantException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TODO: Print the restaurant administration (Using toString from your RestaurantAdministration)
        System.out.println(admin.toString());

        //TODO: Print the most expensive dish
        System.out.println(admin.getMostExpensiveDish());

    }
}
