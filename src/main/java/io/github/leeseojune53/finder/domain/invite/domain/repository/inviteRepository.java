package io.github.leeseojune53.finder.domain.invite.domain.repository;

import io.github.leeseojune53.finder.domain.invite.domain.Invite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface inviteRepository extends CrudRepository<Invite, Long> {
}
