package org.ecp.people;

import java.util.ArrayList;
import java.util.Scanner;
import org.ecp.items.Order;
import org.ecp.items.Product;
import org.ecp.navigation.OnlineMaps;
import org.ecp.system.Admin;

public class Customer extends User {
   private String address;
   private ArrayList<Product> shoppingCart;
   private Order orderedProducts;

   public Customer() {
	   address = "unknown";
	   shoppingCart = new ArrayList<Product>();
	   orderedProducts = null;
   }

   public void setAddress(String addressChosen) {
       if (isValidString(addressChosen)) {
           this.address = addressChosen;
           System.out.println("Address set to: " + this.address);
       } else {
           System.out.println("Invalid address format!");
       }
   }
   
   public void chooseAddress(OnlineMaps location) {
	   System.out.println("Choose an address from this list: ");
	      System.out.println(location.getAddressList());
	      
	      Scanner myObj = new Scanner(System.in);
	      String addressChosen = myObj.nextLine();
	      
	      if (location.getAddressList().contains(addressChosen)) {
	    	 setAddress(addressChosen);
	      } //check in setAddress;
	      else {
	    	  System.out.println("Entered an invalid address. ");
	      }
   }

   public String getAddress() {
      return this.address;
   }

   public void setShoppingCart(ArrayList<Product> shoppingCart) {
      this.shoppingCart = shoppingCart;
   }

   public ArrayList<Product> getShoppingCart() {
      return this.shoppingCart;
   }

   public void addFunds(double amount) {
	    if (amount > 0) { // Ensure the amount to add is positive
	        this.accountBalance += amount;
	        System.out.println("Funds added successfully. Current balance: " + this.accountBalance);
	    } else {
	        System.out.println("Invalid amount. Please provide a positive amount to add.");
	    }
	}



   public void addProduct(Product product) {
      Scanner myObj = new Scanner(System.in);
      System.out.println("Enter quanity of product to add to shoppingCart: ");
      int quantityProd = myObj.nextInt();

      for(int i = 0; i < quantityProd; ++i) {
         this.shoppingCart.add(product); //might be an inefficient way to do this: should probably just change quantity in order product? 
         //or not, bc quantity field in product is seller's quantity, not customer's--> add new field?
      }

   }

   public void removeProduct(Product product) {
      Scanner myObj = new Scanner(System.in);
      System.out.println("Enter quanity of product to remove from shoppingCart: ");
      int totalLoop = myObj.nextInt();

      for(int i = 0; i < totalLoop; ++i) {
         if (this.shoppingCart.contains(product)) {
            this.shoppingCart.remove(product);
         }
      }

   }
   
   public void checkOut() {
	   if (this.shoppingCart.size() == 0) {
		   System.out.println("Cannot check out, no items in shopping cart.");
	   }
	   else {
		   for (Product product : this.shoppingCart) {
			   this.orderedProducts.addProductNames(product.getName());
		   }
		   completePayment();
	   }
		   
   }
   public void completePayment() {
	   orderedProducts.setCustomerName(this.username);
	   orderedProducts.setCustomerAddress(this.address);
	   orderedProducts.setStatus("Shipped"); //waiting for driver
	   orderedProducts.setDate(1); //CHANGE TO ADD CURRENT DATE (DATE OR TIMESTAMP ORDER IS PLACED)
	   Admin.getDeliveryList().add(orderedProducts);
   }

   public void cancelOrder() {
	   Scanner myObj = new Scanner(System.in);
	   System.out.println("Enter the name your order is placed under: ");
	   String userName = myObj.nextLine();
	   Integer currentDate = 0; ///GET CURRENT DATE TO CHECK IF USER IS ALLOWED TO CANCEL ORDER
	   for (Order order : Admin.getDeliveryList()) {
		   if (order.getCustomerName() == userName) {
			   if (order.getDate() < currentDate) {
				   Admin.getDeliveryList().remove(orderedProducts);
			   }
			   else {
				   System.out.println("Cannot cancel order, time of cancellation request is too close to delivery date.");
			   }
		   }
		   else {
			   System.out.println("There is no order under that name.");
		   }
	   }
   }

   public void submitComplaint() {
   }
   private boolean isValidString(String input) {
       // Add your logic here to validate the address as a string
       // For a simple check, you can ensure that the input is not empty
       return input != null && !input.trim().isEmpty();
   }
   
}

