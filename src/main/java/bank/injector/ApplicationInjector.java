package bank.injector;


import bank.domain.User;
import bank.repository.UserRepository;
import bank.repository.impl.UserRepositoryImpl;
import bank.service.UserService;
import bank.service.encryptor.Encryptor;
import bank.service.encryptor.PBKDF2Encryptor;
import bank.service.impl.UserServiceImpl;
import bank.service.validator.UserValidator;
import bank.service.validator.Validator;
import bank.view.View;

public class ApplicationInjector {

    private static final ApplicationInjector INSTANCE = new ApplicationInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final Encryptor PASSWORD_ENCRIPTOR = new PBKDF2Encryptor();

    private static final UserRepository USER_REPOSITORY = new UserRepositoryImpl();

    private static final UserService USER_SERVICE = new UserServiceImpl(USER_REPOSITORY, PASSWORD_ENCRIPTOR, USER_VALIDATOR);

    private static final View USER_VIEW = new View(USER_SERVICE);



    private ApplicationInjector() {
    }

    public static ApplicationInjector getInstance() {
        return INSTANCE;
    }

    public  View getView(){return USER_VIEW;}

    public UserService getUserService() {
        return USER_SERVICE;
    }

    public  UserRepository getUserRepository() {
        return USER_REPOSITORY;
    }
}
