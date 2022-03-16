package io.github.leeseojune53.finder.domain.user.domain.repository;

import io.github.leeseojune53.finder.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByNumber(String number);
}
