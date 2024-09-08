package gymApp;

import gymApp.controller.LoginController;
import gymApp.service.AuthService;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        LoginController loginController = new LoginController(authService);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        boolean isAuthenticated = loginController.login(username, password);
        System.out.println("Authenticated: " + isAuthenticated);
    }
}
