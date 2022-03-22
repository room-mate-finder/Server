package io.github.leeseojune53.finder.global.infrastructure.feign;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import io.github.leeseojune53.finder.global.infrastructure.feign.exception.OtherBadRequestException;
import io.github.leeseojune53.finder.global.infrastructure.feign.exception.OtherExpiredTokenException;
import io.github.leeseojune53.finder.global.infrastructure.feign.exception.OtherForbiddenException;
import io.github.leeseojune53.finder.global.infrastructure.feign.exception.OtherUnauthorizedException;

public class FeignClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {


        if (response.status() >= 400) {
            switch (response.status()) {
                case 401:
                    throw OtherUnauthorizedException.EXCEPTION;
                case 403:
                    throw OtherForbiddenException.EXCEPTION;
                case 419:
                    throw OtherExpiredTokenException.EXCEPTION;
                default:
                    throw OtherBadRequestException.EXCEPTION;

            }
        }


        return FeignException.errorStatus(methodKey, response);
    }

}
