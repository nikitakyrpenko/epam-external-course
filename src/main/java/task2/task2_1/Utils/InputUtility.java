package task2.task2_1.Utils;

import java.util.Random;

public class InputUtility {
    private static Random random = new Random();

    public static String[] generateShapeColor(int amount){
        String[] colors = new String[amount];
        for (int i = 0; i < amount; i++)
            colors[i] = "#" + Integer.toHexString(random.nextInt(0xFFFFFF));
        return colors;
    }

    public static double[] generateShapeDimensions(int amount){
        double[] dimensions = new double[amount];
        for (int i = 0; i < amount; i++){
            dimensions[i] = random.nextInt(50);
        }
        return dimensions;
    }


}
