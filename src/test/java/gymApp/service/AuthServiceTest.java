package gymApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import gymApp.dao.UserDAO;
import gymApp.model.User;

public class AuthServiceTest {

    private AuthService authService;
    private UserDAO userDAO;

    @BeforeEach
    public void setUp() {
        userDAO = Mockito.mock(UserDAO.class);
        authService = new AuthService(userDAO); 
    }

    @Test
    public void testAuthenticateSuccess() {
        User user = new User(1, "Azhar", "CorrectPassword", "azhar@example.com", "member");

        Mockito.when(userDAO.findByUsername("Azhar")).thenReturn(user);

        boolean result = authService.authenticate("Azhar", "CorrectPassword");

        assertTrue(result, "Authentication should succeed with correct credentials.");
    }

    @Test
    public void testAuthenticateFailWrongPassword() {
        User user = new User(1, "Azhar", "CorrectPassword", "azhar@example.com", "admin");

        Mockito.when(userDAO.findByUsername("Azhar")).thenReturn(user);

        boolean result = authService.authenticate("Azhar", "WrongPassword");

        assertFalse(result, "Authentication should fail with incorrect password.");
    }

    @Test
    public void testAuthenticateFailNonExistentUser() {
        Mockito.when(userDAO.findByUsername("NonExistentUser")).thenReturn(null);

        boolean result = authService.authenticate("NonExistentUser", "SomePassword");

        assertFalse(result, "Authentication should fail if the user does not exist.");
    }

    @Test
    public void testAuthenticateAdminUser() {
        User adminUser = new User(1, "AdminUser", "adminpass", "admin@example.com", "admin");

        Mockito.when(userDAO.findByUsername("AdminUser")).thenReturn(adminUser);

        boolean result = authService.authenticate("AdminUser", "adminpass");

        assertTrue(result, "Authentication should succeed for an admin user with correct credentials.");
        assertEquals("admin", adminUser.getRole(), "The user role should be 'admin'.");
    }
}
