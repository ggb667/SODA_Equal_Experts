package com.soda_equal_experts;

import java.util.TreeMap;

public class ShoppingCart extends TreeMap<Product,Integer> {

    public Money totalPrice = Money.dollars("0.00");

    public Money add(Product product, int numberOfItems) {
        super.put(product, numberOfItems);
        totalPrice = totalPrice.add(product.price.multiply(numberOfItems));
        return totalPrice;
    }

}
