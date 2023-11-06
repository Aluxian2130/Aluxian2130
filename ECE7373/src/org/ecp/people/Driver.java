package org.ecp.people;

import java.util.ArrayList;
import org.ecp.items.Order;
import org.ecp.system.Admin;

public abstract class Driver extends User {
   private ArrayList<Order> deliveries;

   Driver() {
	   deliveries = new ArrayList<Order>();
   }

   public void setDeliveryList(ArrayList<Order> deliveries) {
      this.deliveries = deliveries;
   }

   public ArrayList<Order> getDeliveryList() {
      return deliveries;
   }

   public void addDelivery(Order order) {
      if (Admin.getDeliveryList().contains(order)) {
         this.deliveries.add(order);
      }

   }

   public void removeDelivery(Order order) {
      if (this.deliveries.contains(order) && order.getDate() >= 0) {
         this.deliveries.remove(order);
      }

   }
   public void completeDelivery(Order order) {
	   if (Admin.getDeliveryList().contains(order) && (order.getStatus() != "delivered")) {
	         order.setStatus("delivered");
	         Admin.getDeliveryList().remove(order);
	         this.deliveries.remove(order);
	         //add to customer's order history list
	      }
   }

   public void createAccount() {
   }
}

