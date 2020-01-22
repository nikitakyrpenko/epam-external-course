package sorting;


import sorting.impl.BubbleSort;
import sorting.impl.MergeSort;
import sorting.impl.QuickSort;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;


public class SortsTest {

    private Sort<Comparable> sort;

    private final Comparable[] expectedIntegerArray = {1,4,17,52,137};
    private final Comparable[] expectedStringArray = {"e","l","m","o","p","r","s","t","z"};
    private final Comparable[] expectedEmptyArray = {};


   @Test
    public void bubbleSortOfIntegersArrayShouldReturnSortedArray(){
       Comparable[] array = {137,1,52,17,4};
       sort = new BubbleSort<>();
       sort.sort(array);
       assertArrayEquals(expectedIntegerArray, array);
   }

   @Test
    public void bubbleSortOfStringArrayShouldReturnSortedArray(){
       Comparable[] array = {"s","o","r","t","m","e","p","l","z"};
       sort = new BubbleSort<>();
       sort.sort(array);
       assertArrayEquals(expectedStringArray, array);
   }

   @Test
    public void bubbleSortOfEmptyArrayShouldReturnEmptyArray(){
       Comparable[] array = {};
       sort = new BubbleSort<>();
       sort.sort(array);
       assertArrayEquals(expectedEmptyArray, array);
   }

    @Test
    public void quickSortOfIntegersArrayShouldReturnSortedArray(){
        Comparable[] array = {137,1,52,17,4};
        sort = new QuickSort<>();
        sort.sort(array);
        assertArrayEquals(expectedIntegerArray, array);
    }

    @Test
    public void quickSortOfStringArrayShouldReturnSortedArray(){
        Comparable[] array = {"s","o","r","t","m","e","p","l","z"};
        sort = new QuickSort<>();
        sort.sort(array);
        assertArrayEquals(expectedStringArray, array);
    }

    @Test
    public void quickSortOfEmptyArrayShouldReturnEmptyArray(){
        Comparable[] array = {};
        sort = new QuickSort<>();
        sort.sort(array);
        assertArrayEquals(expectedEmptyArray, array);
    }

    @Test
    public void mergeSortOfIntegersArrayShouldReturnSortedArray(){
        Comparable[] array = {137,1,52,17,4};
        sort = new MergeSort<>();
        sort.sort(array);
        assertArrayEquals(expectedIntegerArray, array);
    }

    @Test
    public void mergeSortOfStringArrayShouldReturnSortedArray(){
        Comparable[] array = {"s","o","r","t","m","e","p","l","z"};
        sort = new MergeSort<>();
        sort.sort(array);
        assertArrayEquals(expectedStringArray, array);
    }

    @Test
    public void mergeSortOfEmptyArrayShouldReturnEmptyArray(){
        Comparable[] array = {};
        sort = new MergeSort<>();
        sort.sort(array);
        assertArrayEquals(expectedEmptyArray, array);
    }

}
