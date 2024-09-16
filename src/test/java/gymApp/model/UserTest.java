package gymApp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the User class.
 */
public class UserTest {

    @Test
    public void testUserConstructor() {
        // Create a user using the constructor
        User user = new User(1, "testuser", "password", "testuser@example.com", "member");

        // Check if the fields are correctly set
        assertEquals(1, user.getId(), "User ID should be correctly set");
        assertEquals("testuser", user.getUsername(), "Username should be correctly set");
        assertEquals("password", user.getPassword(), "Password should be correctly set");
        assertEquals("testuser@example.com", user.getEmail(), "Email should be correctly set");
        assertEquals("member", user.getRole(), "Role should be correctly set");
    }

    @Test
    public void testSetUsername() {
        User user = new User(1, "testuser", "password", "testuser@example.com", "member");
        user.setUsername("newusername");
        assertEquals("newusername", user.getUsername(), "Username should be updated");
    }

    @Test
    public void testSetPassword() {
        User user = new User(1, "testuser", "password", "testuser@example.com", "member");
        user.setPassword("newpassword");
        assertEquals("newpassword", user.getPassword(), "Password should be updated");
    }

    @Test
    public void testSetEmail() {
        User user = new User(1, "testuser", "password", "testuser@example.com", "member");
        user.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", user.getEmail(), "Email should be updated");
    }

    @Test
    public void testSetRole() {
        User user = new User(1, "testuser", "password", "testuser@example.com", "member");
        user.setRole("admin");
        assertEquals("admin", user.getRole(), "Role should be updated to admin");
    }

    @Test
    public void testInvalidRole() {
        User user = new User(1, "testuser", "password", "testuser@example.com", "invalidRole");

        // Test for a role that is not valid (this depends on your business logic)
        // Optionally, you could throw an exception if an invalid role is set, but for now we are just testing what happens.
        assertEquals("invalidRole", user.getRole(), "Role should be whatever is passed in the constructor");
    }
}

