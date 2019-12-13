package task_2.task2_2.utils;

import task_2.task2_2.model.entities.Book;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Utils {

    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();

    public static String arrayToString(Book[] array) {
        String result = Arrays.toString(array);
        return array.length == 0? "[]" : result;
    }

    public static int input(){ return sc.nextInt(); }

    public static int pickRandom(int bound){ return random.nextInt(bound); }
}
