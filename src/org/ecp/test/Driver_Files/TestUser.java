package org.ecp.test.Driver_Files;

import org.ecp.items.Product;
//Since the User class is an abstract base class, 
//the driver class will primarily test the methods 
//and behaviors that are specific to its concrete subclasses
import org.ecp.people.Customer;

public class TestUser {

    public static void main(String[] args) {

        // Create a Customer
        Customer customer = new Customer();
        customer.setUsername("customer123");
        customer.setEmail("customer@example.com");
        customer.setAccountBalance(100.0);

        // Add some funds to the customer's account
        customer.addFunds(50.0);

        // Create some products
        Product product1 = new Product("Product A", 10.0, 1);
        Product product2 = new Product("Product B", 15.0, 2);
        Product product3 = new Product("Product C", 20.0, 1);

        // Add products to the customer's shopping cart
        customer.addProduct(product1);
        customer.addProduct(product2);
        customer.addProduct(product3);

        // Remove a product from the shopping cart
        customer.removeProduct(product2);

        // Set the customer's address
        // THIS IS STILL BROKEN TODO
//        customer.setAddress(1); // Assuming 1 is a valid address position

        // Print the customer's information
        System.out.println("Customer Information:");
        System.out.println("Username: " + customer.getUsername());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Account Balance: $" + customer.getAccountBalance());
//        System.out.println("Address: " + customer.getAddress());

        // Perform other customer-related actions as needed

    }
}
