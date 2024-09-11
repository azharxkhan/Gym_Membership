package gymApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gymApp.model.User;

/**
 * Implementation of UserDAO interface that manages user data operations in the SQLite database.
 */
public class UserDAOImpl implements UserDAO {

    private Connection connection;

    /**
     * Constructor to accept the connection, typically used for testing purposes.
     * 
     * @param connection a valid database connection
     */
    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Default constructor that initializes the connection to the SQLite database.
     */
    public UserDAOImpl() {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:gymdb.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Finds a user by their username.
     * 
     * @param username the username of the user to find
     * @return a User object if found, otherwise null
     */
    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Saves a new user to the database.
     * 
     * @param user the User object to save
     * @return true if the user is successfully saved, otherwise false
     */
    @Override
    public boolean save(User user) {
        String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Updates an existing user in the database.
     * 
     * @param user the User object with updated information
     * @return true if the user is successfully updated, otherwise false
     */
    @Override
    public boolean update(User user) {
        String query = "UPDATE users SET password = ?, email = ? WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getUsername());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Deletes a user from the database by their username.
     * 
     * @param username the username of the user to delete
     * @return true if the user is successfully deleted, otherwise false
     */
    @Override
    public boolean delete(String username) {
        String query = "DELETE FROM users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
