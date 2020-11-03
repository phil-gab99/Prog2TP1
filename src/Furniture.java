public class Furniture {

    private String type;
    private double price;
    private int height;

    public Furniture(String manager, String type, double price, int height) {

        super(manager);

        this.type = type;
        this.price = price;
        this.height = height;
    }
}