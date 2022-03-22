package io.github.leeseojune53.finder.global.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties("auth.dsm")
public class DsmAuthProperties {
    private final String baseUrl;
    private final String format;
    private final String clientId;
    private final String clientSecret;
    private final String redirectUrl;
}
