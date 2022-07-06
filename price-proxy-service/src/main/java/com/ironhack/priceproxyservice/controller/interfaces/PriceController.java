package com.ironhack.priceproxyservice.controller.interfaces;

import com.ironhack.priceproxyservice.model.Money;

public interface PriceController {
    Money convert (Money moneyUSD, String currency);
}
