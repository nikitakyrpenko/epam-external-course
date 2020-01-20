package homework2.computing;

public class FibonacciAndFactorial {

    public static int recursiveFibonacci(int n){
        if( n <= 1){ return  n;}
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static int iterativeFibonacci(int bound){
        if (bound < 0) {return bound;}
        int previous = 0;
        int postPrevious;
        int current = 1;
        for (int i = 1 ; i < bound; i++){
            postPrevious = previous;
            previous = current;
            current = postPrevious + previous;
        }
        return current;
    }




}
