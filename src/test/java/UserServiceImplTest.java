import bank.domain.User;
import bank.repository.UserRepository;
import bank.service.encryptor.Encryptor;
import bank.service.impl.UserServiceImpl;
import bank.service.validator.Validator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private Validator<User> userValidator;

    @Mock
    private Encryptor encryptor;

    @InjectMocks
    private UserServiceImpl userService;

    private static  User USER = User.builder()
            .withPassword("Strong@Password10")
            .withEmail("my@mail.ru")
            .build();

    @Test
    public void userShouldNotLogin(){
        Mockito.when(userService.login("test","pass")).thenReturn(false);

    }

    @Test
    public void userShouldRegister(){
        Mockito.doNothing().when(userValidator).validate(any(User.class));
        Mockito.when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        Mockito.doNothing().when(userRepository).save(any(User.class));

        User actual = userService.register(USER);
        Assert.assertEquals(USER, actual);
        Mockito.verify(userValidator).validate(any(User.class));
        //Mockito.verify(userRepository).findByEmail(anyString());
        Mockito.verify(userRepository).save(any(User.class));

    }

}
