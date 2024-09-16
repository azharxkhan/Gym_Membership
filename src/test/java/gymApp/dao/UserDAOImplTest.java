package gymApp.dao;

import gymApp.model.User;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserDAOImplTest {

    private UserDAOImpl userDAO;
    private Connection connection;

    @BeforeAll
    public void setUp() throws SQLException {
        // Initialize in-memory SQLite database for testing
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        userDAO = new UserDAOImpl(connection);
        
        // Create the users table for testing
        connection.createStatement().execute(
            "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "username TEXT NOT NULL UNIQUE, password TEXT NOT NULL, email TEXT NOT NULL, role TEXT)"
        );
    }

    @AfterAll
    public void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    public void testSaveUser() {
        User user = new User(0, "testuser", "password", "testuser@example.com", "member");
        assertTrue(userDAO.save(user), "User should be saved successfully");
    }

    @Test
    public void testFindUserByUsername() {
        // Save a user first
        User user = new User(0, "testfind", "password", "finduser@example.com", "member");
        userDAO.save(user);

        // Find the user by username
        User foundUser = userDAO.findByUsername("testfind");
        assertNotNull(foundUser, "User should be found");
        assertEquals("testfind", foundUser.getUsername(), "Username should match");
    }

    @Test
    public void testUpdateUser() {
        // Save a user first
        User user = new User(0, "testupdate", "password", "updateuser@example.com", "member");
        userDAO.save(user);

        // Update the user's details
        user.setPassword("newpassword");
        user.setEmail("updateduser@example.com");
        assertTrue(userDAO.update(user), "User should be updated successfully");

        // Verify the update
        User updatedUser = userDAO.findByUsername("testupdate");
        assertEquals("newpassword", updatedUser.getPassword(), "Password should be updated");
        assertEquals("updateduser@example.com", updatedUser.getEmail(), "Email should be updated");
    }

    @Test
    public void testDeleteUser() {
        // Save a user first
        User user = new User(0, "testdelete", "password", "deleteuser@example.com", "member");
        userDAO.save(user);

        // Delete the user
        assertTrue(userDAO.delete("testdelete"), "User should be deleted successfully");

        // Verify the deletion
        assertNull(userDAO.findByUsername("testdelete"), "User should not be found after deletion");
    }

    @Test
    public void testSaveDuplicateUser() {
        User user1 = new User(0, "testduplicate", "password", "duplicateuser@example.com", "member");
        User user2 = new User(0, "testduplicate", "password", "duplicateuser2@example.com", "member");

        // Save the first user
        assertTrue(userDAO.save(user1), "First user should be saved");

        // Try to save a user with the same username
        assertFalse(userDAO.save(user2), "Saving duplicate user should fail");
    }
}
