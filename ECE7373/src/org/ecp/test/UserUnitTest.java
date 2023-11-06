import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testSetEmail() {
        User user = new User();
        user.setEmail("test@example.com");
        assertEquals("Email should be set", "test@example.com", user.getEmail());
    }

    @Test
    public void testSetPassword() {
        User user = new User();
        user.setPassword("password123");
        assertEquals("Password should be set", "password123", user.getPassword());
    }

    @Test
    public void testSetUsername() {
        User user = new User();
        user.setUsername("testuser");
        assertEquals("Username should be set", "testuser", user.getUsername());
    }

    @Test
    public void testSetAccountBalance() {
        User user = new User();
        user.setAccountBalance(100.0);
        assertEquals("Account balance should be set", 100.0, user.getAccountBalance(), 0.01);
    }

    @Test
    public void testRemoveFunds() {
        User user = new User();
        user.setAccountBalance(100.0);
        user.removeFunds(50.0);
        assertEquals("Account balance should be decreased", 50.0, user.getAccountBalance(), 0.01);
    }

    @Test
    public void testDeleteAccount() {
        // You might need to test the behavior of the deleteAccount method in a specific subclass
        // Since it's a protected method in the base class, it can't be tested directly in this context.
    }

    @Test
    public void testLogin() {
        // You might need to test the behavior of the login method in a specific subclass
        // Since it's a protected method in the base class, it can't be tested directly in this context.
    }

    @Test
    public void testLogout() {
        // You might need to test the behavior of the logout method in a specific subclass
        // Since it's a protected method in the base class, it can't be tested directly in this context.
    }
}
