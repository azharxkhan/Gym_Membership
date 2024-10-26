package gymApp.model;

import java.util.List;

/**
 * Represents a workout plan created for an individual.
 */
public class WorkoutPlan {
    private int planId;
    private String name;
    private String goal;
    private String level;
    private String createdBy;
    private List<Double> weights;
    private List<Double> bodyMeasurements;
    private List<String> fitnessGoals;

    /**
     * Default constructor for creating an empty WorkoutPlan object.
     */
    public WorkoutPlan() {
    }

    /**
     * Constructs a WorkoutPlan object with specified parameters.
     *
     * @param name the name of the workout plan.
     * @param goal the goal of the workout plan.
     * @param level the difficulty level of the workout plan.
     * @param createdBy the name of the creator of the workout plan.
     */
    public WorkoutPlan(String name, String goal, String level, String createdBy) {
        this.name = name;
        this.goal = goal;
        this.level = level;
        this.createdBy = createdBy;
    }

    /**
     * Constructs a WorkoutPlan object with specified parameters including ID.
     *
     * @param planId the unique identifier for the workout plan.
     * @param name the name of the workout plan.
     * @param goal the goal of the workout plan.
     * @param level the difficulty level of the workout plan.
     * @param createdBy the name of the creator of the workout plan.
     */
    public WorkoutPlan(int planId, String name, String goal, String level, String createdBy) {
        this.planId = planId;
        this.name = name;
        this.goal = goal;
        this.level = level;
        this.createdBy = createdBy;
    }

    /**
     * Gets the unique identifier for this workout plan.
     *
     * @return the plan ID.
     */
    public int getPlanId() {
        return planId;
    }

    /**
     * Sets the unique identifier for this workout plan.
     *
     * @param planId the new plan ID.
     */
    public void setPlanId(int planId) {
        this.planId = planId;
    }

    /**
     * Gets the name of the workout plan.
     *
     * @return the name of the workout plan.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the workout plan.
     *
     * @param name the new name of the workout plan.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the goal of the workout plan.
     *
     * @return the goal of the workout plan.
     */
    public String getGoal() {
        return goal;
    }

    /**
     * Sets the goal of the workout plan.
     *
     * @param goal the new goal of the workout plan.
     */
    public void setGoal(String goal) {
        this.goal = goal;
    }

    /**
     * Gets the difficulty level of the workout plan.
     *
     * @return the difficulty level of the workout plan.
     */
    public String getLevel() {
        return level;
    }

    /**
     * Sets the difficulty level of the workout plan.
     *
     * @param level the new difficulty level of the workout plan.
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Gets the name of the creator of the workout plan.
     *
     * @return the creator of the workout plan.
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the name of the creator of the workout plan.
     *
     * @param createdBy the new creator of the workout plan.
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the list of weights associated with this workout plan.
     *
     * @return the list of weights.
     */
    public List<Double> getWeights() {
        return weights;
    }

    /**
     * Sets the list of weights associated with this workout plan.
     *
     * @param weights the new list of weights.
     */
    public void setWeights(List<Double> weights) {
        this.weights = weights;
    }

    /**
     * Gets the list of body measurements associated with this workout plan.
     *
     * @return the list of body measurements.
     */
    public List<Double> getBodyMeasurements() {
        return bodyMeasurements;
    }

    /**
     * Sets the list of body measurements associated with this workout plan.
     *
     * @param bodyMeasurements the new list of body measurements.
     */
    public void setBodyMeasurements(List<Double> bodyMeasurements) {
        this.bodyMeasurements = bodyMeasurements;
    }

    /**
     * Gets the list of fitness goals associated with this workout plan.
     *
     * @return the list of fitness goals.
     */
    public List<String> getFitnessGoals() {
        return fitnessGoals;
    }

    /**
     * Sets the list of fitness goals associated with this workout plan.
     *
     * @param fitnessGoals the new list of fitness goals.
     */
    public void setFitnessGoals(List<String> fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }
}
