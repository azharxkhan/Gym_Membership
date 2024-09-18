package gymApp.service;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import gymApp.dao.SubscriptionDAO;
import gymApp.model.Subscription;

public class SubscriptionServiceTest {

    private SubscriptionService subscriptionService;
    private SubscriptionDAO subscriptionDAO;

    @BeforeEach
    public void setUp() {
        subscriptionDAO = Mockito.mock(SubscriptionDAO.class);
        subscriptionService = new SubscriptionService(subscriptionDAO);
    }

    @Test
    public void testCreateSubscription() {
        Subscription subscription = new Subscription(0, 1, "Monthly", new Date(), new Date(), "active");

        // Use ArgumentMatchers to allow any Subscription object passed to the DAO's save method
        Mockito.when(subscriptionDAO.save(Mockito.any(Subscription.class))).thenReturn(true);

        // Assume createSubscription method in SubscriptionService constructs a Subscription object and saves it
        boolean result = subscriptionService.createSubscription(1, "Monthly", new Date(), new Date());

        // Assert the result
        assertTrue(result, "Subscription creation should succeed.");
    }

    @Test
    public void testRenewSubscription() {
        Subscription existingSubscription = new Subscription(1, 1, "Monthly", new Date(), new Date(), "active");

        Mockito.when(subscriptionDAO.findByUserId(1)).thenReturn(existingSubscription);
        Mockito.when(subscriptionDAO.update(existingSubscription)).thenReturn(true);

        boolean result = subscriptionService.renewSubscription(1, new Date());

        assertTrue(result, "Subscription renewal should succeed.");
    }

    @Test
    public void testCancelSubscription() {
        Subscription existingSubscription = new Subscription(1, 1, "Monthly", new Date(), new Date(), "active");

        Mockito.when(subscriptionDAO.findByUserId(1)).thenReturn(existingSubscription);
        Mockito.when(subscriptionDAO.update(existingSubscription)).thenReturn(true);

        boolean result = subscriptionService.cancelSubscription(1);

        assertTrue(result, "Subscription cancellation should succeed.");
    }
}
