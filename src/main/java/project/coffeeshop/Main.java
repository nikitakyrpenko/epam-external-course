package project.coffeeshop;

import project.coffeeshop.model.CoffeeModel;
import project.coffeeshop.model.entities.Arabica;
import project.coffeeshop.model.entities.Coffee;
import project.coffeeshop.model.entities.Robusta;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Coffee arabica = new Arabica(10, Coffee.CoffeeQualities.HIGH, Coffee.CoffeeConditions.GRAIN, Coffee.CoffeeWrap.JAR);
        Coffee robusta = new Robusta(5, Coffee.CoffeeQualities.LOW, Coffee.CoffeeConditions.GRAIN, Coffee.CoffeeWrap.PACKET);

        Coffee[] coffees = new Coffee[]{robusta, arabica};

        CoffeeModel<Coffee> coffeeModel = new CoffeeModel<>(coffees);
        System.out.println(Arrays.toString(coffeeModel.getSortedByPriceVolumeRatio()));
    }
}
