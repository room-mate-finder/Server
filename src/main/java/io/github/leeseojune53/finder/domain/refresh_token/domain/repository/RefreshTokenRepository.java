package io.github.leeseojune53.finder.domain.refresh_token.domain.repository;

import io.github.leeseojune53.finder.domain.refresh_token.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findByToken(String token);
}
