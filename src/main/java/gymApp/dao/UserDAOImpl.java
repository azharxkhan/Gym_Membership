package gymApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import gymApp.model.User;

public class UserDAOImpl implements UserDAO {

    private Connection connection;

    public UserDAOImpl() {
        try {
            Class.forName("org.sqlite.JDBC");  
            this.connection = DriverManager.getConnection("jdbc:sqlite:gymdb.db");
            createUsersTable();  
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
        try {
            createUsersTable();  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createUsersTable() throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "username TEXT NOT NULL UNIQUE, " +
                                "password TEXT NOT NULL, " +
                                "email TEXT NOT NULL, " +
                                "role TEXT NOT NULL)";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
        }
    }

    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) {
                String hashedPassword = rs.getString("password");
                System.out.println("User found in database: " + rs.getString("username"));
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        hashedPassword,  
                        rs.getString("email"),
                        rs.getString("role")
                );
            } else {
                System.out.println("No user found with username: " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }    

    @Override
    public boolean save(User user) {
        if (findByUsername(user.getUsername()) != null) {
            System.out.println("User with username " + user.getUsername() + " already exists.");
            return false;
        }

        System.out.println("Attempting to save user: " + user.getUsername());

        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        String query = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, hashedPassword);
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getRole());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User saved successfully: " + user.getUsername());
            }
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        String query = "UPDATE users SET password = ?, email = ?, role = ? WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            stmt.setString(1, hashedPassword);
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getRole());
            stmt.setString(4, user.getUsername());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

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

    @Override
    public List<User> findAllUsers() {
        String query = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("role")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int countUsers() {
        String query = "SELECT COUNT(*) AS total FROM users";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}


// Connection Management: Ensure proper closing of database connections to prevent resource leaks and consider using a connection pool for better concurrency handling.
// Security: Implement password hashing to protect user credentials and ensure input validation to prevent SQL injection.
// Error Handling: Improve error propagation and handling to provide clearer feedback on failures, rather than just printing stack traces.
// Data Consistency: Use transactions for operations involving multiple modifications to maintain data integrity, and validate input data for fields like email and role.
// Code Organization: Consider breaking down the DAO into smaller classes or interfaces for better modularity and maintain
//These issues need to be fixed later on to ensure user protection and privacy