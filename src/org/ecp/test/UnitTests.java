package org.ecp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

import org.ecp.items.Order;
import org.ecp.items.Product;
import org.ecp.people.Customer;
import org.ecp.people.Driver;
import org.ecp.people.Seller;
import org.ecp.people.User;
import org.ecp.system.Admin;
import org.junit.jupiter.api.Test;

class UnitTests {

    @Test
    public void testSetAddress() {
        Customer customer = new Customer();
        customer.setAddress("2402 Water st"); // Assuming 1 is a valid address position
//        assertEquals("Address should be set to the chosen address", "chosen address", customer.getAddress());
    }

    @Test
    public void testSetShoppingCart() {
        Customer customer = new Customer();
        ArrayList<Product> shoppingCart = new ArrayList<>();
        Product product1 = new Product("Product 1", 10.0, 4);
        shoppingCart.add(product1);
        customer.setShoppingCart(shoppingCart);
        assertEquals("Shopping cart should be set", shoppingCart, customer.getShoppingCart());
    }

    @Test
    public void testAddFunds() {
        Customer customer = new Customer();
        customer.addFunds(50.0);
        assertEquals("Account balance should be increased", 50.0, customer.getAccountBalance(), 0.01);
    }

    @Test
    public void testAddProduct() {
        Customer customer = new Customer();
        Product product = new Product("Product 1", 10.0, 3);
        customer.addProduct(product);
        assertEquals("Shopping cart should contain the added product", 1, customer.getShoppingCart().size());
    }

    @Test
    public void testRemoveProduct() {
        Customer customer = new Customer();
        Product product = new Product("Product 1", 10.0, 1);
        customer.addProduct(product);
        customer.removeProduct(product);
        assertEquals("Shopping cart should not contain the removed product", 0, customer.getShoppingCart().size());
    }
    @Test
    public void testSetDeliveryList() {
        Driver driver = new Driver();
        ArrayList<Order> deliveryList = new ArrayList<>();
        Order order1 = new Order();
        deliveryList.add(order1);
        driver.setDeliveryList(deliveryList);
        assertEquals("Delivery list should be set", deliveryList, driver.getDeliveryList());
    }

    @Test
    public void testAddDelivery() {
        Driver driver = new Driver();
        Order order = new Order();
//        Admin.addOrder(order); // Assuming there's an `addOrder` method in the Admin class
        driver.completeDelivery(order);
        assertTrue("Driver should have the added delivery", driver.getDeliveryList().contains(order));
    }

    @Test
    public void testRemoveDelivery() {
        Driver driver = new Driver();
        Order order = new Order();
//        Admin.addOrder(order);
        driver.completeDelivery(order);
        driver.completeDelivery(order);
        assertFalse("Driver should not have the removed delivery", driver.getDeliveryList().contains(order));
    }

    @Test
    public void testCompleteDelivery() {
        Driver driver = new Driver();
        Order order = new Order();
//        Admin.addOrder(order);
        driver.completeDelivery(order);
        driver.completeDelivery(order);
//        assertEquals("Order should be marked as delivered", "delivered", order.getStatus());
        assertFalse("Admin should not have the delivered order", Admin.getDeliveryList().contains(order));
        assertFalse("Driver should not have the delivered order", driver.getDeliveryList().contains(order));
        // You might need to add more assertions based on the expected behavior
    }
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
    public void testAddProductseller() {
        Seller seller = new Seller();
        Product product = new Product("Test Product", 20.0, 4);
        // You might need to simulate user input for the product details (name, price, quantity, description)
        // Mocking user input is beyond the scope of this test, so it's not shown here.
        seller.addToProductList(product);
        assertTrue("Seller should have the added product: ", seller.getProductList().contains(product));
    }

    @Test
    public void testRemoveProductseller() {
        Seller seller = new Seller();
        Product product = new Product("Product 1", 10.0, 5);
        seller.addToProductList(product);
        seller.removeProduct(product);
        assertFalse("Seller should not have the removed product: ", seller.getProductList().contains(product));
    }
    
    
    //TODO Find UNIT TESTS FOR USER.
//    @Test
//    public void testSetEmail() {
//        User user = new User();
//        user.setEmail("test@example.com");
//        assertEquals("Email should be set", "test@example.com", user.getEmail());
//    }
//
//    @Test
//    public void testSetPassword() {
//        User user = new User();
//        user.setPassword("password123");
//        assertEquals("Password should be set", "password123", user.getPassword());
//    }
//
//    @Test
//    public void testSetUsername() {
//        User user = new User();
//        user.setUsername("testuser");
//        assertEquals("Username should be set", "testuser", user.getUsername());
//    }
//
//    @Test
//    public void testSetAccountBalance() {
//        User user = new User();
//        user.setAccountBalance(100.0);
//        assertEquals("Account balance should be set", 100.0, user.getAccountBalance(), 0.01);
//    }
//
//    @Test
//    public void testRemoveFunds() {
//        User user = new User();
//        user.setAccountBalance(100.0);
//        user.removeFunds(50.0);
//        assertEquals("Account balance should be decreased", 50.0, user.getAccountBalance(), 0.01);
//    }
//
//    @Test
//    public void testDeleteAccount() {
//        // You might need to test the behavior of the deleteAccount method in a specific subclass
//        // Since it's a protected method in the base class, it can't be tested directly in this context.
//    }
//
//    @Test
//    public void testLogin() {
//        // You might need to test the behavior of the login method in a specific subclass
//        // Since it's a protected method in the base class, it can't be tested directly in this context.
//    }
//
//    @Test
//    public void testLogout() {
//        // You might need to test the behavior of the logout method in a specific subclass
//        // Since it's a protected method in the base class, it can't be tested directly in this context.
//    }

}

