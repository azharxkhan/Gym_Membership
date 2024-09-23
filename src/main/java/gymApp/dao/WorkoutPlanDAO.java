package gymApp.dao;

import gymApp.model.WorkoutPlan;
import java.util.List;

public interface WorkoutPlanDAO {
    WorkoutPlan createWorkoutPlan(WorkoutPlan plan);
    List<WorkoutPlan> getAllWorkoutPlans();
    boolean deleteWorkoutPlan(int planId);
}
