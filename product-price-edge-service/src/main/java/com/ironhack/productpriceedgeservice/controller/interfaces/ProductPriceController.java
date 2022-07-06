package com.ironhack.productpriceedgeservice.controller.interfaces;

import com.ironhack.productpriceedgeservice.controller.DTO.ProductPriceDTO;

public interface ProductPriceController {
    ProductPriceDTO productPriceFindByIdAndConvert (Long id, String currency);

}
