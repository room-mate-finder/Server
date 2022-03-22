package io.github.leeseojune53.finder.global.infrastructure.feign.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "DsmAuthClient", url = "${auth.dsm.request-url}")
public interface DsmAuthClient {



}
