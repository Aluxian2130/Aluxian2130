package org.ecp.items;

public class Product {
   private String name;
   private double price;
   private String description;
   private Integer quantity;

   Product() {
	   name = "unknown";
	   price = 0.0;
	   description = "unknown";
	   quantity = 0;
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

   public double getPrice() {
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
}

