package com.ironhack.productproxyservice.Controller.impl;

import com.ironhack.productproxyservice.Controller.interfaces.ProductController;
import com.ironhack.productproxyservice.model.Product;
import com.ironhack.productproxyservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProductControllerImpl implements ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findById(@PathVariable Long id) {
        Optional<Product> product= productRepository.findById(id);
        return product.get();
    }
}
