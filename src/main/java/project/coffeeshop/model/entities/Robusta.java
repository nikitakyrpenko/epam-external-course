package project.coffeeshop.model.entities;

import project.coffeeshop.model.CoffeeTypes;

public class Robusta extends Coffee {

    private CoffeeTypes type;

    public Robusta(long price, CoffeeQualities coffeeQualities, CoffeeConditions coffeeConditions, CoffeeWrap coffeeWrap) {
        super(price, coffeeQualities, coffeeConditions, coffeeWrap);
        this.type = CoffeeTypes.ROBUSTA;
    }

    @Override
    public CoffeeTypes getType() { return type; }

    @Override
    public String toString(){
        return super.toString() + ", coffeeType=" + type +
                "}\n";
    }
}
