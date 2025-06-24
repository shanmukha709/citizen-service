package com.village.basicinfo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "auth-service", url = "https://auth-service-n9ms.onrender.com")
public interface AuthClient {
    @GetMapping("/auth/user-exists/{username}")
    boolean userExists(@PathVariable("username") String username);
}
