package org.ecp.system;

import java.util.ArrayList;
import org.ecp.items.Order;
import org.ecp.items.Product;
import org.ecp.people.Customer;
import org.ecp.people.Driver;
import org.ecp.people.Seller;
import org.ecp.people.User;

public class Admin {
   private static double maxLimit;
   private static Integer maxProducts;
   private static Integer maxDeliveries;
   private ArrayList<Product> itemDirectory;
   private static ArrayList<Order> deliveryList;
   //private ArrayList<User> userList;
   private static ArrayList<User> userList = new ArrayList<User>();

   public Admin() {
      maxLimit = 0.0D;
      maxProducts = 10;
      maxDeliveries = 5;
      itemDirectory = new ArrayList<Product>();
      deliveryList = new ArrayList<Order>();
      //userList = new ArrayList<User>();
   }

   public static void setMaxLimit(double maxLimit) {
      Admin.maxLimit = maxLimit;
   }
   
   public static double getMaxLimit() {
      return maxLimit;
   }

   public static void setMaxProducts(Integer maxProducts) {
      Admin.maxProducts = maxProducts;
   }
   
   public static Integer getMaxProducts() {
      return maxProducts;
   }
   
   public static void setMaxDeliveries(Integer maxDeliveries) {
	  Admin.maxDeliveries = maxDeliveries;
   }
   
   public static Integer getMaxDeliveries() {
	  return maxDeliveries;
   }

   public void setItemDirectory(ArrayList<Product> itemDirectory) {
      this.itemDirectory = itemDirectory;
   }
   
   public ArrayList<Product> getItemDirectory() {
      return itemDirectory;
   }

   public void setDeliveryList(ArrayList<Order> deliveryList) {
      Admin.deliveryList = deliveryList;
   }
   
   public static ArrayList<Order> getDeliveryList() {
      return deliveryList;
   }

   public void setUserList(ArrayList<User> userList) {
      Admin.userList = userList;
   }

   public ArrayList<User> getUserList() {
      return userList;
   }

   public Boolean detectSignupConflict(String email, String username, String password) {
	   //if(this.getUserList().contains(user_A))
	   for(User x: this.getUserList()) {
		   if(x.getUsername().equals(username) ) {
			   System.out.println("Username: " + x.getUsername() + " already exists.\nRe enter username");
			   return true;
		   }
		   if(x.getEmail().equals(email) ) {
			   System.out.println("Email: " + x.getEmail() + " already exists.\nRe enter email");
			   return true;
		   }
	   }
	   
	   if(email == null || username == null || password == null) {
		   System.out.println("Please fill all required information");
		   return true;
	   }
	   
	   return false;
   }
   
   public static void printSellers() {
	   for(User x: userList) { 
		if(x instanceof Seller) {
		System.out.println(x.getUsername());   
		}
	   }
   }
   
   public static void printCustomers() {
	   for(User x: userList) { 
		   if(x instanceof Customer) {
			   System.out.println(x.getUsername());   
		   }
	   }
   }
   
   public static void printDrivers() {
	   for(User x: userList) { 
		   if(x instanceof Driver) {
			   System.out.println(x.getUsername());
		   }
	   }
   }
   
   public static void printUsers() {
	   printSellers();
	   printCustomers();
	   printDrivers();
   }
   
   
   public boolean checkAccount() {
      return false;
   }

   public boolean checkFunds() {
      return false;
   }

   public boolean checkPayment() {
      return false;
   }

   public boolean checkProduct() {
      return false;
   }

   public boolean checkStatus() {
      return false;
   }
}

