import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testSetAddress() {
        Customer customer = new Customer();
        customer.setAddress(1); // Assuming 1 is a valid address position
        assertEquals("Address should be set to the chosen address", "chosen address", customer.getAddress());
    }

    @Test
    public void testSetShoppingCart() {
        Customer customer = new Customer();
        ArrayList<Product> shoppingCart = new ArrayList<>();
        Product product1 = new Product("Product 1", 10.0);
        shoppingCart.add(product1);
        customer.setShoppingCart(shoppingCart);
        assertEquals("Shopping cart should be set", shoppingCart, customer.getShoppingCart());
    }

    @Test
    public void testAddFunds() {
        Customer customer = new Customer();
        customer.addFunds(50.0);
        assertEquals("Account balance should be increased", 50.0, customer.getAccountBalance(), 0.01);
    }

    @Test
    public void testAddProduct() {
        Customer customer = new Customer();
        Product product = new Product("Product 1", 10.0);
        customer.addProduct(product);
        assertEquals("Shopping cart should contain the added product", 1, customer.getShoppingCart().size());
    }

    @Test
    public void testRemoveProduct() {
        Customer customer = new Customer();
        Product product = new Product("Product 1", 10.0);
        customer.addProduct(product);
        customer.removeProduct(product);
        assertEquals("Shopping cart should not contain the removed product", 0, customer.getShoppingCart().size());
    }
}
