package com.ironhack.priceproxyservice.service.impl;

import com.ironhack.priceproxyservice.Enum.Currency;
import com.ironhack.priceproxyservice.model.Money;
import com.ironhack.priceproxyservice.service.interfaces.PriceService;
import org.springframework.stereotype.Service;

import static com.ironhack.priceproxyservice.model.Convert.*;

@Service
public class PriceServiceImpl implements PriceService {

    public Money convert(Money moneyUSD, String currency) {
        Currency currency1= Currency.valueOf(currency.toUpperCase());
        Money result= null;
        switch (currency1){

            case EURO : result = convertFromUSDToEuro(moneyUSD);
            break;

            case COP : result = convertFromUSDToCOP(moneyUSD);
            break;

            case UYU : result = convertFromUSDToUYU(moneyUSD);
            break;
        }
        return result;

    }
}
