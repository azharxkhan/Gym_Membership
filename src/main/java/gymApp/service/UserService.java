package gymApp.service;

import java.util.regex.Pattern;

import gymApp.dao.UserDAO;
import gymApp.model.User;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
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
        // Check if the username is already taken
        if (userDAO.findByUsername(user.getUsername()) != null) {
            return false; 
        }

        // Validate email format
        if (!isValidEmail(user.getEmail())) {
            return false;
        }

        // Validate password strength
        if (!isValidPassword(user.getPassword())) {
            return false;
        }

        // Ensure the role is either "admin" or "member"
        if (!"admin".equalsIgnoreCase(user.getRole()) && !"member".equalsIgnoreCase(user.getRole())) {
            return false;
        }

        // Save the user if all validations pass
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

            // If all conditions are met, no need to continue checking
            if (hasUppercase && hasLowercase && hasDigit) {
                return true;
            }
        }

        return false;  // Return false if any condition is not met
    }
}
