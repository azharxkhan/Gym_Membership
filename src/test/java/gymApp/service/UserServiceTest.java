package gymApp.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import gymApp.dao.UserDAO;
import gymApp.model.User;

public class UserServiceTest {

    private UserService userService;
    private UserDAO userDAO;

    @BeforeEach
    public void setUp() {
        userDAO = Mockito.mock(UserDAO.class);
        userService = new UserService(userDAO); 
    }

    @Test
    public void testRegisterUserSuccess() {
        User user = new User(0, "JohnDoe", "password123", "john@example.com");

        Mockito.when(userDAO.findByUsername("JohnDoe")).thenReturn(null); 
        Mockito.when(userDAO.save(user)).thenReturn(true);  

        boolean result = userService.registerUser(user);

        assertTrue(result, "User registration should succeed.");
        Mockito.verify(userDAO, Mockito.times(1)).save(user);
    }

    @Test
    public void testRegisterUserFailOnDuplicate() {
        User existingUser = new User(1, "JohnDoe", "password123", "john@example.com");

        Mockito.when(userDAO.findByUsername("JohnDoe")).thenReturn(existingUser); 

        boolean result = userService.registerUser(existingUser);

        assertFalse(result, "User registration should fail due to duplicate username.");
        Mockito.verify(userDAO, Mockito.times(0)).save(existingUser); 
    }
}
