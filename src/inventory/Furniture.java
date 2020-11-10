package inventory;

import store.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.0.1 2020-11-12
*
* The class Furniture gives a definition of furniture-type products
**/

public class Furniture extends Product {

    private String type;
    private int price;
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

    public Furniture(String manager, String type, int price, int height) {

        super(manager);

        this.type = type;
        this.price = price;
        this.height = height;

        Base.addProduct(this);
    }

    public String toString() {

        return getManager() + "_" + type + "_" + price + "_" + height + "_" +
        getClass().getSimpleName();
    }
}