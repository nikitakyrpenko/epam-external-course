package bank.service.impl;



import bank.domain.User;
import bank.repository.Page;
import bank.repository.UserRepository;
import bank.repository.impl.Pageable;
import bank.service.UserService;
import bank.service.encryptor.Encryptor;
import bank.service.validator.Validator;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static final int USER_PER_PAGE = 2;
    public static final int PAGE_THRESHOLD = 10;
    private static Integer ID_COUNTER = 4;
    private final UserRepository userRepository;
    private final Encryptor passwordEncriptor;
    private final Validator<User> userValidator;

    public UserServiceImpl(UserRepository userRepository, Encryptor passwordEncriptor,
                           Validator<User> userValidator) {
        this.userRepository = userRepository;
        this.passwordEncriptor = passwordEncriptor;
        this.userValidator = userValidator;
    }

    @Override
    public boolean login(String email, String password) {
        String token = passwordEncriptor.hash(password.toCharArray());

        return userRepository.findByEmail(email)
                .map(User::getPassword)
                .filter(pass -> passwordEncriptor.checkPassword(pass.toCharArray(), token))
                .isPresent();
    }

    @Override
    public User register(User user) {
        userValidator.validate(user);
        user.setId(ID_COUNTER++);
        userRepository.save(user);
        return user;
    }

    public Optional<User> findById(Integer id) {
        if (id == null){throw new IllegalArgumentException();}
        return userRepository.findById(id);
    }

   @Override
    public Optional<User> findByEmail(String email) {
        if (email == null){throw new IllegalArgumentException();}
        return userRepository.findByEmail(email);

    }

    @Override
    public List<User> findAll(int page) {
        if (page < 0 ){page = 0;}

        if (page > PAGE_THRESHOLD){page = PAGE_THRESHOLD;}

        final Pageable<User> users = userRepository.findAll(new Page(page, USER_PER_PAGE));

        return users.getItems();
    }
}
