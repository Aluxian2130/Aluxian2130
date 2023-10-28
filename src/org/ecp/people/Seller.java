package org.ecp.people;

import java.util.ArrayList;
import java.util.Scanner;
import org.ecp.items.Product;
import org.ecp.system.Admin;

public class Seller extends User {
   private ArrayList<Product> products;

   Seller() {
	   products = new ArrayList<Product>();
   }

   public ArrayList<Product> getProductList() {
      return this.products;
   }

   public void setProductList(ArrayList<Product> products) {
      this.products = products;
   }

   public void addProduct(Product product) {
      if (this.products.size() < Admin.getMaxProducts()) {
         System.out.println("Adding product to Seller's Products: ");
         Scanner myObj = new Scanner(System.in);
         System.out.println("Enter name of product: ");
         product.setName(myObj.nextLine());
         System.out.println("Enter price of product: ");
         product.setPrice(myObj.nextDouble());
         System.out.println("Enter quanity of product: ");
         if (myObj.nextInt() != 0) {
            product.setQuantity(myObj.nextInt());
         }

         System.out.println("Add description of product? (true/false): ");
         if (myObj.nextBoolean()) {
            System.out.println("Enter quanity of product to add to shoppingCart: ");
            product.setDescription(myObj.nextLine());
         }

         if (product.getName() != "unknown" && product.getPrice() != 0.0D && product.getQuantity() != 0) {
            this.products.add(product);
         } else {
            System.out.println("Could not add product because one or more of required fields (name, price, quantity) was empty. ");
         }
      }

   }

   public void removeProduct(Product product) {
      if (this.products.contains(product)) {
         this.products.remove(product);
      }

   }

   public void updateProduct(Product product) {
      if (this.products.contains(product)) {
         System.out.println("Which field would you like to modify? (name, price, quantity, description): ");
         Scanner myObj = new Scanner(System.in);
         if (myObj.nextLine() == "name") {
            System.out.println("Enter new name of product: ");
            product.setName(myObj.nextLine());
         } else if (myObj.nextLine() == "price") {
            System.out.println("Enter new price of product: ");
            product.setPrice(myObj.nextDouble());
         } else if (myObj.nextLine() == "quantity") {
            System.out.println("Enter new quantity of product: ");
            product.setQuantity(myObj.nextInt());
         } else if (myObj.nextLine() == "description") {
            System.out.println("Enter new description of product: ");
            product.setDescription(myObj.nextLine());
         } else {
            System.out.println("Did not enter correct field. ");
         }
      }

   }

   public void createAccount() {
   }
}

