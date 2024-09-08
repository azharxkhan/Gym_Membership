package gymApp.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import gymApp.model.User;

public class UserServiceTest {

    private UserService userService;
    private UserDAO userDAO;

    @BeforeEach
    public void setUp() {
        userDAO = Mockito.mock(UserDAO.class);
        userService = new UserService(userDAO); // Assuming UserService takes UserDAO as a constructor parameter
    }

    @Test
    public void testRegisterUserSuccess() {
        User user = new User("JohnDoe", "password123", "john@example.com");

        // Mocking the behavior of UserDAO
        Mockito.when(userDAO.save(user)).thenReturn(true);

        boolean result = userService.registerUser(user);

        assertTrue(result, "User registration should succeed.");
        Mockito.verify(userDAO, Mockito.times(1)).save(user);
    }

    @Test
    public void testRegisterUserFailOnDuplicate() {
        User user = new User("JohnDoe", "password123", "john@example.com");

        // Mocking the behavior of UserDAO to simulate duplicate user
        Mockito.when(userDAO.findByUsername("JohnDoe")).thenReturn(user);

        boolean result = userService.registerUser(user);

        assertFalse(result, "User registration should fail due to duplicate username.");
        Mockito.verify(userDAO, Mockito.times(0)).save(user); // Save should not be called
    }
}

