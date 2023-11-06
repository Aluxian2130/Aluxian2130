package org.ecp.items;

public class Product {
   private String name;
   private Double price;
   private String description;
   private Integer quantity;

   public Product() {
	   name = "unknown";
	   price = null;
	   description = "unknown";
	   quantity = 0;
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
}

