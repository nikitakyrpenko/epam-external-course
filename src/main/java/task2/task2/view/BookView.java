package task2.task2.view;

public class BookView {

    public static final String AUTHOR_TEXT = "\t Find by author ";
    public static final String PUBLISHER_TEXT = "\t Find by publisher ";
    public static final String YEAR_TEXT = "\t Find by year of publishing ";
    public static final String SORT_TEXT = "\t Sorted by author ";
    public static final String ERROR_TEXT = "Wrong input";

    public void printMessage(String msg, String param, String result){
        System.out.println(msg + "("+param+"): \n" + result);
    }
    public void printMessage(String msg, int param, String result){
        System.out.println(msg + "("+param+"): \n" + result);
    }
    public void printMessage(String msg, String result){
        System.out.println(msg + result);
    }

    public void printMenu(){
        System.out.println("\nMenu: \n");
        System.out.println("\t Press 1 to get books by author");
        System.out.println("\t Press 2 to get books by publisher");
        System.out.println("\t Press 3 to get books by year");
        System.out.println("\t Press 4 to sort by publishers");
        System.out.println("\t Press 0 to exit");
    }
}
