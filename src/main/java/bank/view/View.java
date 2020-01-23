package bank.view;

import bank.domain.User;
import bank.service.UserService;
import static bank.view.ViewConstant.*;
import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in);
    private final UserService userService;

    public View(UserService userService){
        this.userService = userService;
    }

    public void authentication(){
        printMessage(AUTHORIZATION_MENU);
        printMessage(INPUT);
        String command = scanner.nextLine();
        switch (command){
            case REGISTRATION:
                User user = registration();
                if (isAuthenticated(user)){
                    work();
                }
                break;
            case AUTHORIZATION:
                if (isAuthenticatedByEmailAndPassword()){
                    work();
                }
                break;
            case EXIT:
                break;
        }
    }

    public void work(){
        work_block:
        while (true) {
            printMessage(WORK_MENU);
            printMessage(INPUT);
            String command = scanner.nextLine();
            switch (command){
                case FIND_ALL:
                    printMessage(INPUT);
                    String findAllResult = userService.findAll(0).toString();
                    printMessageWithResult(FIND_ALL_RESULT, findAllResult);
                    break ;
                case FIND_BY_EMAIL:
                    printMessage(INPUT);
                    String emailToFind = scanner.nextLine();
                    String findByEmailResult = userService.findByEmail(emailToFind).toString();
                    printMessageWithResult(FIND_BY_EMAIL_RESULT , findByEmailResult);
                    break;
                case FIND_BY_ID:
                    printMessage(INPUT);
                    Integer id = Integer.parseInt(scanner.nextLine());
                    String findByIdResult = userService.findById(id).toString();
                    printMessageWithResult(FIND_BY_ID_RESULT, findByIdResult);
                    break ;
                case EXIT:
                    break work_block;
            }
        }
    }

    private User registration(){
        String email = scanner.nextLine();
        String password = scanner.nextLine();
        String telephone = scanner.nextLine();

        User user = User
                .builder()
                .withEmail(email)
                .withPassword(password)
                .withTelephone(telephone)
                .build();

        return userService.register(user);
    }

    public boolean isAuthenticatedByEmailAndPassword() {
        String email = scanner.nextLine();
        String password = scanner.nextLine();
        return userService.login(email, password);
    }

    public boolean isAuthenticated(User user){
        return userService.login(user.getEmail(), user.getPassword());
    }


}
