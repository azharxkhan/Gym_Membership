package gymApp.model;

import java.util.List;

public class WorkoutPlan {
    private int planId;
    private String name;
    private String goal;
    private String level;
    private String createdBy;
    private List<Double> weights;
    private List<Double> bodyMeasurements;
    private List<String> fitnessGoals;

    public WorkoutPlan() {
    }

    public WorkoutPlan(String name, String goal, String level, String createdBy) {
        this.name = name;
        this.goal = goal;
        this.level = level;
        this.createdBy = createdBy;
    }

    public WorkoutPlan(int planId, String name, String goal, String level, String createdBy) {
        this.planId = planId;
        this.name = name;
        this.goal = goal;
        this.level = level;
        this.createdBy = createdBy;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<Double> getWeights() {
        return weights;
    }

    public void setWeights(List<Double> weights) {
        this.weights = weights;
    }

    public List<Double> getBodyMeasurements() {
        return bodyMeasurements;
    }

    public void setBodyMeasurements(List<Double> bodyMeasurements) {
        this.bodyMeasurements = bodyMeasurements;
    }

    public List<String> getFitnessGoals() {
        return fitnessGoals;
    }

    public void setFitnessGoals(List<String> fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }
}
