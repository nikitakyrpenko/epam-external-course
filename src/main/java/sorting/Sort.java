package sorting;

public interface Sort<T extends Comparable> {

     static void exchange(Comparable[] arr, int a, int b){
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    void sort(T[] t);
}
