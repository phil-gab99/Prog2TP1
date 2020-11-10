package inventory;

import store.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.0.1 2020-11-12
*
* The class Food gives a definition of food-type products
**/

public class Food extends Product {

    private String name;
    private String color;
    private int weight;

    /*
    * The Food constructor serves to assign the traits specific for food-type
    * products
    *
    * @param name String indicating the food's name
    * @param color String indicating the food's color
    * @param weight Double indicating the food's weight
    **/

    public Food(String manager, String name, String color, int weight) {

        super(manager);

        this.name = name;
        this.color = color;
        this.weight = weight;

        Base.addProduct(this);
    }

    public String toString() {

        return getManager() + "_" + name + "_" + color + "_" + weight + "_" +
        getClass().getSimpleName();
    }
}