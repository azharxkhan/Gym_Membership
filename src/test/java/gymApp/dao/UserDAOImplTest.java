package gymApp.dao;

import gymApp.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.Assert.*;

public class UserDAOImplTest {

    private UserDAOImpl userDAO;
    private Connection connection;

    @Before
    public void setUp() throws Exception {
        // Set up SQLite database connection
        connection = DriverManager.getConnection("jdbc:sqlite:./gymdb_test.db");
        userDAO = new UserDAOImpl(connection);

        // Create users table for testing
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "username TEXT NOT NULL, " +
                                "password TEXT NOT NULL, " +
                                "email TEXT NOT NULL)";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
        }
    }

    @After
    public void tearDown() throws Exception {
        // Clean up database after each test
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS users");
        }
        connection.close();
    }

    @Test
    public void testSaveUser() throws Exception {
        User user = new User("testuser", "password123", "test@example.com");
        boolean result = userDAO.save(user);
        assertTrue(result);

        // Check if the user was saved in the database
        User savedUser = userDAO.findByUsername("testuser");
        assertNotNull(savedUser);
        assertEquals("testuser", savedUser.getUsername());
    }

    @Test
    public void testFindUserByUsername() throws Exception {
        // Insert a user into the database for testing
        User user = new User("john", "password123", "john@example.com");
        userDAO.save(user);

        // Find the user by username
        User foundUser = userDAO.findByUsername("john");
        assertNotNull(foundUser);
        assertEquals("john", foundUser.getUsername());
        assertEquals("john@example.com", foundUser.getEmail());
    }

    @Test
    public void testUpdateUser() throws Exception {
        // Insert and then update a user
        User user = new User("updateuser", "oldpassword", "old@example.com");
        userDAO.save(user);

        user.setPassword("newpassword");
        user.setEmail("new@example.com");
        boolean result = userDAO.update(user);
        assertTrue(result);

        // Fetch updated user
        User updatedUser = userDAO.findByUsername("updateuser");
        assertEquals("newpassword", updatedUser.getPassword());
        assertEquals("new@example.com", updatedUser.getEmail());
    }

    @Test
    public void testDeleteUser() throws Exception {
        // Insert and then delete a user
        User user = new User("deleteuser", "password", "delete@example.com");
        userDAO.save(user);

        boolean result = userDAO.delete(user.getUsername());
        assertTrue(result);

        // Verify the user was deleted
        User deletedUser = userDAO.findByUsername("deleteuser");
        assertNull(deletedUser);
    }
}
