package com.village.basicinfo.feign;

import com.village.basicinfo.dto.DesignationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "citizen-designation", url = "https://designation-service-ci54.onrender.com") // Change port if needed
public interface DesignationClient {

    @GetMapping("/designation/{id}")
    DesignationDTO getDesignationById(@PathVariable("id") Long id);
}
