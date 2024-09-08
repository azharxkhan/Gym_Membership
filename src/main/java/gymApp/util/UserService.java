package gymApp.util;

import gymApp.dao.UserDAO;
import gymApp.model.User;

public class UserService {
    
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean registerUser(User user) {
        if (userDAO.findByUsername(user.getUsername()) != null) {
            return false;
        }

        if (!Validator.isValidEmail(user.getEmail()) || !Validator.isValidPassword(user.getPassword())) {
            return false;
        }

        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);

        return userDAO.save(user);
    }

    private String hashPassword(String password) {
        return Integer.toHexString(password.hashCode());
    }
}

