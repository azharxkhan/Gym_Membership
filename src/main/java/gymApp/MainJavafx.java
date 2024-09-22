package gymApp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainJavafx extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gym Membership App");

        // Labels
        Label titleLabel = new Label("Welcome to the Gym Membership App");
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");

        // Input fields
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");

        // Buttons
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");

        // Button actions
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            // For now, we'll just print the values (you can replace this with actual login logic)
            System.out.println("Logging in with Username: " + username + ", Password: " + password);
        });

        registerButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            // Simulate a registration action
            System.out.println("Registering user: " + username + ", Password: " + password);
        });

        // Layout
        VBox vbox = new VBox(10); // Set spacing between elements
        vbox.setPadding(new Insets(20)); // Set padding around the VBox
        vbox.setAlignment(Pos.CENTER); // Center everything
        vbox.getChildren().addAll(titleLabel, usernameLabel, usernameField, passwordLabel, passwordField, loginButton, registerButton);

        // Scene
        Scene scene = new Scene(vbox, 350, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
