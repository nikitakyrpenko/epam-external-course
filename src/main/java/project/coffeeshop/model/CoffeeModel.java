package project.coffeeshop.model;

import project.coffeeshop.model.entities.Coffee;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class CoffeeModel<T extends Coffee> {

    T[] coffees;

    public CoffeeModel(T[] coffees){
        this.coffees = coffees;
    }


    public T[] getSortedByPriceVolumeRatio(){
        T[] copy = Arrays.copyOf(coffees, coffees.length);
        Arrays.sort(copy, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return (int) (o1.getPriceVolumeRatio() - o2.getPriceVolumeRatio());
            }
        });
        return copy;
    }





}
