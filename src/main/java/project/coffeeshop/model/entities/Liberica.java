package project.coffeeshop.model.entities;

import project.coffeeshop.model.CoffeeTypes;

public class Liberica extends Coffee{

    private CoffeeTypes type;

    public Liberica(long price, CoffeeQualities coffeeQualities, CoffeeConditions coffeeConditions, CoffeeWrap coffeeWrap) {
        super(price, coffeeQualities, coffeeConditions, coffeeWrap);
        this.type = CoffeeTypes.LIBERICA;
    }

    @Override
    public final CoffeeTypes getType() { return type; }

    @Override
    public String toString(){
        return super.toString() + ", coffeeType=" + type +
                "}\n";
    }
}
