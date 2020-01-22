package computing;

public class FibonacciAndFactorial {

    //ДОБАВИТЬ КОНТРАКТ РАЗЬИТЬ НА КЛАССЫ

    public static int recursiveFibonacci(int n){
        return n <= 1 ? n : recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static int iterativeFibonacci(int n){
        if (n < 0) {return n;}
        int previous = 0;
        int postPrevious;
        int current = 1;
        for (int i = 1 ; i < n; i++){
            postPrevious = previous;
            previous = current;
            current = postPrevious + previous;
        }
        return current;
    }




}
