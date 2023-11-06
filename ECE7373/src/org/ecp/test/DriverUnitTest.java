import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DriverTest {

    @Test
    public void testSetDeliveryList() {
        Driver driver = new Driver();
        ArrayList<Order> deliveryList = new ArrayList<>();
        Order order1 = new Order();
        deliveryList.add(order1);
        driver.setDeliveryList(deliveryList);
        assertEquals("Delivery list should be set", deliveryList, driver.getDeliveryList());
    }

    @Test
    public void testAddDelivery() {
        Driver driver = new Driver();
        Order order = new Order();
        Admin.addOrder(order); // Assuming there's an `addOrder` method in the Admin class
        driver.addDelivery(order);
        assertTrue("Driver should have the added delivery", driver.getDeliveryList().contains(order));
    }

    @Test
    public void testRemoveDelivery() {
        Driver driver = new Driver();
        Order order = new Order();
        Admin.addOrder(order);
        driver.addDelivery(order);
        driver.removeDelivery(order);
        assertFalse("Driver should not have the removed delivery", driver.getDeliveryList().contains(order));
    }

    @Test
    public void testCompleteDelivery() {
        Driver driver = new Driver();
        Order order = new Order();
        Admin.addOrder(order);
        driver.addDelivery(order);
        driver.completeDelivery(order);
        assertEquals("Order should be marked as delivered", "delivered", order.getStatus());
        assertFalse("Admin should not have the delivered order", Admin.getDeliveryList().contains(order));
        assertFalse("Driver should not have the delivered order", driver.getDeliveryList().contains(order));
        // You might need to add more assertions based on the expected behavior
    }
}
