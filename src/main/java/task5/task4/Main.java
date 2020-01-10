package task5.task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0 ; i < 10; i++ )
            numbers.put(i,i);

        RBTree<Integer, Integer> tree = new RBTree<>(numbers);

        tree.postOrderTraversing();

        tree.inOrderTraversing();

        tree.preOrderTraversing();




    }
}
