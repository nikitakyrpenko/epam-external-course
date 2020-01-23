package bank.repository.impl;



import bank.domain.Account;
import bank.repository.AccountRepository;
import bank.repository.Page;

import java.util.Collections;

import java.util.List;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {


    @Override
    public Pageable<Account> findAll(Page page) {
        return null;
    }


    @Override
    public void save(Account entity) {

    }

    @Override
    public Optional<Account> findById(Integer id) {
        return Optional.empty();
    }


    @Override
    public long count() {
        return 0;
    }

    @Override
    public void update(Account entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
