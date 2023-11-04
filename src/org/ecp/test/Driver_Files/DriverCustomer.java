package org.ecp.people;

import org.ecp.items.Product;
import org.ecp.system.Admin;

public class CustomerDriver {

    public static void main(String[] args) {

        // Create a Customer
        Customer customer = new Customer();
        customer.setUsername("john_doe");
        customer.setEmail("john.doe@example.com");
        customer.setAccountBalance(100.0);

        // Add some funds to the customer's account
        customer.addFunds(50.0);

        // Create some products
        Product product1 = new Product("Product A", 10.0);
        Product product2 = new Product("Product B", 15.0);
        Product product3 = new Product("Product C", 20.0);

        // Add products to the customer's shopping cart
        customer.addProduct(product1);
        customer.addProduct(product2);
        customer.addProduct(product3);

        // Remove a product from the shopping cart
        customer.removeProduct(product2);

        // Set the customer's address
        customer.setAddress(1); // Assuming 1 is a valid address position

        // Print the customer's information
        System.out.println("Customer Information:");
        System.out.println("Username: " + customer.getUsername());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Account Balance: $" + customer.getAccountBalance());
        System.out.println("Address: " + customer.getAddress());

        // Print the shopping cart
        System.out.println("\nShopping Cart:");
        for (Product product : customer.getShoppingCart()) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }

        // Perform other customer-related actions as needed

    }
}
