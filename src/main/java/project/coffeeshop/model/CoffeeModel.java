package project.coffeeshop.model;

import project.coffeeshop.model.entities.Coffee;

import java.util.*;


public class CoffeeModel<T extends Coffee> {

    List<T> coffees;

    public CoffeeModel(List<T> coffees){
        this.coffees = coffees;
    }

    public List<T> sortByPriceVolumeRatio(){
       List<T> copy = new ArrayList<>(coffees);
       Collections.sort(copy, new Comparator<T>() {
           @Override
           public int compare(T o1, T o2) {
               return (int) (o1.getPriceVolumeRatio() - o2.getPriceVolumeRatio());
           }
       });
       return copy;
    }

    public List<T> filterByPriceMoreThen(long price){
        List<T> result = new ArrayList<>();
        for(T t : coffees)
            if (t.getPrice() > price)
                result.add(t);
         return result;
    }
    public List<T> filterByCoffeeSort(CoffeeTypes type){
        List<T> result = new ArrayList<>();
        for (T t : coffees)
            if (t.getType().equals(type))
                result.add(t);
        return result;
    }



    public List<T> getCoffees() {
        return coffees;
    }
}
