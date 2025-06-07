package gymApp;

import gymApp.model.User;
import gymApp.model.Subscription;
import gymApp.service.UserService;
import gymApp.service.SubscriptionService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class AdminDashboard extends Application {

    private UserService userService;
    private SubscriptionService subscriptionService;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:gymdb.db");
        userService = new UserService(new gymApp.dao.UserDAOImpl(connection));
        subscriptionService = new SubscriptionService(new gymApp.dao.SubscriptionDAOImpl(connection));

        TabPane tabPane = new TabPane();

        Tab userTab = new Tab("Users", createUserPane());
        Tab subscriptionTab = new Tab("Subscriptions", createSubscriptionPane());

        tabPane.getTabs().addAll(userTab, subscriptionTab);

        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setTitle("Admin Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createUserPane() {
        VBox layout = new VBox(10);
        ListView<String> listView = new ListView<>();

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            listView.getItems().add(user.getUsername() + " | " + user.getEmail());
        }

        layout.getChildren().addAll(new Label("All Users"), listView);
        return layout;
    }

    private VBox createSubscriptionPane() {
        VBox layout = new VBox(10);
        ListView<String> listView = new ListView<>();

        List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();
        for (Subscription sub : subscriptions) {
            listView.getItems().add("User ID: " + sub.getUserId() + " | Type: " + sub.getType());
        }

        layout.getChildren().addAll(new Label("All Subscriptions"), listView);
        return layout;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
