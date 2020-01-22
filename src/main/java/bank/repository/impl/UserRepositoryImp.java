package bank.repository.impl;

import bank.domain.User;
import bank.repository.UserRepository;
import java.util.*;
import static java.util.Objects.isNull;

public class UserRepositoryImp implements UserRepository {

    public Map<Integer, User> userIdToUser = new HashMap<>();

    //done
    @Override
    public User findByEmail(String email) {
        if (isNull(email)){ throw new IllegalArgumentException();}
        return userIdToUser
                .values()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny()
                .orElse(null);
    }

    @Override
    public void safe(User entity) {
        if (isNull(entity)){ throw new IllegalArgumentException();}
        userIdToUser.put(entity.getId(), entity);
    }

    @Override
    public User findById(Integer id) {
        if (isNull(id)) {throw new IllegalArgumentException();}
        return userIdToUser
                .values()
                .stream()
                .filter(user -> user.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userIdToUser.isEmpty() ? Collections.emptyList() : new ArrayList<>(userIdToUser.values());
    }

    @Override
    public void update(User entity) {
        safe(entity);
    }

    @Override
    public void deleteById(Integer id) {
        if (isNull(id)) {throw new IllegalArgumentException();}
        userIdToUser.remove(id);
    }
}
