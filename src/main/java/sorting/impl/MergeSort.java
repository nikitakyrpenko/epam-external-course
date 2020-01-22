package sorting.impl;

import sorting.Sort;

public class MergeSort<T extends Comparable> implements Sort {
    @Override
    public void sort(Comparable[] array) {
        int lo = 0;
        int hi = array.length - 1;
        mergesort(array, lo, hi);
    }

    private  void mergesort(Comparable[] array, int lo, int hi){
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            mergesort(array, lo, mid);
            mergesort(array, mid + 1, hi);
            merge(array, lo, mid, hi);
        }
    }

    private void merge(Comparable[] array, int lo, int mid, int hi){
        Comparable[] temp = new Comparable[array.length];
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <=hi; k++){
            temp[k] = array[k];
        }
        for (int k = lo; k <= hi; k++){
            if (i > mid) {array[k] = temp[j++];}
            else if (j > hi) {array[k] = temp[i++];}
            else if (temp[i].compareTo(temp[j]) > 0) {array[k] = temp[j++];}
            else {array[k] = temp[i++];}
        }
    }
}
