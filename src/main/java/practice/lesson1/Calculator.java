package practice.lesson1;

public class Calculator {

    public int calc(int a, String operator, int b){
        if (operator == null)
            throw new IllegalArgumentException("Operators is null");
       switch (operator){
           case "+":
               return a + b;
           case "-":
               return a - b;
           case "*":
               return a * b;
           default:
               return a / b ;
       }
    }


}
