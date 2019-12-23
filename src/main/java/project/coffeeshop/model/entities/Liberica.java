package project.coffeeshop.model.entities;

public class Liberica extends Coffee{

    private String type;

    public Liberica(long price, CoffeeQualities coffeeQualities, CoffeeConditions coffeeConditions, CoffeeWrap coffeeWrap) {
        super(price, coffeeQualities, coffeeConditions, coffeeWrap);
        this.type = "Liberica";
    }

    @Override
    public final String getType() { return type; }

    @Override
    public String toString(){
        return super.toString() + ", coffeeType=" + type +
                '}';
    }
}
