package gymApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gymApp.model.Subscription;

public class SubscriptionDAOImplTest {

    private Connection connection;
    private SubscriptionDAOImpl subscriptionDAO;

    @BeforeEach
    public void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        subscriptionDAO = new SubscriptionDAOImpl(connection);
        subscriptionDAO.createSubscriptionsTable();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    public void testSaveSubscription() {
        Subscription subscription = new Subscription(0, 1, "Monthly", new Date(), new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30), "active");
        boolean result = subscriptionDAO.save(subscription);
        assertTrue(result, "Subscription should be saved successfully.");
    }

    @Test
    public void testUpdateSubscription() {
        Subscription subscription = new Subscription(0, 1, "Monthly", new Date(), new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30), "active");
        subscriptionDAO.save(subscription);
        subscription.setPlanName("Yearly");
        boolean result = subscriptionDAO.update(subscription);
        assertTrue(result, "Subscription should be updated successfully.");
    }

    @Test
    public void testDeleteSubscription() {
        Subscription subscription = new Subscription(0, 1, "Monthly", new Date(), new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30), "active");
        subscriptionDAO.save(subscription);
        boolean result = subscriptionDAO.delete(subscription.getId());
        assertTrue(result, "Subscription should be deleted successfully.");
    }

    @Test
    public void testFindByUserId() {
        Subscription subscription = new Subscription(0, 1, "Monthly", new Date(), new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30), "active");
        subscriptionDAO.save(subscription);
        Subscription foundSubscription = subscriptionDAO.findByUserId(1);
        assertNotNull(foundSubscription, "Subscription should be found for the user ID.");
    }

    @Test
    public void testFindAll() {
        Subscription subscription1 = new Subscription(0, 1, "Monthly", new Date(), new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30), "active");
        Subscription subscription2 = new Subscription(0, 2, "Yearly", new Date(), new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 365), "active");
        subscriptionDAO.save(subscription1);
        subscriptionDAO.save(subscription2);
        List<Subscription> subscriptions = subscriptionDAO.findAll();
        assertEquals(2, subscriptions.size(), "There should be two subscriptions in the database.");
    }

    @Test
    public void testPreventDuplicateActiveSubscription() {
        Subscription subscription1 = new Subscription(0, 1, "Monthly", new Date(), new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30), "active");
        Subscription subscription2 = new Subscription(0, 1, "Monthly", new Date(), new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30), "active");
        
        subscriptionDAO.save(subscription1);
        boolean result = subscriptionDAO.save(subscription2);
        assertFalse(result, "User should not be able to save a duplicate active subscription.");
    }

    @Test
    public void testDifferentPlansForSameUser() {
        Subscription subscription1 = new Subscription(0, 1, "Monthly", new Date(), new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30), "active");
        Subscription subscription2 = new Subscription(0, 1, "Yearly", new Date(), new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 365), "active");
        
        subscriptionDAO.save(subscription1);
        boolean result = subscriptionDAO.save(subscription2);
        assertFalse(result, "User should be unable to save a different plan.");
        
        List<Subscription> subscriptions = subscriptionDAO.findAll();
        assertEquals(1, subscriptions.size(), "There should be 1 subscriptions in the database.");
        
        Subscription foundSubscription = subscriptions.get(0);
        assertEquals("Monthly", foundSubscription.getPlanName(), "The active subscription should be a Monthly plan.");
    }
}
