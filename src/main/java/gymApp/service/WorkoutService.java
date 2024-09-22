package gymApp.service;

import java.util.List;

import gymApp.dao.WorkoutPlanDAO;
import gymApp.model.WorkoutPlan;

public class WorkoutService {
    private final WorkoutPlanDAO workoutPlanDAO = new WorkoutPlanDAO();

    public WorkoutPlan createWorkoutPlan(WorkoutPlan plan) {
        return workoutPlanDAO.createWorkoutPlan(plan);
    }

    public List<WorkoutPlan> getAllWorkoutPlans() {
        return workoutPlanDAO.getAllWorkoutPlans();
    }

    public boolean deleteWorkoutPlan(int planId) {
        return workoutPlanDAO.deleteWorkoutPlan(planId);
    }
}
