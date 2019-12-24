package project.coffeeshop;


import project.coffeeshop.model.CoffeeModel;
import project.coffeeshop.model.entities.Arabica;
import project.coffeeshop.model.entities.Coffee;
import project.coffeeshop.model.entities.Robusta;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        Coffee arabica = new Arabica(10, Coffee.CoffeeQualities.HIGH, Coffee.CoffeeConditions.GRAIN, Coffee.CoffeeWrap.JAR);
        Coffee robusta = new Robusta(5, Coffee.CoffeeQualities.LOW, Coffee.CoffeeConditions.GRAIN, Coffee.CoffeeWrap.PACKET);

        CoffeeParser coffeeParser = new CoffeeParser(50,5.0);
        List<Coffee> coffees = coffeeParser.parse();
        System.out.println(new CoffeeModel<>(coffees).sortByPriceVolumeRatio());

    }
}
