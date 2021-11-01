package com.soda_equal_experts;

import java.util.TreeMap;

public class ShoppingCart extends TreeMap<Product, Integer> {

    protected Money totalPrice = Money.dollars("0.00");

    public Money add(final Product product, final int numberOfItems) {
        super.put(product, numberOfItems);
        totalPrice = totalPrice.add(product.price.multiply(numberOfItems));
        return totalPrice;
    }

    public Money addSalesTax(final String taxRatePercentage) {
        final Product salesTax = new Product("Sales Tax", totalPrice.multiply(taxRatePercentage));
        return add(salesTax, 1);
    }

}
