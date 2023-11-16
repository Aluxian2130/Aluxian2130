package org.ecp.test.Driver_Files;

import java.util.Scanner;

import org.ecp.items.Product;
import org.ecp.navigation.OnlineMaps;
import org.ecp.people.Customer;
import org.ecp.people.Seller;
import org.ecp.people.User;
import org.ecp.system.Admin;

public class NormalInstanceDriver {
	
	public static void main(String[] args) {
		System.out.println("Starting normal instance of program as customer user. ");
		
		//Set constraints for system
		Admin.setMaxDeliveries(5);
		Admin.setMaxLimit(100.0);
		Admin.setMaxProducts(10);
		OnlineMaps.addAddress("4581 Star St");
        OnlineMaps.addAddress("6740 Moon Ave");
        OnlineMaps.addAddress("3682 Nebula Blvd");
        OnlineMaps.addAddress("7129 Galaxy Rd");
		
		// Create a Customer
        Customer customer = new Customer();
        customer.setAccountBalance(50.0);
        System.out.println("Current account balance: $" + customer.getAccountBalance());
        System.out.println("How much money would you like to add to your account? ");
        Scanner myObj = new Scanner(System.in);
        Double num = myObj.nextDouble();
        // Add some funds to the customer's account
        customer.addFunds(num);

        // Create some sellers
        Seller seller1 = new Seller("123@gmail", "pass1", "Mark", 0.0D);
        Seller seller2 = new Seller("456@gmail", "pass2", "Hannah", 0.0D);
        // Create some products
        Product product1 = new Product("Product A", 10.0, 1);  // Specify quantity
        Product product2 = new Product("Product B", 15.0, 1);  // Specify quantity
        Product product3 = new Product("Product C", 20.0, 1);  // Specify quantity
        
        seller1.addToProductList(product1);
        seller1.addToProductList(product2);
        seller2.addToProductList(product3);

        // Add products to the customer's shopping cart
        customer.addProduct(product1);
        customer.addProduct(product2);
        customer.addProduct(product3);
        
        System.out.println("Your shopping cart: ");
        customer.printShoppingCart();
        
        System.out.println("Checking out... ");
        customer.checkOut();
        System.out.println("Current account balance: $" + customer.getAccountBalance());
        
        
        
        
		
		
	}

}
