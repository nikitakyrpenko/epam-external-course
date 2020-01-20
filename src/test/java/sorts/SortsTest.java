package sorts;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static homework2.sorts.Sorts.*;

public class SortsTest {



    private final Comparable[] expectedIntegerArray = {1,4,17,52,137};
    private final Comparable[] expectedStringArray = {"e","l","m","o","p","r","s","t","z"};
    private final Comparable[] expectedEmptyArray = {};


   @Test
    public void bubbleSortOfIntegersArrayShouldReturnSortedArray(){
       Comparable[] array = {137,1,52,17,4};
       bubblesort(array);
       assertArrayEquals(expectedIntegerArray, array);
   }

   @Test
    public void bubbleSortOfStringArrayShouldReturnSortedArray(){
       Comparable[] array = {"s","o","r","t","m","e","p","l","z"};
       bubblesort(array);
       assertArrayEquals(expectedStringArray, array);
   }

   @Test
    public void bubbleSortOfEmptyArrayShouldReturnEmptyArray(){
       Comparable[] array = {};
       bubblesort(array);
       assertArrayEquals(expectedEmptyArray, array);
   }

    @Test
    public void quickSortOfIntegersArrayShouldReturnSortedArray(){
        Comparable[] array = {137,1,52,17,4};
        quicksort(array);
        assertArrayEquals(expectedIntegerArray, array);
    }

    @Test
    public void quickSortOfStringArrayShouldReturnSortedArray(){
        Comparable[] array = {"s","o","r","t","m","e","p","l","z"};
        quicksort(array);
        assertArrayEquals(expectedStringArray, array);
    }

    @Test
    public void quickSortOfEmptyArrayShouldReturnEmptyArray(){
        Comparable[] array = {};
        quicksort(array);
        assertArrayEquals(expectedEmptyArray, array);
    }

    @Test
    public void mergeSortOfIntegersArrayShouldReturnSortedArray(){
        Comparable[] array = {137,1,52,17,4};
        mergesort(array);
        assertArrayEquals(expectedIntegerArray, array);
    }

    @Test
    public void mergeSortOfStringArrayShouldReturnSortedArray(){
        Comparable[] array = {"s","o","r","t","m","e","p","l","z"};
        mergesort(array);
        assertArrayEquals(expectedStringArray, array);
    }

    @Test
    public void mergeSortOfEmptyArrayShouldReturnEmptyArray(){
        Comparable[] array = {};
        mergesort(array);
        assertArrayEquals(expectedEmptyArray, array);
    }

}
