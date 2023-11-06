package org.ecp.test.Driver_Files;

import java.util.ArrayList;

import org.ecp.items.Order;
import org.ecp.people.Driver;
import org.ecp.system.Admin;

public class TestDriver {

    @SuppressWarnings("static-access")
	public static void main(String[] args) {


        Driver driver = new Driver();
        driver.setUsername("test_driver");

        // Create some orders
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();

        // Add orders to the delivery driver's delivery list
        Admin admin = new Admin();
        admin.setDeliveryList(new ArrayList<Order>());
        admin.getDeliveryList().add(order1);
        admin.getDeliveryList().add(order2);
        admin.getDeliveryList().add(order3);
        driver.setDeliveryList(admin.getDeliveryList());

        // Remove an order from the delivery list
        driver.removeDelivery(order2);

        // Complete a delivery
        driver.completeDelivery(order1);

        // Print the driver's information
        System.out.println("Driver Information:");
        System.out.println("Username: " + driver.getUsername());

        // Print the delivery list
        System.out.println("\nDelivery List:");
        for (Order order : driver.getDeliveryList()) {
            System.out.println("Order ID: " + order.getId() + " - Status: " + order.getStatus());
        }

        // Perform other driver-related actions as needed

    }
}
