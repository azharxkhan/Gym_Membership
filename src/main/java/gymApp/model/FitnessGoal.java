package gymApp.model;

/**
 * Represents a fitness goal set by an individual.
 */
public class FitnessGoal {
    private int id;
    private String goalDescription;
    private boolean isAchieved;

    /**
     * Gets the unique identifier for this fitness goal.
     *
     * @return the ID of the fitness goal.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this fitness goal.
     *
     * @param id the new ID of the fitness goal.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the description of the fitness goal.
     *
     * @return the goal description (e.g., "Lose 5 kg", "Run 5 km").
     */
    public String getGoalDescription() {
        return goalDescription;
    }

    /**
     * Sets the description of the fitness goal.
     *
     * @param goalDescription the new goal description.
     */
    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    /**
     * Checks if the fitness goal has been achieved.
     *
     * @return true if the goal is achieved, false otherwise.
     */
    public boolean isAchieved() {
        return isAchieved;
    }

    /**
     * Sets the status of the fitness goal achievement.
     *
     * @param isAchieved the new achievement status of the goal.
     */
    public void setAchieved(boolean isAchieved) {
        this.isAchieved = isAchieved;
    }
}
