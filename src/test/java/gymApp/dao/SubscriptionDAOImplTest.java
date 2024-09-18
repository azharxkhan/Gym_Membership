package gymApp.dao;

import gymApp.model.Subscription;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SubscriptionDAOImplTest {

    private Connection connection;
    private SubscriptionDAOImpl subscriptionDAO;

    @BeforeEach
    public void setUp() throws SQLException {
        // Set up an in-memory SQLite database
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        subscriptionDAO = new SubscriptionDAOImpl(connection);

        // Create the subscriptions table
        subscriptionDAO.createSubscriptionsTable();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    public void testSaveSubscription() {
        Subscription subscription = new Subscription(0, 1, "Monthly", new Date(), new Date(), "active");

        boolean result = subscriptionDAO.save(subscription);

        assertTrue(result, "Subscription should be saved successfully.");
    }

    @Test
    public void testUpdateSubscription() {
        Subscription subscription = new Subscription(0, 1, "Monthly", new Date(), new Date(), "active");
        subscriptionDAO.save(subscription);

        subscription.setPlanName("Yearly");
        boolean result = subscriptionDAO.update(subscription);

        assertTrue(result, "Subscription should be updated successfully.");
    }

    @Test
    public void testDeleteSubscription() {
        Subscription subscription = new Subscription(0, 1, "Monthly", new Date(), new Date(), "active");
        subscriptionDAO.save(subscription);

        boolean result = subscriptionDAO.delete(subscription.getId());

        assertTrue(result, "Subscription should be deleted successfully.");
    }

    @Test
    public void testFindByUserId() {
        Subscription subscription = new Subscription(0, 1, "Monthly", new Date(), new Date(), "active");
        subscriptionDAO.save(subscription);

        Subscription foundSubscription = subscriptionDAO.findByUserId(1);

        assertNotNull(foundSubscription, "Subscription should be found for the user ID.");
    }

    @Test
    public void testFindAll() {
        Subscription subscription1 = new Subscription(0, 1, "Monthly", new Date(), new Date(), "active");
        Subscription subscription2 = new Subscription(0, 2, "Yearly", new Date(), new Date(), "active");
        subscriptionDAO.save(subscription1);
        subscriptionDAO.save(subscription2);

        List<Subscription> subscriptions = subscriptionDAO.findAll();

        assertEquals(2, subscriptions.size(), "There should be two subscriptions in the database.");
    }
}
