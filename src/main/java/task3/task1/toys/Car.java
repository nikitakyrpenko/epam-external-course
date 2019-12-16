package task3.task1.toys;

import task3.task1.toys.abstracts.BoysToy;

import java.math.BigDecimal;

public class Car extends BoysToy {

    private String voice = "Wroom-Wroom";

    public Car(String color, BigDecimal price, Double weight) {
        super(color, price, weight);
    }

    @Override
    public String play() {
        return voice;
    }
}
