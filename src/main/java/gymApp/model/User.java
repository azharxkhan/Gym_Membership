package gymApp.model;

/**
 * Model class representing a user in the system.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String role; // New field to represent the role (admin or member)

    /**
     * No-argument constructor for creating an empty user (useful for testing or default initialization).
     */
    public User() {
    }

    /**
     * Constructor for creating a new user where the ID is auto-generated and the role is provided.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param email the email of the user
     * @param role the role of the user (admin or member)
     */
    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    /**
     * Constructor for creating a user with a known ID (typically for existing users) and the role is provided.
     *
     * @param id the unique identifier of the user
     * @param username the username of the user
     * @param password the password of the user
     * @param email the email of the user
     * @param role the role of the user (admin or member)
     */
    public User(int id, String username, String password, String email, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    /**
     * Returns the ID of the user.
     * 
     * @return the user's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     * 
     * @param id the new ID of the user
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the username of the user.
     * 
     * @return the user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     * 
     * @param username the new username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password of the user.
     * 
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * 
     * @param password the new password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the email of the user.
     * 
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     * 
     * @param email the new email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the role of the user.
     * 
     * @return the user's role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     * 
     * @param role the new role of the user (admin or member)
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Returns a string representation of the User object.
     * 
     * @return a string containing user details
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
