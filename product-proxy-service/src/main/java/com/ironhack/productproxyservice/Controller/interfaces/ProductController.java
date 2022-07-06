package com.ironhack.productproxyservice.Controller.interfaces;

import com.ironhack.productproxyservice.model.Product;

public interface ProductController {
    Product findById(Long id);
}
