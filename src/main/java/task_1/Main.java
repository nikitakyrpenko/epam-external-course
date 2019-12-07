package task_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        System.out.println(FirstTask.printPyramid(4));

        int [][][] matrixResult = FirstTask.transposeMatrix(2);
        print2D(matrixResult[0]);
        print2D(matrixResult[1]);
        System.out.println(" ");


        System.out.println(FirstTask.decimalToBinary(100));
        System.out.println(FirstTask.decimalToOctal(100));
        System.out.println(FirstTask.decimalToHex(100));


        System.out.println(FirstTask.perfectNumbers(10000));

    }

    public static void print2D(int mat[][]) {
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
        System.out.println(" ");
    }
}
