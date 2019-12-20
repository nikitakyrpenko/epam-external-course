package task2.task2_1.view;

public class ShapeView {

    public static final String SHAPES_REPRESENTATION = "\n\tSHAPES REPRESENTATION: \n";
    public static final String SHAPES_TOTAL_AREA = "\n\tSHAPES TOTAL AREA: \n";
    public static final String SHAPES_TOTAL_AREA_OF_CLASS = "\n\tSHAPES TOTAL AREA OF CLASS: \n";
    public static final String SHAPES_SORTED_BY_AREA = "\n\tSHAPES SORTED BY AREA: \n";
    public static final String SHAPES_SORTED_BY_COLOR = "\n\tSHAPES SORTED BY COLOR: \n";

    public void printMessage(String msg, String result) {
        System.out.println(msg + result + '\n');
    }



}
