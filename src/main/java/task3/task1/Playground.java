package task3.task1;

import task3.task1.toys.abstracts.Toy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class Playground <T extends Toy> {

    private T[] toys;

    public Playground(T[] toys){
        this.toys = toys;
    }


    public BigDecimal getToysPrice(){
        BigDecimal price = new BigDecimal(0);
        for (T t: toys)
            price = price.add(t.getPrice());
        return price;
    }

    public T[] getToysSortedByPrice(){
        T[] copy = Arrays.copyOf(toys,toys.length);
        Arrays.sort(copy, new ToyPriceComparator());
        return copy;
    }

    public T[] getToysSortedByOwnerGender(){
        T[] copy = Arrays.copyOf(toys, toys.length);
        Arrays.sort(copy, new ToyGenderComparator());
        return copy;
    }
    public Toy[] getToysFilteredByPrice(BigDecimal price){
        int count = 0;
        for (T t : toys)
            if (t.getPrice().compareTo(price) > 0)
                count = count + 1;

        Toy[] result = new Toy[count];
        int innerCounter = 0;
        for (T t : toys)
            if (t.getPrice().compareTo(price) > 0)
                result[innerCounter++] = t;

        return result;
    }

    public Toy[] getToysFilteredByOwnerGender(String gender){
        int count = 0;
        for (T t : toys)
            if (t.getOwner().equals(gender))
                count = count + 1;

        Toy[] result = new Toy[count];
        int innerCounter = 0;
        for (T t : toys)
            if (t.getOwner().equals(gender))
                result[innerCounter++] = t;

        return result;
    }



    private class ToyPriceComparator implements Comparator<T>{
        @Override
        public int compare(T o1, T o2) {
            return o1.getPrice().compareTo(o2.getPrice());
        }
    }

    private class ToyGenderComparator implements Comparator<T>{
        @Override
        public int compare(T o1, T o2) {
            return o1.getOwner().compareTo(o2.getOwner());
        }
    }

}
