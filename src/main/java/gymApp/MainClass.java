package gymApp;

import java.util.Scanner;

import gymApp.controller.LoginController;
import gymApp.controller.RegisterController;
import gymApp.dao.UserDAOImpl;
import gymApp.service.AuthService;
import gymApp.service.UserService;

public class MainClass {
    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();  

        AuthService authService = new AuthService(userDAO); 
        UserService userService = new UserService(userDAO);  
        LoginController loginController = new LoginController(authService);
        RegisterController registerController = new RegisterController(userService);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! Do you want to log in or register? (login/register):");
        String choice = scanner.nextLine();

        if ("login".equalsIgnoreCase(choice)) {
            System.out.println("Enter username:");
            String username = scanner.nextLine();

            System.out.println("Enter password:");
            String password = scanner.nextLine();

            boolean isAuthenticated = loginController.login(username, password);
            if (isAuthenticated) {
                System.out.println("Successfully authenticated.");
            } else {
                System.out.println("Authentication failed.");
            }
        } else if ("register".equalsIgnoreCase(choice)) {
            System.out.println("Enter a new username:");
            String newUsername = scanner.nextLine();

            System.out.println("Enter a new password:");
            String newPassword = scanner.nextLine();

            System.out.println("Enter your email:");
            String email = scanner.nextLine();

            boolean isRegistered = registerController.register(newUsername, newPassword, email);
            if (isRegistered) {
                System.out.println("Registration successful.");
            } else {
                System.out.println("Registration failed. Username may already exist.");
            }
        } else {
            System.out.println("Invalid choice. Please restart the application.");
        }
    }
}
