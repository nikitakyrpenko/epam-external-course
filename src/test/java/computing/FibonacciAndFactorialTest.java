package computing;

import computing.FibonacciAndFactorial;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciAndFactorialTest {

    @Test
    public void FibonacciShouldReturn55IfParameterIs10(){
        assertEquals(55, FibonacciAndFactorial.recursiveFibonacci(10));
        assertEquals(55, FibonacciAndFactorial.iterativeFibonacci(10));
    }

    @Test
    public void FibonacciShouldReturn3IfParameterIs2(){
        assertEquals(2, FibonacciAndFactorial.recursiveFibonacci(3));
        assertEquals(2, FibonacciAndFactorial.iterativeFibonacci(3));
    }

    @Test
    public void FibonacciShouldReturnParameterIfParameterIsNegative(){
        assertEquals(-2, FibonacciAndFactorial.recursiveFibonacci(-2));
        assertEquals(-2, FibonacciAndFactorial.iterativeFibonacci(-2));
    }


}
