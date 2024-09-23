package gymApp.service;

import java.util.List;

import gymApp.dao.WorkoutPlanDAOImpl;
import gymApp.model.WorkoutPlan;

public class WorkoutService {
    private final WorkoutPlanDAOImpl workoutPlanDAO = new WorkoutPlanDAOImpl();

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
