package homework2.bank.repository;

import homework2.bank.domain.User;

public interface UserRepository extends CrudRepository<User>{

    User findByEmail(String email);
}
