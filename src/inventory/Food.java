package inventory;

import store.Base;

/**
* @author Philippe Gabriel
* @version 1.2.0 2020-11-12
*
* The class Food gives a definition of food-type products
***/

public class Food extends Product {

    private String name;  //String indicating food's name
    private String color; //String indicating food's color
    private int weight;   //Integer indicating food's height

    /**
    * The constructor method Food serves to assign the traits specific for
    * food-type products
    *
    * @param manager String indicating manager who enlisted this food
    * @param name String indicating the food's name
    * @param color String indicating the food's color
    * @param weight Double indicating the food's weight
    ***/

    public Food(String manager, String name, String color, int weight) {

        super(manager);

        this.name = name;
        this.color = color;
        this.weight = weight;

        //The created furniture is registered in the temporary database
        Base.addProduct(this);
    }

    /**
    * The method toString converts the furniture's information into its String
    * implementation that will be displayed to the user
    *
    * @return String representing the String implementation
    ***/

    public String toString() {

        return getManager() + "_" + name + "_" + color + "_" + weight + "_" +
        getClass().getSimpleName();
    }
}