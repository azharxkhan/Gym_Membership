package gymApp.model;

import java.util.Date;

/**
 * Represents a subscription for a user to a specific workout plan.
 */
public class Subscription {
    private int id;
    private int userId;
    private String planName;
    private Date startDate;
    private Date endDate;
    private String status;

    /**
     * Constructs a Subscription object with specified parameters.
     *
     * @param id the unique identifier for the subscription.
     * @param userId the ID of the user associated with the subscription.
     * @param planName the name of the workout plan.
     * @param startDate the start date of the subscription.
     * @param endDate the end date of the subscription.
     * @param status the current status of the subscription (e.g., active, expired).
     */
    public Subscription(int id, int userId, String planName, Date startDate, Date endDate, String status) {
        this.id = id;
        this.userId = userId;
        this.planName = planName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    /**
     * Gets the unique identifier for this subscription.
     *
     * @return the ID of the subscription.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this subscription.
     *
     * @param id the new ID of the subscription.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of the user associated with this subscription.
     *
     * @return the user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user associated with this subscription.
     *
     * @param userId the new user ID.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the name of the workout plan associated with this subscription.
     *
     * @return the name of the plan.
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * Sets the name of the workout plan associated with this subscription.
     *
     * @param planName the new name of the plan.
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     * Gets the start date of the subscription.
     *
     * @return the start date.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the subscription.
     *
     * @param startDate the new start date.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date of the subscription.
     *
     * @return the end date.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date of the subscription.
     *
     * @param endDate the new end date.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the current status of the subscription.
     *
     * @return the status of the subscription.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the current status of the subscription.
     *
     * @param status the new status of the subscription.
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
