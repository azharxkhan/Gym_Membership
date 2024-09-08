package gymApp.service;

import gymApp.dao.UserDAO;
import gymApp.model.User;

public class AuthService {

    private UserDAO userDAO;

    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean authenticate(String username, String password) {
        User user = userDAO.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
