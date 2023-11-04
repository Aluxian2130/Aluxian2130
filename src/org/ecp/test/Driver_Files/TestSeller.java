package org.ecp.people;

import org.ecp.items.Product;
import org.ecp.system.Admin;

public class SellerDriver {

    public static void main(String[] args) {

        // Create a Seller
        Seller seller = new Seller();
        seller.setUsername("testSeller");

        // Create some products
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();

        // Add products to the seller's product list
        seller.addProduct(product1);
        seller.addProduct(product2);
        seller.addProduct(product3);

        // Remove a product from the product list
        seller.removeProduct(product2);

        // Update a product
        seller.updateProduct(product1);

        // Print the seller's information
        System.out.println("Seller Information:");
        System.out.println("Username: " + seller.getUsername());

        // Print the product list
        System.out.println("\nProduct List:");
        for (Product product : seller.getProductList()) {
            System.out.println("Product Name: " + product.getName() + " - Price: $" + product.getPrice());
        }

        // Perform other seller-related actions as needed

    }
}
