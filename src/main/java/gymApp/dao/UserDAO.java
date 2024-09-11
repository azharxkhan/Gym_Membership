package gymApp.dao;

import gymApp.model.User;

/**
 * Interface for data access operations related to users in the database.
 */
public interface UserDAO {

    /**
     * Finds a user by their username.
     *
     * @param username the username of the user to find
     * @return the User object if found, otherwise null
     */
    User findByUsername(String username);

    /**
     * Saves a new user to the database.
     *
     * @param user the User object to save
     * @return true if the user is successfully saved, otherwise false
     */
    boolean save(User user);

    /**
     * Updates an existing user's information in the database.
     *
     * @param user the User object with updated information
     * @return true if the user's information is successfully updated, otherwise false
     */
    boolean update(User user);

    /**
     * Deletes a user from the database by their username.
     *
     * @param username the username of the user to delete
     * @return true if the user is successfully deleted, otherwise false
     */
    boolean delete(String username);
}
