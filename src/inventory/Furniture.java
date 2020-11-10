package inventory;

import store.Base;

/**
* @author Philippe Gabriel
* @version 1.2.0 2020-11-12
*
* The class Furniture gives a definition of furniture-type products
***/

public class Furniture extends Product {

    private String type; //String indicating furniture's type
    private int price;   //Integer indicating furniture's price
    private int height;  //Integer indicating furniture's height

    /**
    * The constructor method Furniture serves to assign the traits specific for
    * furniture-type products
    *
    * @param manager String indicating manager who enlisted this furniture
    * @param type String indicating the furniture's type
    * @param price Integer indicating the furniture's price
    * @param height Integer indicating the furniture's height
    ***/

    public Furniture(String manager, String type, int price, int height) {

        super(manager);

        this.type = type;
        this.price = price;
        this.height = height;

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

        return getManager() + "_" + type + "_" + price + "_" + height + "_" +
        getClass().getSimpleName();
    }
}