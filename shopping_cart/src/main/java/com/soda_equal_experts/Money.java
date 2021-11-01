package com.soda_equal_experts;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;

public class Money {

    static final Currency USD = java.util.Currency.getInstance("USD");
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;

    private final BigDecimal amount;
    private final Currency currency;

    public Money add(Money m){
        if(this.currency.equals(m.currency)){
            return new Money(this.amount.add(m.amount), currency);
        } else throw new IllegalArgumentException(currency.getCurrencyCode() + " currency code does not match " + m.currency.getCurrencyCode());
    }    

    public Money multiply(Money m){
        if(this.currency.equals(m.currency)){
            return new Money(this.amount.multiply(m.amount), currency);
        } else throw new IllegalArgumentException(currency.getCurrencyCode() + " currency code does not match " + m.currency.getCurrencyCode());
    }

    public Money multiply(int i) {
        Money m = new Money(new BigDecimal(i), currency);
        return this.multiply(m);
    }

    public static Money dollars(BigDecimal amount) {
        return new Money(amount, USD);
    }

    public static Money dollars(String amountStr) {
        return new Money(new BigDecimal(amountStr), USD);
    }
    
    Money(BigDecimal amount, Currency currency) {
        this(amount, currency, DEFAULT_ROUNDING);
    }

    Money(BigDecimal amount, Currency currency, RoundingMode rounding) {
        this.currency = currency;
        this.amount = amount.setScale(currency.getDefaultFractionDigits(), rounding);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        DecimalFormat currencyFormat = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.getDefault());
        return currencyFormat.toPattern();        
    }

    public String toString(Locale locale) {
        return getCurrency().getSymbol(locale) + " " + getAmount();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Money)) {
            return false;
        }
        Money other = (Money) obj;
        return Objects.equals(amount, other.amount) && Objects.equals(currency, other.currency);
    }

}
