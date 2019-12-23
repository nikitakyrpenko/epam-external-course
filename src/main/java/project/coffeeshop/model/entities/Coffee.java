package project.coffeeshop.model.entities;

public  abstract  class Coffee {

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

    public abstract String getType();

    public double getPriceVolumeRatio(){
        return price / coffeeWrap.getTotalVolume();
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
            PACKET(10,1),
            JAR(15,3);

            private int coffeeVolume;
            private int wrapVolume;

             CoffeeWrap(int coffeeVolume, int wrapVolume){
                this.coffeeVolume = coffeeVolume;
                this.wrapVolume = wrapVolume;
            }

            public int getCoffeeVolume(){return coffeeVolume;}
            public int getWrapVolume(){return wrapVolume;}
            public int getTotalVolume(){return coffeeVolume + wrapVolume;}
        }
    }

