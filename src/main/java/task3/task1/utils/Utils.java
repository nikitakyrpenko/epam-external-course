package task3.task1.utils;

import java.util.Arrays;

public class Utils {

    public static final  String GET_TOTAL_PRICE = "Toys total price: \n";
    public static final  String GET_SORTED_BY_PRICE = "Toys sorted by  price: \n";
    public static final  String GET_SORTED_BY_GENDER = "Toys sorted by owner gender: \n";
    public static final  String GET_FILTERED_BY_PRICE = "Toys filtered by price: \n";
    public static final  String GET_FILTERED_BY_OWNER_GENDER = "Toys filtered by owner gender: \n";


    public static<T> String arrayToString(T[] array){
        return Arrays.toString(array);
    }
}
