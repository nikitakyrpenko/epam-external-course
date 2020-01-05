package task5.task3;

public class Main {
    public static void main(String[] args) {
        try {
            Translator translator = new Translator();
            System.out.println(translator.translate("I write word with computer"));
            System.out.println(translator.translate("I make my homework"));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
