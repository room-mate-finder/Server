package io.github.leeseojune53.finder.domain.message.domain.repository;

import io.github.leeseojune53.finder.domain.message.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
}
