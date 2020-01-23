package bank.service;


import bank.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean login(String email, String password);

    User register(User user);

    List<User> findAll(int page);

    Optional<User> findById(Integer id);

    Optional<User> findByEmail(String email);
}
