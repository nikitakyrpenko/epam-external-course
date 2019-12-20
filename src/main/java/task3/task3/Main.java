package task3.task3;

import java.util.Scanner;

public class Main {
    public static void main(String... args){
        for (DaysOfWeek day : DaysOfWeek.values())
           if (day.isFlag())
               System.out.println(day);


       /* Scanner scanner = new Scanner(System.in);
        System.out.println("Enter day of week -> ");
        System.out.print("Next day -> " + DaysOfWeek.valueOf(scanner.next().toUpperCase()).nextDay());*/
    }
}
