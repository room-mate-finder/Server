package io.github.leeseojune53.finder.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.leeseojune53.finder.global.error.ErrorHandlingFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final ObjectMapper objectMapper;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        builder.addFilterBefore(new ErrorHandlingFilter(objectMapper), UsernamePasswordAuthenticationFilter.class);
    }
}
