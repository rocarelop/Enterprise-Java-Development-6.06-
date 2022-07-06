package com.ironhack.productpriceedgeservice.controller.impl;

import com.ironhack.productpriceedgeservice.Client.PriceServiceClient;
import com.ironhack.productpriceedgeservice.Client.ProductServiceClient;
import com.ironhack.productpriceedgeservice.controller.DTO.ProductPriceDTO;
import com.ironhack.productpriceedgeservice.controller.interfaces.ProductPriceController;
import com.ironhack.productpriceedgeservice.model.Money;
import com.ironhack.productpriceedgeservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductPriceControllerImpl implements ProductPriceController {
    @Autowired
    private PriceServiceClient priceServiceClient;
    @Autowired
    private ProductServiceClient productServiceClient;

    @GetMapping("/product-prices/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductPriceDTO productPriceFindByIdAndConvert(@PathVariable Long id, @RequestParam String currency) {
        Product product = productServiceClient.findById(id);
        Money money = priceServiceClient.convert(product.getPrice(), currency);
        ProductPriceDTO productPriceDTO = new ProductPriceDTO(product.getProductName(), money);
        return productPriceDTO;
    }
}
