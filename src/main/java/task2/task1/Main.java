package task2.task1;

import task2.task1.controller.ShapeController;
import task2.task1.utils.InputUtility;

public class Main {
    public static void main(String[] args){


        ShapeController shapeController = new ShapeController(InputUtility.data);
        shapeController.reply();

    }
}
