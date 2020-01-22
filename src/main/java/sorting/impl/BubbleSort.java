package sorting.impl;

import sorting.Sort;

public class BubbleSort<T extends Comparable> implements Sort {

    @Override
    public void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0){
                    Sort.exchange(array, j, j + 1);
                }
            }
        }
    }
}
