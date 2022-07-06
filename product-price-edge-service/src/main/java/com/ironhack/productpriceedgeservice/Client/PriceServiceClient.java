package com.ironhack.productpriceedgeservice.Client;

import com.ironhack.productpriceedgeservice.model.Money;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("price-proxy-service")
public interface PriceServiceClient {

    @PostMapping("/prices")
    Money convert(@RequestBody Money moneyUSD, @RequestParam String currency);

}
