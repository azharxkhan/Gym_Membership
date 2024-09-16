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
     */
    public boolean register(String username, String password, String email, String role) {
        if (!role.equalsIgnoreCase("admin") && !role.equalsIgnoreCase("member")) {
            throw new IllegalArgumentException("Invalid role specified. Role must be either 'admin' or 'member'.");
        }
        
        User newUser = new User(0, username, password, email, role);
        return userService.registerUser(newUser);
    }
}
