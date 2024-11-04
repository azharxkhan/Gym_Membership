package gymApp.model;

import java.time.LocalDate;

/**
 * Represents a fitness goal set by an individual.
 */
public class FitnessGoal {
    private int id;
    private String goalDescription;
    private boolean isAchieved;
    private LocalDate startDate;
    private LocalDate targetDate;
    private double progressPercentage;

    /**
     * Constructs a new FitnessGoal with a specified ID and goal description.
     *
     * @param id The unique identifier for the goal.
     * @param goalDescription A brief description of the goal.
     */
    public FitnessGoal(int id, String goalDescription) {
        this.id = id;
        this.goalDescription = goalDescription;
        this.isAchieved = false;
        this.startDate = LocalDate.now();
        this.targetDate = this.startDate.plusDays(30); 
        this.progressPercentage = 0.0;
    }

    /**
     * Returns the unique identifier of the goal.
     *
     * @return The goal ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the goal.
     *
     * @param id The goal ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the description of the goal.
     *
     * @return The goal description.
     */
    public String getGoalDescription() {
        return goalDescription;
    }

    /**
     * Sets the description of the goal.
     *
     * @param goalDescription The goal description to set.
     */
    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    /**
     * Checks if the goal has been achieved.
     *
     * @return True if the goal is achieved, false otherwise.
     */
    public boolean isAchieved() {
        return isAchieved;
    }

    /**
     * Sets the achievement status of the goal.
     *
     * @param achieved The achievement status to set.
     */
    public void setAchieved(boolean achieved) {
        isAchieved = achieved;
    }

    /**
     * Returns the start date of the goal.
     *
     * @return The start date.
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the goal.
     *
     * @param startDate The start date to set.
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Returns the target date by which the goal should be completed.
     *
     * @return The target date.
     */
    public LocalDate getTargetDate() {
        return targetDate;
    }

    /**
     * Sets the target date for goal completion.
     *
     * @param targetDate The target date to set.
     */
    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    /**
     * Returns the progress percentage of the goal.
     *
     * @return The progress percentage.
     */
    public double getProgressPercentage() {
        return progressPercentage;
    }

    /**
     * Sets the progress percentage of the goal.
     *
     * @param progressPercentage The progress percentage to set.
     */
    public void setProgressPercentage(double progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    /**
     * Updates the progress of the goal and checks if it is completed.
     *
     * @param newProgress The new progress percentage to set.
     */
    public void updateProgress(double newProgress) {
        this.progressPercentage = newProgress;
        if (newProgress >= 100.0) {
            this.isAchieved = true;
            System.out.println("Goal completed!");
        } else {
            System.out.println("Progress updated to: " + newProgress + "%");
        }
    }

    /**
     * Extends the target date for this goal by a specified number of days.
     *
     * @param additionalDays The number of days to extend the target date.
     */
    public void extendTargetDate(int additionalDays) {
        this.targetDate = this.targetDate.plusDays(additionalDays);
        System.out.println("Target date extended by " + additionalDays + " days. New target date: " + this.targetDate);
    }
} 