package org.ecp.system;

import java.util.ArrayList;
import org.ecp.items.Order;
import org.ecp.items.Product;
import org.ecp.people.User;

public class Admin {
   private static double maxLimit;
   private static Integer maxProducts;
   private ArrayList<Product> itemDirectory;
   private static ArrayList<Order> deliveryList;
   private ArrayList<User> userList;

   Admin() {
      maxLimit = 0.0;
      maxProducts = 0;
      itemDirectory = new ArrayList<Product>();
      deliveryList = new ArrayList<Order>();
      userList = new ArrayList<User>();
   }

   public void setMaxLimit(double maxLimit) {
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
      this.userList = userList;
   }

   public ArrayList<User> getUserList() {
      return userList;
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

