package io.github.leeseojune53.finder.domain.refresh_token.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@RedisHash
public class RefreshToken {

    @Id
    private String number;

    @Indexed
    private String token;

    @TimeToLive
    private Long ttl;

    @Builder
    public RefreshToken(String number, String token, Long ttl) {
        this.number = number;
        this.token = token;
        this.ttl = ttl;
    }

    public void updateToken(String token, Long ttl) {
        this.token = token;
        this.ttl = ttl;
    }

}
