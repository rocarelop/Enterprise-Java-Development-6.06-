package com.ironhack.priceproxyservice.service.interfaces;

import com.ironhack.priceproxyservice.model.Money;

public interface PriceService {
    Money convert (Money moneyUSD, String currency);
}
