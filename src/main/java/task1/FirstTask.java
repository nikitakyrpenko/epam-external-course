package task1;

import java.util.Random;

public class FirstTask {

    public static String decimalToBinary(int number) {
       return computeBase(number, 2,false);
    }

    public static String decimalToOctal(int number){
       return computeBase(number, 8, false);
    }

    public static String decimalToHex(int number){ return computeBase(number,16,true); }

    public static String printPyramid(int bound){
        String result = "";
        String spaces = "         ";
        char[][] array = {
                {'1'},
                {'1', '2'},
                {'1', '2', '3'},
                {'1', '2', '3', '4'},
                {'1','2','3','4','5'},
                {'1','2','3','4','5','6'},
                {'1','2','3','4','5','6','7'},
                {'1','2','3','4','5','6','7','8'},
                {'1','2','3','4','5','6','7','8','9'}
        };
       for (int i = 0; i < bound; i++){
           // spaces needs to be added for alignment
           String spacesToAdd = spaces.substring(0,spaces.length() - i);
           // actual row
           String row  =  new String(array[i]);
           // reversed actual row without first element
           String reverseRow = reverseString(new String(array[i]),1,array[i].length).trim() + '\n';

           result = result + spacesToAdd + row + reverseRow;

        }
       return  result;
    }

    public static String perfectNumbers(int bound){
        String result = "";
        for (int i = 1; i<bound; i++)
        {
            int sum = 0;
            for (int j  = 1; j<i; j++)
            {
                if (i%j == 0)
                    sum = sum + j;
            }
            if (i == sum)
               result = result + i + ";";

        }
        return result;
    }

    public static int[][][]transposeMatrix(int dimension){
        Random random = new Random();

        //matrix initialization
        int[][] result = new int[dimension][dimension];
        int[][] matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                matrix[i][j] = random.nextInt();

        //transposing
        for (int i = 0 ; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                result[i][j] = matrix[j][(dimension - 1) - i];

        return new int[][][]{matrix, result};
    }


    private static String computeBase(int number, int base, boolean isHex){
        char[] hexValues = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String result = "";
        if (number < 0)
            throw new IllegalArgumentException();
        if (number == 0)
            return "0";
        for (; number > 0; number = number / base){
            int binary = number % base;
            if (isHex)
                result = result + hexValues[binary];
            else
                result = result + binary;
        }
        return reverseString(result,0, result.length());
    }

    private static String reverseString(String value,int start, int end){
        char[] array = value.toCharArray();
        char[] result = new char[array.length];
        for (int i = start; i < end; i++){
           result[i] = array[end - i - 1];
        }
        return new String(result);
    }


}
