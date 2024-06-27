package gymApp;

import gymApp.controller.LoginController;
import gymApp.service.AuthService;

public class MainClass {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        LoginController loginController = new LoginController(authService);

        // Example usage
        boolean isAuthenticated = loginController.login("Azhar", "CorrectPassword");
        System.out.println("Authenticated: " + isAuthenticated);
    }
}
