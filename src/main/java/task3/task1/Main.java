package task3.task1;
import task3.task1.Playground;
import task3.task1.toys.abstracts.Toy;
import task3.task1.utils.Utils;
import java.math.BigDecimal;

import static task3.task1.utils.Data.toys;


public class Main {

    public static void main(String... args){
        Playground<Toy> playground = new Playground<Toy>(toys);
        printResult(playground);
    }

    private static void printResult(Playground playground){
        System.out.println(playground.getToysPrice());
        System.out.println(Utils.ArrayToString(playground.getToysSortedByPrice()));
        System.out.println(Utils.ArrayToString(playground.getToysSortedByOwnerGender()));
        System.out.println(Utils.ArrayToString(playground.getToysFilteredByPrice(new BigDecimal(10))));
        System.out.println(Utils.ArrayToString(playground.getToysFilteredByOwnerGender("girl")));
    }


}
