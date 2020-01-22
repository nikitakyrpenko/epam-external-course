package bank.repository.impl;

import bank.domain.Account;
import bank.repository.AccountRepository;
import static java.util.Objects.isNull;
import java.util.*;

public class AccountRepositoryImp implements AccountRepository {

    private Map<Integer, Account> accountIdToAccount = new HashMap<>();

    @Override
    public void safe(Account entity) {
        if (isNull(entity)) {throw new IllegalArgumentException();}
        accountIdToAccount.put(entity.getId(), entity);
    }

    @Override
    public Account findById(Integer id) {
        if (isNull(id)) { throw new IllegalArgumentException();}
        return accountIdToAccount
                .values()
                .stream()
                .filter(account -> account.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Account> findAll() {
        return (accountIdToAccount.values().isEmpty()) ? Collections.emptyList() : new ArrayList<>(accountIdToAccount.values());
    }

    @Override
    public void update(Account entity) {
        safe(entity);
    }

    @Override
    public void deleteById(Integer id) {
        if (isNull(id)) {throw new IllegalArgumentException();}
        accountIdToAccount.remove(id);
    }
}
