package gymApp.service;

import java.util.List;
import java.util.regex.Pattern;

import gymApp.dao.UserDAO;
import gymApp.model.User;

public class UserService {
    private final UserDAO userDAO;

    /**
     * Constructor to initialize the UserService with a UserDAO instance.
     *
     * @param userDAO the UserDAO used to interact with the data layer
     */
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     *  Gets all users
     *  @return a list of all users
     */
    public List<User> getAllUsers() {
        return userDAO.findAllUsers();
    }

    /**
     * Finds a user by their username.
     *
     * @param username the username of the user
     * @return the User object if found, otherwise null
     */
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    /**
     * Registers a new user if the username is unique and the input is valid.
     *
     * @param user the user object containing username, password, email, and role
     * @return true if registration is successful, false otherwise
     */
    public boolean registerUser(User user) {
        if (userDAO.findByUsername(user.getUsername()) != null) {
            return false;
        }

        if (!isValidEmail(user.getEmail())) {
            return false;
        }

        if (!isValidPassword(user.getPassword())) {
            return false;
        }

        if (!"admin".equalsIgnoreCase(user.getRole()) && !"member".equalsIgnoreCase(user.getRole())) {
            return false;
        }

        return userDAO.save(user);
    }

    /**
     * Validates email format using a regex pattern.
     *
     * @param email the email to validate
     * @return true if the email format is valid, false otherwise
     */
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    /**
     * Validates password strength by ensuring it is at least 8 characters long
     * and contains at least one uppercase letter, one lowercase letter, and one number.
     *
     * @param password the password to validate
     * @return true if the password is strong enough, false otherwise
     */
    private boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }

            if (hasUppercase && hasLowercase && hasDigit) {
                return true;
            }
        }
        System.out.println("Invalid password: Must have Uppercase, Lowercase and a Digit");

        return false;
    }
}
