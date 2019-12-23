package task1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class FirstTaskTest {

    private int number;
    private final int _INTEGER_THRESHOLD =  2147483647;


    @Before
    public void init(){
        Random random = new Random();
        number = random.nextInt(_INTEGER_THRESHOLD);
    }

    @Test
    public void testDecimalToBinary(){
        String expectedResult = FirstTask.decimalToBinary(number);
        String actualResult = Integer.toBinaryString(number);
        System.out.println("Actual number: " + number+ "; Expected result : "+ expectedResult + "; Actual result : "+ actualResult);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDecimalToOctal(){
        String expectedResult = FirstTask.decimalToOctal(number);
        String actualResult = Integer.toOctalString(number);
        System.out.println("Actual number: " + number+ "; Expected result : "+ expectedResult + "; Actual result : "+ actualResult);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testPerfectNumbers(){
        String result = FirstTask.perfectNumbers(10000);
        System.out.println("Expected results: "+ "6;28;496;8128;" + "Actual results: " + result);
        Assert.assertEquals("6;28;496;8128;", result);
    }

    @Test
    public void testDecimalToHex(){
        String expectedResult = FirstTask.decimalToHex(number);
        String actualResult = Integer.toHexString(number);
        System.out.println("Actual number: " + number+ "; Expected result : "+ expectedResult + "; Actual result : "+ actualResult);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testPrintPyramid(){
        System.out.println(FirstTask.printPyramid(9));
    }

    @Test
    public void testTransposeMatrix(){
        int[][][] result = FirstTask.transposeMatrix(3);
        Main.print2D(result[0]);
        Main.print2D(result[1]);
    }

}
