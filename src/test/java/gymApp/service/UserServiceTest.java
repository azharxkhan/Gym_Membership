    package gymApp.service;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;

    import org.junit.jupiter.api.AfterEach;
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertFalse;
    import static org.junit.jupiter.api.Assertions.assertNotNull;
    import static org.junit.jupiter.api.Assertions.assertTrue;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;

    import gymApp.dao.UserDAOImpl;
    import gymApp.model.User;

    public class UserServiceTest {

        private UserService userService;
        private Connection connection;
        private UserDAOImpl userDAO;

        @BeforeEach
        public void setUp() throws SQLException {
            // Set up an in-memory SQLite database
            connection = DriverManager.getConnection("jdbc:sqlite::memory:");
            userDAO = new UserDAOImpl(connection);
            userService = new UserService(userDAO);

            try (Statement stmt = connection.createStatement()) {
                stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "username TEXT NOT NULL UNIQUE, " +
                        "password TEXT NOT NULL, " +
                        "email TEXT NOT NULL, " +
                        "role TEXT NOT NULL)");
            }
        }

        @AfterEach
        public void tearDown() throws SQLException {
            connection.close();
        }

        @Test
        public void testRegisterUserSuccess() {
            User user = new User(0, "JohnDoe", "Password123", "john@example.com", "member");

            boolean result = userService.registerUser(user);

            assertTrue(result, "User registration should succeed.");
            User registeredUser = userDAO.findByUsername("JohnDoe");
            assertNotNull(registeredUser, "User should be registered in the database.");
        }

        @Test
        public void testRegisterAdminUserSuccess() {
            User adminUser = new User(0, "AdminUser", "AdminPass123", "admin@example.com", "admin");

            boolean result = userService.registerUser(adminUser);

            assertTrue(result, "Admin user registration should succeed.");
            User registeredAdmin = userDAO.findByUsername("AdminUser");
            assertNotNull(registeredAdmin, "Admin should be registered in the database.");
            assertEquals("admin", registeredAdmin.getRole(), "The role should be 'admin'.");
        }

        @Test
        public void testRegisterUserFailOnDuplicate() {
            User existingUser = new User(0, "JohnDoe", "Password123", "john@example.com", "member");

            // Register the first user
            userService.registerUser(existingUser);

            // Try to register the same user again
            User duplicateUser = new User(0, "JohnDoe", "AnotherPassword", "john@example.com", "member");
            boolean result = userService.registerUser(duplicateUser);

            assertFalse(result, "User registration should fail due to duplicate username.");
        }

        @Test
        public void testRegisterAdminUserFailOnDuplicate() {
            User existingAdmin = new User(0, "AdminUser", "AdminPass123", "admin@example.com", "admin");

            // Register the first admin
            userService.registerUser(existingAdmin);

            // Try to register the same admin again
            User duplicateAdmin = new User(0, "AdminUser", "AnotherAdminPass", "admin2@example.com", "admin");
            boolean result = userService.registerUser(duplicateAdmin);

            assertFalse(result, "Admin user registration should fail due to duplicate username.");
        }
    }
