package gymApp.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import gymApp.service.AuthService;
import gymApp.controller.LoginController;

class LoginControllerTest {

    private LoginController loginController;
    private AuthService authService;

    @BeforeEach
    void setUp() {
        authService = Mockito.mock(AuthService.class);
        loginController = new LoginController(authService);
    }

    @Test
    void testLoginSuccess() {
        String username = "Azhar";
        String password = "CorrectPassword";
        when(authService.authenticate(username, password)).thenReturn(true);

        boolean result = loginController.login(username, password);

        assertTrue(result);
        verify(authService, times(1)).authenticate(username, password);
    }

    @Test
    void testLoginFailure() {
        String username = "Azhar";
        String password = "WrongPassword";
        when(authService.authenticate(username, password)).thenReturn(false);

        boolean result = loginController.login(username, password);

        assertFalse(result);
        verify(authService, times(1)).authenticate(username, password);
    }
}

