package inventory;

import java.awt.Color;

public class Food extends Product {

    private String name;
    private Color color;
    private double weight;

    public Food(String manager, String name, Color color, double weight) {

        super(manager);

        this.name = name;
        this.color = color;
        this.weight = weight;
    }
}