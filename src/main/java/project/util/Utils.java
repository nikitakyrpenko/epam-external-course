package project.util;

import java.util.Random;

public class Utils {
    private static Random random = new Random();


    public static <T extends Enum<?>> T getRandomEnumValue(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public static  int pickRandom(int bound){
        return random.nextInt(bound);
    }
}
