package gymApp.dao;

import gymApp.model.User;

public interface UserDAO {
    User findByUsername(String username);
    boolean save(User user);
}
