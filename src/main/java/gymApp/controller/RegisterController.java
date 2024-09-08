package gymApp.controller;

import gymApp.model.User;
import gymApp.service.UserService;

public class RegisterController {

    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    public boolean register(String username, String password, String email) {
        User newUser = new User(0, username, password, email);
        return userService.registerUser(newUser);
    }
}
