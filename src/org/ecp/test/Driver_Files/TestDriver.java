package org.ecp.people;

import org.ecp.items.Order;
import org.ecp.system.Admin;

public class DriverDriver {

    public static void main(String[] args) {

        // Create a Driver
        Driver driver = new Driver();
        driver.setUsername("test_driver");

        // Create some orders
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();

        // Add orders to the delivery driver's delivery list
        driver.addDelivery(order1);
        driver.addDelivery(order2);
        driver.addDelivery(order3);

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
