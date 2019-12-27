package project.coffeeshop.model.entities;

import project.coffeeshop.model.CoffeeTypes;

public  abstract  class Coffee implements ComparableRatio{

    private long price;
    private CoffeeQualities coffeeQuality;
    private CoffeeConditions coffeeCondition;
    private CoffeeWrap coffeeWrap;

    public Coffee (long price, CoffeeQualities coffeeQualities, CoffeeConditions coffeeConditions, CoffeeWrap coffeeWrap){
        this.price = price;
        this.coffeeCondition = coffeeConditions;
        this.coffeeQuality = coffeeQualities;
        this.coffeeWrap = coffeeWrap;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "price=" + price +
                ", coffeeQuality=" + coffeeQuality +
                ", coffeeCondition=" + coffeeCondition +
                ", coffeeWrap=" + coffeeWrap;
    }

    public abstract CoffeeTypes getType();

    public long getPrice(){ return price;}

    public CoffeeWrap getCoffeeWrap() { return coffeeWrap; }


    @Override
    public double computeRatio() {
        return this.price / this.coffeeWrap.getTotalVolume();
    }

    public enum CoffeeConditions{
            GRAIN,
            GROUND,
            INSTANT;
        }

        public enum CoffeeQualities{
            PREMIUM,
            HIGH,
            MIDDLE,
            LOW;
        }

        public enum CoffeeWrap{
            PACKET(0.2,0.05),
            JAR(0.3,0.1);

            private double coffeeVolume;
            private double wrapVolume;

             CoffeeWrap(double coffeeVolume, double wrapVolume){
                this.coffeeVolume = coffeeVolume;
                this.wrapVolume = wrapVolume;
            }
            public double getTotalVolume(){return coffeeVolume + wrapVolume;}
        }


}

