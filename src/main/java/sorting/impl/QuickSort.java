package sorting.impl;


import sorting.Sort;

public class QuickSort<T extends Comparable> implements Sort {

    @Override
    public void sort(Comparable[] array) {
        int lo = 0;
        int hi = array.length - 1;
        quicksort(array, lo, hi);
    }

    private  void quicksort(Comparable[] array, int lo, int hi){
        if (lo < hi) {
            int partition = partition(array, lo, hi);
            quicksort(array, lo, partition - 1);
            quicksort(array, partition + 1, hi);
        }
    }

    private int partition(Comparable[] array, int lo, int hi){
        Comparable pivot = array[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++){
            if (array[j].compareTo(pivot) < 0){
                Sort.exchange(array, ++i, j);
            }
        }
        Sort.exchange(array, ++i, hi);
        return i;

    }
}
