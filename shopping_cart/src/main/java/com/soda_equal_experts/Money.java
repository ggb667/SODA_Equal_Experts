package com.soda_equal_experts;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An exact amount of money, a tuple of Big Decimal and a Currency
 * (providing representation and the decimal places of precision).
 */
public class Money {

    private final BigDecimal amount;
    private final Currency currency;
    private final static Pattern regexForDecimalNumber = Pattern.compile("(\\d+(?:\\.\\d+)?)");

    public Money multiply(final String percentage){
        final Matcher matcher = regexForDecimalNumber.matcher(percentage);
        if(matcher.find()) {
            return new Money(this.amount.multiply(new BigDecimal(matcher.group(1)).divide(new BigDecimal(100))), currency);
        } else throw new IllegalArgumentException("Percentage could not be parsed: " + percentage);
    }

    public Money multiply(final Money m){
        if(this.currency.equals(m.currency)){
            return new Money(this.amount.multiply(m.amount), currency);
        } else throw new IllegalArgumentException(
            currency.getCurrencyCode() + " currency code does not match " + m.currency.getCurrencyCode());
    }

    public Money multiply(final int i) {
        final Money m = new Money(new BigDecimal(i), currency);
        return this.multiply(m);
    }

    public Money add(final Money m){
        if(this.currency.equals(m.currency)){
            return new Money(this.amount.add(m.amount), currency);
        } else throw new IllegalArgumentException(
            currency.getCurrencyCode() + " currency code does not match " + m.currency.getCurrencyCode());
    }    

    public static Money dollars(final String amountStr) {
        return new Money(new BigDecimal(amountStr), java.util.Currency.getInstance("USD"));
    }
    
    Money(final BigDecimal amount, final Currency currency) {
        this.currency = currency;
        this.amount = amount.setScale(currency.getDefaultFractionDigits(), RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return NumberFormat.getCurrencyInstance(Locale.getDefault()).format(amount);
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
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Money)) {
            return false;
        }
        final Money other = (Money) obj;
        return Objects.equals(amount, other.amount) && Objects.equals(currency, other.currency);
    }

}
