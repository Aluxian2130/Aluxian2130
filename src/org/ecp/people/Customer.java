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
   private OnlineMaps om = new OnlineMaps();

   public Customer() {
	   address = "unknown";
	   shoppingCart = new ArrayList<Product>();
	   orderedProducts = null;
   }

   public void setAddress(String addressChosen) {
      if (om.getAddressList().contains(addressChosen)) { this.address = addressChosen; }
      else { System.out.println("This address does not exist in the list."); }
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
      if ((amount > 0) && (this.accountBalance + amount <= Admin.getMaxLimit())) {
         this.accountBalance += amount;
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
	   orderedProducts.setStatus("Waiting for driver."); 
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

   
}

