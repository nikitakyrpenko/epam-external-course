package bank.service;

import bank.domain.User;
import bank.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean login(String email, String password){
       final User user = userRepository.findByEmail(email);
       if (user == null) {return false;}
       return user.getPassword().equals(password);
    }
}
