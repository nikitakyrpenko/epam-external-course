package homework2.sorts;

import java.util.Arrays;

public class Sorts {

    public static<T extends Comparable> void quicksort(T[] a){
        Arrays.stream(a).anyMatch("A"::equals);
        int lo = 0;
        int hi = a.length - 1;
        quicksort(a, lo, hi);
    }

    public static <T extends Comparable> void mergesort(T[] a){
        int lo = 0;
        int hi = a.length - 1;
        mergesort(a, lo, hi);
    }

    public static<T extends Comparable> void bubblesort(T[] a){
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length - i - 1; j++){
                if (a[j].compareTo(a[j + 1]) > 0){
                    exchange(a, j, j + 1);
                }
            }
        }
    }


    private static void quicksort(Comparable[] a, int lo, int hi){
        if (lo < hi) {
            int partition = partition(a, lo, hi);
            quicksort(a, lo, partition - 1);
            quicksort(a, partition + 1, hi);
        }
    }

    private static void mergesort(Comparable[] a, int lo, int hi){
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            mergesort(a, lo, mid);
            mergesort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }
    }

    private static int partition(Comparable[] a, int lo, int hi){
        Comparable pivot = a[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++){
            if (a[j].compareTo(pivot) < 0){
                exchange(a, ++i, j);
            }
        }
        exchange(a, ++i, hi);
        return i;

    }

    private static void exchange(Comparable[] arr, int a, int b){
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi){
        Comparable[] temp = new Comparable[a.length];
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <=hi; k++){
            temp[k] = a[k];
        }
        for (int k = lo; k <= hi; k++){
           if (i > mid) {a[k] = temp[j++];}
           else if (j > hi) {a[k] = temp[i++];}
           else if (temp[i].compareTo(temp[j]) > 0) {a[k] = temp[j++];}
           else {a[k] = temp[i++];}
        }
    }


    public static void main(String[] args) {
        Comparable[] array = {137,1,52,17,4};
        mergesort(array);
        System.out.println(Arrays.toString(array));
    }
}
