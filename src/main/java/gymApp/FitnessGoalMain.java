package gymApp;

import gymApp.model.FitnessGoal;
import gymApp.model.ProgressTracking;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FitnessGoalMain {
    private static List<FitnessGoal> fitnessGoals = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nFitness Goal Management Menu");
            System.out.println("1. Create a new goal");
            System.out.println("2. View all goals");
            System.out.println("3. Update progress of a goal");
            System.out.println("4. Edit a goal");
            System.out.println("5. Remove a goal");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createGoal();
                    break;
                case 2:
                    viewGoals();
                    break;
                case 3:
                    updateGoalProgress();
                    break;
                case 4:
                    editGoal();
                    break;
                case 5:
                    removeGoal();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createGoal() {
        System.out.print("Enter goal ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter goal description: ");
        String description = scanner.nextLine();
        
        FitnessGoal newGoal = new FitnessGoal(id, description);
        fitnessGoals.add(newGoal);
        System.out.println("Goal created successfully: " + description);
    }

    private static void viewGoals() {
        if (fitnessGoals.isEmpty()) {
            System.out.println("No goals available.");
        } else {
            for (FitnessGoal goal : fitnessGoals) {
                System.out.println("ID: " + goal.getId() + ", Description: " + goal.getGoalDescription() + ", Progress: " + goal.getProgressPercentage() + "%, Target Date: " + goal.getTargetDate() + ", Achieved: " + (goal.isAchieved() ? "Yes" : "No"));
            }
        }
    }

    private static void updateGoalProgress() {
        System.out.print("Enter goal ID to update progress: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        FitnessGoal goal = findGoalById(id);
        if (goal != null) {
            System.out.print("Enter progress increment (as percentage): ");
            double progressIncrement = scanner.nextDouble();
            scanner.nextLine();
            
            ProgressTracking tracker = new ProgressTracking();
            tracker.updateGoalProgress(goal, progressIncrement);
        } else {
            System.out.println("Goal not found.");
        }
    }

    private static void editGoal() {
        System.out.print("Enter goal ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        FitnessGoal goal = findGoalById(id);
        if (goal != null) {
            System.out.print("Enter new goal description: ");
            String newDescription = scanner.nextLine();
            goal.setGoalDescription(newDescription);
            System.out.println("Goal updated successfully.");
        } else {
            System.out.println("Goal not found.");
        }
    }

    private static void removeGoal() {
        System.out.print("Enter goal ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        FitnessGoal goal = findGoalById(id);
        if (goal != null) {
            fitnessGoals.remove(goal);
            System.out.println("Goal removed successfully.");
        } else {
            System.out.println("Goal not found.");
        }
    }

    private static FitnessGoal findGoalById(int id) {
        for (FitnessGoal goal : fitnessGoals) {
            if (goal.getId() == id) {
                return goal;
            }
        }
        return null;
    }
} 
