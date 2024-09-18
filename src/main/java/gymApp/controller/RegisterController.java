package gymApp.controller;

import gymApp.model.User;
import gymApp.service.UserService;

public class RegisterController {

    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Registers a new user with a specified role.
     * 
     * @param username the username of the user
     * @param password the password of the user
     * @param email the email of the user
     * @param role the role of the user (admin or member)
     * @return true if the registration is successful, false otherwise
     * @throws IllegalArgumentException if the role is invalid or inputs are empty/invalid
     */
    public boolean register(String username, String password, String email, String role) {
        // Validate role
        if (!role.equalsIgnoreCase("admin") && !role.equalsIgnoreCase("member")) {
            throw new IllegalArgumentException("Invalid role specified. Role must be either 'admin' or 'member'.");
        }

        if (username == null || username.trim().isEmpty()) {
            System.out.println("Username is required.");
            return false;
        }
        
        if (password == null || password.trim().isEmpty()) {
            System.out.println("Password is required.");
            return false;
        }

        if (email == null || !isValidEmail(email)) {
            System.out.println("Invalid email format.");
            return false;
        }

        // Create the new user object
        User newUser = new User(0, username, password, email, role);

        // Attempt to register the user
        boolean isRegistered = userService.registerUser(newUser);
        
        if (isRegistered) {
            System.out.println("User registered successfully: " + username);
            return true;
        } else {
            System.out.println("Registration failed. Username may already exist.");
            return false;
        }
    }

    /**
     * Validates an email address using a simple regex pattern.
     * 
     * @param email the email to validate
     * @return true if the email is valid, false otherwise
     */
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
}
