package com.ironhack.productpriceedgeservice.service.interfaces;

import com.ironhack.productpriceedgeservice.controller.DTO.ProductPriceDTO;
import com.ironhack.productpriceedgeservice.model.Money;
import com.ironhack.productpriceedgeservice.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProductPriceService {
    ProductPriceDTO productPriceFindByIdAndConvert(Long id,  String currency);
}
