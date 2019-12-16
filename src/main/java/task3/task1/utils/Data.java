package task3.task1.utils;

import task3.task1.toys.Car;
import task3.task1.toys.Doll;
import task3.task1.toys.Robot;
import task3.task1.toys.TeddyBear;
import task3.task1.toys.abstracts.Toy;

import java.math.BigDecimal;

public interface Data {

   Toy[] toys ={new Doll("green", new BigDecimal(30), 3.7),
                new Robot("black",new BigDecimal(20), 5.5),
                new TeddyBear("pink",new BigDecimal(10), 3.1),
                new Car("yellow", new BigDecimal(3), 1.0),
                new Doll("red", new BigDecimal(15), 2.2)};
}
