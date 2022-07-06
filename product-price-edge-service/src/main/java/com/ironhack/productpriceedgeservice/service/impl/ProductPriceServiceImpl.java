package com.ironhack.productpriceedgeservice.service.impl;

import com.ironhack.productpriceedgeservice.Client.PriceServiceClient;
import com.ironhack.productpriceedgeservice.Client.ProductServiceClient;
import com.ironhack.productpriceedgeservice.controller.DTO.ProductPriceDTO;
import com.ironhack.productpriceedgeservice.model.Money;
import com.ironhack.productpriceedgeservice.model.Product;
import com.ironhack.productpriceedgeservice.service.interfaces.ProductPriceService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {
    @Autowired
    private PriceServiceClient priceServiceClient;
    @Autowired
    private ProductServiceClient productServiceClient;

    private final Logger logger = LoggerFactory.getLogger(ProductPriceServiceImpl.class);


    @CircuitBreaker(name = "productPriceFindByIdAndConvert", fallbackMethod = "productPriceFindByIdAndConvertFallBack")
    public ProductPriceDTO productPriceFindByIdAndConvert( Long id, String currency) {
        Product product = productServiceClient.findById(id);
        Money money = priceServiceClient.convert(product.getPrice(), currency);
        ProductPriceDTO productPriceDTO = new ProductPriceDTO(product.getProductName(), money);
        return productPriceDTO;
    }

    public ProductPriceDTO productPriceFindByIdAndConvertFallBack( Long id, String currency, Exception e){
        logger.error(e.getMessage());
        Product product = new Product("paraguas", new Money(new BigDecimal(20.20)));
        ProductPriceDTO productPriceDTO = new ProductPriceDTO(product.getProductName(), product.getPrice());

        return productPriceDTO;
    }
}
