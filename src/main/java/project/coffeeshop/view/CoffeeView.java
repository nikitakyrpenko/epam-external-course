package project.coffeeshop.view;

public class CoffeeView {

    public static final String LOAD_INFO = "\n\tVan loaded with: \n";
    public static final String SORT_INFO = "\n\t Sorted by price / volume ratio : \n";
    public static final String FILTER_PRICE_INFO = "\n\t Filtered by price : \n";
    public static final String FILTERED_SORT_INFO = "\n\t Filtered by sort : \n";

    public void printMessage(String msg, String result){
        System.out.println(msg + result);
    }

}
