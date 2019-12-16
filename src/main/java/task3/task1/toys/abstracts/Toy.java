package task3.task1.toys.abstracts;

import java.math.BigDecimal;

public abstract class Toy {

    private String color;
    private BigDecimal price;
    private Double weight;

    public Toy(String color, BigDecimal price, Double weight) {
        this.color = color;
        this.price = price;
        this.weight = weight;
    }

    public abstract String play();
    public abstract String getOwner();

    public String getColor(){return color;}
    public BigDecimal getPrice(){return price;}
    public Double getWeight(){return weight;}




}
