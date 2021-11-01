package com.soda_equal_experts;

import java.util.Objects;

public class Product implements Comparable<Product> {

    public Money price;
    public String productName;

    public Product(String productName, Money price) {
       this.price = price;
       this.productName = productName;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    
    @Override
    public int hashCode() {
        return Objects.hash(price, productName);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product other = (Product) obj;
        return Objects.equals(price, other.price) && Objects.equals(productName, other.productName);
    }

    @Override
    public int compareTo(Product o) {
        return productName.compareTo(o.productName);
    }

}
