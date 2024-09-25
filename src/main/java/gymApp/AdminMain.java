package gymApp;

import gymApp.dao.SubscriptionDAOImpl;
import gymApp.dao.UserDAOImpl;
import gymApp.model.Subscription;
import gymApp.model.User;
import gymApp.service.SubscriptionService;
import gymApp.service.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AdminMain {
    private static final Scanner scanner = new Scanner(System.in);
    private static SubscriptionService subscriptionService;
    private static UserService userService;

    public static void main(String[] args) {
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection("jdbc:sqlite:gymdb.db");

            // Initialize DAOs with the established connection
            subscriptionService = new SubscriptionService(new SubscriptionDAOImpl(connection));
            userService = new UserService(new UserDAOImpl(connection));

            // Main menu loop
            while (true) {
                displayMainMenu();
                int choice = getChoice();
                handleMenuChoice(choice);
            }

        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n--- Admin Main Menu ---");
        System.out.println("1. View All Subscriptions");
        System.out.println("2. View All Users");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }

    private static void handleMenuChoice(int choice) {
        switch (choice) {
            case 1 -> viewAllSubscriptions();
            case 2 -> viewAllUsers();
            case 3 -> exitProgram();
            default -> System.out.println("Invalid choice. Please choose a valid option.");
        }
    }

    private static void viewAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();
        if (subscriptions.isEmpty()) {
            System.out.println("No subscriptions found.");
        } else {
            System.out.println("\n--- Subscriptions ---");
            for (Subscription subscription : subscriptions) {
                System.out.printf("ID: %d, User ID: %d, Plan Name: %s, Start Date: %s, End Date: %s, Status: %s%n",
                        subscription.getId(), subscription.getUserId(), subscription.getPlanName(),
                        subscription.getStartDate(), subscription.getEndDate(), subscription.getStatus());
            }
        }
    }

    private static void viewAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("\n--- Users ---");
            for (User user : users) {
                System.out.printf("ID: %d, Username: %s, Email: %s, Role: %s%n",
                        user.getId(), user.getUsername(), user.getEmail(), user.getRole());
            }
        }
    }

    private static void exitProgram() {
        System.out.println("Exiting program.");
        System.exit(0);
    }
}
