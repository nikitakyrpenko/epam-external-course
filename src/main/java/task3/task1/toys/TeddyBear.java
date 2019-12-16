package task3.task1.toys;

import task3.task1.toys.abstracts.GirlsToy;

import java.math.BigDecimal;

public class TeddyBear extends GirlsToy {

    private String voice = "Hug me";

    public TeddyBear(String color, BigDecimal price, Double weight) {
        super(color, price, weight);
    }

    @Override
    public String play() {
        return voice;
    }
}
