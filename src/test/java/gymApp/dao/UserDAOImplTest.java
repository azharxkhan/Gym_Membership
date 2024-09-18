package gymApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gymApp.model.User;

public class UserDAOImplTest {

    private Connection connection;
    private UserDAOImpl userDAO;

    @BeforeEach
    public void setUp() throws SQLException {
        // Set up an in-memory SQLite database
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        userDAO = new UserDAOImpl(connection);

        // Create the users table
        userDAO.createUsersTable();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    public void testSaveUser() {
        User user = new User(0, "JohnDoe", "Password123", "john@example.com", "member");

        boolean result = userDAO.save(user);

        assertTrue(result, "User should be saved successfully.");
        User savedUser = userDAO.findByUsername("JohnDoe");
        assertNotNull(savedUser, "Saved user should not be null.");
        assertEquals("JohnDoe", savedUser.getUsername(), "Username should match.");
    }

    @Test
    public void testFindByUsername() {
        User user = new User(0, "JaneDoe", "Password123", "jane@example.com", "member");
        userDAO.save(user);

        User foundUser = userDAO.findByUsername("JaneDoe");

        assertNotNull(foundUser, "User should be found in the database.");
        assertEquals("JaneDoe", foundUser.getUsername(), "Username should match.");
        assertEquals("jane@example.com", foundUser.getEmail(), "Email should match.");
    }

    @Test
    public void testUpdateUser() {
        User user = new User(0, "JohnDoe", "Password123", "john@example.com", "member");
        userDAO.save(user);

        user.setEmail("newemail@example.com");
        user.setPassword("NewPassword123");
        boolean updateResult = userDAO.update(user);

        assertTrue(updateResult, "User should be updated successfully.");

        User updatedUser = userDAO.findByUsername("JohnDoe");
        assertNotNull(updatedUser, "Updated user should not be null.");
        assertEquals("newemail@example.com", updatedUser.getEmail(), "Email should be updated.");
        assertEquals("NewPassword123", updatedUser.getPassword(), "Password should be updated.");
    }

    @Test
    public void testDeleteUser() {
        User user = new User(0, "JohnDoe", "Password123", "john@example.com", "member");
        userDAO.save(user);

        boolean deleteResult = userDAO.delete("JohnDoe");

        assertTrue(deleteResult, "User should be deleted successfully.");
        User deletedUser = userDAO.findByUsername("JohnDoe");
        assertNull(deletedUser, "Deleted user should be null.");
    }

    @Test
    public void testFindAllUsers() {
        User user1 = new User(0, "UserOne", "Password123", "userone@example.com", "member");
        User user2 = new User(0, "UserTwo", "Password456", "usertwo@example.com", "member");
        userDAO.save(user1);
        userDAO.save(user2);

        List<User> users = userDAO.findAllUsers();

        assertEquals(2, users.size(), "There should be two users in the database.");
    }

    @Test
    public void testCountUsers() {
        User user1 = new User(0, "UserOne", "Password123", "userone@example.com", "member");
        User user2 = new User(0, "UserTwo", "Password456", "usertwo@example.com", "member");
        userDAO.save(user1);
        userDAO.save(user2);

        int userCount = userDAO.countUsers();

        assertEquals(2, userCount, "User count should be 2.");
    }

    @Test
    public void testSaveDuplicateUser() {
        User user1 = new User(0, "duplicateUser", "password123", "email1@example.com", "member");
        User user2 = new User(0, "duplicateUser", "password456", "email2@example.com", "member");

        // First save should succeed
        boolean result1 = userDAO.save(user1);
        assertTrue(result1, "First user save should succeed.");

        // Second save with the same username should fail
        boolean result2 = userDAO.save(user2);
        assertFalse(result2, "Second user save should fail due to duplicate username.");
    }

}
