package bank.repository.impl;



import bank.domain.User;
import bank.repository.Page;
import bank.repository.UserRepository;

import bank.service.impl.UserServiceImpl;

import java.util.*;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {



    public  Map<Integer, User> userIdToUser = new HashMap<>();

    {
        User user1 = User.builder().withId(1).withEmail("alex@gmail.com").withPassword("P@ssWord97").build();
        User user2 = User.builder().withId(2).withEmail("mickaborscha@gmail.com").withPassword("Mut@bor70").build();
        User user3 = User.builder().withId(3).withEmail("user3@mail.ru").withPassword("G00dP@ssword").build();

        userIdToUser.put(user1.getId(),user1);
        userIdToUser.put(user2.getId(),user2);
        userIdToUser.put(user3.getId(),user3);

    }


    @Override
    public Optional<User> findByEmail(String email) {
        if (email == null){throw new IllegalArgumentException();}
        return userIdToUser
                .values()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny();

    }

    @Override
    public void save(User entity) {
        if (entity == null){throw new IllegalArgumentException();}
        userIdToUser.put(entity.getId(), entity);
    }

    @Override
    public Optional<User> findById(Integer id) {
        if (id == null){throw new IllegalArgumentException();}
        return Optional.ofNullable(userIdToUser.get(id));
    }

    @Override
    public Pageable<User> findAll(Page page) {
        int pageOffset = page.getPageNumber() * page.getItemsPerPage();
        int pageSize = page.getItemsPerPage();

        List<User> collect = userIdToUser
                .values()
                .stream()
                .skip(pageOffset)
                .limit(pageSize)
                .collect(Collectors.toList());

        return new Pageable<>(collect, page.getPageNumber(), page.getItemsPerPage(), UserServiceImpl.PAGE_THRESHOLD);

    }

    @Override
    public long count() {
        return userIdToUser.size();
    }

    @Override
    public void update(User entity) {
        save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null){throw new IllegalArgumentException();}
        userIdToUser.remove(id);
    }
}
