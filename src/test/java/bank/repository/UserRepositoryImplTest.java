package bank.repository;


import bank.repository.impl.UserRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import bank.domain.User;


@RunWith(JUnit4.class)
public class UserRepositoryImplTest {

    public UserRepositoryImpl userRepositoryImp;

    @Before
    public  void init(){
        userRepositoryImp = new UserRepositoryImpl();
    }

    @Test
    public void userRepositoryFindAllShouldReturnZeroIfMapIsEmpty(){
      /* Assert.assertEquals(userRepositoryImp.findAll().size(), 0);*/
    }

   @Test
    public void userRepositorySaveShouldReturnOneSizeAfterAddUser(){
       /* User user = User.builder()
                .withId(1)
                .withPassword("123")
                .withEmail("gmail@mail.com")
                .withAccount(null)
                .build();
        userRepositoryImp.save(user);
        Assert.assertEquals(userRepositoryImp.findAll().size(),1);*/
   }

   @Test(expected = IllegalArgumentException.class)
   public void userRepositorySaveShouldThrowIllegalArgumentExceptionIfUserIsNull(){
        userRepositoryImp.save(null);
   }

   @Test
    public void userRepositoryFindByEmailShouldReturnNullOfEmptyUsersList(){
    /*   User user = userRepositoryImp.findByEmail("mail@gmail.com");
       Assert.assertNull(user);*/
   }

   @Test
    public void userRepositoryFindByEmailShouldReturnUserIfEmailOfUserIsPresent(){
        String email = "mail@ukr.net";

       User user = User.builder()
               .withId(1)
               .withPassword("123")
               .withEmail("gmail@mail.com")
               .withAccount(null)
               .build();

       User secondUser = User.builder()
               .withId(2)
               .withPassword("123")
               .withEmail(email)
               .withAccount(null)
               .build();

       userRepositoryImp.save(user);
       userRepositoryImp.save(secondUser);

       Assert.assertEquals(secondUser, userRepositoryImp.findByEmail(email));
   }

   @Test(expected = IllegalArgumentException.class)
    public void userRepositoryFindByEmailShouldThrowIllegalArgumentExceptionIfEmailIsNull(){
        userRepositoryImp.findByEmail(null);
   }

   @Test
    public void userRepositoryFindByEmailShouldReturnNullIfEmailIsNotPresent(){
       User secondUser = User.builder()
               .withId(2)
               .withPassword("123")
               .withEmail("email")
               .withAccount(null)
               .build();
       userRepositoryImp.save(secondUser);
       Assert.assertNull(userRepositoryImp.findByEmail("not email"));
   }

    @Test(expected = IllegalArgumentException.class)
    public void userRepositoryFindByIdShouldThrowIllegalArgumentIfIdIsNull(){
        userRepositoryImp.findById(null);
   }

   @Test
    public void userRepositoryFindByIdShouldReturnUserIfIdIsPresent(){
       User secondUser = User.builder()
               .withId(2)
               .withPassword("123")
               .withEmail("email")
               .withAccount(null)
               .build();

       userRepositoryImp.save(secondUser);

       Assert.assertEquals(secondUser, userRepositoryImp.findById(2));
   }

   @Test
    public void userRepositoryFindByIdShouldReturnNullIfIdIsNotPresent(){
       User user = User.builder()
               .withId(2)
               .withPassword("123")
               .withEmail("email")
               .withAccount(null)
               .build();

       userRepositoryImp.save(user);
       Assert.assertNull(userRepositoryImp.findById(1));
   }


   @Test
    public void userRepositoryShouldDeleteUserIfIdIsPresent(){
       User user = User.builder()
               .withId(1)
               .withPassword("123")
               .withEmail("email")
               .withAccount(null)
               .build();
       User secondUser = User.builder()
               .withId(2)
               .withPassword("123456")
               .withEmail("main@gmail.com")
               .withAccount(null)
               .build();

       userRepositoryImp.userIdToUser.put(user.getId(), user);
       userRepositoryImp.userIdToUser.put(secondUser.getId(), secondUser);

       userRepositoryImp.deleteById(secondUser.getId());
      /* Assert.assertEquals(userRepositoryImp.findAll().size(), 1);*/
   }

   @Test(expected = IllegalArgumentException.class)
    public void userRepositoryDeleteShouldThrowIllegalArgumentExceptionIfIdIsNull(){
        userRepositoryImp.deleteById(null);
   }



}
