package task2.task1.controller;

import task2.task1.model.entities.abstracts.Shape;
import task2.task1.model.entities.Circle;
import task2.task1.model.ShapeModel;
import task2.task1.view.ShapeView;

import java.util.Arrays;
import java.util.Random;

public class ShapeController {

    private ShapeModel<Shape> shapeModel;
    private ShapeView shapeView;
    private Shape[] shapes;


    public ShapeController(String[] data){
        shapes = new Shape[data.length];
        parseData(data);
        shapeModel = new ShapeModel(shapes);
        shapeView = new ShapeView();
    }

    public void reply(){
        shapeView.printMessage(ShapeView.SHAPES_REPRESENTATION, shapeModel.getShapesRepresentation());
        shapeView.printMessage(ShapeView.SHAPES_TOTAL_AREA, shapeModel.getTotalShapesArea());
        shapeView.printMessage(ShapeView.SHAPES_TOTAL_AREA_OF_CLASS, shapeModel.getTotalShapesAreaOfClass(Circle.class));
        shapeView.printMessage(ShapeView.SHAPES_SORTED_BY_AREA, Arrays.toString(shapeModel.sortByShapeArea()));
        shapeView.printMessage(ShapeView.SHAPES_SORTED_BY_COLOR, Arrays.toString(shapeModel.sortByShapeColor()));
    }

    private void parseData(String[] data){
        int counter = 0;
        for (String str : data)
            shapes[counter++] = ShapeParser.parse(str);
    }


    private int pickRandom(int bound){
        return new Random().nextInt(bound);
    }



}
