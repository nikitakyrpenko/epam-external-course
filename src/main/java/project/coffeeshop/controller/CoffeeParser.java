package project.coffeeshop.controller;
import static project.coffeeshop.util.Utils.*;

import project.coffeeshop.model.CoffeeTypes;
import project.coffeeshop.model.entities.Arabica;
import project.coffeeshop.model.entities.Coffee;
import project.coffeeshop.model.entities.Liberica;
import project.coffeeshop.model.entities.Robusta;

import java.util.ArrayList;
import java.util.List;

public class CoffeeParser {

    private long availableCosts;
    private double availableVolume;
    private long expenses;
    private double usedVolume;


    public CoffeeParser(long moneys, double volume){
        this.availableCosts = moneys;
        this.availableVolume = volume;
    }



    public List<Coffee> parse(){
        List<Coffee> result = new ArrayList<>();
        generate:
            for (;;){
                int i = pickRandom(CoffeeTypes.values().length);
                Coffee coffee = getCoffeeByRandomChoice(i);
                if (hasFreeMoneyAndVolume(coffee)){
                    this.expenses = this.expenses + coffee.getPrice();
                    this.usedVolume = this.usedVolume + coffee.getCoffeeWrap().getTotalVolume();
                    result.add(coffee);
                }else break generate;

            }
            return result;
    }

    private boolean hasFreeMoneyAndVolume(Coffee coffee){
        if (this.expenses + coffee.getPrice() <= availableCosts &&
                this.usedVolume + coffee.getCoffeeWrap().getTotalVolume() <= availableVolume)
            return true;
        return false;
    }



    private Coffee getCoffeeByRandomChoice(int i){
        Coffee coffee = null;
        switch (i){
            case 0:
                coffee = new Arabica(10,
                        getRandomEnumValue(Coffee.CoffeeQualities.class),
                        getRandomEnumValue(Coffee.CoffeeConditions.class),
                        getRandomEnumValue(Coffee.CoffeeWrap.class));
                break;
            case 1:
                coffee = new Robusta(5,
                        getRandomEnumValue(Coffee.CoffeeQualities.class),
                        getRandomEnumValue(Coffee.CoffeeConditions.class),
                        getRandomEnumValue(Coffee.CoffeeWrap.class));
                break;
            case 2:
                coffee = new Liberica(2,
                        getRandomEnumValue(Coffee.CoffeeQualities.class),
                        getRandomEnumValue(Coffee.CoffeeConditions.class),
                        getRandomEnumValue(Coffee.CoffeeWrap.class));
                break;
        }
        return coffee;
    }

}
