package com.soda_equal_experts;

import java.util.Objects;

public class Product implements Comparable<Product> {

    public Money price;
    public String productName;

    public Product(final String productName, final Money price) {
        this.price = price;
        this.productName = productName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        return Objects.hash(price, productName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(javsa.lang.Object)
     */

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        final Product other = (Product) obj;
        return Objects.equals(price, other.price) && Objects.equals(productName, other.productName);
    }

    @Override
    public int compareTo(final Product o) {
        return productName.compareTo(o.productName);
    }

}
