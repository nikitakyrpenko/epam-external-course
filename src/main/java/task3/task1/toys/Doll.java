package task3.task1.toys;

import task3.task1.toys.abstracts.GirlsToy;

import java.math.BigDecimal;

public class Doll extends GirlsToy {

    private String voice = "Play with me";

    public Doll(String color, BigDecimal price, Double weight){
        super(color, price, weight);
    }

    @Override
    public String play() {
        return voice;
    }


}
