package project.model.entities;

import project.model.CoffeeTypes;

public class Arabica extends Coffee {

    private CoffeeTypes type;

    public Arabica(long price, CoffeeQualities coffeeQualities, CoffeeConditions coffeeConditions, CoffeeWrap coffeeWrap) {
        super(price, coffeeQualities, coffeeConditions, coffeeWrap);
        this.type = CoffeeTypes.ARABICA;
    }

    @Override
    public final CoffeeTypes getType() { return type; }

    @Override
    public String toString(){
        return super.toString() + ", coffeeType=" + type +
                "}\n";
    }
}
