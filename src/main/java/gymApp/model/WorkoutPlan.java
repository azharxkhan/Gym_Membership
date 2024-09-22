package gymApp.model;

public class WorkoutPlan {
    private int planId;
    private String name;
    private String goal;
    private String level;
    private String createdBy;

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
}

