package bank.view;

public interface ViewConstant {

    String AUTHORIZATION = "1";
    String REGISTRATION = "2";
    String EXIT = "0";
    String FIND_BY_ID = "3";
    String FIND_BY_EMAIL = "4";
    String FIND_ALL = "5";

    String AUTHORIZATION_MENU = "1 -> authorization \n2 -> registration \n0 -> exit\n";
    String WORK_MENU = "3 -> find by id\n 4 -> find by email\n 5 -> find all\n";
    String INPUT = "Input -> ";

    String FIND_ALL_RESULT = "\tfind all result : \n";
    String FIND_BY_EMAIL_RESULT = "\t find by email result : \n";
    String FIND_BY_ID_RESULT = "\t find by id result : \n";

    static void printMessage(String message){
        System.out.println(message);
    }

    static void printMessageWithResult(String message, String result){
        System.out.println(message + result);
    }

}
