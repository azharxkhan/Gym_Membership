package gymApp.service;

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
        return userDAO.save(user);
    }
}
