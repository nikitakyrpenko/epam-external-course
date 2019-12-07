package task_2.task2_1;

import task_2.task2_1.Controller.ShapeController;
import task_2.task2_1.Utils.InputUtility;

public class Main {
    public static void main(String[] args){

        int shapeAmount = 10;

        String[] colors = InputUtility.generateShapeColor(shapeAmount);
        double[] dimensions = InputUtility.generateShapeDimensions(shapeAmount);

        ShapeController shapeController = new ShapeController(shapeAmount, colors, dimensions);
        shapeController.reply();

    }
}
