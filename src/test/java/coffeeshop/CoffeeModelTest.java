package coffeeshop;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import project.model.CoffeeModel;
import project.model.CoffeeTypes;
import project.model.entities.Arabica;
import project.model.entities.Coffee;
import project.model.entities.Liberica;
import project.model.entities.Robusta;

import java.util.Arrays;
import java.util.List;



public class CoffeeModelTest {


    private CoffeeModel<Coffee> coffeeModel;
    private List<Coffee> coffees =Arrays.asList(
            new Arabica(10, Coffee.CoffeeQualities.HIGH, Coffee.CoffeeConditions.GRAIN, Coffee.CoffeeWrap.JAR),
            new Arabica(10, Coffee.CoffeeQualities.LOW, Coffee.CoffeeConditions.GROUND, Coffee.CoffeeWrap.JAR),
            new Robusta(5, Coffee.CoffeeQualities.MIDDLE, Coffee.CoffeeConditions.GRAIN, Coffee.CoffeeWrap.PACKET),
            new Robusta(5, Coffee.CoffeeQualities.MIDDLE, Coffee.CoffeeConditions.GROUND, Coffee.CoffeeWrap.PACKET),
            new Liberica(2, Coffee.CoffeeQualities.LOW, Coffee.CoffeeConditions.INSTANT, Coffee.CoffeeWrap.PACKET));


    @Before
    public void init() {coffeeModel = new CoffeeModel<>(coffees);}

    @Test
    public void sortByPriceVolumeRatio(){
        List<Coffee> actual = coffeeModel.sortByPriceVolumeRatio();
        List<Coffee> expected = Arrays.asList(
                coffees.get(4),
                coffees.get(2),
                coffees.get(3),
                coffees.get(0),
                coffees.get(1)
        );

        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    public void filterByPriceMoreThanTest(){
        List<Coffee> actual = coffeeModel.filterByPriceMoreThen(5);
        List<Coffee> expected = Arrays.asList(
                coffees.get(0),
                coffees.get(1)
        );
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void filterByCoffeeSortTest(){
        List<Coffee> actual = coffeeModel.filterByCoffeeSort(CoffeeTypes.LIBERICA);
        List<Coffee> expected = Arrays.asList(
                coffees.get(4)
        );
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @After
    public void dest(){
        coffeeModel = null;
    }

}
