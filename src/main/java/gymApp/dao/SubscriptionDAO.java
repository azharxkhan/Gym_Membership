package gymApp.dao;

import java.util.List;

import gymApp.model.Subscription;

/**
 * Interface for data access operations related to subscriptions in the database.
 */
public interface SubscriptionDAO {
    
    /**
     * Saves a new subscription to the database.
     *
     * @param subscription the Subscription object to be saved.
     * @return true if the subscription is successfully saved, false otherwise.
     */
    boolean save(Subscription subscription);
    
    /**
     * Updates the details of an existing subscription in the database.
     *
     * @param subscription the Subscription object with updated details.
     * @return true if the subscription is successfully updated, false otherwise.
     */
    boolean update(Subscription subscription);
    
    /**
     * Deletes a subscription from the database based on the provided subscription ID.
     *
     * @param subscriptionId the ID of the subscription to be deleted.
     * @return true if the subscription is successfully deleted, false otherwise.
     */
    boolean delete(int subscriptionId);
    
    /**
     * Finds a subscription by the user ID.
     *
     * @param userId the ID of the user whose subscription is to be found.
     * @return the Subscription object associated with the user ID, or null if not found.
     */
    Subscription findByUserId(int userId);
    
    /**
     * Retrieves all subscriptions from the database.
     *
     * @return a List of all Subscription objects in the database.
     */
    List<Subscription> findAll();
}
