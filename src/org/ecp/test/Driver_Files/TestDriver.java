package org.ecp.test.Driver_Files;

import org.ecp.items.Order;
import org.ecp.people.Driver;
import org.ecp.system.Admin;

public class TestDriver {

    public static void main(String[] args) {

        // Create a Driver
        Driver driver = new Driver();

        // Add some orders to the delivery list (You can add specific orders from Admin or any other source)
        driver.setDeliveryList(Admin.getDeliveryList());

        // Add delivery
        driver.addDelivery();

        // Remove a delivery
        String orderToRemove = "John Doe"; // Replace with the actual order name
        driver.removeDelivery(orderToRemove);

        // Complete a delivery
        Order orderToComplete = new Order(); // Replace with the actual order object
        driver.completeDelivery(orderToComplete);
    }
}
