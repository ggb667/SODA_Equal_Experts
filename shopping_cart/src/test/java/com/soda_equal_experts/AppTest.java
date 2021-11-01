package com.soda_equal_experts;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    /**
     * Step1 Given:
     *
     * An empty shopping cart And a product, Dove Soap with a unit price of 39.99
     * When:
     * 
     * The user adds 5 Dove Soaps to the shopping cart Then:
     * 
     * The shopping cart should contain 5 Dove Soaps each with a unit price of 39.99
     * And the shopping cart’s total price should equal 199.95
     */
    @Test
    public void stepOneTest() {
        ShoppingCart s = new com.soda_equal_experts.ShoppingCart();
        Product product1 = new Product("Dove Soap", Money.dollars("39.99"));
        int numberOfItems = 5;
        s.add(product1, numberOfItems);
        assertTrue(s.totalPrice.equals(Money.dollars("199.95")));
    }

    /**
     * Step 2: Add additional products of the same type to the shopping cart. Given:
     * 
     * An empty shopping cart And a product, Dove Soap with a unit price of 39.99
     * When:
     * 
     * The user adds 5 Dove Soaps to the shopping cart And then adds another 3 Dove
     * Soaps to the shopping cart Then:
     * 
     * The shopping cart should contain 8 Dove Soaps each with a unit price of 39.99
     * And the shopping cart’s total price should equal 319.92 Archive this as a
     * separate .zip file named step2.zip then continue on to step three.
     */
    @Test
    public void stepTwoTest() {
        ShoppingCart s = new com.soda_equal_experts.ShoppingCart();
        Product product1 = new Product("Dove Soap", Money.dollars("39.99"));
        int numberOfItems = 5;
        s.add(product1, numberOfItems);
        numberOfItems = 3;
        s.add(product1, numberOfItems);
        assertTrue(s.totalPrice.equals(Money.dollars("319.92")));
    }

}
