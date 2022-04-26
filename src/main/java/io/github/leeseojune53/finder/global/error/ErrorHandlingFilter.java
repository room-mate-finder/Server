package io.github.leeseojune53.finder.global.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.leeseojune53.finder.global.error.exception.ErrorCode;
import io.github.leeseojune53.finder.global.error.exception.FinderException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class ErrorHandlingFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (FinderException e) {
            errorCodeToJson(response, e.getErrorCode());
        } catch (Exception e) {
            errorCodeToJson(response, ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    private void errorCodeToJson(HttpServletResponse response, ErrorCode errorCode) {
        try {
            ErrorResponse errorResponse = new ErrorResponse(errorCode);
            String errorResponseJson = objectMapper.writeValueAsString(errorResponse);

            response.setStatus(errorCode.getStatus());
            response.setContentType("application/json");
            response.getWriter().write(errorResponseJson);
        } catch (IOException e) {
            response.setStatus(500);
        }
    }

}
