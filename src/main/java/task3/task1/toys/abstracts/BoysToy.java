package task3.task1.toys.abstracts;

import java.math.BigDecimal;

public abstract class BoysToy extends Toy {

    private  String owner = "boy";

        public BoysToy(String color, BigDecimal price, Double weight){
            super(color, price, weight);
        }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return String.format("%s, color= %s; price= %s; weight= %s; my owner is= %s; i`m saying= %s\n",
                this.getClass().getSimpleName(),
                getColor(),
                getPrice(),
                getWeight(),
                getOwner(),
                play());
    }
}
