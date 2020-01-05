package task5.task2;


public class Main {
    public static void main(String[] args) {
        InputUtility inputUtility = new InputUtility();
        try {
            inputUtility.getParameters();
            CollectionGenerator collectionGenerator = new CollectionGenerator(inputUtility.getAmount(), inputUtility.getLow(),inputUtility.getHigh());
            collectionGenerator.display();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
