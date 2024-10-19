package gymApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import gymApp.dao.WorkoutPlanDAOImpl;
import gymApp.model.WorkoutPlan;
import gymApp.service.WorkoutService;

public class Mainworkout {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gymdb.db")) {
            WorkoutService workoutService = new WorkoutService(new WorkoutPlanDAOImpl(connection));

            // Optional: Preload basic workout plans (uncomment to use it)
            // preloadBasicWorkoutPlans(workoutService);

            addWorkoutPlanThroughInput(workoutService);

            displayAllWorkoutPlans(workoutService);

            deleteFirstWorkoutPlan(workoutService);

            displayAllWorkoutPlans(workoutService);

        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    private static void preloadBasicWorkoutPlans(WorkoutService workoutService) {
        List<WorkoutPlan> basicPlans = List.of(
                new WorkoutPlan("Beginner Full Body", "General Fitness", "Beginner", "Admin"),
                new WorkoutPlan("Cardio Burn", "Cardio", "Intermediate", "Admin"),
                new WorkoutPlan("Strength Builder", "Strength", "Advanced", "Admin"),
                new WorkoutPlan("Flexibility and Mobility", "Flexibility", "All Levels", "Admin"),
                new WorkoutPlan("Core Crusher", "Core", "Intermediate", "Admin")
        );

        for (WorkoutPlan plan : basicPlans) {
            WorkoutPlan createdPlan = workoutService.createWorkoutPlan(plan);
            if (createdPlan != null) {
                System.out.println("Preloaded Workout Plan: " + createdPlan.getName());
            } else {
                System.out.println("Failed to preload Workout Plan: " + plan.getName());
            }
        }
    }

    private static void addWorkoutPlanThroughInput(WorkoutService workoutService) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Workout Plan Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Workout Goal (e.g., Strength, Cardio, Flexibility): ");
        String goal = scanner.nextLine();

        System.out.print("Enter Difficulty Level (e.g., Beginner, Intermediate, Advanced): ");
        String level = scanner.nextLine();

        System.out.print("Enter Created By (e.g., Admin): ");
        String createdBy = scanner.nextLine();

        WorkoutPlan newPlan = new WorkoutPlan(name, goal, level, createdBy);
        WorkoutPlan createdPlan = workoutService.createWorkoutPlan(newPlan);

        if (createdPlan != null) {
            System.out.println("Created Workout Plan: " + createdPlan);
        } else {
            System.out.println("Failed to create Workout Plan.");
        }
    }

    private static void displayAllWorkoutPlans(WorkoutService workoutService) {
        List<WorkoutPlan> plans = workoutService.getAllWorkoutPlans();
        System.out.println("All Workout Plans:");
        for (WorkoutPlan plan : plans) {
            System.out.println("Plan ID: " + plan.getPlanId() + ", Name: " + plan.getName() +
                    ", Goal: " + plan.getGoal() + ", Level: " + plan.getLevel());
        }
    }

    private static void deleteFirstWorkoutPlan(WorkoutService workoutService) {
        List<WorkoutPlan> plans = workoutService.getAllWorkoutPlans();
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
    }
}
