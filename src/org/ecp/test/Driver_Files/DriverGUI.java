package org.ecp.test.Driver_Files;
import org.ecp.gui.files.CustomerPage;
import org.ecp.gui.files.DriverPage;
import org.ecp.gui.files.GUI;
import org.ecp.gui.files.SellerPage;
import org.ecp.items.Order;
import org.ecp.items.Product;
import org.ecp.navigation.OnlineMaps;
import org.ecp.people.Customer;
import org.ecp.people.Driver;
import org.ecp.people.Seller;
import org.ecp.system.Admin;

public class DriverGUI {
	
	
	public static void main(String[] args)
	{
		Seller seller_A = new Seller();
	    Seller seller_B = new Seller();
	    
	    Driver driver_A = new Driver();
	    
	    Product prod_A = new Product();
		Product prod_B = new Product();
		Product prod_C = new Product();
		
		
    	
    	//creating product A and B and C
    	prod_A.setName("iPhone");
    	prod_A.setPrice(30);
    	prod_A.setDescription("Really useful tool. Can make calls, text, take pictures and more!");

    	prod_B.setName("suitcase");
    	prod_B.setPrice(10);
    	prod_B.setDescription("Can carry up to 28kg of weight.");

    	prod_C.setName("printer");
    	prod_C.setPrice(20);
    	prod_C.setDescription("Prints in all colours");
    	
    	//Seller A has 2 and Seller B has 1
    	seller_A.addStaticProdList(prod_A);
    	seller_A.addStaticProdList(prod_B);
    	seller_B.addStaticProdList(prod_C);
    	Admin.getSellerList().add(seller_A);
    	Admin.getSellerList().add(seller_B);
    	
    	
    	seller_A.setUsername("Lahiru");
    	Admin.getUserList().add(seller_A);
    	
    	seller_B.setUsername("James");
    	Admin.getUserList().add(seller_B);
    	
    	//dirver A 
    	driver_A.setUsername("Tom");
    	Admin.getUserList().add(driver_A);
    	
    	OnlineMaps om1 = new OnlineMaps();
    	
    	//To test CustomerPage
<<<<<<< HEAD
    			Customer c1 = new Customer();
    			c1.setEmail("Wayne@email");
    			c1.setUsername("Wayne");
    			c1.setAccountType("Customer");
    			c1.setAddress("5678 W Elm St");
    			c1.setPassword("password_100");
    			c1.setAccountBalance(3590);
    			Admin.getUserList().add(c1);
    			
    			Customer c2 = new Customer();
    			c2.setEmail("Sorla@email");
    			c2.setUsername("Sorla");
    			c2.setAccountType("Customer");
    			c2.setAddress("1234 E Willow Dr");
    			c2.setPassword("password_70");
    			c2.setAccountBalance(3590);
    			Admin.getUserList().add(c2);
    			//CustomerPage cp = new CustomerPage(c1.getEmail(), c1.getUsername(), c1.getPassword(), c1.getAccountType(), 2000.0);
    			
    			Order o1 = new Order();
    			o1.setCustomerAddress(c1.getAddress());
    			o1.setCustomerName(c1.getUsername());
    			o1.setDeliveryDate(1205);
    			o1.setStatus("Ordered");
    			o1.addProductNames(prod_A.getName());
    			o1.addProductNames(prod_B.getName());
    			Admin.getDeliveryList().add(o1);
    			
    			Order o2 = new Order();
    			o2.setCustomerAddress(c2.getAddress());
    			o2.setCustomerName(c2.getUsername());
    			o2.setDeliveryDate(1205);
    			o2.setStatus("Ordered");
    			o2.addProductNames(prod_B.getName());
    			o2.addProductNames(prod_C.getName());
    			Admin.getDeliveryList().add(o2);
    			
    			
    			
    			//To test sellerPage
    			Seller s1 = new Seller();
    			s1.setEmail("Robin@email");
    			s1.setUsername("Robin");
    			s1.setAccountType("Seller");
    			s1.setPassword("password_90");
    			s1.setAccountBalance(3590);
    			Admin.getUserList().add(s1);
    			//SellerPage p = new SellerPage(s1);
    			
    			//To test sellerPage
    			Driver d1 = new Driver();
    			d1.setEmail("Lisa@email");
    			d1.setUsername("Lisa");
    			d1.setAccountType("Driver");
    			d1.setPassword("password_80");
    			d1.setAccountBalance(3590);
    			Admin.getUserList().add(d1);
    		
    			//TO TEST AS A WHOLE
    			GUI home = new GUI("E commerce Platform");      
=======
		Customer c1 = new Customer();
		c1.setEmail("Wayne@email");
		c1.setUsername("Wayne");
		c1.setAccountType("Customer");
		c1.setAddress(null);
		c1.setPassword("blegh123");
		c1.setAccountBalance(3590);
		Admin.getUserList().add(c1);
		//CustomerPage cp = new CustomerPage(c1.getEmail(), c1.getUsername(), c1.getPassword(), c1.getAccountType(), 2000.0);
		
		
		//To test sellerPage
		Seller s1 = new Seller();
		s1.setEmail("Robin@email");
		s1.setUsername("Robin");
		s1.setAccountType("Seller");
		s1.setAccountBalance(3590);
		Admin.getUserList().add(s1);
		//SellerPage p = new SellerPage(s1);
	
		//TO TEST AS A WHOLE
		GUI home = new GUI("E commerce Platform");    
>>>>>>> 28b6c0d1bbe6c55bf055ee314d3abbe6ee82bac5
		
	}
}