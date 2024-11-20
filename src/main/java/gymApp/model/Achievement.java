package gymApp.model;

public class Achievement {
    private final int id;
    private String description;
    private boolean isAchieved;
    private int rewardPoints;

    public Achievement(int id, String description, int rewardPoints) {
        this.id = id;
        this.description = description;
        this.isAchieved = false;
        this.rewardPoints = rewardPoints;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsAchieved() {
        return isAchieved;
    }

    public void setIsAchieved(boolean isAchieved) {
        this.isAchieved = isAchieved;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public void unlock() {
        if (!isAchieved) {
            isAchieved = true;
            System.out.println("Achievement unlocked: " + description);
        }
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isAchieved=" + isAchieved +
                ", rewardPoints=" + rewardPoints +
                '}';
    }
}