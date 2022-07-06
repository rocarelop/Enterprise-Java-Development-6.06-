package com.ironhack.productpriceedgeservice.Client;

import com.ironhack.productpriceedgeservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@FeignClient("product-proxy-service")
public interface ProductServiceClient {
    @GetMapping("/products/{id}")
    Product findById(@PathVariable Long id);

}
