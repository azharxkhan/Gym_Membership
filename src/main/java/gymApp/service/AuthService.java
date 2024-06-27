package gymApp.service;

public class AuthService {

    public boolean authenticate(String username, String password) {
        // For simplicity, let's use a hardcoded user.
        // In a real application, you would check the username and password against a database.
        if ("Azhar".equals(username) && "CorrectPassword".equals(password)) {
            return true;
        }
        return false;
    }
}
