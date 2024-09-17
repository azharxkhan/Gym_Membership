package gymApp.dao;

import gymApp.model.Subscription;
import java.util.List;

public interface SubscriptionDAO {
    boolean save(Subscription subscription); // Add a new subscription
    boolean update(Subscription subscription); // Update subscription details
    boolean delete(int subscriptionId); // Delete a subscription
    Subscription findByUserId(int userId); // Find subscription by user ID
    List<Subscription> findAll(); // Find all subscriptions
}
