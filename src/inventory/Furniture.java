package inventory;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.0.1 2020-11-12
*
* The class Furniture gives a definition of furniture-type products
**/

public class Furniture extends Product {

    private String type;
    private double price;
    private int height;

    /*
    * The Furniture constructor serves to assign the traits specific for
    * furniture-type products
    *
    * @param type String representing the category of furniture in which this
    * instance belongs
    * @param price Double indicating the furniture's price
    * @param height Integer indicating the furniture's height
    **/

    public Furniture(String manager, String type, double price, int height) {

        super(manager);

        this.type = type;
        this.price = price;
        this.height = height;
    }

    /*
    * toString method implemented which returns the type of furniture, it's price,
    * it's height (in cm) and the manager which added it to the list.
    *
     */
    public String toString() {

        String temp = "C'est un meuble de type : " + type + "\n qui coute : " + price
                + "$\n de taille : " + height + "cm\n qui a été rentré par : " + getManager();


        return temp;
    }
}