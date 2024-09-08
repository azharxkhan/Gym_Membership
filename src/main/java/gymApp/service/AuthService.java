package gymApp.service;

public class AuthService {

    public boolean authenticate(String username, String password) {
        return "Azhar".equals(username) && "CorrectPassword".equals(password);
    }
}
