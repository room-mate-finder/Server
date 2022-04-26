package io.github.leeseojune53.finder.domain.invite.domain.repository;

import io.github.leeseojune53.finder.domain.invite.domain.Invite;
import io.github.leeseojune53.finder.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InviteRepository extends CrudRepository<Invite, Long> {
    Optional<Invite> findByInvitedUserAndSendUser(User invitedUser, User sendUser);

    List<Invite> findByInvitedUser(User invitedUser);
}
