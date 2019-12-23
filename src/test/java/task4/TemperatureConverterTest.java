package task4;

import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TemperatureConverterTest {

    private TemperatureConverter temperatureConverter;

    @Parameterized.Parameter(0)
    public double actual;
    @Parameterized.Parameter(1)
    public double expected;

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(
                new Object[][]{
                        {0.0, 273.2},
                        {-273.2, 0.0},
                        {3.0, 276.2},
                        {-5.0, 268.2}
                }
        );
    }


    @Before
    public void init(){
        temperatureConverter = new TemperatureConverter();
    }

    @Test
    public void convertFtoC() {
    }

    @Test
    public void convertCtoF() {
    }

    @Test
    public void convertCtoK() {
        double actualResult = temperatureConverter.convertCtoK(actual);
        Assert.assertEquals(expected, actualResult, 0.05);
    }

    @Test
    public void convertKtoC() {
        double actualResult = temperatureConverter.convertKtoC(expected);
        assertEquals(actual, actual, 0.05);
    }

    @Test
    public void convertFtoK() {
    }

    @Test
    public void convertKtoF() {
    }
}