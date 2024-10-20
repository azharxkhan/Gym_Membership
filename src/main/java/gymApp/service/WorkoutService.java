package gymApp.service;

import java.util.List;

import gymApp.dao.WorkoutPlanDAO;
import gymApp.model.WorkoutPlan;

public class WorkoutService {
    private final WorkoutPlanDAO workoutPlanDAO;

    public WorkoutService(WorkoutPlanDAO workoutPlanDAO) {
        this.workoutPlanDAO = workoutPlanDAO;
    }

    public WorkoutPlan createWorkoutPlan(WorkoutPlan workoutPlan) {
        return workoutPlanDAO.createWorkoutPlan(workoutPlan);
    }

    public List<WorkoutPlan> getAllWorkoutPlans() {
        return workoutPlanDAO.getAllWorkoutPlans();
    }

    public boolean updateWorkoutPlan(WorkoutPlan workoutPlan) {
        return workoutPlanDAO.updateWorkoutPlan(workoutPlan);
    }

    public boolean deleteWorkoutPlan(int planId) {
        return workoutPlanDAO.deleteWorkoutPlan(planId);
    }

    public void addWeightToPlan(int planId, double weight) {
        workoutPlanDAO.addWeightToPlan(planId, weight);
    }

    public void addBodyMeasurementToPlan(int planId, double measurement) {
        workoutPlanDAO.addBodyMeasurementToPlan(planId, measurement);
    }

    public void addFitnessGoalToPlan(int planId, String goal) {
        workoutPlanDAO.addFitnessGoalToPlan(planId, goal);
    }
}
