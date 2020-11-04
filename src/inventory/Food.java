package inventory;

import java.awt.Color;

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
    private double weight;

    /*
    * The Food constructor serves to assign the traits specific for food-type
    * products
    *
    * @param name String indicating the fruit's name
    * @param color Color indicating the fruit's color
    * @param weight Double indicating the fruit's weight
    **/

    public Food(String manager, String name, String color, double weight) {

        super(manager);

        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    /*
     * toString method implemented which returns the name of the food, it's color,
     * it's weight in cm and it's weight.
     *
     */

    public String toString() {

        String temp = "Nom : " + name + "\ncouleur : " + color
                + "\nde poids : " + weight + "lbs\nqui a été rentré par : " + getManager();


        return temp;
    }
}