package bank.repository;

import bank.repository.impl.Pageable;
import java.util.Optional;

public interface CrudRepository<E> {

    void save(E entity);

    Optional<E> findById(Integer id);

    Pageable<E> findAll(Page page);

    long count();

    void update(E entity);

    void deleteById(Integer id);
}
