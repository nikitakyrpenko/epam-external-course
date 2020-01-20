package homework2.bank;

import homework2.bank.domain.User;
import homework2.bank.repository.impl.UserRepositoryImp;

public class ConsoleApplication {

    public static void main(String[] args) {
       User user = User.builder()
               .withId(1)
               .withEmail("mail@gmail.com")
               .withPassword("123")
               .withAccount(null)
               .build();

    UserRepositoryImp userRepositoryImp = new UserRepositoryImp();
    userRepositoryImp.findAll();


        System.out.println(user);
    }

}
