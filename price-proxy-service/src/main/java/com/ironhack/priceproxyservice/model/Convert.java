package com.ironhack.priceproxyservice.model;

import com.ironhack.priceproxyservice.Enum.Currency;

import java.math.BigDecimal;

public class Convert {

public static Money convertFromUSDToEuro(Money moneyUSD){
    BigDecimal amountEuro = moneyUSD.getAmount().multiply(new BigDecimal(0.98));
    Money moneyEuro = new Money(amountEuro, Currency.EURO);
    return moneyEuro;
}

public static Money convertFromUSDToCOP(Money moneyUSD){
    BigDecimal amountCOP = moneyUSD.getAmount().multiply(new BigDecimal(4337.62));
    Money moneyCOP = new Money(amountCOP, Currency.COP);
    return moneyCOP;
    }
    public static Money convertFromUSDToUYU(Money moneyUSD){
        BigDecimal amountUYU = moneyUSD.getAmount().multiply(new BigDecimal(39.97));
        Money moneyUYU = new Money(amountUYU, Currency.UYU);
        return moneyUYU;
    }
}
