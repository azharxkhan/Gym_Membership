package gymApp.service;

import java.util.Date;
import java.util.List;

import gymApp.dao.SubscriptionDAO;
import gymApp.model.Subscription;

public class SubscriptionService {
    private final SubscriptionDAO subscriptionDAO;

    public SubscriptionService(SubscriptionDAO subscriptionDAO) {
        this.subscriptionDAO = subscriptionDAO;
    }

    public boolean createSubscription(int userId, String planName, Date startDate, Date endDate, String type) {
        Subscription subscription = new Subscription(0, userId, planName, startDate, endDate, "active", type);
        return subscriptionDAO.save(subscription);
    }


    public boolean renewSubscription(int userId, Date newEndDate) {
        Subscription subscription = subscriptionDAO.findByUserId(userId);
        if (subscription != null) {
            subscription.setEndDate(newEndDate);
            return subscriptionDAO.update(subscription);
        }
        return false;
    }

    public boolean cancelSubscription(int userId) {
        Subscription subscription = subscriptionDAO.findByUserId(userId);
        if (subscription != null) {
            subscription.setStatus("cancelled");
            return subscriptionDAO.update(subscription);
        }
        return false;
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionDAO.findAll();
    }
}
