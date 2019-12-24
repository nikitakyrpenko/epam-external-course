package project.coffeeshop.model.entities;

public class Arabica extends Coffee {

    private String type;

    public Arabica(long price, CoffeeQualities coffeeQualities, CoffeeConditions coffeeConditions, CoffeeWrap coffeeWrap) {
        super(price, coffeeQualities, coffeeConditions, coffeeWrap);
        this.type = "Arabica";
    }

    @Override
    public final String getType() { return type; }

    @Override
    public String toString(){
        return super.toString() + ", coffeeType=" + type +
                "}\n";
    }
}
