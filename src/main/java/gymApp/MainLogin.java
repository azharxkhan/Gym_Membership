package gymApp;

import java.util.Scanner;

import gymApp.controller.LoginController;
import gymApp.controller.RegisterController;
import gymApp.dao.UserDAOImpl;
import gymApp.model.User;
import gymApp.service.AuthService;
import gymApp.service.UserService;

public class MainLogin {
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
                User authenticatedUser = userService.findByUsername(username);
                System.out.println("Successfully authenticated. Your role is: " + authenticatedUser.getRole());

                if ("admin".equalsIgnoreCase(authenticatedUser.getRole())) {
                    System.out.println("As an admin, do you want to register a new admin user? (yes/no):");
                    String adminChoice = scanner.nextLine();

                    if ("yes".equalsIgnoreCase(adminChoice)) {
                        System.out.println("Enter a new admin username:");
                        String newAdminUsername = scanner.nextLine();

                        System.out.println("Enter a new admin password:");
                        String newAdminPassword = scanner.nextLine();

                        System.out.println("Enter new admin's email:");
                        String newAdminEmail = scanner.nextLine();

                        boolean isAdminRegistered = registerController.register(newAdminUsername, newAdminPassword, newAdminEmail, "admin");
                        if (isAdminRegistered) {
                            System.out.println("New admin registration successful.");
                        } else {
                            System.out.println("Admin registration failed. Username may already exist.");
                        }
                    }
                }
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

            boolean isRegistered = registerController.register(newUsername, newPassword, email, "member");
            if (isRegistered) {
                System.out.println("Registration successful. You have been registered as a member.");
            } else {
                System.out.println("Registration failed. Username may already exist.");
            }
        } else {
            System.out.println("Invalid choice. Please restart the application.");
        }
    }
}
