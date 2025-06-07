package gymApp.Intergration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

import gymApp.dao.UserDAOImpl;
import gymApp.dao.SubscriptionDAOImpl;
import gymApp.model.User;
import gymApp.model.Subscription;

public class GymAppIntegrationTest {

    private Connection connection;
    private UserDAOImpl userDAO;
    private SubscriptionDAOImpl subscriptionDAO;

    @BeforeEach
    public void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");  // In-memory for testing
        userDAO = new UserDAOImpl(connection);
        subscriptionDAO = new SubscriptionDAOImpl(connection);

        // Create necessary tables for users and subscriptions
        userDAO.createUsersTable();
        subscriptionDAO.createSubscriptionsTable();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    public void testUserAndSubscriptionIntegration() throws SQLException {
        // Create a new user
        User user = new User(0, "testuser", "testpass", "testuser@example.com", "member");
        userDAO.save(user);

        // Retrieve the user to get the ID
        User savedUser = userDAO.findByUsername("testuser");

        assertNotNull(savedUser, "User should be saved and retrieved.");

        // Add a subscription for this user
        Subscription subscription = new Subscription(
            0,
            savedUser.getId(),
            "Monthly",
            new Date(),
            new Date(),
            "active",
            "Standard" // new type field
        );

        boolean subscriptionSaved = subscriptionDAO.save(subscription);

        assertTrue(subscriptionSaved, "Subscription should be saved successfully.");

        // Retrieve the subscription by user ID
        Subscription userSubscription = subscriptionDAO.findByUserId(savedUser.getId());

        assertNotNull(userSubscription, "Subscription should be found for the user.");
        assertEquals("Monthly", userSubscription.getPlanName(), "Plan name should match.");
        assertEquals("Standard", userSubscription.getType(), "Subscription type should match.");
    }
}
