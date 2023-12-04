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
   private static ArrayList<Customer> customerList = new ArrayList<Customer>();
   private static ArrayList<Seller> sellerList = new ArrayList<Seller>();
   private static ArrayList<Driver> driverList = new ArrayList<Driver>();

   public Admin() {
      maxLimit = 100.0;
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

   public static ArrayList<User> getUserList() {
      return userList;
   }
   
   public static ArrayList<Customer> getCustomerList() {
       return customerList;
   }
   public static ArrayList<Driver> getDriverList() {
       return driverList;
   }
   public static ArrayList<Seller> getSellerList() {
	   return sellerList;
   }
   public void setCustomerList(ArrayList<Customer> customerList) {
	   Admin.customerList = customerList;
   }
   public void setDriverList(ArrayList<Driver> driverList) {
	   Admin.driverList = driverList;
   }
   public void setSellerList(ArrayList<Seller> sellerList) {
	   Admin.sellerList = sellerList;
   }

   public static Boolean detectSignupConflict(String email, String username, String password, String accountType) {
	   //if(this.getUserList().contains(user_A))
	   for(User x: Admin.getUserList()) {
		   if(x.getUsername().equals(username) ) {
			   System.out.println("Username: " + x.getUsername() + " already exists.");
			   return true;
		   }
		   if(x.getEmail().equals(email) ) {
			   System.out.println("Email: " + x.getEmail() + " already exists.");
			   return true;
		   }
	   }
	   
	   if(email == null || username == null || password == null || accountType == null) {
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

