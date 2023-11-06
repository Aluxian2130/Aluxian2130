package org.ecp.test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.ecp.items.Product;
import org.ecp.people.Seller;

public class SellerUnitTest {

    @Test
    public void testSetProductList() {
        Seller seller = new Seller();
        ArrayList<Product> productList = new ArrayList<Product>();
        Product product1 = new Product("Product 1", 10.0, 3);
        productList.add(product1);
        seller.setProductList(productList);
        assertEquals("Product list should be set", productList, seller.getProductList());
    }

    @Test
    public void testAddProduct() {
        Seller seller = new Seller();
        Product product = new Product("Test Product", 20.0, 4);
        // You might need to simulate user input for the product details (name, price, quantity, description)
        // Mocking user input is beyond the scope of this test, so it's not shown here.
        seller.addToProductList(product);
        assertTrue("Seller should have the added product: ", seller.getProductList().contains(product));
    }

    @Test
    public void testRemoveProduct() {
        Seller seller = new Seller();
        Product product = new Product("Product 1", 10.0, 5);
        seller.addToProductList(product);
        seller.removeProduct(product);
        assertFalse("Seller should not have the removed product: ", seller.getProductList().contains(product));
    }

    
}
