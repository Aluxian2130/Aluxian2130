package org.ecp.people;

import java.util.ArrayList;
import java.util.Scanner;

import org.ecp.items.Order;
import org.ecp.items.Product;
import org.ecp.system.Admin;

public class Driver extends User {
   private ArrayList<Order> deliveries;

   public Driver() {
	   deliveries = new ArrayList<Order>();
   }

   public void setDeliveryList(ArrayList<Order> deliveries) {
      this.deliveries = deliveries;
   }

   public ArrayList<Order> getDeliveryList() {
      return deliveries;
   }

   public void addDelivery() {
	  System.out.println("Choose an order to deliver by entering Customer's name: ");
	  System.out.println(Admin.getDeliveryList());
	      
	  Scanner myObj = new Scanner(System.in);
	  String orderChosen = myObj.nextLine();
      if (deliveries.size() <= Admin.getMaxDeliveries()) {
    	  for (Order order : Admin.getDeliveryList()) {
    		  if (order.getCustomerName() == orderChosen) {
     	         this.deliveries.add(order);
     	         order.setStatus("In delivery");
    		  }
    		  else {
        		  System.out.println("This name does not match an order in the given list.");
        	  }
    	  }
    	  
      }
      else {
    	  System.out.println("You have reached maximum number of allowed deliveries. ");
      }

   }

   public void removeDelivery(String orderName) { 
	   Integer currentDate = 0; //GET CURRENT DATE/TIMESTAMP
	  for (Order order : deliveries) {
		  if (order.getCustomerName() == orderName) {
			  if (order.getDeliveryDate() - currentDate <= 1) {
				  this.deliveries.remove(order);
				  order.setStatus("Waiting for driver.");
			  }
			  else {
				  System.out.println("The current date is too close to scheduled date of delivery. Proceed with completing delivery. ");
			  }
		  }
		  else {
			  System.out.println("This order is not in your list of scheduled deliveries. ");
		  }
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

   @Override
   public void addProduct(Product var1) { } // Technically should not exist in driver. Added so driver class does not have to be abstract for now. 
   @Override
   public void removeProduct(Product var1) { } // Technically should not exist in driver. Added so driver class does not have to be abstract for now. 
}

