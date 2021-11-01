package com.soda_equal_experts;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    /**
    Given:

    An empty shopping cart
    And a product, Dove Soap with a unit price of 39.99
    When:
    
    The user adds 5 Dove Soaps to the shopping cart
    Then:
    
    The shopping cart should contain 5 Dove Soaps each with a unit price of 39.99
    And the shopping cart’s total price should equal 199.95
    */
    @Test
    public void stepOneTest(){
        ShoppingCart s = new com.soda_equal_experts.ShoppingCart();
        Product product1 = new Product("Dove Soap", Money.dollars("39.99"));
        int numberOfItems = 5;
        s.add(product1, numberOfItems);
        assertTrue( s.totalPrice.equals(Money.dollars("199.95")) );
    }


}
