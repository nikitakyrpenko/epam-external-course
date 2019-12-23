package task3.task3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        CustomEnum.init("NORTH", "WEST", "SOUTH", "EAST");

        System.out.println("\n\tValues: " + Arrays.toString(CustomEnum.values()));

        System.out.printf("\n\tValue of WEST : %s\n", CustomEnum.valueOf("WEST"));

        for (CustomEnum ce : CustomEnum.values())
            System.out.printf("\n\tvalue: %s, position : %s",ce.toString(), ce.ordinal());
    }

}
