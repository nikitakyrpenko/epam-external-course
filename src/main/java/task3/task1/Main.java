package task3.task1;
import task3.task1.toys.abstracts.BoysToy;
import task3.task1.toys.abstracts.Toy;
import task3.task1.utils.Utils;
import java.math.BigDecimal;

import static task3.task1.utils.Data.toys;


public class Main {

    public static void main(String... args){
        Playground<Toy> playground = new Playground<>(toys);
        printResult(playground);
    }

    private static void printResult(Playground playground){
        System.out.println(Utils.GET_TOTAL_PRICE + playground.getToysPrice()+"\n");
        System.out.println(Utils.GET_SORTED_BY_PRICE+ Utils.arrayToString(playground.getToysSortedByPrice())+"\n");
        System.out.println(Utils.GET_SORTED_BY_GENDER + Utils.arrayToString(playground.getToysSortedByOwnerGender())+"\n");
        System.out.println(Utils.GET_FILTERED_BY_PRICE + Utils.arrayToString(playground.getToysFilteredByPrice(new BigDecimal(10)))+"\n");
        System.out.println(Utils.GET_FILTERED_BY_OWNER_GENDER+ Utils.arrayToString(playground.getToysFilteredByOwnerGender("girl"))+"\n");
    }


}
