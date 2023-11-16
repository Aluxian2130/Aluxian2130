package org.ecp.test.Driver_Files;

//import org.ecp.items.Product;
import org.ecp.people.Seller;
//import org.ecp.system.Admin;

public class TestSeller {

    public static void main(String[] args) {

        
    	Seller s1 = new Seller();
    	//Product p1 = new Product();
    	//Admin a1 = new Admin();
    	s1.addProduct();
    	s1.addProduct();
    	
    	System.out.println("Detect error if seller attempts to add more products than defined maximum product amount.");
    	s1.addProduct();//if products are above 2 we get an errormessage.
    	
    	//printing product list for seller
    	s1.printProductList();
    	
    	//testing product removal
    	s1.beginRemoveProduct();
    	s1.printProductList();
<<<<<<< HEAD
	    s1.beginUpdateProduct();
	    s1.printProductList();

=======
    	
    	s1.beginUpdateProduct();
	    s1.printProductList();
>>>>>>> b19d5077f1c663b6c7404d9cd1ea61586090e7e6
    	
    	/*
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
         
         */
    }
}
