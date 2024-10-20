package gymApp.model;

public class FitnessGoal {
    private int id;
    private String goalDescription; // "Lose 5 kg", "Run 5 km" (needs to have a time measurement and is link to a class)
    private boolean isAchieved;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    public boolean isIsAchieved() {
        return isAchieved;
    }

    public void setIsAchieved(boolean isAchieved) {
        this.isAchieved = isAchieved;
    }

}
