package com.soda_equal_experts;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)  Make sure assertions are working.
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    /**
     * Step 1: Add products to the shopping cart.
     * 
     * Given:
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
     * Step 2: Add additional products of the same type to the shopping cart.
     * 
     * Given:
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

    /**
     * Step 3: Calculate the tax rate of the shopping cart with multiple items
     * Given:
     * 
     * An empty shopping cart And a product, Dove Soap with a unit price of 39.99
     * And another product, Axe Deo with a unit price of 99.99 And a sales tax rate
     * of 12.5% When:
     * 
     * The user adds 2 Dove Soaps to the shopping cart And then adds 2 Axe Deos to
     * the shopping cart Then:
     * 
     * The shopping cart should contain 2 Dove Soaps each with a unit price of 39.99
     * And the shopping cart should contain 2 Axe Deos each with a unit price of
     * 99.99 And the total sales tax amount for the shopping cart should equal 35.00
     * And the shopping cart’s total price should equal 314.96 Archive this as a
     * separate zip file named step3.zip file and send all of the zip files as email
     * attachments to your recruitment contact, following the guidance set out
     * below.
     * 
     * Please include the version number 5b8d0fd276b6d288905ed2f63a934e057e8feca2 in
     * a README file with your submission so we know what version of the
     * instructions you’ve been given.
     * 
     * Note: Please don’t include the compiled code in the zip files. We won’t use
     * it, and it causes trouble with many email systems.
     */
    @Test
    public void stepThreeTest() {
        ShoppingCart s = new com.soda_equal_experts.ShoppingCart();
        Product product1 = new Product("Dove Soap", Money.dollars("39.99"));
        int numberOfItems = 2;
        s.add(product1, numberOfItems);
        Product product2 = new Product("Axe Deo", Money.dollars("99.99"));
        numberOfItems = 2;
        s.add(product2, numberOfItems);
        assertTrue(s.totalPrice.equals(Money.dollars("279.96")));
        String taxRate = "12.5%";
        s.addSalesTax(taxRate);
        assertTrue(s.totalPrice.equals(Money.dollars("314.96")));
    }

    /**
     * Step 0:
     * All totals should be rounded up to 2 decimal places, i.e. 0.565 should result in 0.57 but 0.5649 should result in 0.56.
     */
    @Test
    public void stepZeroTest() {
        Money a = Money.dollars("0.005");
        Money A = Money.dollars("0.01");
        assertTrue(a.equals(A));

        Money c = Money.dollars("0.565");
        Money C = Money.dollars("0.57");
        assertTrue(c.equals(C));

        Money b = Money.dollars("0.5649");
        Money B = Money.dollars("0.56");
        assertTrue(b.equals(B));
    }    

}
