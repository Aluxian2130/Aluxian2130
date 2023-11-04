import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SellerTest {

    @Test
    public void testSetProductList() {
        Seller seller = new Seller();
        ArrayList<Product> productList = new ArrayList<>();
        Product product1 = new Product("Product 1", 10.0);
        productList.add(product1);
        seller.setProductList(productList);
        assertEquals("Product list should be set", productList, seller.getProductList());
    }

    @Test
    public void testAddProduct() {
        Seller seller = new Seller();
        Product product = new Product("Test Product", 20.0);
        // You might need to simulate user input for the product details (name, price, quantity, description)
        // Mocking user input is beyond the scope of this test, so it's not shown here.
        seller.addProduct(product);
        assertTrue("Seller should have the added product", seller.getProductList().contains(product));
    }

    @Test
    public void testRemoveProduct() {
        Seller seller = new Seller();
        Product product = new Product("Product 1", 10.0);
        seller.addProduct(product);
        seller.removeProduct(product);
        assertFalse("Seller should not have the removed product", seller.getProductList().contains(product));
    }

    @Test
    public void testUpdateProduct() {
        Seller seller = new Seller();
        Product product = new Product("Product 1", 10.0);
        seller.addProduct(product);
        // You might need to simulate user input for the field to be modified and the new value
        // Mocking user input is beyond the scope of this test, so it's not shown here.
        seller.updateProduct(product);
        // Assert that the product's field is updated as expected
        // For instance, you can use assertEquals to compare the new value with the expected value
        // Example: assertEquals("Product name should be updated", "New Name", product.getName());
    }
}
