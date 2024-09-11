package gymApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import gymApp.model.User;

public class UserDAOImplTest {

    private UserDAOImpl userDAO;
    private Connection connection;

    @Before
    public void setUp() throws Exception {
        connection = DriverManager.getConnection("jdbc:sqlite:./gymdb_test.db");
        userDAO = new UserDAOImpl(connection);

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

        User savedUser = userDAO.findByUsername("testuser");
        assertNotNull(savedUser);
        assertEquals("testuser", savedUser.getUsername());
    }

    @Test
    public void testFindUserByUsername() throws Exception {
        User user = new User("john", "password123", "john@example.com");
        userDAO.save(user);

        User foundUser = userDAO.findByUsername("john");
        assertNotNull(foundUser);
        assertEquals("john", foundUser.getUsername());
        assertEquals("john@example.com", foundUser.getEmail());
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User("updateuser", "oldpassword", "old@example.com");
        userDAO.save(user);

        user.setPassword("newpassword");
        user.setEmail("new@example.com");
        boolean result = userDAO.update(user);
        assertTrue(result);

        User updatedUser = userDAO.findByUsername("updateuser");
        assertEquals("newpassword", updatedUser.getPassword());
        assertEquals("new@example.com", updatedUser.getEmail());
    }

    @Test
    public void testDeleteUser() throws Exception {
        User user = new User("deleteuser", "password", "delete@example.com");
        userDAO.save(user);

        boolean result = userDAO.delete(user.getUsername());
        assertTrue(result);

        User deletedUser = userDAO.findByUsername("deleteuser");
        assertNull(deletedUser);
    }
}
