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
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                displayMenu();
                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        addWorkoutPlanThroughInput(workoutService, scanner);
                        break;
                    case 2:
                        addWeightToPlan(workoutService, scanner);
                        break;
                    case 3:
                        addBodyMeasurementToPlan(workoutService, scanner);
                        break;
                    case 4:
                        addFitnessGoalToPlan(workoutService, scanner);
                        break;
                    case 5:
                        displayAllWorkoutPlans(workoutService);
                        break;
                    case 6:
                        deleteFirstWorkoutPlan(workoutService);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0);

        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    private static void displayMenu() {
        System.out.println("Workout Plan Management Menu:");
        System.out.println("1. Create Workout Plan");
        System.out.println("2. Add Weight to Plan");
        System.out.println("3. Add Body Measurement to Plan");
        System.out.println("4. Add Fitness Goal to Plan");
        System.out.println("5. Display All Workout Plans");
        System.out.println("6. Delete First Workout Plan");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addWorkoutPlanThroughInput(WorkoutService workoutService, Scanner scanner) {
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
            System.out.println("Created Workout Plan: " + createdPlan.getName());
        } else {
            System.out.println("Failed to create Workout Plan.");
        }
    }

    private static void addWeightToPlan(WorkoutService workoutService, Scanner scanner) {
        System.out.print("Enter Plan ID to add weight: ");
        int planId = scanner.nextInt();
        System.out.print("Enter weight: ");
        double weight = scanner.nextDouble();
        workoutService.addWeightToPlan(planId, weight);
        System.out.println("Weight added to plan ID: " + planId);
    }

    private static void addBodyMeasurementToPlan(WorkoutService workoutService, Scanner scanner) {
        System.out.print("Enter Plan ID to add body measurement: ");
        int planId = scanner.nextInt();
        System.out.print("Enter body measurement (e.g., height in cm): ");
        double measurement = scanner.nextDouble();
        workoutService.addBodyMeasurementToPlan(planId, measurement);
        System.out.println("Body measurement added to plan ID: " + planId);
    }

    private static void addFitnessGoalToPlan(WorkoutService workoutService, Scanner scanner) {
        System.out.print("Enter Plan ID to add fitness goal: ");
        int planId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter fitness goal: ");
        String goal = scanner.nextLine();
        workoutService.addFitnessGoalToPlan(planId, goal);
        System.out.println("Fitness goal added to plan ID: " + planId);
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
