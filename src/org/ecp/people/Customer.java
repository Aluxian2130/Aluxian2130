package org.ecp.people;

import java.util.ArrayList;
import java.util.Scanner;
import org.ecp.items.Order;
import org.ecp.items.Product;
import org.ecp.navigation.OnlineMaps;
import org.ecp.system.Admin;

public class Customer extends User {
   private String address = "unknown";
   private ArrayList<Product> shoppingCart = new ArrayList();

   Customer() {
   }

   public void setAddress(Integer addressPos) {
      OnlineMaps om = null; //maybe have a new OnlineMaps object for diff countries etc???
      
      Scanner myObj = new Scanner(System.in);
      String addressChosen = myObj.nextLine();
      System.out.println("Choose an address from this list: ");
      System.out.println(om.getAddressList());
      
      if (om.getAddressList().contains(addressChosen)) {
    	 address = addressChosen;
      }
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
      if (this.accountBalance + amount <= Admin.getMaxLimit()) {
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

   public void completePayment() {
   }

   public void cancelOrder(Order order) {
   }

   public void submitComplaint() {
   }

   public void createAccount() {
   }
}

