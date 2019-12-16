package task2.task2_1;

import task2.task2_1.Controller.ShapeController;
import task2.task2_1.Utils.InputUtility;

public class Main {
    public static void main(String[] args){

        int shapeAmount = 10;

        String[] colors = InputUtility.generateShapeColor(100);
        double[] dimensions = InputUtility.generateShapeDimensions(50);

        ShapeController shapeController = new ShapeController(shapeAmount, colors, dimensions);
        shapeController.reply();

    }
}
