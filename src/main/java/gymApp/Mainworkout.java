package gymApp;

import java.util.List;

import gymApp.model.WorkoutPlan;
import gymApp.service.WorkoutService;

public class Mainworkout {
    public static void main(String[] args) {
        WorkoutService workoutService = new WorkoutService();

        WorkoutPlan newPlan = new WorkoutPlan("Full Body Blast", "Strength", "Intermediate", "Admin");
        WorkoutPlan createdPlan = workoutService.createWorkoutPlan(newPlan);

        if (createdPlan != null) {
            System.out.println("Created Workout Plan: " + createdPlan);
        } else {
            System.out.println("Failed to create Workout Plan.");
        }

        List<WorkoutPlan> plans = workoutService.getAllWorkoutPlans();
        System.out.println("All Workout Plans:");
        for (WorkoutPlan plan : plans) {
            System.out.println("Plan ID: " + plan.getPlanId() + ", Name: " + plan.getName());
        }

        if (!plans.isEmpty()) {
            int planIdToDelete = plans.get(0).getPlanId();
            boolean isDeleted = workoutService.deleteWorkoutPlan(planIdToDelete);
            if (isDeleted) {
                System.out.println("Deleted Workout Plan with ID: " + planIdToDelete);
            } else {
                System.out.println("Failed to delete Workout Plan with ID: " + planIdToDelete);
            }
        } else {
            System.out.println("No workout plans available to delete.");
        }

        List<WorkoutPlan> updatedPlans = workoutService.getAllWorkoutPlans();
        System.out.println("Updated Workout Plans:");
        for (WorkoutPlan plan : updatedPlans) {
            System.out.println("Plan ID: " + plan.getPlanId() + ", Name: " + plan.getName());
        }
    }
}
