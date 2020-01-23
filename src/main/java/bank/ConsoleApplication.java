package bank;
import bank.domain.User;
import bank.injector.ApplicationInjector;


public class ConsoleApplication {

    public static void main(String[] args) {

        ApplicationInjector injector = ApplicationInjector.getInstance();


        injector.getView().authentication();

    }
}
