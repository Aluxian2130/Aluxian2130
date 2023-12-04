package org.ecp.items;

import org.ecp.people.Seller;

public class Product {
   private String name;
   private Double price;
   private String description;
   private Integer quantity;
   private Seller seller;

   public Product() {
	   name = "unknown";
	   price = 0.0;
	   description = "unknown";
	   quantity = 0;
	   seller = null;
   }

   public Product(String name, double price, Integer quantity) {
 	   this.name = name;
 	   this.price = price;
 	   this.quantity = quantity;
    }
   
   public void setName(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public Double getPrice() {
      return price;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getDescription() {
      return description;
   }

   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }

   public Integer getQuantity() {
      return quantity;
   }
   
   public void setSeller(Seller seller) {
	   this.seller = seller;
   }

   public Seller getSeller() {
	   return seller;
   }

   
}

